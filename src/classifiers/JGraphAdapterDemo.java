package classifiers;

import java.util.*;

import javax.swing.*;

import org.jgrapht.*;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.ListenableDirectedWeightedGraph;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;

public class JGraphAdapterDemo{
	private ListenableGraph<String, MyEdge> graph;
	private ArrayList<String> features;
	
	public JGraphAdapterDemo(int numFeatures){
		features = new ArrayList<String>();
		 graph = new ListenableDirectedWeightedGraph<String, MyEdge>(MyEdge.class);
	        
	        for(int i = 0; i < numFeatures; i++){
	        	features.add("x"+i);
	        	graph.addVertex(features.get(i));
	        	
	        }
	        graph.addEdge(features.get(0), features.get(1));
	        graph.addEdge(features.get(0), features.get(2));
	        
	        graph.addEdge(features.get(1), features.get(3));
	        graph.addEdge(features.get(1), features.get(4));
	        
	        graph.addEdge(features.get(2), features.get(5));
	        graph.addEdge(features.get(2), features.get(6));
	        
	        graph.addEdge(features.get(3), features.get(7));
	        graph.addEdge(features.get(3), features.get(8));
	        
	        graph.addEdge(features.get(4), features.get(9));
	}
	public  void createAndShowGui() {
        JFrame frame = new JFrame("DemoGraph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JGraphXAdapter<String, MyEdge> graphAdapter = 
                new JGraphXAdapter<String, MyEdge>(graph);

        mxIGraphLayout layout = new mxCircleLayout(graphAdapter);
        layout.execute(graphAdapter.getDefaultParent());

        frame.add(new mxGraphComponent(graphAdapter));

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static class MyEdge extends DefaultWeightedEdge {
        @Override
        public String toString() {
            return String.valueOf(getWeight());
        }
    }
    /*
    public  ListenableGraph<String, MyEdge> buildGraph(ArrayList<String> features) {
        ListenableDirectedWeightedGraph<String, MyEdge> g = 
            new ListenableDirectedWeightedGraph<String, MyEdge>(MyEdge.class);
        
        for(int i = 0; i < features.size(); i++){
        	g.addVertex(features.get(i));
        }
        g.addEdge(features.get(0), features.get(1));
        g.addEdge(features.get(0), features.get(2));
        
        g.addEdge(features.get(1), features.get(3));
        g.addEdge(features.get(1), features.get(4));
        
        g.addEdge(features.get(2), features.get(5));
        g.addEdge(features.get(2), features.get(6));
        
        g.addEdge(features.get(3), features.get(7));
        g.addEdge(features.get(3), features.get(8));
        
        g.addEdge(features.get(4), features.get(9));
       
        graph = g;
        return g;
    }
	*/
    public ListenableGraph<String, MyEdge> getGraph(){
    	return graph;
    }
    public ArrayList<String> getFeatures(){
    	return features;
    }
    public static void main(String[] args) {
    	
    	JGraphAdapterDemo jg = new JGraphAdapterDemo(10);
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                jg.createAndShowGui();
                
            }
        });
        System.out.println(jg.getFeatures());
    }
}
