package lab_5;

/**
 * Created by lqsch on 2016-12-04.
 */
    import edu.princeton.cs.algs4.CC;
    import edu.princeton.cs.algs4.DepthFirstSearch;
    import edu.princeton.cs.algs4.IndexMinPQ;
    import edu.princeton.cs.algs4.Queue;
    import lab_1.IterativePascal;
    import se.kth.id1020.Edge;
    import se.kth.id1020.Graph;
    import se.kth.id1020.DataSource;
    import se.kth.id1020.Vertex;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.Scanner;

//import java.util.Queue;

public class Paths {
boolean [] mark;
    int [] distTo;
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
                    int vertex = p.search(g,"Renyn");
                    p.prismMST(g);
                    System.out.println(" ");
                    System.out.println(" ");
                    System.out.println("The shortest path bewtween Renyn and Parses is: ");

                    System.out.print("Shortest path is: ");
                    for (int v = 0; vertex!=p.search(g,"Parses"); v++) {
                        System.out.print(g.vertex(vertex));
                        vertex = p.edgeToA[vertex].dequeue();
                            System.out.print(" --> ");
                    }
                    System.out.print(g.vertex(vertex));
                    System.out.println(" ");
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
    public void prismMST(Graph g){
       // int v =0;
        mark= new boolean[g.numberOfVertices()];
       edgeToA=new Queue[g.numberOfVertices()];
        ArrayList<Edge> q = new ArrayList<Edge>();
      int i=1006;
        mark[1006]=true;
        while(i!=918){

          for (Edge e : g.adj(i)) {
                  q.add(e);
          }
          if (edgeToA[i] == null) {
              edgeToA[i] = new Queue<Integer>();
          }
          Edge e = Collections.min(q, new Comparator<Edge>() {
              public int compare(Edge o1, Edge o2) {
                  return Double.compare(o2.weight, o1.weight);
              }
          });



          if(mark[e.to]!=true) {
              edgeToA[i].enqueue(e.to);
              mark[e.to] = true;
              i=e.to;
              q.remove(e);
          }else{
             // Edge w;
              while(mark[e.to]==true) {
                  q.remove(e);
                  if(q.isEmpty()){
                      break;
                  }
                   e = Collections.min(q, new Comparator<Edge>() {
                      public int compare(Edge o1, Edge o2) {
                          return Double.compare(o2.weight, o1.weight);
                      }
                  });
              }
              if(!q.isEmpty()){
                  edgeToA[i].enqueue(e.to);
                  mark[e.to] = true;
                  i=e.to;
                  q.remove(e);
              }


          }


      }
        return;
    }

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

