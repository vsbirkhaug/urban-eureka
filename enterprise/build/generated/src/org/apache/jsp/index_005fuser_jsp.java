package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_005fuser_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>User login</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/login.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"login-page\">\n");
      out.write("        <div class=\"form\">\n");
      out.write("          <form class=\"register-form\" method=\"POST\" action=\"NewUser.do\">\n");
      out.write("            <input type=\"text\" name=\"username\" placeholder=\"username\"/>\n");
      out.write("            <input type=\"text\" name=\"address\" placeholder=\"address\"/>\n");
      out.write("            <input type=\"date\" name=\"dob\" placeholder=\"date of birth\"/>\n");
      out.write("            <input class=\"button\" type=\"submit\" name=\"tbl\" value=\"Register\"/>\n");
      out.write("            </br>         \n");
      out.write("            <p class=\"message\">Already registered? <a href=\"#\">Sign In</a></p>\n");
      out.write("          </form>\n");
      out.write("          <form class=\"login-form\">\n");
      out.write("            <input type=\"text\" placeholder=\"username\"/>\n");
      out.write("            <input type=\"password\" placeholder=\"password\"/>\n");
      out.write("            <button>login</button>\n");
      out.write("            <p class=\"message\">Not registered? <a href=\"#\">Create an account</a></p>\n");
      out.write("          </form>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("            <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>\n");
      out.write("            <script src=\"javascript/login.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
