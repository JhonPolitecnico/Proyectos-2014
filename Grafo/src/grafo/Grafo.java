package grafo;

public class Grafo {
	private Vertice[] vertices;
	private int[][] matrizDeAdyacencia;

	public Grafo(int numVertices) {
		this.vertices = new Vertice[numVertices];
		this.matrizDeAdyacencia = new int[numVertices][numVertices];
	}

	public void insertarVertice(String etiqueta) {
		if (buscarVertice(etiqueta) == -1)
			return;

		int i = 0;

		for (Vertice vertice : this.vertices) {
			if (vertice != null) {
				i++;
				continue;
			}

			this.vertices[i] = new Vertice(etiqueta);
			break;
		}
	}

	public int buscarVertice(String etiqueta) {
		int i = 0;

		for (Vertice vertice : this.vertices) {
			if (vertice.getEtiqueta().equals(etiqueta))
				return i;
			i++;
		}

		return -1;
	}

	public void insertarArco(String origen, String destino) {
		if (this.buscarVertice(origen) == -1 || this.buscarVertice(destino) == -1)
			return;

		this.matrizDeAdyacencia[this.buscarVertice(origen)][this.buscarVertice(destino)] = 1;
		this.matrizDeAdyacencia[this.buscarVertice(destino)][this.buscarVertice(origen)] = 1;
	}

}
