public class Test {
    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(9);
        Prim prim = new Prim();
        prim.prim(graph.createGraph());

        System.out.println("----------------------------");

        Kruskal kruskal = new Kruskal(15);
        kruskal.createEdgeArray();
        kruskal.miniSpanTreeKruskal();
    }
}
