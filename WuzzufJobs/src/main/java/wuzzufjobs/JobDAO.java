/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrameNaFunctions;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.commons.lang3.StringUtils;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;
import scala.Tuple2;

/**
 *
 * @author hassan
 */
public class JobDAO {
    private static final String COMMA_DELIMITER = ",";
    private Dataset<Row> df;
    private JavaRDD<String> jobs;
    JobDAO(){
    }
    
    
    public void read(String CSVFile){
        SparkConf conf = new SparkConf ().setAppName ("Wuzzuf Jobs")
                        .setMaster("local[*]")
                        .set("com.couchbase.bucket.default", "");
        JavaSparkContext javaSparkContext = new JavaSparkContext(conf);
        this.jobs = javaSparkContext.textFile (CSVFile);
        SQLContext sqlContext = new SQLContext(javaSparkContext);
        this.df =  sqlContext.read()
            .format("com.databricks.spark.csv")
            .option("inferSchema", "true")
            .option("header", "true").load(CSVFile);
        this.df.show(5);
        
    }
    
    public void summary(){
        String names = Arrays.toString(this.df.columns());
        long columns = this.df.columns().length;
        long rows = this.df.count();
        Tuple2<String,String>[] types = this.df.dtypes();
        System.out.println("Number of Rows\n"+rows);
        System.out.println("Number of Column\n"+columns);
        System.out.println("Column Names\n"+names);
        System.out.println("Column Types\n"+Arrays.toString(types));
        df.printSchema();
    }
    
    public void clean(){
        this.df = this.df.dropDuplicates();
        long rows = this.df.count();
        DataFrameNaFunctions f = this.df.na();
        f.drop();
        long r = df.count();
        System.out.println("Number of Rows After removing Duplicates\n"+rows);
        System.out.println("Number of Rows After removing Nulls\n"+r);
    }
    
    public void popularTitles(){
        JavaRDD<String> titles = this.jobs
                .map (JobDAO::extractTitle)
                .filter (StringUtils::isNotBlank);
        Map<String, Long> titleCounts = titles.countByValue ();
        List<Map.Entry> sorted = titleCounts.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        
        CategoryChart chart = new CategoryChartBuilder ()
                .width (1024).height (768)
                .title ("Top Five Popular Titles")
                .xAxisTitle ("Names")
                .yAxisTitle("Number of Jobs").build ();
        // 2.Customize Chart
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        
        List<String> o =new ArrayList() ;
        sorted.forEach(c->{o.add((String) c.getKey());});
        List<Long> p = new ArrayList() ;
        sorted.forEach(c->{p.add((Long) c.getValue());});
        chart.addSeries ("Top Five Popular Titles", o.subList(o.size()-5, o.size()), p.subList(o.size()-5, o.size()));
        // 4.Show it
        new SwingWrapper (chart).displayChart ();
        
    }
    public void popularAreas(){
        JavaRDD<String> areas = this.jobs
                .map (JobDAO::extractLocation)
                .filter (StringUtils::isNotBlank);
        Map<String, Long> areaCounts = areas.countByValue ();
        List<Map.Entry> sorted = areaCounts.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        CategoryChart chart = new CategoryChartBuilder ()
                .width (1024).height (768)
                .title ("Top Five Popular Locations")
                .xAxisTitle ("Names")
                .yAxisTitle("Number of jobs").build ();
        // 2.Customize Chart
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        
        List<String> o =new ArrayList() ;
        sorted.forEach(c->{o.add((String) c.getKey());});
        List<Long> p = new ArrayList() ;
        sorted.forEach(c->{p.add((Long) c.getValue());});
        chart.addSeries ("Top Five Popular Locations", o.subList(o.size()-5, o.size()), p.subList(o.size()-5, o.size()));
        // 4.Show it
        new SwingWrapper (chart).displayChart ();
        
    }
    public void popularCompanies(){
        JavaRDD<String> companies = this.jobs
                .map (JobDAO::extractCompany)
                .filter (StringUtils::isNotBlank);
        Map<String, Long> companyCounts = companies.countByValue ();
        List<Map.Entry> sorted = companyCounts.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
        CategoryChart chart = new CategoryChartBuilder ()
                .width (1024).height (768)
                .title ("Top Five Hiring Companies")
                .xAxisTitle ("Names")
                .yAxisTitle("Jobs").build ();
        // 2.Customize Chart
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        
        List<String> o =new ArrayList() ;
        sorted.forEach(c->{o.add((String) c.getKey());});
        List<Long> p = new ArrayList() ;
        sorted.forEach(c->{p.add((Long) c.getValue());});
        chart.addSeries ("Top Five Demanding Companies", o.subList(o.size()-5, o.size()), p.subList(o.size()-5, o.size()));
        // 4.Show it
        new SwingWrapper (chart).displayChart ();
        
    }
   /* public void c(){
        List<Row> g = df.groupBy("Title").count().collectAsList();
        g.forEach(c->{System.out.println(c.getString(0)+" : "+c.getLong(1));});
        
        //df.groupBy("Title").count().sort().show();
        //Dataset<Row> s = this.df.sort("Company");
        //s.foreach(x->{System.out.println(x.toString());});
    }*/
    
    public void getSkillCount() {
        JavaRDD<String> skills = this.jobs
                .map (JobDAO::extractSkill)
                .filter (StringUtils::isNotBlank);
        JavaRDD<String> words = skills.flatMap (tag -> Arrays.asList (tag
                .split (",")).iterator ());
        Map<String, Long> skillCounts = words.countByValue ();
        List<Map.Entry> sorted = skillCounts.entrySet ()
                .stream ()
                .sorted (Map.Entry.comparingByValue ())
                .collect (Collectors.toList ());
        
        // DISPLAY
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
    }
    
    private static String extractTitle(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[0];
        } catch (Exception e) {
            return "";
        }
    }
    
    private static String extractCompany(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[1];
        } catch (Exception e) {
            return "";
        }
        
    }
    private static String extractLocation(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[2];
        } catch (Exception e) {
            return "";
        }
    }
    private static String extractType(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[4];
        } catch (Exception e) {
            return "";
        }
    }
    
    private static String extractLevel(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[5];
        } catch (Exception e) {
            return "";
        }
        
    }
   private static String extractYearsExpr(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[6];
        } catch (Exception e) {
            return "";
        }
    }
    
    private static String extractCountry(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[7];
        } catch (Exception e) {
            return "";
        }
        
    }
    
    private static String extractSkill(String jobLine) {
        try {
             return jobLine.split (COMMA_DELIMITER)[8];
        } catch (Exception e) {
            return "";
        }
    }

   
    
}
