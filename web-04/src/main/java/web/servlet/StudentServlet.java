package web.servlet;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import pojo.R;
import pojo.Student;
import pojo.StudentVo;
import service.ClassService;
import service.ClassServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * @author 54350
 */
@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentService studentService;
    private ClassService classService;


    @Override
    public void init() throws ServletException {
        studentService=new StudentServiceImpl();
        classService=new ClassServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //处理post请求的中文乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf8");
        //1.得到请求参数cmd
        String cmd=request.getParameter("cmd");
        //2.根据参数调用不同的方法
        if(StrUtil.isNotBlank(cmd)){
            if("list".equals(cmd)){
                //列表所有学生
                list(request,response);
            }else if("add".equals(cmd)){
                //添加学生信息
                add(request,response);
            }else if("update".equals(cmd)){
                //更新学生信息
                update(request,response);
            }else if("delete".equals(cmd)){
                //删除学生信息
                delete(request,response);
            }else if("findPage".equals(cmd)){
                //分页查询
                findPage(request,response);
            }else if("search".equals(cmd)){
                //分页带条件查询
                search(request,response);
            }else if("deleteByIds".equals(cmd)){
                deleteByIds(request,response);
            }
        }
    }


    //根据学生id删除学生（一个或多个)
    private void deleteByIds(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        1. 得到要删除的学生id
        String ids=request.getParameter("ids");
//        2. 开始删除
        String[] split=ids.split(",");
        for(String s : split){
            studentService.delete(s);
        }
//        3. 构造返回的R对象
        R ok=R.ok();
        response.getWriter().println(JSON.toJSONString(ok));
        response.getWriter().flush();
    }


    private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //2.1得到学生信息
        String sid=req.getParameter("sid");
        //2.2开始删除
        studentService.delete(sid);
        //2.4构造返回的R对象
        R ok=R.ok();
        resp.getWriter().println(JSON.toJSONString(ok));
        resp.getWriter().flush();

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.1查询所有学生
        List<Student> students=studentService.findAll();
        //1.2将上面的集合转换为json字符串
        String str= JSON.toJSONString(students);
        //1.3输出上面的内容到页面
        response.getWriter().println(str);
        //1.4刷新流
        response.getWriter().flush();
    }

    /**
     * 3更新学生信息
     * @param request
     * @param response
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //2.1得到学生信息
        String stud=request.getParameter("stud");
        //2.2转换为学生对象
        Student student=JSON.parseObject(stud,Student.class);
        //2.3添加学生到数据库中
        studentService.update(student);
        //2.4构造返回的R对象
        R ok=R.ok();
        response.getWriter().println(JSON.toJSONString(ok));
        response.getWriter().flush();
    }

    /**
     * 2新增学生信息
     * @param request
     * @param response
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        //2.1得到学生信息
        String stud=request.getParameter("stud");
        //2.2转换为学生对象
        Student student=JSON.parseObject(stud,Student.class);
        //2.3添加学生到数据库中
        studentService.insert(student);
        //2.4构造返回的R对象
        R ok=R.ok();
        response.getWriter().println(JSON.toJSONString(ok));
        response.getWriter().flush();
    }

    /**
     * 5.分页查询学生信息
     * @param request
     * @param response
     */
    private void findPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //5.1得到当前页及大小
        //当前页
        int page=Integer.parseInt(request.getParameter("page"));
        //每页大小
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
        //5.2开始分页
        PageInfo<Student> studentPageInfo=studentService.findPage(page,pageSize);
        //5.3转换为字符串并输出
        //当前记录集合
        List<Student> rows=studentPageInfo.getList();
        //总记录数
        long total=studentPageInfo.getTotal();
        //放入r对象之内
        R r=R.ok().put("rows",rows).put("total",total);
        //输出
        response.getWriter().println(JSON.toJSONString(r));
        response.getWriter().flush();
    }

    /**
     * 分页带条件查询
     * @param request
     * @param response
     */
    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        1. 得到当前页及每页大小
        int page=Integer.parseInt(request.getParameter("page"));
        int pageSize=Integer.parseInt(request.getParameter("pageSize"));
//        2. 得到查询参数字符串
        String stud=request.getParameter("stud");
//        3. 转换为学生对象
        StudentVo vo = JSON.parseObject(stud, StudentVo.class);
//        4. 开始进行分页带条件查询
        PageInfo<Student> studentPageInfo=studentService.search(page,pageSize,vo);
//        5. 转换为字符串并输出
//        5.1 得到当前页的记录集合
        //当前记录集合
        List<Student>rows=studentPageInfo.getList();
//        5.2 得到总记录数
        //总记录数
        long total=studentPageInfo.getTotal();
//        5.3 放到r对象中
        R r= Objects.requireNonNull(R.ok().put("rows", rows)).put("total",total);
//        5.4 输出
        response.getWriter().println(JSON.toJSONString(r));
        response.getWriter().flush();

    }


}
