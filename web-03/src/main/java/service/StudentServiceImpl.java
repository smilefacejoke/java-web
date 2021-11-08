package service;

import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Student;
import util.MyBatisUtil;

import java.util.List;

/**
 * @author 54350
 */
public class StudentServiceImpl implements StudentService{

    private StudentMapper studentMapper;
    public StudentServiceImpl(){
        //1.得到sqlsession
        SqlSession sqlSession= MyBatisUtil.getSqlSession(true);
        studentMapper=sqlSession.getMapper(StudentMapper.class);
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void delete(String sid) {
        studentMapper.delete(sid);
    }
}
