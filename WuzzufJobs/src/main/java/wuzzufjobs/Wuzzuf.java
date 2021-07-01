/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import java.util.List;
import java.util.Map;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

/**
 *
 * @author hassan
 */
public class Wuzzuf 
{
    public static void main(String [] args){
        
        JobDAO readJobs = new JobDAO();
        Dataset<Row> df = readJobs.read("Wuzzuf_Jobs.csv");
        
        Pandas s = new Pandas();
        Pandas.summary(df);
        df = Pandas.clean(df);
        
        List<Job> jobs = s.convertToList(df);
        
        List<Map.Entry> PTitles = Count.popularTitles(jobs);
        List<Map.Entry> PCompanies = Count.popularCompanies(jobs);
        List<Map.Entry> PAreas = Count.popularAreas(jobs);
        List<Map.Entry> PSkills = Count.getSkillCount(jobs);
        
        Graph.barPlot(PTitles, "Top Five Popular Titles", "Names", "Number of Jobs");
        Graph.barPlot(PAreas, "Top Five Popular Locations", "Names", "Number of Jobs");
        Graph.piePlot(PCompanies, "Top Five Hiring Companies");
        
    }
    
}
