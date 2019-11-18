import java.util.*;

/*
Author : Namit Shah
*/

class Prim{
    int vertex;
    int graph[][];

    Prim(int vertex){
        this.vertex = vertex;
        graph = new int[vertex][vertex];
    }

    int getMinKey(int[] keys,Boolean[] MSTset){
        int mn = Integer.MAX_VALUE, min_ind = -1; 
        for (int v = 0; v < vertex; v++){ 
            if (MSTset[v] == false && keys[v] < mn) { 
                mn = keys[v]; 
                min_ind = v; 
            }
        }
        return min_ind;
    }

    void printMST(int par[]){
        System.out.println("Edge\t\tWeight");
        for(int i=1;i<vertex;i++){
            System.out.println((par[i]+1) + " - " + (i+1) + "   \t" + graph[i][par[i]]);
        }
    }

    void addEdge(int node1,int node2,int weight){
       node1--;
       node2--;
       graph[node1][node2] = weight;
       graph[node2][node1] = weight;
    }

    void primsAlgo(){
        int par[] = new int[vertex]; 
        int keys[] = new int[vertex]; 
  
        Boolean MSTset[] = new Boolean[vertex]; 
        Arrays.fill(keys, Integer.MAX_VALUE);
        Arrays.fill(MSTset, false);
        
        keys[0] = 0; 
        par[0] = -1; 
  
        for (int count = 0; count < vertex-1; count++) { 
            int u = getMinKey(keys, MSTset); 
            MSTset[u] = true; 
            for (int v = 0; v < vertex; v++){ 
                if (graph[u][v] != 0 && MSTset[v] == false && graph[u][v] < keys[v]) { 
                    par[v] = u; 
                    keys[v] = graph[u][v]; 
                } 
            }
        } 
        printMST(par); 
    }

