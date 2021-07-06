/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobServices;

import java.util.ArrayList;
import java.util.List;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
/**
 *
 * @author hassan
 */
public class JobDAO {
    private Dataset<Row> df;
    
    JobDAO(){
    }
    
    public List<Job> read(String CSVFile){
        SparkConf conf = new SparkConf ().setAppName ("Wuzzuf Jobs")
                        .setMaster("local[*]")
                        .set("com.couchbase.bucket.default", "");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(javaSparkContext);
        this.df =  sqlContext.read()
            .format("com.databricks.spark.csv")
            .option("inferSchema", "true")
            .option("header", "true").load(CSVFile);
        Dataset<Row> df1 = Pandas.clean(df);
        Pandas pd = new Pandas();
        List<Job> jobs = pd.convertToList(df1);
        javaSparkContext.close();
        
        return jobs;
    }
    
    
    public List<Dataset<Row>>  dataPrep(Dataset<Row> dataFrame){
        List<Dataset<Row>> r = new ArrayList();
        double split[] = {0.8, 0.2};
        Dataset<Row> dfArray[] = dataFrame.randomSplit (split, 42);
        Dataset<Row> dfTrain = dfArray[0];
        Dataset<Row> dfTest =dfArray[1];
        r.add(dfTrain);
        r.add(dfTest);
        System.out.println ("Training Data Set Size is : " + dfTrain.count ());
        System.out.println ("Test Data Set Size is     : " +dfTest.count ());
        return r;
    } 
}
