/* Graph
 * Giray Berk Kuþhan
 * Section 4 
 * Assignment 1 Q2 
 * 1088978942 
 */
import java.util.*;

public class Graph {
	public final int V;
	public Bag<Integer>[] adj;

	public Graph(int V) {
		this.V = V;
		Bag<Integer>[] bags = (Bag<Integer>[]) new Bag[V];
		adj = bags;
		int v = 0;
		do {
			adj[v] = new Bag<Integer>();
			v++;
		} while (v < V);

	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
	}

	public int V() {
		return V;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}
}
/*
 * This part of code defined a class Graph wihch represents a graph data
 * structure with a given with inputs number of vertices, Get the vertices's
 * number from the graph Also adjancacey list has been implemented by using
 * array of bags.
 */

class DepthFirstSearch {
	ArrayList<Integer> tmp;
	String tmp2;
	HashMap<Integer, String> h;
	public boolean marked[], check;

	public DepthFirstSearch(Graph G, int StartIndex) {
		tmp = new ArrayList<Integer>();
		h = new HashMap<Integer, String>();
		tmp.add(StartIndex);
		marked = new boolean[G.V()];
		marked[StartIndex] = true;
		check = false;
		tmp2 = "";
	}

	public boolean isPath(Graph graph, int index) {
		Iterator<Integer> it = graph.adj(index).iterator();
		while (it.hasNext()) {
			int w = it.next();
			if (!marked[w])
				return true;
		}
		return false;
	}

	public void controlPath(Graph graph, int StartIndex, int FinalIndex) {
		Iterator<Integer> iterator = graph.adj(StartIndex).iterator();
		while (iterator.hasNext()) {
			int w = iterator.next();
			if (marked[w]) {
				continue;
			}
			tmp.add(w);
			marked[w] = true;
			if (tmp.contains(FinalIndex) && !isPath(graph, w)) {
				marked[w] = false;
				int size = tmp.size();
				int i = 0;
				do {
					tmp2 += Integer.toString(tmp.get(i));
					i++;
				} while (i < size);

				h.put(tmp2.length(), tmp2);
				tmp2 = "";
			}
			controlPath(graph, w, FinalIndex);
			tmp.remove(tmp.size() - 1);
		}
	}

	public void Print() {
		int i;
		for (i = 0; h.get(i) == null; i++)
			;
		tmp.clear();
		tmp2 = h.get(i);
		int j = 0;
		do {
			tmp.add(Character.getNumericValue(tmp2.charAt(j)));
			j++;
		} while (j < tmp2.length());
		Collections.sort(tmp);
		int k = 0;
		while (k < tmp.size()) {
			System.out.print(tmp.get(k) + " ");
			k++;
		}
	}
	/*
	 * DepthFirstSearch class is used in order to depth first search algorithm to
	 * find all paths in a graph in two vertices Also it keps track of the current
	 * path being explored. stored the valid paths found in a hashMap.
	 */
}