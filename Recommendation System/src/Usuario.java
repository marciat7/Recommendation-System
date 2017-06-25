import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Usuario {
	ArrayList<Avaliacao> avaliacoes;
	Semelhante[] semelhantes = new Semelhante[5];
	
	public Usuario(ArrayList<Avaliacao> avaliacaos) {
		this.avaliacoes = avaliacaos;
	}
	
	public void calcularSemelhantes(ArrayList<Usuario> usuarios) {
		
		for (int i = 0; i < usuarios.size(); i++) {
			ArrayList<Avaliacao> aux = pegarAvaliacoes(usuarios.get(i));
			double xy = 0, x = 0, y = 0;
			double r = 0;
			for (int j = 0; j < aux.size()-1; j = j + 2) {
				xy = (aux.get(j).nota * aux.get(j+1).nota) + xy;
				x = (aux.get(j).nota * aux.get(j).nota) + x;
				y = (aux.get(j+1).nota * aux.get(j+1).nota) + y;
			}
			
			r = xy / (Math.sqrt(x) * Math.sqrt(y));
			if (i < 5) {
				semelhantes[i] = new Semelhante(i, r, usuarios.get(i).avaliacoes);
			}else {
				for (int j = 0; j < semelhantes.length; j++) {
					if (semelhantes[j].coeficient < r) {
						semelhantes[j] = null;
						semelhantes[j] = new Semelhante(i, r, usuarios.get(i).avaliacoes);
					}
				}
			}
			
		}	

	}
	
	private ArrayList<Avaliacao> pegarAvaliacoes(Usuario usuario) {
		ArrayList<Avaliacao> tmp = new ArrayList<Avaliacao>();
		for (int i = 0; i < avaliacoes.size(); i++) {
			for (int j = 0; j < usuario.avaliacoes.size(); j++) {
				if (avaliacoes.get(i).item == usuario.avaliacoes.get(j).item) {
					tmp.add(avaliacoes.get(i));
					tmp.add(usuario.avaliacoes.get(j));
					j = usuario.avaliacoes.size();
				}
			}
		}
		return tmp;
	}
	
	public boolean recomendarItem(int item) {
		double d = 0, r = 0;
		int count = 0;
		for (int i = 0; i < semelhantes.length; i++) {
			for (int j = 0; j < semelhantes[i].avaliacoes.size(); j++) {
				if (semelhantes[i].avaliacoes.get(j).item == item) {
					d = semelhantes[i].avaliacoes.get(j).nota + d;
					count++;
				}
			}
		}
		
		if (count > 0) {
			r = d / count;
		}
		
		if (r >= 4) {
			return true;
		}else {
			return false;
		}

	}

}
