
public class prueba {

	public static void main(String[] arg) {
		Graph grafo = new Graph();
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 4);
		grafo.addEdge(2, 4);
		
		grafo.removeNode(3);
		grafo.addNode(3);
		grafo.removeEdge(2, 3);
		grafo.removeNode(4);
		grafo.addNode(3);
	}
}
