package ${packageName}.dao;

import  ${packageName}.base.BaseDao;
import  ${packageName}.po.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* Created by ${userId} on ${createTime}
*/
@Repository
public class BookDAOImpl extends BaseDao implements BookDAO {

@Override
public List<Book> getAllBooks() {
    List<Book> list = (List<Book>)this.getHibernateTemplate().find("from Book");
        return list;
        }

        @Override
        public Book getBookById(int id) {
        return null;
        }

        @Override
        public int add(Book entity) {
        return 0;
        }

        @Override
        public int delete(int id) {
        return 0;
        }

        @Override
        public int update(Book entity) {
        return 0;
        }
        }