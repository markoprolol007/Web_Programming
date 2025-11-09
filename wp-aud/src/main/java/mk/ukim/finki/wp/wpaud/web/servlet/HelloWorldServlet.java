package mk.ukim.finki.wp.wpaud.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = {"", "/hello"})
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        String name = req.getParameter("name");
        String surname = req.getParameter("surname");

        if (name == null){
            name = "John";
        }
        if (surname == null){
            surname = "Doe";
        }

        //write the response
        writer.format("<html><head></head><body><h1>Hello %s %s</h1></body></html>", name, surname);
        writer.flush();

    }

}
