package web.servlet;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.beanutils.BeanUtils;
import pojo.R;
import pojo.Student;
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
import java.lang.reflect.InvocationTargetException;
import java.net.SocketOption;
import java.util.List;

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
            }else{
                //删除学生信息
                delete(request,response);
            }
        }
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
}
