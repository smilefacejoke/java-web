package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {

    //1.得到sqlsessionFactor
    private static SqlSessionFactory getSqlSessionFactory() throws IOException {
        //1.1 定义配置文件位置
        String resource = "mybatis/mybatis-config.xml";
        //1.2 得到配置文件对应的输入流对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //1.3 返回sqlSessionFactor对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder(). build(inputStream);
        return sqlSessionFactory;
    }

    //2.2 得到sqlSession
    public static SqlSession getSqlSession(boolean autoCommit){
        try {
            //2.1 得到sqlSessionFactory对象
            SqlSessionFactory sqlSessionFactory=getSqlSessionFactory();
            //2.2 根据sqlsessionFactory得到sqlSession对象
            return sqlSessionFactory.openSession(autoCommit);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
