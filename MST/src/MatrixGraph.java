import java.util.LinkedList;

public class MatrixGraph {
    private int vertexNum;
    private int[] vertexes;
    private int[][] adjacencyMatrix;
    public static final int MAX_WEIGHT = 65535;
    private boolean[] isVisited;

    public MatrixGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        vertexes = new int[vertexNum];
        adjacencyMatrix = new int[vertexNum][vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            vertexes[i] = i;
        }
        isVisited = new boolean[vertexNum];
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public void setVertexNum(int vertexNum) {
        this.vertexNum = vertexNum;
    }

    public int[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(int[] vertexes) {
        this.vertexes = vertexes;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public void setAdjacencyMatrix(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
    }

    public static int getMaxWeight() {
        return MAX_WEIGHT;
    }

    public boolean[] getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(boolean[] isVisited) {
        this.isVisited = isVisited;
    }

    public int getDegree(int index) {
        int degree = 0;
        for (int j = 0; j < adjacencyMatrix[index].length; j++) {
            int weight = adjacencyMatrix[index][j];
            if (weight != 0 && weight != MAX_WEIGHT) {
                degree++;
            }
        }
        return degree;
    }

    public int getFirstNeighbor(int index) {
        for (int j = 0; j < vertexNum; j++) {
            if (adjacencyMatrix[index][j] > 0 && adjacencyMatrix[index][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    public int getNextNeighbor(int v, int index) {
        for (int j = index + 1; j < vertexNum; j++) {
            if (adjacencyMatrix[index][j] > 0 && adjacencyMatrix[index][j] < MAX_WEIGHT) {
                return j;
            }
        }
        return -1;
    }

    public int getWeight(int v1, int v2) {
        int weight = adjacencyMatrix[v1][v2];
        return weight == 0 ? 0 : (weight == MAX_WEIGHT ? -1 : weight);
    }

    private void DFS(int i) {
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {
                System.out.println("Vertex: " + w + " has been visited!");
                DFS(w);
            }
            w = getNextNeighbor(i, w);
        }
    }

    public void DFS() {
        isVisited = new boolean[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            if (!isVisited[i]) {
                System.out.println("Vertex: " + i + " has been visited!");
                DFS(i);
            }
        }
    }

    private void BFS(int i) {
        int u, w;
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.println("Vertex: " + i + " has been visited!");
        isVisited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()) {
            u = queue.removeFirst().intValue();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.println("Vertex: " + w + " has been visited!");
                    isVisited[w] = true;
                    queue.add(w);
                }
                w = getNextNeighbor(u, w);
            }
        }
    }

    public void BFS() {
        isVisited = new boolean[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            if (!isVisited[i]) {
                BFS(i);
            }
        }
    }

    public MatrixGraph createGraph() {
        MatrixGraph graph = new MatrixGraph(9);
        int[] a1 = {0, 10, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT};
        int[] a2 = {10, 0, 18, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, MAX_WEIGHT, 12};
        int[] a3 = {MAX_WEIGHT, MAX_WEIGHT, 0, 22, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 8};
        int[] a4 = {MAX_WEIGHT, MAX_WEIGHT, 22, 0, 20, MAX_WEIGHT, MAX_WEIGHT, 16, 21};
        int[] a5 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 20, 0, 26, MAX_WEIGHT, 7, MAX_WEIGHT};
        int[] a6 = {11, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 26, 0, 17, MAX_WEIGHT, MAX_WEIGHT};
        int[] a7 = {MAX_WEIGHT, 16, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 17, 0, 19, MAX_WEIGHT};
        int[] a8 = {MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 16, 7, MAX_WEIGHT, 19, 0, MAX_WEIGHT};
        int[] a9 = {MAX_WEIGHT, 12, 8, 21, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, MAX_WEIGHT, 0};

        graph.adjacencyMatrix[0] = a1;
        graph.adjacencyMatrix[1] = a2;
        graph.adjacencyMatrix[2] = a3;
        graph.adjacencyMatrix[3] = a4;
        graph.adjacencyMatrix[4] = a5;
        graph.adjacencyMatrix[5] = a6;
        graph.adjacencyMatrix[6] = a7;
        graph.adjacencyMatrix[7] = a8;
        graph.adjacencyMatrix[8] = a9;
        return graph;
    }
}
