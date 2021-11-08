package service;

import pojo.Student;

import java.util.List;

/**
 * @author 54350
 */
public interface StudentService {
    List<Student> findAll();

    void insert(Student student);

    void update(Student student);

    void delete(String sid);
}
