/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package depebdencies;

import java.io.IOException;
import java.util.List;
import joinery.DataFrame;
import tech.tablesaw.api.Table;

/**
 *
 * @author hassan
 */
public class CSVRead {
    private String path;
    private Table titanicData ;
    private DataFrame<Object> df ;
    CSVRead(String path) throws IOException{
        this.path = path;
        this.titanicData = Table.read().csv(this.path);
    }
    public void ReadCSVByTableSaw() {
      
            List<String> colNames = this.titanicData.columnNames();
            this.titanicData.structure().printAll();
            System.out.println("####### First 5 Rows ###########");
            System.out.println(this.titanicData.first(5));
            System.out.println("####### Summary ###########");
            System.out.println(this.titanicData.summary());
            System.out.println("####### Max, Min, and Mean for Column Age ###########");
            System.out.println("Max  "+this.titanicData.nCol("age").max());
            System.out.println("Min  "+this.titanicData.nCol("age").min());
            System.out.println("Mean "+this.titanicData.nCol("age").mean());
            
    }
    
    public void ReadCSVByJoinery() {
        try {
            this.df = DataFrame.readCsv(this.path,",");
            List<Object> countrylst = df.col("Name");
            System.out.println(" No. of Passangers = " + countrylst.size());
            System.out.println("Passangers are :  " + countrylst);
            
            DataFrame<Object> passengersGroupedByPClass = df.groupBy("Pclass")
                    .count()
                    .sortBy("Age")
                    .head(10);
            System.out.println("Passangers are :  " + passengersGroupedByPClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
