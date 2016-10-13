package filtre;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class SimpleFiltre implements Filter {

 @Override
 public void destroy() {
  // TODO Auto-generated method stub

 }

 @Override
 public void init(FilterConfig filterConfig) throws ServletException {

 }

 @Override
 public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
   throws IOException, ServletException {
  response.setContentType("text/html");

  PrintWriter out = response.getWriter();

  out.println("Headers<hr/>");
  Enumeration<String> headerNames = ((HttpServletRequest) request).getHeaderNames();
  while (headerNames.hasMoreElements()) {
   String headerName = headerNames.nextElement();
   out.print("Header Name: <em>" + headerName);
   String headerValue = ((HttpServletRequest) request).getHeader(headerName);
   out.print("</em>, Header Value: <em>" + headerValue);
   out.println("</em><br/>");
  }

  out.println("<br/>Parameters<hr/>");

  Enumeration<String> parameterNames = request.getParameterNames();
  if (parameterNames.hasMoreElements()) {
   while (parameterNames.hasMoreElements()) {
    String name = parameterNames.nextElement();
    String value = request.getParameter(name);
    out.println("name:" + name + ", value: " + value + "<br/>");
   }
  } else {
   out.println("---Aucun paramètre---<br/>");
  }
  out.println("<br/>");
  out.println("<br/>Début de la page:<br/><hr/>");
  filterChain.doFilter(request, response);
  out.println("<br/><hr/>Fin de la page:<br/>");

 }
}