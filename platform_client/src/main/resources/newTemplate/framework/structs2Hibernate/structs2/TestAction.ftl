package ${packageName}.web;

import com.opensymphony.xwork2.ModelDriven;
import ${packageName}.dao.BookDAO;
import ${packageName}.dao.BookDAOImpl;
import ${packageName}.po.Book;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

/**
* Created by ${userId} on ${createTime}.
* 测试Action
*/
public class TestAction extends ActionSupport implements ModelDriven<Book> {
    private BookDAO bookDao = new BookDAOImpl();
    private Book book = new Book();
    HttpServletResponse response = ServletActionContext.getResponse();
    private String result = "operation is success!!!!";

    public String getResult() {
    return result;
    }

    public void setResult(String result) {
    this.result = result;
    }

    public Book getBook() {
    return book;
    }

    public void setBook(Book book) {
    this.book = book;
    }

    /**
    * 测试struts2 跳转是否成功
    * @return
    */
    public String index() {
    result="success!!!!";
    return SUCCESS;
    }

    /**
    * 测试数据库查询
    */
    public String testDatabase() {
    StringBuilder builder = new StringBuilder();
    List<Book> list = bookDao.getAllBooks();
        if (list != null && list.size() == 0) {
        System.out.println("没有查询到数据-----");
        }
        for (Book tempBook :
        list) {
        builder.append(tempBook.toString()).append("\n");
        }

        result=builder.toString();
        return SUCCESS;
        }

        <#if sitemesh=="yes">
            /***
            * 测试sitemesh
            * @return
            */
            public String nositemesh(){
            return SUCCESS;
            }
        </#if>
        /**
        * 装载model
        * @return
        */
        @Override
        public Book getModel() {
        return book;
        }
        }