/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobServices;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hassan
 */
public class PopularTitles extends HttpServlet{
    
    String CSVFile = "/home/hassan/NetBeansProjects/JobServices/Wuzzuf_Jobs.csv";
    JobDAO dao = new JobDAO();
    List<Job> jobs = dao.read(CSVFile);
    
    List<Map.Entry> titles = Count.popularTitles(jobs);
    
    public PopularTitles(){}
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{        
        String json ;
        Gson h = new Gson();
        if (titles.isEmpty()){json ="Sorry an Error occurred";}
        else{json = h.toJson(titles);}
        
        resp.setContentType("application/json");
        resp.getWriter().println(json);
    }
    
    
}
