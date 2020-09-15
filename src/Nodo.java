import java.util.HashMap;

public class Nodo {

	private HashMap<Integer, Integer> ady;
	
	public Nodo() {
		ady = new HashMap<Integer, Integer>();
	}
	
	public void addAdy(int nodo) {
		ady.put(nodo, nodo);
	}
	
	public boolean conectaCon(int nodo) {
		return ady.get(nodo) != null;
	}
	
	public void removeAdy(int nodo) {
		ady.remove(nodo);
	}
}
