package web.servlet;

import com.alibaba.fastjson.JSON;
import service.ClassService;
import service.ClassServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 54350
 */

@WebServlet("/classes")
public class ClassesServlet extends HttpServlet {

    private ClassService classService;

    @Override
    public void init() throws ServletException {
        classService=new ClassServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.查询所有班级
        List<Class> classes=classService.findAll();
        //2.转换为json串输出
        resp.getWriter().println(JSON.toJSONString(classes));
        resp.getWriter().flush();

    }
}
