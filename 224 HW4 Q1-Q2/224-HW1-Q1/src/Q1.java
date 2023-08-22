/* Q1
 * Giray Berk Kuþhan
 * Section 4 
 * Assignment 1 Q1 
 * 1088978942 
 */
import java.util.*;

public class Q1 {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(), M = scanner.nextInt(), T = scanner.nextInt(), C = scanner.nextInt();
        
        Graph graph = new Graph(N);
        //this part of code provides that inputs which are cities and routes
        int count = 0;
        do {
            int u = scanner.nextInt(), v = scanner.nextInt();
            graph.addEdge(u, v);
            count++;
        } while (count < M);

        // every path that we passed edding in edge.
        
        int x = scanner.nextInt(), y = scanner.nextInt();
        int[] dst = new int[N+1];
        Arrays.fill(dst, Integer.MAX_VALUE);
        dst[x] = 0;
        boolean[] vis = new boolean[N+1];
        int[] parent = new int[N+1];
        Arrays.fill(parent, -1);
        // by using arraylist we put into edges.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        int u, v, wt;
        while (!queue.isEmpty()) {
        u = queue.poll();
        if (vis[u]) 
        	continue;
        /* control is queue is empty or not, if it is not empty we use poll the u, 
        and remove the element from queue*/
        vis[u] = true;
        int i = 0;
        do {
        v = graph.getNeighbors(u).get(i);
        wt = C;
        if (parent[u] != -1 && parent[u] != v && ((dst[u] / T) % 2 == 1)) {
        wt += T - (dst[u] % T);
        }
        if (dst[v] > dst[u] + wt) {
        dst[v] = dst[u] + wt;
        queue.offer(v);
        parent[v] = u;
        }
        i++;
        } while (i < graph.getNeighbors(u).size());
        }
        // controlling to Neighbor vertices, then add path path after occurs Integer type List. 
        List<Integer> path = new ArrayList<>();
        int p = y;
        do {
        path.add(p);
        p = parent[p];
        } while (p != -1);
        // then turn back in directed edges.
        Collections.reverse(path); 
        System.out.println(path.size());
        for (int i : path) {
            System.out.print(i + " ");
        }
        System.out.println("");
        System.out.println(dst[y]);
    }
}
