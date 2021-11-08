package service;

import mapper.ClassMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Class;
import util.MyBatisUtil;

import java.util.List;

/**
 * @author 54350
 */
public class ClassServiceImpl implements ClassService {

    private ClassMapper classMapper;
    public ClassServiceImpl(){
        SqlSession sqlSession= MyBatisUtil.getSqlSession(true);
        classMapper=sqlSession.getMapper(ClassMapper.class);
    }

    @Override
    public List<Class> findAll() {
        return classMapper.selectByExample(null);
    }
}
