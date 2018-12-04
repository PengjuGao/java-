package ${packageName}.web;

import ${packageName}.dao.BookDAO;
import ${packageName}.po.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.util.StringUtils;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;
<#if cache != "">
import ${packageName}.service.CacheService;
</#if>
import java.util.List;


/**
* Created by ${userId} on ${createTime}.
*/
@Controller
@RequestMapping("/test")
public class TestController {

<#if cache != "">
@Autowired
CacheService cacheService;
</#if>

<#if ormFramework == "mybatis" || ormFramework == "hibernate">
@Autowired
BookDAO bookDAO;
/**
* 测试数据库是否正常
* @return
*/
@RequestMapping("/database")
public String testDatabase(Model model) {
StringBuilder builder = new StringBuilder();
List<Book> list = bookDAO.getAllBooks();
    for (Book book :
    list) {
    builder.append(book.toString()).append("\n");
    }
    if(StringUtils.isEmpty(builder.toString())){
    model.addAttribute("result","请先往数据库添加测试数据------");
    }
    model.addAttribute("result",builder.toString());
    return "/testDatabase";
    }
</#if>

    /**
    * 测试页面跳转是否正常
    * @param model
    * @return
    */
@RequestMapping("/index")
public String testPage(Model model){
System.out.println("success!!!!");
model.addAttribute("result","project is running successfully!!!");
return "/index";
}

<#if cache!="">
    /**
    * 测试cache配置是否成功
    * @return
    */
    @RequestMapping("/cache")
    public String testCache() {
    String value = cacheService.testCache("cacheTest");
    return "/cacheTest";
    }
</#if>
<#if sitemesh=="yes">
    @RequestMapping("/nositemesh")
    public String noSitemesh(Model model) {
    model.addAttribute("result", "这是不带有sitemesh的页面");
    return "/nositemesh";
    }
</#if>
}