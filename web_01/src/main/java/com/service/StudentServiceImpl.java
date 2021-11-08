package com.service;

import com.mapper.StudentMapper;
import com.pojo.Student;
import com.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author 54350
 */
public class StudentServiceImpl implements StudentService{

    //1. 得到sqlSession
    private SqlSession sqlSession= MyBatisUtil.getSqlSession(true);
    //2. 得到mapper对象
    private StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
    //3. 查询所有学生
    public List<Student> findAll(){
        return studentMapper.findAll();
    }

}
