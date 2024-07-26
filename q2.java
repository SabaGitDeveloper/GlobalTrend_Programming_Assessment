// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class Graph {
    private int V;
    private LinkedList<Edge>[] adj;
    class Edge{
        int dest, weight;
        Edge(int dest, int weight){
            this.dest=dest;
            this.weight=weight;
        }
    }
    public Graph(int V){
        this.V=V;
        adj =new LinkedList[V];
        for(int i=0; i<V; i++){
            adj[i]=new LinkedList<>();
        }
    }
    public void addEdge(int src, int dest, int weight){
        adj[src].add(new Edge(dest, weight));
        adj[dest].add(new Edge(src, weight));
    }
    public void dijkstra(int src) {
        PriorityQueue<Node> pq= new PriorityQueue<>(V, Comparator.comparingInt(node->node.distance));
        int [] dist= new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        pq.add(new Node(src,0));
        while(!pq.isEmpty()){
            Node node=pq.poll();
            int u=node.vertex;
            for(Edge edge:adj[u]){
                int v=edge.dest;
                int weight=edge.weight;
                if(dist[u]+weight<dist[v]){
                    dist[v]=dist[u]+weight;
                    pq.add(new Node(v, dist[v]));
                    printSolution(dist);
                }
            }
        }
    }
    private void printSolution(int[] dist){
        System.out.println("Vertex ;;;;;; Distance from Source");
        for(int i=0; i<V; i++){
            System.out.println(i + "   " + dist[i]);
        }
    }
    class Node{
        int vertex, distance;
        Node(int vertex, int distance){
            this.vertex=vertex;
            this.distance=distance;
        }
    }
    public static void main(String[] args) {
        Map<Integer, Map<Integer, Integer>> graphInput=new Hashmap<>();
        graphInput.put(0, Map.of(1,4,2,1));
        graphInput.put(1, Map.of(3,1));
        graphInput.put(2, Map.of(1,2,3,5));
        graphInput.put(3, new Hashmap<>());
        int numVertices=graphInput.size();
        Graph g=new Graph(numVertices);
        for(Map.Entry<Integer, Map<Integer, Integer>>entry:graphInput.entrySet()){
            int src=entry.getKey();
            for(Map.Entry<Integer, Integer> edge: entry.getValue().entrySet()){
                int dest=edge.getKey();
                int weight=edge.getValue();
                g.addEdge(src, dest,weight);
            }
        }
        int source=0;
        g.dijkstra(source);
    }
}
