import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Graph {
    private static ArrayList<Integer> G[];
    private static int v;

    // Intialize the graph
    Graph(ArrayList<Integer> G[], int v) {
        Graph.G = G;
        Graph.v = v;

    }

    // Create the graph
    public static void create_Graph(int s, int d) {
        G[s].add(d);
        G[d].add(s);
    }

    // Display the graph
    public static void display() {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < G[i].size(); j++) {
                System.out.print(i + "-->" + G[i].get(j) + " ");
            }
            System.out.println();
        }

    }

    // BFS Traversal
    public static void BFS(int source) {
        boolean Visited_Nodes[] = new boolean[v];
        int Parent_Nodes[] = new int[v];
        LinkedList<Integer> LL = new LinkedList<Integer>();
        LL.add(source);
        Visited_Nodes[source] = true;
        Parent_Nodes[source] = -1;
        while (!LL.isEmpty()) {
            int poll = LL.poll();
            System.out.print(poll + " ");
            for (int ele : G[poll]) {
                if (Visited_Nodes[ele] != true) {
                    Visited_Nodes[ele] = true;
                    LL.add(ele);
                    Parent_Nodes[ele] = poll;

                }
            }

        }
    }

    // DFS Traversal
    public static void DFS(int source) {
        boolean Visited_Nodes[] = new boolean[v];
        int Parent_Nodes[] = new int[v];
        Stack<Integer> LL = new Stack<Integer>();
        LL.add(source);
        Visited_Nodes[source] = true;
        Parent_Nodes[source] = -1;
        while (!LL.isEmpty()) {
            int poll = LL.pop();
            System.out.print(poll + " ");
            for (int ele : G[poll]) {
                if (Visited_Nodes[ele] != true) {
                    Visited_Nodes[ele] = true;
                    LL.add(ele);
                    Parent_Nodes[ele] = poll;

                }
            }

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no. of vertices: ");
        int v = sc.nextInt();
        System.out.print("Enter the no. of edges: ");
        int e = sc.nextInt();
        ArrayList<Integer> G[];
        G = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            G[i] = new ArrayList<Integer>();

        }
        Graph obj = new Graph(G, v);
        System.out.println("Enter the edges: ");
        for (int i = 1; i <= e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            create_Graph(s, d);
        }
        display();
        System.out.print("Enter the source for BFS Traversal: ");
        int source = sc.nextInt();
        System.out.print("BFS Traversal of the Graph : ");
        BFS(source);
        System.out.println();
        System.out.print("Enter the source for BFS Traversal: ");
        source = sc.nextInt();
        System.out.print("DFS Traversal of the Graph : ");
        DFS(source);

    }

}
