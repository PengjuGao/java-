package ${packageName}.dao;

import  ${packageName}.base.BaseDao;
import  ${packageName}.po.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
* Created by ${userId} on ${createTime}
*/

public class BookDAOImpl implements BookDAO {

@Override
public List<Book> getAllBooks() {
    List<Book> list = BaseDao.getSession().createQuery("from Book ", Book.class).getResultList();
        return list;
        }

        @Override
        public Book getBookById(int id) {
        return null;
        }

        @Override
        public int add(Book entity) {
        Session session = BaseDao.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
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