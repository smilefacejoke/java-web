/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-11-03 07:50:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>列表学生</title>\r\n");
      out.write("    <script src=\"webjars/jquery/3.6.0/dist/jquery.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"webjars/bootstrap/3.4.1/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"webjars/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        .table{\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("    <div class=\"panel panel-primary\">\r\n");
      out.write("        <div class=\"panel-heading\">\r\n");
      out.write("            <div class=\"panel-title\">\r\n");
      out.write("                <h3>学生列表</h3>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <table class=\"table table-hover table-striped\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>学号</td>\r\n");
      out.write("                <td>姓名</td>\r\n");
      out.write("                <td>性别</td>\r\n");
      out.write("                <td>年龄</td>\r\n");
      out.write("                <td>住址</td>\r\n");
      out.write("                <td>所在班级</td>\r\n");
      out.write("                <td>操作</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("        </table>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"panel-footer text-right\">\r\n");
      out.write("            <a href=\"\" class=\"btn btn-info btn-sm\" data-toggle=\"modal\" data-target=\"#myModal\" onclick=\"addStudent()\">添加学生</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal fade\" id=\"myModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\">\r\n");
      out.write("            <div class=\"modal-dialog\" role=\"document\">\r\n");
      out.write("                <div class=\"modal-content\">\r\n");
      out.write("                    <div class=\"modal-header\">\r\n");
      out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\r\n");
      out.write("                        <h4 class=\"modal-title\" id=\"myTitle\">添加学生</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-body\">\r\n");
      out.write("                        <form class=\"form-horizontal\" method=\"post\">\r\n");
      out.write("                            <input type=\"hidden\" name=\"sid\" id=\"sid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${student.sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"name\" class=\"col-sm-2 control-label\">学生姓名</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"name\" name=\"name\" placeholder=\"姓名\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label  class=\"col-sm-2 control-label\">性别:</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <div class=\"radio\">\r\n");
      out.write("                                        <label>\r\n");
      out.write("                                            <input type=\"radio\" name=\"sex\" id=\"sex1\" value=\"男\" checked>男\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                        <label>\r\n");
      out.write("                                            <input type=\"radio\" name=\"sex\" id=\"sex2\" value=\"女\" >女\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"age\" class=\"col-sm-2 control-label\">学生年龄</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"age\" name=\"age\" placeholder=\"请输入年龄\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label for=\"addr\" class=\"col-sm-2 control-label\">学生住址</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"addr\" name=\"addr\" placeholder=\"请输入地址\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-group\">\r\n");
      out.write("                                <label  class=\"col-sm-2 control-label\">所在班级:</label>\r\n");
      out.write("                                <div class=\"col-sm-10\">\r\n");
      out.write("                                    <select class=\"form-control\" name=\"cid\" id=\"cid\">\r\n");
      out.write("                                        ");
      if (_jspx_meth_c_005fforEach_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                                    </select>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"modal-footer\">\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">关闭</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-primary\" onclick=\"save()\">保存 </button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    //1.保存学生\r\n");
      out.write("    function save() {\r\n");
      out.write("        //1.1根据表单隐藏域，决定是添加还是修改\r\n");
      out.write("        let sid=$(\"#sid\").val();\r\n");
      out.write("        //1.2定义action定址\r\n");
      out.write("        let url=\"\"\r\n");
      out.write("        if(sid){\r\n");
      out.write("            //修改\r\n");
      out.write("            url=\"/student?cmd=update\"\r\n");
      out.write("        }else {\r\n");
      out.write("            //添加\r\n");
      out.write("            url=\"/student?cmd=add\"\r\n");
      out.write("        }\r\n");
      out.write("        //1.3为表单的action属性赋值\r\n");
      out.write("        document.forms[0].action=url;\r\n");
      out.write("        //1.4提交表单\r\n");
      out.write("        document.forms[0].submit();\r\n");
      out.write("    }\r\n");
      out.write("    //2.添加学生界面\r\n");
      out.write("    function addStudent() {\r\n");
      out.write("        //2.1修改标题\r\n");
      out.write("        $(\"#myTitle\").html(\"添加学生\");\r\n");
      out.write("        //2.2重置表单\r\n");
      out.write("         document.forms[0].reset();\r\n");
      out.write("\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //3.修改学生界面\r\n");
      out.write("    function updateUI(sid,name,sex,age,addr,cid) {\r\n");
      out.write("        //3.1\r\n");
      out.write("        if(sid) {\r\n");
      out.write("            //修改对话框标题\r\n");
      out.write("            $(\"#myTitle\").html(\"修改学生\");\r\n");
      out.write("        }\r\n");
      out.write("        //3.2显示当前修改的数据(为表单赋值）\r\n");
      out.write("        $(\"#sid\").val(sid);\r\n");
      out.write("        $(\"#name\").val(name);\r\n");
      out.write("        $(\"#age\").val(age);\r\n");
      out.write("        $(\"#addr\").val(addr);\r\n");
      out.write("        $(\"#cid\").val(cid);\r\n");
      out.write("        if(sex=='男'){\r\n");
      out.write("            $('#sex1').prop(\"checked\",true);\r\n");
      out.write("        };\r\n");
      out.write("        if(sex=='女'){\r\n");
      out.write("            $('#sex2').prop(\"checked\",true);\r\n");
      out.write("        }\r\n");
      out.write("        //3.4为表单隐藏域sid赋值\r\n");
      out.write("        $(\"sid\").val(sid);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    //4.删除学生信息\r\n");
      out.write("    function delStudent(sid){\r\n");
      out.write("        console.log(\"sid:\",sid);\r\n");
      out.write("        if(confirm(\"你真的要删除吗?\")){\r\n");
      out.write("            location.href = \"/student?cmd=delete&sid=\"+sid;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/student/list.jsp(40,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/student/list.jsp(40,12) '${students}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${students}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/student/list.jsp(40,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("st");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                <tr>\r\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.sex}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.age}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.addr}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                    <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.cname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                    <td>\r\n");
          out.write("                        <a href=\"\" class=\"btn btn-success btn-sm\" onclick=\"updateUI(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.sex}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.age}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(',');
          out.write('\'');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.addr}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('\'');
          out.write(',');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.cid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(")\" data-toggle=\"modal\" data-target=\"#myModal\">修改</a>\r\n");
          out.write("                        <a href=\"\" class=\"btn btn-danger btn-sm\" onclick=\"delStudent(");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${st.sid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(")\">删除</a>\r\n");
          out.write("                    </td>\r\n");
          out.write("                </tr>\r\n");
          out.write("            ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent(null);
    // /WEB-INF/student/list.jsp(104,40) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/student/list.jsp(104,40) '${classes}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${classes}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/student/list.jsp(104,40) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("c");
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("                                            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.cid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${c.cname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("                                        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
