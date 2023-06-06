/*
Instructor: Dr. Mai, Dr. Sidra
Group members:
Layan Bogari 2106104
Dona Alsudais 2106089
Sarah Alarifi 2105657
Raghad Aljedani 2105691
Section: B9A
 */
package graphFramework;
import java.util.*;

public class SingleSourceSPAlg extends ShortestPathAlgorithm {
    
    String[] path; 
    Graph graph;
    int[] distanc;//for storing route length
    
    public SingleSourceSPAlg(Graph graph) {
        this.graph = graph;
    }
    //this method finds the shortest path for a source
    public void computeDijkstraAlg(Graph graph) {
        
        int max = Integer.MAX_VALUE; //max needed in storing distance 
        distanc = new int[graph.vertices.length];
        path = new String[graph.vertices.length];
        
        // assigning tha max to all vertices distances
        for (int i = 0; i < graph.vertices.length; i++) { 
            distanc[i] = max;
        }
        Vertex vertex = graph.vertices[0].adjList.get(0).source;
        distanc[0]= 0;
        path[0] = vertex.displayInfo();//returns null

        for (int i = 0; i < graph.vertices.length - 1; i++) {
            int c = 0;
            int min = Integer.MAX_VALUE; //initiate the minimum distance
            for (int j = 0;j < graph.vertices.length; j++) {
                //if the graph is not visitid and less than the last min distance
                if (graph.vertices[j].isVisited != true && min > distanc[j] ) { 
                    min = distanc[j]; //then store distance as min
                    c = j;//return the index or if not return 0 
                }
            }
            graph.vertices[c].isVisited = true;
            Iterator<Edge> iterate = graph.vertices[c].adjList.iterator();
            while (iterate.hasNext()) {
                Edge edge = iterate.next();
                //if not visitid and edge weight not equal the max distance and not 0
                if (graph.vertices[edge.target.label].isVisited != true && edge.weight != max && edge.weight != 0) {
                    if (distanc[c] + edge.weight < distanc[edge.target.label]) {
                        distanc[edge.target.label] = distanc[c] + edge.weight;
                        path[edge.target.label] = path[c] + " – " + edge.target.displayInfo();
                    }
                }
            }
        }
    }
    public void displayInfo() {//for printing the output
        String locName = String.valueOf((char) (graph.vertices[0].label + 65));// location identifier name in chars 
        //System.out.println("");
        System.out.println("\nThe starting point location is "+ locName);
        System.out.println("\nThe routes from location " + locName + " to the rest of the locations are: ");
     
        for (int i =1; i < graph.verticesNo; i++) {//for all the graphs print the path anf length
            
            System.out.println("\n" +path[i] + " --- route length: " + distanc[i]);
           
        }
    }
}
