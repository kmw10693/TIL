package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * 1. 파라미터 전송 기능
 */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getParameterNames().asIterator().forEachRemaining(p -> System.out.println(p + request.getParameter(p)));
        String username = request.getParameter("username");
        System.out.println(username);
        String age = request.getParameter("age");
        System.out.println(age);

        String[] usernames = request.getParameterValues("username");
        for (String s : usernames) {
            System.out.println(username);
        }
        response.getWriter().write("ok");
    }
}
