

package JobServices;

import java.util.List;
import java.util.Map;
import org.jfree.chart.JFreeChart;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hassan
 */
public class WebServiceTester {
    
    String CSVFile = "/home/hassan/NetBeansProjects/JobServices/Wuzzuf_Jobs.csv";
    JobDAO dao = new JobDAO();
    List<Job> jobs = dao.read(CSVFile);
    
    @Test
    public void jobListTest(){
        Assertions.assertNotNull(jobs);
    }
    
    @Test
    public void titlesListTest(){
        List<Map.Entry> titles = Count.popularTitles(jobs);
        Assertions.assertNotNull(titles);
    }
    
    @Test
    public void areasListTest(){
        List<Map.Entry> areas = Count.popularAreas(jobs);
        Assertions.assertNotNull(areas);
    }
    
    @Test
    public void companiesListTest(){
        List<Map.Entry> companies = Count.popularCompanies(jobs);
        Assertions.assertNotNull(companies);
    }
    
    @Test
    public void skillsListTest(){
        List<Map.Entry> skills = Count.getSkillCount(jobs);
        Assertions.assertNotNull(skills);
    }
    
    @Test
    public void titlesGraphTest(){
        List<Map.Entry> titles = Count.popularTitles(jobs);
        JFreeChart chart = Graph.barPlot(titles,"Top Six Demanded Jobs");
        Assertions.assertNotNull(chart);
    }
    
    @Test
    public void areasGraphTest(){
        List<Map.Entry> areas = Count.popularAreas(jobs);
        JFreeChart chart = Graph.barPlot(areas,"Top Six Demanded Jobs");
        Assertions.assertNotNull(chart);
    }
    
    @Test
    public void companiesGraphTest(){
        List<Map.Entry> companies = Count.popularCompanies(jobs);
        JFreeChart chart = Graph.barPlot(companies,"Top Six Demanded Jobs");
        Assertions.assertNotNull(chart);
    }
    
}
