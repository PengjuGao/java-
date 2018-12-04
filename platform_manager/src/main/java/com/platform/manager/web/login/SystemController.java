package com.platform.manager.web.login;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.platform.manager.web.jdbc.TableAndColumns;
import com.platform.core.service.TableAndColumnsService;
import com.platform.core.vo.TableAndColumnsVo;
import com.platform.manager.web.jdbc.DataBaseConnection;


@Controller
@RequestMapping("/system")
public class SystemController {
	
	@Autowired
	private TableAndColumnsService service;
	
	
	/**
	 * 查询菜单
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/menu_list.html")
	public String menuList(HttpServletRequest request,HttpServletResponse response){
		
		
		return "/system/menu/menu_list";
	}
	
	

	/**
	 * 跳转到操作数据库的页面
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/tablePage.html")
	public String tablePage(HttpServletRequest request,HttpServletResponse response,Model model){
		
		
		return "/system/jdbc/tableAndColumns";
	}
	

	/**
	 * 查询目标数据库中的所有表及字段，先存放到TableAndColumns中，方便获取，然后展示在页面上
	 * TODO:动态传参数的问题还未解决
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/getTableAndColumns.html")
	public String getTableAndColumns(HttpServletRequest request,HttpServletResponse response,Model model){
		
		
		DataBaseConnection connect = new DataBaseConnection();
		
		try {
			
			List<TableAndColumns> list = connect.excuteQuery(null);
			
			int num = 0;
			
			for (TableAndColumns tableAndColumns : list) {
				num++;
				
				com.platform.core.po.TableAndColumns temp = new com.platform.core.po.TableAndColumns();
				
				temp.setTableName(tableAndColumns.getTableName());
				
				List<String> tempList = tableAndColumns.getColumns();
				
				temp.setId(num);
				
				for (int i=0;i<tempList.size();i++) {
					
					
					if(i == 0){
						temp.setColumns(tempList.get(i));
					}else{
						temp.setColumns(temp.getColumns()+tempList.get(i));
					}
					
					if(i!=tempList.size()-1){
						temp.setColumns(temp.getColumns()+",");
					}
				}
				
				service.insert(temp);
			}
			
			model.addAttribute("list", list);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/system/jdbc/tableAndColumns";
	}
	

    /**
     * 操作表字段，判断要生成的页面等一系列可自动生成的操作（所有可自动生成的操作目前只在本项目的状况下支持）
     * @param request
     * @param response
     * @param model
     * @return
     */
	@RequestMapping(value = "/operatorColumns.html")
    public  String operatorColumns(String tableName,HttpServletRequest request,HttpServletResponse response,Model model){
    	
		TableAndColumnsVo vo = new TableAndColumnsVo();
		
		TableAndColumnsVo.Criteria criteria =  vo.createCriteria();
		
		criteria.andTableNameEqualTo(tableName);
		
    	List<com.platform.core.po.TableAndColumns> temp = this.service.selectByVo(vo);
    	
    	model.addAttribute("obj", temp.get(0));
    	
    	return "/system/jdbc/operatorColumns";
    }
	
	
}
