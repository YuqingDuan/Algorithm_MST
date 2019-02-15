public class Prim {
    public void prim(MatrixGraph graph) {
        int[] lowcost = new int[graph.getVertexNum()];//最小代价顶点权值的数组,为0表示已经获取最小权值
        int[] adjvex = new int[graph.getVertexNum()];//放顶点权值
        int min, minId, sum = 0;
        for (int i = 1; i < graph.getVertexNum(); i++) {
            lowcost[i] = graph.getAdjacencyMatrix()[0][i];
        }
        for (int i = 1; i < graph.getVertexNum(); i++) {
            min = graph.MAX_WEIGHT;
            minId = 0;
            for (int j = 1; j < graph.getVertexNum(); j++) {
                if (lowcost[j] < min && lowcost[j] > 0) {
                    min = lowcost[j];
                    minId = j;
                }
            }
            System.out.println("顶点：" + adjvex[minId] + "权值：" + min);
            sum += min;
            lowcost[minId] = 0;
            for (int j = 1; j < graph.getVertexNum(); j++) {
                if (lowcost[j] != 0 && graph.getAdjacencyMatrix()[minId][j] < lowcost[j]) {
                    lowcost[j] = graph.getAdjacencyMatrix()[minId][j];
                    adjvex[j] = minId;
                }
            }
        }
        System.out.println("最小生成树权值和:" + sum);
    }

}
