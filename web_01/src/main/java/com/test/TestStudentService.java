package com.test;

import com.pojo.Student;

import com.service.StudentService;
import com.service.StudentServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author 54350
 */
public class TestStudentService {

    private StudentService studentService=new StudentServiceImpl();

    @Test
    public void test01(){
        //1.3 调用查询学生方法
        List<Student> students=studentService.findAll();
        //1.4打印
        for(Student student:students){
            System.out.println(student);
        }
    }

}