    void printGraph(){
        for(int i=0;i<vertex;i++){
            for(int j=0;j<vertex;j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Krushkal{
    int vertices;
    ArrayList<Edge> allEdges;

    static class Edge{
        int source;
        int destination;
        int weight;

        Edge(int source,int destination,int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return (source+1)+" - "+(destination+1) + " \t|  Weight : " + weight;
        }
    }

    Krushkal(int vertices){
        this.vertices = vertices;
        allEdges = new ArrayList<Edge>();
    }

    void addEdge(int source,int destination,int weight){
        source--;
        destination--;
        Edge edge = new Edge(source, destination, weight);
        allEdges.add(edge);
    }

    void makeSet(int[] par){
        for(int i=0;i<vertices;i++){
            par[i] = i;
        }
    }

    int find(int[] par,int vertex){
        if(par[vertex]!=vertex) return find(par,par[vertex]);
        return vertex;
    }

    void union(int[] par,int x,int y){
        int x_set_par = find(par,x);
        int y_set_par = find(par,y);
        par[y_set_par] = x_set_par;
    }

    void krushkalAlgo(){
        PriorityQueue<Edge> pq = new PriorityQueue<>(allEdges.size(),Comparator.comparingInt(o -> o.weight));
        for(int i=0;i<allEdges.size();i++) pq.add(allEdges.get(i));
        int par[] = new int[vertices];
        makeSet(par);
        ArrayList<Edge> mst = new ArrayList<>();
        int ind = 0;
        while(ind<vertices-1){
            Edge edg = pq.remove();
            int x_set = find(par,edg.source);
            int y_set = find(par,edg.destination);
            if(x_set!=y_set){
                mst.add(edg);
                ind++;
                union(par, x_set, y_set);
            }
        }
        System.out.print("Minimum Spanning Tree using Krushkal's Algorithm : \n\n");
        printGraph(mst);
    }

    void printGraph(ArrayList<Edge> mst){
        for (int i = 0; i <mst.size() ; i++) {
            Edge edge = mst.get(i);
            System.out.println("Edge : " + edge.toString());
        }
    }
}   

class Node{
    int data;
    int weight;
    Node next;

    Node(int d,int weight){
        data = d;
        this.weight = weight;
        next = null;
    }
}

class SingleLinkedList{
    int size;
    Node head;

    SingleLinkedList(){
        size = 0;
        head = null;
    }

    void insert(int data,int weight){
        Node new_node = new Node(data,weight);
        if(this.head==null) this.head = new_node;
        else{
            Node last = this.head;
            while(last.next != null) last = last.next;
            last.next = new_node;
        }
        //System.out.println("Inserted\n");
        size++;
    }

    void printSingleLinkedList(){
        Node current_Node = this.head;
        while(current_Node!=null){
            System.out.print((current_Node.data+1) + " ");
            current_Node = current_Node.next;
        }
        System.out.println();
    }
}

class Dijkstra{
    SingleLinkedList[] graph;
    int vertex;
    int dist[];
    int source;
    boolean visited[];
    int par[];

    Dijkstra(int vert,int source){
        graph = new SingleLinkedList[vert];
        for(int i=0;i<vert;i++){
            graph[i] = new SingleLinkedList();
        }
        this.vertex = vert;
        dist = new int[vert];
        visited = new boolean[vert];
        par = new int[vert];
        source--;
        dist[source] = 0;
        par[source] = 0;
        for(int i=0;i<vertex;i++){
            if(i!=source) {
                dist[i] = Integer.MAX_VALUE;
                par[i] = -1;
            }
        }
        Arrays.fill(visited, false);
     }

    void addEdge(int node1,int node2,int dist){
        node1--;
        node2--;
        graph[node1].insert(node2, dist);
        graph[node2].insert(node1, dist);
    }

    int minDis(){
        int mn = Integer.MAX_VALUE, min_ind = -1; 
        for(int i=0;i<vertex;i++){
            if(!visited[i] && dist[i]<mn){
                mn = dist[i];
                min_ind = i;
            }
        }
        return min_ind;
    }

    void dijkstraAlgo(){
        for(int i=0;i<vertex-1;i++){
            int min_i = minDis();
            visited[min_i] = true;
            Node temp = graph[min_i].head;
            while(temp!=null){
                if(!visited[temp.data]){
                    int newDist = dist[min_i] + temp.weight;
                    if(newDist < dist[temp.data]){
                        dist[temp.data] = newDist;
                        par[temp.data] = min_i;
                    }
                }
                temp = temp.next;
            }
        }
    }

    void printDistance(){
        for(int i=0;i<vertex;i++){
            System.out.print("Distance : "+(source+1) + " to " + (i+1) + " = " + dist[i] + "\t\t| Path : ");
            printPath(source,i,0);
            System.out.println();
        }
    }

    int printPath(int source,int newvert,int cnt){
        if(newvert==source && cnt!=0){
            System.out.print(source+1);
            return 0;
        }
        else if(newvert==source && cnt ==0) {
            System.out.print("Source");
            return 0;
        }
        if(cnt!=0) System.out.print((newvert+1) + " ");
        return printPath(source, par[newvert],cnt+1);
    }


}

public class MST_Dijkstra_Q11{
    public static void main(String args[]) {
        System.out.println("Minimum Spanning Tree Using Prim's Algorithm : \n");
        Prim pmst = new Prim(6);
        pmst.addEdge(1, 2, 4);
        pmst.addEdge(1, 3, 3);
        pmst.addEdge(2, 3, 1);
        pmst.addEdge(2, 4, 2);
        pmst.addEdge(3, 4, 4);
        pmst.addEdge(4, 5, 2);
        pmst.addEdge(5, 6, 6);
        pmst.primsAlgo();

        System.out.println("\n");
        Krushkal kmst = new Krushkal(6);
        kmst.addEdge(1, 2, 4);
        kmst.addEdge(1, 3, 3);
        kmst.addEdge(2, 3, 1);
        kmst.addEdge(2, 4, 2);
        kmst.addEdge(3, 4, 4);
        kmst.addEdge(4, 5, 2);
        kmst.addEdge(5, 6, 6);
        kmst.krushkalAlgo();

        System.out.println("\n");
        Dijkstra dg = new Dijkstra(6,1);
        dg.addEdge(1, 2, 4);
        dg.addEdge(1, 3, 3);
        dg.addEdge(2, 3, 1);
        dg.addEdge(2, 4, 2);
        dg.addEdge(3, 4, 4);
        dg.addEdge(4, 5, 2);
        dg.addEdge(5, 6, 6);
        System.out.println("Shortest Path from the given source to each vertex using Dijkstra's Algorithm : \n");
        dg.dijkstraAlgo();
        dg.printDistance();
    }
}