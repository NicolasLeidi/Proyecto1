import java.util.HashMap;
import java.util.logging.*;

public class Graph {

	private HashMap<Integer, Nodo> mapNodos;
	private static Logger logger;
	
	public Graph() {
		mapNodos = new HashMap<Integer, Nodo>();
		if(logger == null) {
			logger = Logger.getLogger(Graph.class.getName());
			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.FINE);
			logger.addHandler(hnd);
			logger.setLevel(Level.WARNING);
			
			Logger rootLogger = logger.getParent();
			for(Handler h : rootLogger.getHandlers())
				h.setLevel(Level.OFF);
		}
	}
	
	public void addNode(int node) {
		if(node >= 1) {
			if (mapNodos.get(node) == null) {
				mapNodos.put(node, new Nodo());
				logger.fine("Agregué nodo: " + node);
			}
			else
				logger.warning("Nodo introducido ya existe");
		}
		else
			logger.warning("Nodo introducido no válido");
	}
	
	public void addEdge(int node1, int node2) {
		if(node1 >= 1 && node2 >= 1) {
			Nodo n = mapNodos.get(node1);
			if(n != null && mapNodos.get(node2) != null) {
				n.addAdy(node2);
				logger.fine("Agregué arco: " + node1 + " con " + node2);
			}
			else
				logger.warning("Nodos introducidos no pertenecen al grafo");
		}
		else
			logger.warning("Nodos introducidos no válidos");
	}
	
	public void removeNode(int node) {
		if(node >= 1) {
			if (mapNodos.get(node) != null) {
				mapNodos.remove(node);
				for(Nodo n : mapNodos.values())
					n.removeAdy(node);
				logger.fine("Removí nodo: " + node);
			}
			else
				logger.warning("Nodos introducidos no pertenecen al grafo");
		}
		else
			logger.warning("Nodo introducido no válido");
	}
	
	public void removeEdge(int node1, int node2) {
		if(node1 >= 1 && node2 >= 1) {
			Nodo n = mapNodos.get(node1);
			if(n != null && mapNodos.get(node2) != null) {
				if(n.conectaCon(node2)) {
					n.removeAdy(node2);
					logger.fine("Removí arco: " + node1 + " con " + node2);
				}
				else
					logger.warning("No pude remover arco: " + node1 + " con " + node2);
			}
			else
				logger.warning("Nodos introducidos no pertenecen al grafo");
		}
		else
			logger.warning("Nodos introducidos no válidos");
	}
}
