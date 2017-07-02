package exe2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VulnerableClass {
	private static void check(String s){
		if (!s.matches("^[a-zA-Z0-9]*" + "\\.txt$"))
			throw new IllegalArgumentException();
	}
	
	public void vulnerableMethod(String FILENAME){
		int i = 0;
		check(FILENAME);
		//removendo loop infinito por causa do denial of service
		while (i<5) {
		    Scanner console = new Scanner(System.in);
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo>? ");
			
		    String opr= console.nextLine();
			
		    if (opr.equals("R")){
				BufferedReader br = null;
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					String sCurrentLine;

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}
					br.close();
					fr.close();

				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
			
			else {
				if (opr.equals("W")){
					  BufferedWriter buffWrite;
					  
					  try {
						buffWrite = new BufferedWriter(new FileWriter(FILENAME));
						String linha = "";
						System.out.println("Escreva algo: ");
					    linha = console.nextLine();
					    buffWrite.append(linha + "\n");
					    buffWrite.close();
					     
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					System.out.println("Escreve W ou R");
				}
			}
		    i++;
		}
	}
}
