
/*
Author : Namit Shah
*/

import java.util.*;

class Graph_Q10 {
    ArrayList<Integer>[] arr = null;
    boolean visited[];

    Graph_Q10(int vertex) {
        visited = new boolean[vertex];
        Arrays.fill(visited, false);
        arr = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            arr[i] = new ArrayList<>();
        }
    }

    void addEdge(int node1, int node2) {
        arr[node1].add(node2);
        arr[node2].add(node1);
    }

    void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i = 0; i < arr[node].size(); i++) {
            if (!visited[arr[node].get(i)]) {
                DFS(arr[node].get(i));
            }
        }
    }

    void BFS(int s) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.remove(0);
            System.out.print(s + " ");
            for (int i = 0; i < arr[s].size(); i++) {
                int n = arr[s].get(i);
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void resetFlag() {
        Arrays.fill(visited, false);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter total number of vertexes and edges : ");
        int VERTEX_NUM = sc.nextInt();
        int EDGES = sc.nextInt();
        while(EDGES > (VERTEX_NUM*(VERTEX_NUM-1))/2)
        {
            System.out.println("Cannot Add this much number of edges, enter number of edges again : ");
            EDGES = sc.nextInt();
        }
        Graph_Q10 g = new Graph_Q10(VERTEX_NUM + 1);
        System.out.println("Enter edges one by one : ");
        for(int i=0;i<EDGES;i++){
            System.out.print("Enter connection nodes (node1 & node2) : ");
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            g.addEdge(node1, node2);
        }
        System.out.println("DFS : ");
        g.DFS(1);
        g.resetFlag();
        System.out.println("\nBFS : ");
        g.BFS(1);

        sc.close();
    }
}