/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JobServices;

import java.util.List;
import java.util.Map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
/**
 *
 * @author hassan
 */
public class Graph {
    
    public static JFreeChart piePlot(List<Map.Entry> sorted, String title){
        
        int l = sorted.size();
        int g = 0;
        for(int i=6;i<l;i++){
            g = g+(Integer)sorted.get(i).getValue();
        }
        
        DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue((String) sorted.get(0).getKey(), (Integer) sorted.get(0).getValue());
        dataset.setValue((String) sorted.get(1).getKey(), (Integer) sorted.get(1).getValue());
        dataset.setValue((String) sorted.get(2).getKey(), (Integer) sorted.get(2).getValue());
        dataset.setValue((String) sorted.get(3).getKey(), (Integer) sorted.get(3).getValue());
        dataset.setValue((String) sorted.get(4).getKey(), (Integer) sorted.get(4).getValue());
        
        dataset.setValue("Other Companies", g);
        JFreeChart chart = ChartFactory.createPieChart(title,
                dataset, true, false, false);

        chart.setBorderVisible(false);

        return chart;
        
    }
    
    public static JFreeChart barPlot(List<Map.Entry> sorted, String title ){
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue((Integer) sorted.get(0).getValue(), "Hiring Numbers", (String) sorted.get(0).getKey());
        dataset.setValue((Integer) sorted.get(1).getValue(), "Hiring Numbers", (String) sorted.get(1).getKey());
        dataset.setValue((Integer) sorted.get(2).getValue(), "Hiring Numbers", (String) sorted.get(2).getKey());
        dataset.setValue((Integer) sorted.get(3).getValue(), "Hiring Numbers", (String) sorted.get(3).getKey());
        dataset.setValue((Integer) sorted.get(4).getValue(), "Hiring Numbers", (String) sorted.get(4).getKey());
        dataset.setValue((Integer) sorted.get(5).getValue(), "Hiring Numbers", (String) sorted.get(5).getKey());

        JFreeChart barChart = ChartFactory.createBarChart(
            title,
            "",
            "Hiring Numbers",
            dataset,
            PlotOrientation.VERTICAL,
            false, true, false);

            return barChart;
        
    }
    
    
    
}
