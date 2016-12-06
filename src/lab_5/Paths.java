package lab_5;

/**
 * Created by lqsch on 2016-12-04.
 */
    import lab_1.IterativePascal;
    import se.kth.id1020.Graph;
    import se.kth.id1020.DataSource;
    import se.kth.id1020.Vertex;

public class Paths {
        Graph g = DataSource.load();
        public static void main(String[] args) {
            Paths p= new Paths();
            // work on g
            boolean check=false;
            IterativePascal a = new IterativePascal(false);
            int n =p.g.numberOfVertices();
            if(a.binom(n,2)== n*(n-1)/2){
                check =true;
            }else {
                check =false;
            }
            p.dfsVisit(p.g,0);

        }
        public void dfsVisit(Graph g,int n){
            if()
            g.vertex(n);
dfsVisit(g,n+1);
        }
        private class V{
            Vertex vertex;
            Boolean visit;
        }
    }

