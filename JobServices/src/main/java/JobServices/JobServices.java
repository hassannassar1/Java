/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobServices;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hassan
 */
public class JobServices extends HttpServlet{
    String CSVFile = "/home/hassan/NetBeansProjects/JobServices/Wuzzuf_Jobs.csv";
    JobDAO dao = new JobDAO();
    List<Job> jobs = dao.read(CSVFile);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{       
        String json ;
        Gson h = new Gson();
        if (jobs.isEmpty()){json="Sorry Ther is an Error";}
        else{json = h.toJson(jobs);}
        
        resp.setContentType("application/json");
        resp.getWriter().println(json);
    }
    
    
    
}
