package lab_5;

/**
 * Created by lqsch on 2016-12-04.
 */
    import edu.princeton.cs.algs4.CC;
    import edu.princeton.cs.algs4.DepthFirstSearch;
    import lab_1.IterativePascal;
    import se.kth.id1020.Edge;
    import se.kth.id1020.Graph;
    import se.kth.id1020.DataSource;
    import se.kth.id1020.Vertex;

public class Paths {
boolean [] mark;
    int count =0;
        public static void main(String[] args) {
            Graph g = DataSource.load();
            Paths p= new Paths();
            // work on g
            p.mark = new boolean[g.numberOfVertices()];

            p.dfsVis(g,0,false);
           if( p.isConnect(g)) {
               System.out.println(" ");
              /* for(int i =0; i<p.mark.length;i++) {
                   System.out.print("vertex "+ i+ " "+p.mark[i]+ " , ");
               }*/
               System.out.println("The graph itself is fully connected");
           }else {
               System.out.println(" ");
               System.out.println("The graph itself is not fully connected");
           }

        }
    public void dfsVis(Graph g, int vertex,boolean isSub){
        System.out.print(g.vertex(vertex)+" --> ");
        count++;
        mark[vertex]=true;
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
    public boolean isConnect(Graph g){
        boolean con=true;
for(int v =0; v<g.numberOfVertices();v++){
    if (!mark[v]){
            System.out.println(" ");
            System.out.println("Subgraph:");
        dfsVis(g,v,true);
        con =false;
    }else {

    }

}
        return con;
    }
    public void shortestP(){

    }

    }

