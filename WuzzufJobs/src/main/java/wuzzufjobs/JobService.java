/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
/**
 *
 * @author hassan
 */
@Path("/JobService")
public class JobService {
    JobDAO dao = new JobDAO();
    String CSVFile = "Wuzzuf_Jobs.csv";
    @GET
    @Path("/read")
    @Produces(MediaType.APPLICATION_XML)
    public Dataset<Row> read(){
         return dao.read(CSVFile);
    }
    
}
