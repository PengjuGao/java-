package com.auto.test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Controller
@RequestMapping("test")
public class TestMybatisController {

    @Autowired
    com.auto.test.mybatis.dao.BookDAO bookDAO;
    @RequestMapping("mybatis")
    @ResponseBody
    public  String testMybatis(){
       /* List<com.auto.test.mybatis.po.TbUser> list = mapper.getAllUser();
        StringBuilder builder = new StringBuilder();
        for (com.auto.test.mybatis.po.TbUser user :
                list) {
            builder.append(user.toString()).append("\n");
        }*/
        List<com.auto.test.mybatis.po.Book> list = bookDAO.getAllBooks();
        StringBuilder builder = new StringBuilder();
        for (com.auto.test.mybatis.po.Book book :
                list) {
            builder.append(book.getId()).append("####")
                    .append(book.getPrice()).append("#####")
                    .append(book.getTitle()).append("#####").append("\n");
        }
        return builder.toString();
    }

}
