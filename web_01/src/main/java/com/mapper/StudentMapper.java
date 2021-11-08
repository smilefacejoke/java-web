package com.mapper;

import com.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //1.代表查询所有学生

    List<Student> findAll();

}
