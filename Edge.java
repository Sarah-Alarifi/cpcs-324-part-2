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

public class Edge {

    int weight;
    Vertex source;
    Vertex target;
    Vertex parent;

    public Edge() {
        source = new Vertex();
        target = new Vertex();
        parent = new Vertex();
    }

    public Edge(Vertex source, Vertex target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.parent = source;
    }
//setters and getters for the source vertex

    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }

    public void displayInfo() {

    }

} 

