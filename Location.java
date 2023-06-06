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

import graphFramework.Vertex;

public class Location extends Vertex {

    private String city;

    public Location(int label) {
        super(label);
        this.city = String.valueOf((char) (label + 65));
    }

    public Location(int label, int vetticesNum) {
        super(label);
        this.city = String.valueOf((char) (label + 65));
    }

    @Override
    public String displayInfo() {

        return "loc." + city + ": city " + label;

    }

}
