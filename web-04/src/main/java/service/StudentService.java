package service;

import com.github.pagehelper.PageInfo;
import pojo.Student;
import pojo.StudentVo;

import java.util.List;

/**
 * @author 54350
 */
public interface StudentService {
    List<Student> findAll();

    void insert(Student student);

    void update(Student student);

    void delete(String sid);

    /**
     * 分页查询学生数据
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<Student> findPage(int page, int pageSize);

    PageInfo<Student> search(int page, int pageSize, StudentVo vo);
}
