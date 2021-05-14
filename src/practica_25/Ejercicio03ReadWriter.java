package practica_25;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio03ReadWriter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Nombre archivo a encriptar: ");
		String archivo = sc.nextLine();
		
		System.out.println("Contenido ORIGINAL");
		crearFicheroEncriptado(archivo);
		
		System.out.println("\nEl fichero ha sido encriptado");
		
		System.out.println("Pulsa cualquier tecla para visualizar el archivo creado...");
		sc.next();
		
		System.out.println("Contenido ENCRIPTADO");
		muestraContenidoArchivo("encriptado.txt", false);
		
		
		System.out.println("\nContenido DESENCRIPTADO");
		muestraContenidoArchivo("encriptado.txt", true);
		
		eliminaEncriptado("encriptado.txt");
		
	sc.close();	
	}//end main
	
	
	/**
	 * Método que lee el archivo original y lo pasa a otro método para que lo encripte
	 * @param archivo
	 */
	private static void crearFicheroEncriptado(String archivo) {
		
		int caracter=0;
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(archivo)))){
			
			while(caracter!=-1) {	//mientras sea distinto a -1
				
				caracter = br.read(); //lee el caracter
				
				if(caracter != -1) {
					System.out.print((char)caracter);
					escribeEncriptado(caracter);
				}
									
			}			
			
		}
		catch(FileNotFoundException e1) {
			System.out.println("El archivo no existe");
			
		}
		catch (IOException e2) {
			
			e2.printStackTrace();
		}		
		
	}
	
	/**
	 * Método que encripta el archivo original
	 * @param caracter
	 */
	private static void escribeEncriptado(int caracter) {
		
		int caracterEscrito = caracter + 3;
		
		try(FileWriter fw = new FileWriter(new File("encriptado.txt"), true)){
			
			fw.write(caracterEscrito);	
			
			
		} 
		catch (IOException e) {

			e.printStackTrace();
		}		
	}
	
	
	/**
	 * Método que lee un archivo que se le pasa como parámetro
	 * @param archivo
	 */
	private static void muestraContenidoArchivo(String archivo, boolean sw) {
		
		int caracter =0;
		try (BufferedReader br = new BufferedReader(new FileReader(new File(archivo)))){
			
			while(caracter!=-1) {	//mientras sea distinto a -1
				
				caracter = br.read(); //lee el caracter
				
				if(caracter != -1) {
					
					if(!sw)
						System.out.print((char)caracter);
					else {
						System.out.print((char)(caracter-3));
					}					
				}												
			}			
		}
		catch(FileNotFoundException e1) {
			System.out.println("El archivo no existe");
			
		}
		catch (IOException e2) {
			
			e2.printStackTrace();
		}	
		
		
	}
	
	/**
	 * Método que elimina el archivo encriptado. Así no se duplica el contenido cada vez que ejecuto el programa
	 * @param archivo
	 */
	private static void eliminaEncriptado(String archivo) {
		
		
		File fichero = new File(archivo);
		
		fichero.delete();		
	}
	
	
	
	

}
