import java.util.HashMap;

public class Graph {

	private HashMap<Integer, Nodo> mapNodos;
	
	public Graph() {
		mapNodos = new HashMap<Integer, Nodo>();
	}
	
	public void addNode(int node) {
		if(node >= 1) {
			if (mapNodos.get(node) == null) {
				mapNodos.put(node, new Nodo());
				System.out.println("Agregué nodo: " + node);
			}
		}
	}
	
	public void addEdge(int node1, int node2) {
		if(node1 >= 1 && node2 >= 1) {
			Nodo n = mapNodos.get(node1);
			if(n != null && mapNodos.get(node2) != null) {
				n.addAdy(node2);
				System.out.println("Agregué arco: " + node1 + " con " + node2);
			}
		}
	}
	
	public void removeNode(int node) {
		if(node >= 1) {
			if (mapNodos.get(node) != null) {
				mapNodos.remove(node);
				for(Nodo n : mapNodos.values())
					n.removeAdy(node);
				System.out.println("Removí nodo: " + node);
			}
		}
	}
	
	public void removeEdge(int node1, int node2) {
		if(node1 >= 1 && node2 >= 1) {
			Nodo n = mapNodos.get(node1);
			if(n != null && mapNodos.get(node2) != null) {
				if(n.conectaCon(node2)) {
					n.removeAdy(node2);
					System.out.println("Removí arco: " + node1 + " con " + node2);
				}
				else
					System.out.println("No pude remover arco: " + node1 + " con " + node2);
			}
		}
	}
}
