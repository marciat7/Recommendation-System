import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) {
		ArrayList<Usuario> usuarios =  new ArrayList<Usuario>();;
		Arquivo arquivo = new Arquivo("ratings.csv", "saida.txt");
		Map<String, ArrayList<String>> ratings = new HashMap<String, ArrayList<String>>();
		
		arquivo.lerString();
		
		while (arquivo.scanner.hasNext()) {
			String[] aux = arquivo.lerString().split(",");
			
			int x = 0; 
			if (ratings.get(aux[0]) != null) {
				ratings.get(aux[0]).add(aux[1] + "," + aux[2]);
			}else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(aux[1] + "," + aux[2]);
				ratings.put(aux[0], temp);
			}
			
		}
		
		for (Entry<String, ArrayList<String>> par : ratings.entrySet()) {
			arquivo.escrever(par.getKey() + ": ");
			ArrayList<Avaliacao> tmp = new ArrayList<Avaliacao>();			
			for (int i = 0; i < par.getValue().size(); i++) {
				arquivo.escrever(par.getValue().get(i) + ";");
				String[] t = par.getValue().get(i).split(",");
				tmp.add(new Avaliacao(Integer.parseInt(t[0]), Double.parseDouble(t[1])));
			}
			Usuario usuario = new Usuario(tmp);
			usuarios.add(usuario);
			arquivo.escrever("\n");
		}
		
		for (int i = 0; i < usuarios.size(); i++) {
			usuarios.get(i).calcularSemelhantes(usuarios);
			System.out.println(usuarios.get(i).recomendarItem(230));
		}
	}

}
