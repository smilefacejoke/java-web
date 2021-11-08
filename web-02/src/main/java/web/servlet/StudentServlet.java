package web.servlet;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import org.apache.commons.beanutils.BeanUtils;
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
        //4.1 得到要删除的学生id
        String sid = req.getParameter("sid");
        System.out.println("sid = " + sid);
        //4.2 开始删除
        studentService.delete(sid);
        //4.3 进行转发或重定向
        resp.sendRedirect("/student?cmd=list");

    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.1查询所有学生
        List<Student> students=studentService.findAll();
        //1.2将集合放到请求作用域中
        request.setAttribute("students",students);
        //1.3查询所有的班级列表
        List<Class> classes = classService.findAll();
        request.setAttribute("classes",classes);
        //1.4进行页面转发
        request.getRequestDispatcher("/WEB-INF/student/list.jsp").forward(request,response);
    }

    /**
     * 3更新学生信息
     * @param request
     * @param response
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //3.1得到请求参数
        Student student=new Student();
        try {
            BeanUtils.populate(student,request.getParameterMap());
        }  catch (Exception e) {
            e.printStackTrace();
        }
        //3.2执行更新操作
        studentService.update(student);
        //3.3进行页面重定向
        response.sendRedirect("/student?cmd=list");
    }

    /**
     * 2新增学生信息
     * @param request
     * @param response
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        //2.1得到请求参数
        Student student=new Student();
        try {
            BeanUtils.populate(student,request.getParameterMap());
        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("student = " + student);
        //2.2添加学生到数据库中
        studentService.insert(student);
        //2.3进行页面重定向（不能转发，如果转发就会重复提交数据）
        response.sendRedirect("/student?cmd=list");
    }
}
