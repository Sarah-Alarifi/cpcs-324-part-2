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

import java.io.*;
import java.util.*;

import graphFramework.*;

public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {
        int verticesNo = 0;
        int edgesNo = 0;
        boolean isDigraph = false;

        System.out.println("");
        System.out.println("1- first requirement");
        System.out.println("2- second requirement");
        System.out.println("");

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose: ");

        //read request
        int req = sc.nextInt();

        //invalid input
        while (req != 1 && req != 2) {
            System.out.println("wrong input");
            System.exit(0);
        }

        //read from file
        if (req == 1) {

            File f = new File("graph.txt"); // Read from File
            Graph g = new Graph(); // Create An Object of Graph as graph
            g.readGraphFromFile(f); // Access readGraphFromFile Method in Graph Class
            SingleSourceSPAlg dij = new SingleSourceSPAlg(g);
            dij.computeDijkstraAlg(g); // Read Graph in Dijkstra Algorithm
            dij.displayInfo(); // Print path list and router length

        } else if (req == 2) {
            System.out.println("");
            System.out.println(" 1-  n = 2000 , m = 10000");
            System.out.println(" 2-  n = 3000 , m = 15000");
            System.out.println(" 3-  n = 4000 , m = 20000");
            System.out.println(" 4-  n = 5000 , m = 25000");
            System.out.println(" 5-  n = 6000 , m = 30000");
            System.out.print("\nChoose: ");

            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    verticesNo = 2000;
                    edgesNo = 10000;
                    break;
                case 2:
                    verticesNo = 3000;
                    edgesNo = 15000;
                    break;
                case 3:
                    verticesNo = 4000;
                    edgesNo = 20000;
                    break;
                case 4:
                    verticesNo = 5000;
                    edgesNo = 25000;
                    break;
                case 5:
                    verticesNo = 6000;
                    edgesNo = 30000;
                    break;
                default:
                    System.out.println("wrong input");
                    System.exit(0);
            }

            Graph g = new Graph(verticesNo, edgesNo, isDigraph);
            g.makeGraph(verticesNo, edgesNo);
            SingleSourceSPAlg dij = new SingleSourceSPAlg(g);
            long startTime = System.currentTimeMillis();
            dij.computeDijkstraAlg(g);
            long finishTime = System.currentTimeMillis();
            System.out.println("");
            System.out.println("Run time for Dijkstra algorithm is: " + (finishTime - startTime) + " ms ");
            System.out.println("");
            
        }
        sc.close();
    }

}
