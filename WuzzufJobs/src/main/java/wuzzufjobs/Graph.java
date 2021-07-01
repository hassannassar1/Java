/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wuzzufjobs;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler;

/**
 *
 * @author hassan
 */
public class Graph {
    
    public static void piePlot(List<Map.Entry> sorted, String title){
        
        PieChart chart = new PieChartBuilder ()
                .width (800).height (600)
                .title (title).build ();
        
        Color[] sliceColors = new Color[]{new Color (180, 68, 50),
            new Color (130, 105, 120), new Color (80, 143, 160),
            new Color (130, 105, 100), new Color (150, 105, 120), new Color (150, 10, 120)};
        
        int l = sorted.size();
        int g = 0;
        for(int i=0;i<l-6;i++){
            g = g+(Integer)sorted.get(i).getValue();
        }
        
        chart.addSeries ((String) sorted.get(l-1).getKey(), (Integer) sorted.get(l-1).getValue());
        chart.addSeries ((String) sorted.get(l-2).getKey(), (Integer) sorted.get(l-2).getValue());
        chart.addSeries ((String) sorted.get(l-3).getKey(), (Integer) sorted.get(l-3).getValue());
        chart.addSeries ((String) sorted.get(l-4).getKey(), (Integer) sorted.get(l-4).getValue());
        chart.addSeries ((String) sorted.get(l-5).getKey(), (Integer) sorted.get(l-5).getValue());
        chart.addSeries ((String) sorted.get(l-6).getKey(), (Integer) sorted.get(l-6).getValue());
        
        chart.addSeries ("Other Companies", g);
        
        new SwingWrapper (chart).displayChart ();
        
    }
    
    public static void barPlot(List<Map.Entry> sorted, String title,
                                   String xlabel, String ylabel ){
        
        CategoryChart chart = new CategoryChartBuilder ()
                .width (1024).height (768)
                .title (title)
                .xAxisTitle (xlabel)
                .yAxisTitle(ylabel).build ();
       
        chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNW);
        chart.getStyler ().setHasAnnotations (true);
        chart.getStyler ().setStacked (true);
        
        List<String> o =new ArrayList() ;
        sorted.forEach(c->{o.add((String) c.getKey());});
        List<Integer> p = new ArrayList() ;
        sorted.forEach(c->{p.add((Integer) c.getValue());});
        
        chart.addSeries (title, o.subList(o.size()-5, o.size()), p.subList(o.size()-5, o.size()));
        
        new SwingWrapper (chart).displayChart ();
        
    }
    
    
    
}
