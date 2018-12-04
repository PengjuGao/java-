package com.platform.client.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CHUCHU on 2017/5/22.
 */
@Component
public class C3P0Factory {

    @Autowired
    DataSourceEnum dataSourceEnum;

    private Lock lock = new ReentrantLock();


    public ComboPooledDataSource getDataSource(int value) {
        return dataSourceEnum.getDataSource(value);
    }

    public Map<String, Object> excute(ComboPooledDataSource pooledDataSource, String filePath) throws Exception {
        Map<String, Object> map = null;
        Connection connection = pooledDataSource.getConnection();
        try {
            map = new HashMap<>();
            List<String> list = new ArrayList<>();
            map.put("dataSource",pooledDataSource);
            map.put("databaseUser",pooledDataSource.getUser());
            map.put("databasePassword",pooledDataSource.getPassword());
            System.out.println(Thread.currentThread().getId());
            String dataSourceName = "";

            dataSourceName = connection.getCatalog();
            ScriptRunner runner = new ScriptRunner(connection);
            PrintWriter writer = new PrintWriter(System.out);
            runner.setErrorLogWriter(writer);
            runner.setLogWriter(null);
            //dataSourceName =  connection.getSchema();
            System.out.println(dataSourceName);
            connection.getTypeMap().get("userName");
            connection.getTypeMap().get("password");
            map.put("databaseName", dataSourceName);
            lock.lock();
            List<String> oldTableList = this.getTableNames(dataSourceName,connection);
            try {
                runner.runScript(new FileReader(filePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("--old table list size="+oldTableList.size());
            list = this.getTableNames(dataSourceName,connection);
            System.out.println(list.size());
            //去重
            for (String table :
                    oldTableList) {
                for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
                    String next = iterator.next();
                    if(table.equals(next)){
                        iterator.remove();
                        break;
                    }
                }
            }
            System.out.println(list.size());
            map.put("tableList", list);
            System.out.println("------输出查询到的表----结束");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            if(connection != null){
                connection.close();
            }
        }
        System.out.println("---thread "+Thread.currentThread().getId()+"----save map---begin");
        MapHolder.saveMap(map);
        System.out.println("---thread "+Thread.currentThread().getId()+"+++"+map.keySet().toString());
        System.out.println("---thread "+Thread.currentThread().getId()+"----save map---end");
        return map;

    }

    /**
     * 获取表里的数据
     * @param dataSourceName
     * @param connection
     * @return
     * @throws Exception
     */
    private List<String> getTableNames(String dataSourceName,Connection connection) throws Exception{
        List<String> list = new ArrayList<>();
        String sql = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" + dataSourceName + "'";
        System.out.println("---查询所有表的sql语句---" + sql);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);
        System.out.println("------输出查询到的表----开始");
        while (resultSet.next()) {
            String tableName = resultSet.getString("table_name");
            System.out.println(tableName);
            list.add(tableName);
        }
        return list;
    }

    /**
     * drop current thread tables
     */
    @SuppressWarnings("unchecked")
    public void dropTable() throws Exception{
        Long id = Thread.currentThread().getId();
        int num = id.intValue()%20;
        Map<String,Object> threadMap = MapHolder.getMap();
        ComboPooledDataSource dataSource = dataSourceEnum.getNewDataSource(num);
        List<String> tableList = (List<String>)threadMap.get("tableList");
        if(dataSource != null ){
            Connection connection = dataSource.getConnection();
            if(tableList != null && tableList.size()>0){
                for (String table :
                        tableList) {
                    String value = "drop table "+table;
                    System.out.println("---thread "+Thread.currentThread()+"---drop table "+value);
                    connection.createStatement().execute(value);
                }
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
