/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobServices;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

/**
 *
 * @author hassan
 */
public class GraphAreas extends HttpServlet{
    
    String CSVFile = "/home/hassan/NetBeansProjects/JobServices/Wuzzuf_Jobs.csv";
    JobDAO dao = new JobDAO();
    List<Job> jobs = dao.read(CSVFile);
    
    List<Map.Entry> areas = Count.popularAreas(jobs);
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
{        
        resp.setContentType("image/png");

        OutputStream os = resp.getOutputStream();

        JFreeChart chart = Graph.barPlot(areas,"Top Six Popular Areas");
        int width = 1024;
        int height = 720;

        ChartUtils.writeChartAsPNG(os, chart, width, height);
    }
    
}
