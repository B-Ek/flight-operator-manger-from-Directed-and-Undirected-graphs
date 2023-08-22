/* Graph
 * Giray Berk Kuþhan
 * Section 4 
 * Assignment 1 Q1 
 * 1088978942 
 */
import java.util.*;

public class Graph {
        private Map<Integer, List<Integer>> adjList;
        // This is the Graph class that provides traversing edges and vertices.
        public Graph(int N) {
            adjList = new HashMap<>();
            int i = 1;
            do {
            adjList.put(i, new ArrayList<>());
            i++;
            } while (i <= N);
        }
        
        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        
        public List<Integer> getNeighbors(int u) {
            return adjList.get(u);
        }
    }
    