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

import AirFreightApp.AFRouteMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graph {

    public int verticesNo; //number of vertices
    int edgeNo; //number of edges
    Boolean isDigraph; //graph is directed or undirected
    public Vertex[] vertices;

    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        this.vertices = new Vertex[verticesNo];
    }

    public Graph() {
    }

    public Vertex createVertex(int label) {
        return new Vertex(label);
    }

    public Edge createEdge(Vertex source, Vertex target, int weight) {
        return new Edge(source, target, weight);
    }

    public void readGraphFromFile(File fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(fileName); //read from file
        String digraph = sc.next(); // read "digraph"
        String dire = sc.next();
        if (dire.equals("0")) {
            isDigraph = false; //not directed
        } else if (dire.equals("1")) {
            isDigraph = true; //directed
        }
        int numvert = sc.nextInt(); //total number of vertices
        int numedges = sc.nextInt(); //total number of edges
        if (!isDigraph) {
            numedges *= 2;
        }
        vertices = new Vertex[numvert]; //array of vertices
        while (edgeNo < numedges) {
            int vLabel = sc.next().charAt(0) - 65;
            int uLabel = sc.next().charAt(0) - 65;
            int w = sc.nextInt();

            Vertex v = createVertex(vLabel);
            Vertex u = createVertex(uLabel);

            addEdge(v, u, w);
        } // End of while-loop

        sc.close();
    }

    public void makeGraph(int verticesNo, int edgeNo) {
        for (int i = 0; i < verticesNo; i++) { //loop for store vertices in the array
            vertices[i] = new Vertex(i);
        }
        for (int i = 0; i < verticesNo - 1; i++) {
            //add edges with random weight
            addEdge(vertices[i], vertices[i + 1], (int) (1 + Math.random() * 10));
        }
        int i = 0;
        while (i < (edgeNo - (verticesNo - 1))) {
            int v = (int) (Math.random() * verticesNo); //source
            int u = (int) (Math.random() * verticesNo); //target
            if (u == v) { //self loop
                continue;
            }
            for (int j = 0; j < vertices[u].adjList.size(); j++) {
                if (vertices[u].adjList.get(j).target.label != v) {
                    break; //break if not connected with an edge
                }
            }
            //add edges with random weight
            addEdge(vertices[u], vertices[v], (int) (1 + Math.random() * 10));
            i++;
        }
    }

    public void addEdge(Vertex v, Vertex u, int w) {

        Graph city = new AFRouteMap();
        if (vertices[v.label] == null) {
            verticesNo++;
            vertices[v.label] = city.createVertex(v.label); //create new source 
        }

        if (vertices[u.label] == null) {
            verticesNo++;
            vertices[u.label] = city.createVertex(u.label); //create new target
        }

        Edge e = city.createEdge(vertices[v.label], vertices[u.label], w); //create new edge
        edgeNo++;

        //add edge and weight in vertex's adjacency list
        vertices[v.label].adjList.add(e);

        //if graph is undirected
        if (!isDigraph) {

            //add the opposite edge
            e = city.createEdge(vertices[u.label], vertices[v.label], w);
            edgeNo++;
            //add edge and weight in vertex's adjacency list
            vertices[u.label].adjList.add(e);
        }

    }
}
