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

import java.util.LinkedList;

public class Vertex {

    public int label;
    Boolean isVisited;
    LinkedList<Edge> adjList;

    public Vertex() {
        adjList = new LinkedList<>();
    }

    public Vertex(int label) {
        this.label = label;
        this.isVisited = false;
        adjList = new LinkedList<>();
    }

    public String displayInfo() {
        return null;
    }

}
