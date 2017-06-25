

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Arquivo {

	Scanner scanner;
	BufferedWriter writer;
	String entrada, saida;
	
	public Arquivo(String entrada,String saida) {
		this.entrada = entrada;
		this.saida = saida;
		try {
			scanner = new Scanner(new File(entrada));
			writer = new BufferedWriter(new FileWriter(saida));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String lerString() {
		return scanner.nextLine();
	}
	
	public int lerInt() {
		return scanner.nextInt();
	}
	
	public void fechar() {
		try {
			writer.flush();		
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//scanner.close();
	}

	public void escrever(String txt) {
		try {
			writer.write(txt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
