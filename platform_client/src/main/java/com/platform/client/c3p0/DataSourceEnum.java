package com.platform.client.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by CHUCHU on 2017/5/22.
 */
@Component
public class DataSourceEnum {

    @Autowired
    ComboPooledDataSource dataSource0;
    @Autowired
    ComboPooledDataSource dataSource1;
    @Autowired
    ComboPooledDataSource dataSource2;
    @Autowired
    ComboPooledDataSource dataSource3;
    @Autowired
    ComboPooledDataSource dataSource4;
    @Autowired
    ComboPooledDataSource dataSource5;
    @Autowired
    ComboPooledDataSource dataSource6;
    @Autowired
    ComboPooledDataSource dataSource7;
    @Autowired
    ComboPooledDataSource dataSource8;
    @Autowired
    ComboPooledDataSource dataSource9;
    @Autowired
    ComboPooledDataSource dataSource10;
    @Autowired
    ComboPooledDataSource dataSource11;
    @Autowired
    ComboPooledDataSource dataSource12;
    @Autowired
    ComboPooledDataSource dataSource13;
    @Autowired
    ComboPooledDataSource dataSource14;
    @Autowired
    ComboPooledDataSource dataSource15;
    @Autowired
    ComboPooledDataSource dataSource16;
    @Autowired
    ComboPooledDataSource dataSource17;
    @Autowired
    ComboPooledDataSource dataSource18;
    @Autowired
    ComboPooledDataSource dataSource19;


    @Autowired
    ComboPooledDataSource newdataSource0;
    @Autowired
    ComboPooledDataSource newdataSource1;
    @Autowired
    ComboPooledDataSource newdataSource2;
    @Autowired
    ComboPooledDataSource newdataSource3;
    @Autowired
    ComboPooledDataSource newdataSource4;
    @Autowired
    ComboPooledDataSource newdataSource5;
    @Autowired
    ComboPooledDataSource newdataSource6;
    @Autowired
    ComboPooledDataSource newdataSource7;
    @Autowired
    ComboPooledDataSource newdataSource8;
    @Autowired
    ComboPooledDataSource newdataSource9;
    @Autowired
    ComboPooledDataSource newdataSource10;
    @Autowired
    ComboPooledDataSource newdataSource11;
    @Autowired
    ComboPooledDataSource newdataSource12;
    @Autowired
    ComboPooledDataSource newdataSource13;
    @Autowired
    ComboPooledDataSource newdataSource14;
    @Autowired
    ComboPooledDataSource newdataSource15;
    @Autowired
    ComboPooledDataSource newdataSource16;
    @Autowired
    ComboPooledDataSource newdataSource17;
    @Autowired
    ComboPooledDataSource newdataSource18;
    @Autowired
    ComboPooledDataSource newdataSource19;


    public ComboPooledDataSource getNewDataSource(int value){
        if(0 == value){
            return newdataSource0;
        }else if(1 == value){
            return newdataSource1;
        }else if(2 == value){
            return newdataSource2;
        }else if(3 == value){
            return newdataSource3;
        }else if(4 == value){
            return newdataSource4;
        }else if(5 == value){
            return newdataSource5;
        }else if(6 == value){
            return newdataSource6;
        }else if(7 == value){
            return newdataSource7;
        }else if(8 == value){
            return newdataSource8;
        }else if(9 == value){
            return newdataSource9;
        }else if(10 == value){
            return newdataSource10;
        }else if(11 == value){
            return newdataSource11;
        }else if(12 == value){
            return newdataSource12;
        }else if(13 == value){
            return newdataSource13;
        }else if(14 == value){
            return newdataSource14;
        }else if(15 == value){
            return newdataSource15;
        }else if(16 == value){
            return newdataSource16;
        }else if(17 == value){
            return newdataSource17;
        }else if(18 == value){
            return newdataSource18;
        }else if(19 == value){
            return newdataSource19;
        }
        return null;
    }


    public ComboPooledDataSource getDataSource(int value){
        if(0 == value){
            return dataSource0;
        }else if(1 == value){
            return dataSource1;
        }else if(2 == value){
            return dataSource2;
        }else if(3 == value){
            return dataSource3;
        }else if(4 == value){
            return dataSource4;
        }else if(5 == value){
            return dataSource5;
        }else if(6 == value){
            return dataSource6;
        }else if(7 == value){
            return dataSource7;
        }else if(8 == value){
            return dataSource8;
        }else if(9 == value){
            return dataSource9;
        }else if(10 == value){
            return dataSource10;
        }else if(11 == value){
            return dataSource11;
        }else if(12 == value){
            return dataSource12;
        }else if(13 == value){
            return dataSource13;
        }else if(14 == value){
            return dataSource14;
        }else if(15 == value){
            return dataSource15;
        }else if(16 == value){
            return dataSource16;
        }else if(17 == value){
            return dataSource17;
        }else if(18 == value){
            return dataSource18;
        }else if(19 == value){
            return dataSource19;
        }
        return null;
    }


}
