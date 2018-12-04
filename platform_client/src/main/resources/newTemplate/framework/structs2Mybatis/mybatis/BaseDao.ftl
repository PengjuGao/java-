package ${packageName}.base;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
* Created by ${userId} on ${createTime}.
*/
public class BaseDao {
private static SqlSessionFactory factory;

static {
try {
Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
factory = new SqlSessionFactoryBuilder().build(reader, "local");
} catch (IOException e) {
e.printStackTrace();
}
}

public static SqlSession getSession() {
return factory.openSession();
}

public static <T> T getMapper(Class mapper) {
    SqlSession session = getSession();
    return (T) session.getMapper(mapper);
    }

    }
