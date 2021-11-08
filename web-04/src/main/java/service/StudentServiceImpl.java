package service;

import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.ClassMapper;
import mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import pojo.Student;
import pojo.StudentExample;
import pojo.StudentVo;
import util.MyBatisUtil;
import pojo.Class;

import java.util.List;

/**
 * @author 54350
 */
public class StudentServiceImpl implements StudentService{

    private StudentMapper studentMapper;
    private ClassMapper classMapper;

    public StudentServiceImpl(){
        //1.得到sqlsession
        SqlSession sqlSession= MyBatisUtil.getSqlSession(true);
        studentMapper=sqlSession.getMapper(StudentMapper.class);
        classMapper=sqlSession.getMapper(ClassMapper.class);
    }

    //1.查询所有学生
    @Override
    public List<Student> findAll() {
//        1.1得到所有学生列表
        List<Student> students = studentMapper.selectByExample(null);
        for(Student student : students){
//            1.2得到所有学生列表
            Integer cid = student.getCid();
//            1.3根据班级编号查询出班级对象
            Class classes = classMapper.selectByPrimaryKey(cid);
//            1.4将班级名称与学生对象绑定
            student.setCname(classes.getCname());
        }
        return students;
    }

    //2.添加学生
    @Override
    public void insert(Student student) {
        studentMapper.insert(student);
    }

    //3.更新学生
    @Override
    public void update(Student student) {
        studentMapper.updateByPrimaryKey(student);
    }

    //4.删除学生
    @Override
    public void delete(String sid) {
        studentMapper.deleteByPrimaryKey(Integer.parseInt(sid));
    }

    /**
     * 分页查询学生数据
     *
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Student> findPage(int page, int pageSize) {
//        5.1开始分页查询
        PageHelper.startPage(page,pageSize);
//        5.2进行查询
        StudentExample example=new StudentExample();
        List<Student>students=studentMapper.selectByExample(example);
//        5.3将查询到的学生绑定班级
        for(Student student:students){
            student.setCname(classMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
//        5.4定义返回的对象
        PageInfo<Student> studentPageInfo=new PageInfo<>(students);
//        5.5返回
        return studentPageInfo;



    }


    /**
     * 6. 分页带条件查询
     * @param page
     * @param pageSize
     * @param vo
     * @return
     */
    @Override
    public PageInfo<Student> search(int page, int pageSize, StudentVo vo) {
//        6.1 开始分页
        PageHelper.startPage(page,pageSize);
//        6.2 开始查询
//        6.2.1 定义查询示例（一次完整的查询过程）
        StudentExample example=new StudentExample();
//        6.2.2 为示例添加查询条件
        StudentExample.Criteria criteria=example.createCriteria();
        if(vo!=null){
            if(StrUtil.isNotBlank(vo.getName())){
                criteria.andNameLike("%"+vo.getName()+"%");
            }
            if(StrUtil.isNotBlank(vo.getAddr())){
                criteria.andAddrLike("%"+vo.getAddr()+"%");
            }
            if(vo.getCid()!=0){
                criteria.andCidEqualTo(vo.getCid());
            }
        }
//        6.2.3 开始条件查询
        List<Student> students=studentMapper.selectByExample(example);
//        6.2.4 将查询到的学生绑定班级名称
        for(Student student:students){
            student.setCname(classMapper.selectByPrimaryKey(student.getCid()).getCname());
        }
//        6.3 定义返回pageInfo对象
        return new PageInfo<>(students);

    }
}
