import java.util.ArrayList;

public class Semelhante {
	int id;
	double coeficient;
	ArrayList<Avaliacao> avaliacoes;
	
	public Semelhante(int id, double coeficient, ArrayList<Avaliacao> avaliacoes) {
		this.id = id;
		this.coeficient = coeficient;
		this.avaliacoes = avaliacoes;
	}
}
