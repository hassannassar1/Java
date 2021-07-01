/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
/**
 *
 * @author hassan
 */
@XmlRootElement(name="job")
public class JobDAO implements Serializable{
    private Dataset<Row> df;
    
    JobDAO(){
    }
    
    @XmlElement
    public Dataset<Row>  read(String CSVFile){
        SparkConf conf = new SparkConf ().setAppName ("Wuzzuf Jobs")
                        .setMaster("local[*]")
                        .set("com.couchbase.bucket.default", "");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(javaSparkContext);
        this.df =  sqlContext.read()
            .format("com.databricks.spark.csv")
            .option("inferSchema", "true")
            .option("header", "true").load(CSVFile);
        
        return this.df;
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
