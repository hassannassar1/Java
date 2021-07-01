/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import scala.Tuple2;

/**
 *
 * @author hassan
 */
public class Pandas {
    private List<Job> jobsList = new ArrayList();
    
    public static void summary(Dataset<Row> df){
        String names = Arrays.toString(df.columns());
        long columns = df.columns().length;
        long rows = df.count();
        Tuple2<String,String>[] types = df.dtypes();
        df.show(5);
        System.out.println("\nNumber of Rows   : "+rows);
        System.out.println("\nNumber of Column : "+columns);
        System.out.println("\nColumn Names     : "+names);
        System.out.println("\nColumn Types     : "+Arrays.toString(types));
        df.printSchema();
    }
    
    public static Dataset<Row>  clean(Dataset<Row> df){
        df = df.dropDuplicates();
        long rows = df.count();
        long r = df.na().drop().count();
        System.out.println("\nNumber of Rows After removing Duplicates : "+rows);
        System.out.println("\nNumber of Rows After removing Nulls      : "+r);
        return df;
    }
    
    public List<Job> convertToList(Dataset<Row> df){
        df.collectAsList().forEach(row -> {
            this.jobsList.add(createJob(row));
        });
        return this.jobsList;
    }
    
    public Job createJob(Row row){
        return new Job( 
                  row.get(0).toString()
                , row.get(1).toString()
                , row.get(2).toString()
                , row.get(3).toString()
                , row.get(4).toString()
                , row.get(5).toString()
                , row.get(6).toString()
                , row.get(7).toString());

    }
}
