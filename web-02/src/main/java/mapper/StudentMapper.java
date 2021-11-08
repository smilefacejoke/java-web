package mapper;



import pojo.Student;

import java.util.List;

/**
 * @author 54350
 */
public interface StudentMapper {

    //1.代表查询所有学生

    List<Student> findAll();

    void insert(Student student);

    void update(Student student);

    void delete(String sid);
}
