package lab_5;

/**
 * Created by lqsch on 2016-12-04.
 */
    import edu.princeton.cs.algs4.CC;
    import edu.princeton.cs.algs4.DepthFirstSearch;
    import lab_1.IterativePascal;
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
p.dfsVis(g,0);
            p.isConnect(g, 0);

        }
    public void dfsVis(Graph g, int vertex){
        count++;
        mark[vertex]=true;
        int w=0;
        while(g.adj(v).iterator().hasNext()){
            if(!mark[w]){
                dfsVis(g,w);
            }else{
                w++;
            }
        }
    }
    public boolean isConnect(Graph g, int v){
        if (!mark[v]){
            //dfsVis(g,v);
            return false;
        }
        if(v<mark.length){
            return true;
        }else{
            isConnect(g,v++);
        }

        return true;
    }
    public void subGraph(Graph g, int v){
        //count++;
        boolean[] subm= new boolean[g.numberOfVertices()];
        subm[v]=true;
        int w=0;
        while(g.adj(v).iterator().hasNext()){
            if(!mark[w]){
                g.adj(v).iterator().next();
                dfsVis(g,w);
            }else{
                w++;
            }
        }
    }
    }

