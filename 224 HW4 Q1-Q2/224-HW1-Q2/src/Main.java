/* Main
 * Giray Berk Kuþhan
 * Section 4 
 * Assignment 1 Q2 
 * 1088978942 
 */
import java.util.*;

class Node<Item> {
	public Item item;
	public Node<Item> next;

	public Node() {
		this.item = null;
	}
}

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String exp;
		String paths;
		int noI;
		int nop;
		int beggining = '\0', ending = '\0';

		exp = scanner.nextLine();
		exp = exp.replaceAll("\\s", "");

		noI = Character.getNumericValue(exp.charAt(0));
		nop = Character.getNumericValue(exp.charAt(1));
		/*
		 * The part of this code processes a user input by assigning the numbers inside
		 * it to the variables number of Islands and number oof paths.
		 */

		Graph g = new Graph(nop + 1);
		for (; nop > 0;) {
			paths = scanner.nextLine();
			paths = paths.replaceAll("\\s", "");
			if (beggining == '\0') {
				beggining = Character.getNumericValue(paths.charAt(0));
			}
			g.addEdge(Character.getNumericValue(paths.charAt(0)), Character.getNumericValue(paths.charAt(1)));
			nop--;
			if (nop == 0) {
				ending = Character.getNumericValue(paths.charAt(1));
			}
		}

		exp = scanner.nextLine();
		exp = exp.replaceAll("\\s", "");
		DepthFirstSearch deepFirstSearch = new DepthFirstSearch(g, beggining);
		deepFirstSearch.controlPath(g, Character.getNumericValue(exp.charAt(0)),
				Character.getNumericValue(exp.charAt(1)));
		deepFirstSearch.Print();
	}
}

/*
 * in this part I created a graph with given number of vertices and edges Then
 * reads in the paths from user inputs, adds to the graph, After that created a
 * DepthFirstSearch object with the graph. Also it used the object to find and
 * print the path between vertices
 * 
 */
class Bag<Item> implements Iterable<Item> {
	public Node<Item> first;
	public int count; // size of Bag

	public Bag() {
		first = null;
		count = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return count;
	}

	public void add(Item item) {

		Node<Item> current = first;
		first = new Node<Item>();
		first.item = item;
		first.next = current;
		count++;
	}

	public Iterator<Item> iterator() {
		return new LinkedIterator(first);
	}
	/*
	 * defines a generic Bag data structure and uses linked list, and provides
	 * methodas for adding items. Then making a control whether Bag is empty or not
	 * and getting size In addiditon Bag implements iterable interface.
	 */

	public class LinkedIterator implements Iterator<Item> {
		public Node<Item> current;

		public LinkedIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}
		

		public void remove() {

			try {
				throw new UnsupportedOperationException();
			} catch (UnsupportedOperationException e) {
				System.out.println("Unsupported operation: " + e.getMessage());
			}
		}

		public Item next() {
			try {
				if (!hasNext())
					throw new NoSuchElementException();
				Item item = current.item;
				current = current.next;
				return item;
			} catch (NoSuchElementException e) {
				System.err.println("No such element exception: " + e.getMessage());
				return null;
			} catch (Exception e) {
				System.err.println("An error occurred: " + e.getMessage());
				return null;
			}
		}
	}
	/*
	 * Defines an class as LinkedIterator which implements the Itertor interface.
	 * Also methods for iterating over the items in a Bag. It controls to more items
	 * to iterate over or not. After that remove items from bag.(In that part It
	 * might be causes an exception so needed to control with thorws.)
	 * 
	 */
}
