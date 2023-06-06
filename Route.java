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
import graphFramework.Vertex;

public class Route extends Edge {

    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
    }

    // override the Method
    @Override
    public void displayInfo() {
    }

} 
