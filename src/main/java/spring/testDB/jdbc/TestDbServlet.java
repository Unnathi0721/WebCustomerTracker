package spring.testDB.jdbc;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;
@WebServlet("/TestDBServlet")
public class TestDbServlet extends HttpServlet {
    private static final long serialVersionUID=1;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String user="springstudent";
        String pass="springstudent";
        String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false";
        String driver="com.mysql.cj.jdbc.Driver";
        try{
            PrintWriter out=response.getWriter();
            out.println("Connecting to DataBase ...  : "+jdbcUrl);
            Class.forName(driver);
            Connection mycon= DriverManager.getConnection(jdbcUrl,user,pass);
            out.println("SUCCESS!!");
            mycon.close();
        }
        catch(Exception exc){
            exc.printStackTrace();
            throw new ServletException();
        }
    }

}
