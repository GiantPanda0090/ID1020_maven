package lab_5;

/**
 * Created by lqsch on 2016-12-04.
 */

import edu.princeton.cs.algs4.Queue;
import se.kth.id1020.DataSource;
import se.kth.id1020.Edge;
import se.kth.id1020.Graph;

import java.util.ArrayList;
import java.util.Scanner;

//import java.util.Queue;

public class Paths {
boolean [] mark;
    int [] distTo;
    double[] distToD;
    int[] edgeTo;
    int count =0;
    String [] labelList;
    int counter=1;
    public int INFINITY = Integer.MAX_VALUE;
    Queue<Integer>[] edgeToA;
        public static void main(String[] args) {
            Graph g = DataSource.load();
            Paths p= new Paths();
            // work on g
            p.distToD=new double[g.numberOfVertices()];
            p.edgeToA= new Queue[g.numberOfVertices()];
            p.mark = new boolean[g.numberOfVertices()];
            p.distTo= new int[g.numberOfVertices()];
            p.edgeTo=new int[g.numberOfVertices()];
            p.labelList = new String[g.numberOfVertices()];
            Scanner sysin = new Scanner(System.in);
            while(true) {
                System.out.println(" ");
                System.out.println("0 - for USING DFS to check the subgraph and if a graph is fully connected(QUESTION 1).");
                System.out.println("1 - for USING BFS to check the shortest path with out weight(QUESTION 2)");
                System.out.println("2 - for USING BFS to check the shortest path with weight(QUESTION 2)");
                System.out.print("Choice: ");

                int choice = sysin.nextInt();

                if (choice == 0) {
                    p.dfsVis(g, 0, false);
                    if (p.isConnect(g, true)) {
                        System.out.println(" ");
                        for (int i = 0; i < p.mark.length; i++) {
                            System.out.print("vertex " + i + " " + p.mark[i] + " , ");
                        }
                        System.out.println("The graph itself is fully connected");
                    } else {
                        System.out.println(" ");
                        System.out.println("The graph itself is not fully connected");
                        System.out.println("There are " + p.counter + " subgraphs");
                        //System.out.println(p.count);
                    }
                    System.out.println("------------------------------------------------------------------------------------------------------------------------");
                }
                if (choice == 1) {
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("The shortest path bewtween Renyn and Parses is: " + p.bfsShortVis(g, "Renyn", "Parses"));
                    int vertex = 918;
                    System.out.print("Shortest path is: ");
                    for (int v = 0; v <= p.distTo[918]; v++) {
                        System.out.print(g.vertex(vertex));
                        vertex = p.edgeTo[vertex];
                        if (v < p.distTo[918]) {
                            System.out.print(" --> ");
                        }

                    }
                    System.out.println(" ");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------");
                }
                if (choice == 2) {
                    int vertex = 918;
                    //  p.prismMST(g);
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("The shortest path bewtween Renyn and Parses is: " + p.DShort(g, "Renyn", "Parses"));

                    System.out.print("Shortest path is: ");
                   p.counter =0;
                    for (int v = 0; vertex!=1006; v++) {
                        System.out.print(g.vertex(vertex));
                        p.counter++;
                        vertex = p.edgeTo[vertex];
                        if (v <= p.counter) {
                            System.out.print(" --> ");
                        }
                    }
                    System.out.print(g.vertex(vertex));
                    System.out.println(" ");
                    System.out.println("The shortest path bewtween Renyn and Parses is: " + " "+ p.counter+ " length");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------");




                }
            }
        }
    public void dfsVis(Graph g, int vertex,boolean isSub){
        if(isSub) {
            System.out.print(g.vertex(vertex) + " --> ");
        }
        count++;
        mark[vertex]=true;
        labelList[vertex]=g.vertex(vertex).label;
        for(Edge w:g.adj(vertex)){
            //int w =vertex;
            if(!mark[w.to]){
                if(!isSub) {
                    dfsVis(g, w.to, false);
                }else{
                    dfsVis(g, w.to, true);
                }
            }

            //System.out.println("||");
        }

        //System.out.println(" ");
    }
    public boolean isConnect(Graph g,boolean u){
        boolean con=true;
for(int v =0; v<g.numberOfVertices();v++){
    if (!mark[v]){
        if(u) {
            System.out.println(" ");
            System.out.println("Subgraph:");
            counter++;
        }
        dfsVis(g,v,u);
        con =false;
    }else {

    }

}
        return con;
    }
    public void shortestP(){

    }
public int bfsShortVis(Graph G, String label,String toLabel){
    int s =search(G,label);
    int sTo =search(G,toLabel);
    mark=new boolean[G.numberOfVertices()];
    Queue<Integer>q = new Queue<Integer>();
    for (int v = 0; v < G.numberOfVertices(); v++)//setup
        distTo[v] = INFINITY;
    distTo[s] = 0;
    mark[s] = true;
    q.enqueue(s);
    counter =0;
    while (!q.isEmpty()) {//brench
        int v = q.dequeue();
        System.out.println(" ");
        System.out.print("Brenched from -->> "+ G.vertex(v) );//brench
        System.out.println(" ");
        System.out.print(G.vertex(v) );
        if(v==sTo){
            break;
        }

        for (Edge w : G.adj(v)) {//content inside brench
            if (!mark[w.to]) {
                System.out.print(" --> ");
                System.out.print(G.vertex(w.to) );
                edgeTo[w.to] = v;
                counter++;
                distTo[w.to] = distTo[v] + 1;
                mark[w.to] = true;
                q.enqueue(w.to);
if(w.to==sTo){
    break;
}
            }
            if(w.to==sTo){
                break;
            }
        }
    }
    return distTo[sTo];//non-weight
}

    public Double DShort(Graph G, String label, String toLabel) {
        int s =search(G,label);
        int sTo =search(G,toLabel);
        mark=new boolean[G.numberOfVertices()];
        edgeTo = new int[G.numberOfVertices()];
        Queue<Integer>q = new Queue<Integer>();
        for (int v = 0; v < G.numberOfVertices(); v++)//setup
            distToD[v] = Double.POSITIVE_INFINITY;
        distToD[s] = 0.0;
        mark[s] = true;
        q.enqueue(s);
      //  counter =0;
        while (!q.isEmpty()) {//brench
            int v = q.dequeue();

            //System.out.print(G.vertex(v) );

            for (Edge w : G.adj(v)) {//content inside brench
                if (!mark[w.to]) {
                    if(Double.compare( distToD[w.to],distToD[v] + w.weight)>0) {
                        edgeTo[w.to] = v;
                        //counter++;
                        distToD[w.to] = distToD[v] + w.weight;
                        mark[w.to] = true;
                        q.enqueue(w.to);
                    }

                    if(w.to==sTo){
                        break;
                    }
                }
                if(w.to==sTo){
                    break;
                }
            }
        }
        return distToD[sTo];//non-weight
    }

    //return;


    public boolean allmarked(){
        boolean con=true;
        for(int i=0;i<mark.length;i++){
            con =con&mark[i];
        }
        return con;
    }
    public int search(Graph G,String label){
        dfsVis(G,0,false);
        isConnect(G,false);
       for(int i =0; i < G.numberOfVertices();i++){
           if (labelList[i].equals(label)){
               return G.vertex(i).id;
           }
       }
        return 0;
    }
    }

