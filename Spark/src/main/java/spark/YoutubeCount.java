/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spark;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 *
 * @author hassan
 */
public class YoutubeCount {
    private static final String COMMA_DELIMITER = ",";
    
    public void getTitleWordCount(){
    // CREATE SPARK CONTEXT
    SparkConf conf = new SparkConf ().setAppName ("wordCounts").setMaster ("local[3]");
    JavaSparkContext sparkContext = new JavaSparkContext (conf);
    
    // LOAD DATASETS
    JavaRDD<String> videos = sparkContext.textFile ("USvideos.csv");
    
    // TRANSFORMATIONS
    JavaRDD<String> titles = videos
    .map (YoutubeCount::extractTitle)
    .filter (StringUtils::isNotBlank);
    
    JavaRDD<String> words = titles.flatMap (title -> Arrays.asList (title
    .toLowerCase ()
    .trim ()
    .replaceAll ("\\p{Punct}", "")
    .split (" ")).iterator ());
    
    // COUNTING
    Map<String, Long> wordCounts = words.countByValue ();
    
    List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
    .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
    
    // DISPLAY
    sorted.forEach(entry -> {
        System.out.println (entry.getKey () + " : " + entry.getValue ());
    });
    
    }
    
    public void getTagWordCount() {
        
        // CREATE SPARK CONTEXT
        SparkConf conf = new SparkConf ().setAppName ("tagCounts").setMaster ("local[6]");
        JavaSparkContext sparkContext = new JavaSparkContext (conf);
        
        // LOAD DATASETS
        JavaRDD<String> videos = sparkContext.textFile ("USvideos.csv");
 
        // TRANSFORMATIONS
        JavaRDD<String> tags = videos
                .map (YoutubeCount::extractTag)
                .filter (StringUtils::isNotBlank);
       // JavaRDD<String>
        JavaRDD<String> words = tags.flatMap (tag -> Arrays.asList (tag
                .split ("\"\"\\|\"\"")).iterator ());
        System.out.println("*****************************************" + words.toString ());
        
        // COUNTING
        Map<String, Long> wordCounts = words.countByValue ();
        List<Map.Entry> sorted = wordCounts.entrySet ().stream ()
                .sorted (Map.Entry.comparingByValue ()).collect (Collectors.toList ());
        
        // DISPLAY
        sorted.forEach(entry -> {
            System.out.println (entry.getKey () + " : " + entry.getValue ());
        });
    }
    
    private static String extractTag(String videoLine) {
        try {
             return videoLine.split (COMMA_DELIMITER)[6];
        } catch (Exception e) {
            return "";
        }
        
    }
    
    private static String extractTitle(String videoLine) {
            try{
            return videoLine.split (COMMA_DELIMITER)[2];
            }
            catch ( Exception e ){
                return "";
            }
    }

}
