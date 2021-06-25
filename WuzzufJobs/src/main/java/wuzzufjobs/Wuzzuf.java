/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author hassan
 */
public class Wuzzuf 
{
    public static void main(String [] args) throws IOException{
        
        JobDAO readJobs = new JobDAO();
        readJobs.read("Wuzzuf_Jobs.csv");
        readJobs.summary();
        //readJobs.clean();
        
        readJobs.popularAreas();
        readJobs.popularTitles();
        readJobs.popularCompanies();
        readJobs.getSkillCount();
    }
    
}
