package ${packageName}.po;

import java.util.Date;
import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;
/**
* Created by ${userId} on ${createTime}.
 * 图书实体
 */
@Entity//声明当前类为hibernate映射到数据库中的实体类
@Table(name = "book")//声明在数据库中自动生成的表名为t_user
public class Book implements Serializable{
    /**
     * 编号
     */
//声明此列为主键
@Id
//根据不同数据库自动选择合适的id生成方案，这里使用mysql,为递增型
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    /**
     * 书名
     */
    private String title;
    /**
     * 价格
     */
    private double price;
    /**
     * 出版日期
     */
    private Date publishDate;

    public Book(int id, String title, double price, Date publishDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }
    
    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
@Override
public String toString() {
return this.getTitle()+"---"+this.getId()+"----"+this.getPrice()+"--------";
}
}