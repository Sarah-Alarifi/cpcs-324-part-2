/*
Instructor: Dr. Mai, Dr. Sidra
Group members:
Layan Bogari 2106104
Dona Alsudais 2106089
Sarah Alarifi 2105657
Raghad Aljedani 2105691
Section: B9A
 */
package AirFreightApp;

import graphFramework.Edge;
import graphFramework.Graph;
import graphFramework.Vertex;

public class AFRouteMap extends Graph {

    public AFRouteMap() {

    }

    // Create Vertex
    @Override
    public Vertex createVertex(int label) {
        return new Location(label);
    }

    // Create Edge
    @Override
    public Edge createEdge(Vertex source, Vertex target, int weight) {
        return new Route(source, target, weight);
    }

}
