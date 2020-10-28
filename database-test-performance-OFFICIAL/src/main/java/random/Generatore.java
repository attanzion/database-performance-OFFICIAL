package random;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import classi.Giocatore;
import classi.Portiere;
import jogamp.opengl.SharedResourceRunner.Resource;

public class Generatore {
	
	private ArrayList<String> nomi = null;
	private ArrayList<String> cognomi = null;
	private ArrayList<String> nazionalita = null;
	private ArrayList<Giocatore> all_gioc = null;
	private ArrayList<Portiere> all_por = null;
	private ArrayList<String> info_squad = null;
	
	/**
	 * Costruttore della classe 'Generatore'.
	 */
	
	public Generatore() {
		
		this.setNomi();
		this.setCognomi();
		this.setNazionalita();
		this.setAll_gioc();
		this.setAll_por();
		this.setInfo_squad();
		
		this.Carica_Txt();
		
	}
	
	/**
	 * Funzione che crea un numero di giocatori random in base al numero 'numero_calciatori'.
	 * @param numero_calciatori
	 */
	
	public void Genera_Calciatori(int numero_calciatori) {
		
		System.out.println("\nGENERAZIONE DI " + numero_calciatori + " CALCIATORI in corso..........\n");
		
		Generatore_calciatore gc = new Generatore_calciatore(this.nomi, this.cognomi, this.nazionalita, this.all_gioc, this.all_por, this.info_squad);
		
		while((this.all_gioc.size() + this.all_por.size()) < numero_calciatori) {
			
			try {
				
				gc.Crea_Calciatore(numero_calciatori);
				
			}catch (Exception e) {
				
				//System.out.println("Errore in Generatore - Genera_Calciatori().");
				
			}
			
		}
		
	}
	
	/**
	 * Funzione che carica i dati negli arraylist dai file testo.
	 */
	
	public void Carica_Txt() {
		
		try {
			
//			BufferedReader reader_nomi = new BufferedReader(new FileReader("C:\\Users\\andre\\git\\database-test-performace\\Database-test-performance\\database-test-performance\\Nomi.txt"));
//			BufferedReader reader_cognomi = new BufferedReader(new FileReader("C:\\Users\\andre\\git\\database-test-performace\\Database-test-performance\\database-test-performance\\Cognomi.txt"));
//			BufferedReader reader_nazionalita = new BufferedReader(new FileReader("C:\\Users\\andre\\git\\database-test-performace\\Database-test-performance\\database-test-performance\\Nazionali.txt"));
//			BufferedReader reader_info_squad = new BufferedReader(new FileReader("C:\\Users\\andre\\git\\database-test-performace\\Database-test-performance\\database-test-performance\\Info squadre.txt"));
			
			InputStream is = getClass().getResourceAsStream("/Nomi.txt");
		    InputStreamReader isr = new InputStreamReader(is);
		    BufferedReader reader_nomi = new BufferedReader(isr);
			
			String line_nomi = reader_nomi.readLine();
			
	        while(line_nomi != null) {
	        	
	        	String i = line_nomi.substring(0, 1).toUpperCase();
	        	String e = line_nomi.substring(1).toLowerCase();
	        	
	            this.nomi.add(i + e); 					/** Aggiunge il nome trovato nel file Nomi.txt all'arraylist 'nomi'.*/
	            line_nomi = reader_nomi.readLine();
	            
	        }
	        
	        is = getClass().getResourceAsStream("/Cognomi.txt");
		    isr = new InputStreamReader(is);
		    BufferedReader reader_cognomi = new BufferedReader(isr);
	        
	        String line_cognomi = reader_cognomi.readLine();
	        
	        while(line_cognomi != null) {
	        	
	        	String i = line_cognomi.substring(0, 1).toUpperCase();
	        	String e = line_cognomi.substring(1).toLowerCase();
	        	
	            this.cognomi.add(i + e);				/** Aggiunge il cognome trovato nel file Cognomi.txt all'arraylist 'cognomi'.*/
	            line_cognomi = reader_cognomi.readLine();
	            
	        }
	        
	        is = getClass().getResourceAsStream("/Nazionali.txt");
		    isr = new InputStreamReader(is);
		    BufferedReader reader_nazionalita = new BufferedReader(isr);
	        
	        String line_nazionalita = reader_nazionalita.readLine();
			
			while(line_nazionalita != null) {
				
				this.nazionalita.add(line_nazionalita.trim());
				
				line_nazionalita = reader_nazionalita.readLine();
				
			}
			
			is = getClass().getResourceAsStream("/Info squadre.txt");
		    isr = new InputStreamReader(is);
		    BufferedReader reader_info_squad = new BufferedReader(isr);
			
			String line_info = reader_info_squad.readLine();
			
			while(line_info != null) {
				
				this.info_squad.add(line_info);
				
				line_info = reader_info_squad.readLine();
				
			}
			
		} catch (Exception e) {
			
			System.out.println("Errore in Generatore_calciatori - Carica_Txt(). " + e);

		}
		
	}
	
	
	/**
	 * Funzione che ritorna 'nomi'.
	 * @return nomi
	 */
	
	public ArrayList<String> getNomi() {
		
		return this.nomi;
		
	}
	

	/**
	 * Funzione che setta 'nomi', inizializzando un nuovo arraylist.
	 */
	
	public void setNomi() {
		
		this.nomi = new ArrayList<String>();
		
	}

	/**
	 * Funzione che ritorna 'cognomi'.
	 * @return cognomi
	 */
	
	public ArrayList<String> getCognomi() {
		
		return this.cognomi;
		
	}

	/**
	 * Funzione che setta 'cognomi', inizializzando un nuovo arraylist.
	 */
	public void setCognomi() {
		
		this.cognomi = new ArrayList<String>();
		
	}

	/**
	 * Funzione che ritorna 'nazionalita'.
	 * @return nazionalita
	 */
	public ArrayList<String> getNazionalita() {
		
		return this.nazionalita;
		
	}

	/**
	 * Funzione che setta 'nazionalita', inizializzando un nuovo arraylist.
	 */
	
	public void setNazionalita() {
		
		this.nazionalita = new ArrayList<String>();
		
	}

	/**
	 * @return the all_gioc
	 */
	
	public ArrayList<Giocatore> getAll_gioc() {
		
		return this.all_gioc;
		
	}

	/**
	 * @param all_gioc the all_gioc to set
	 */
	
	public void setAll_gioc() {
		
		this.all_gioc = new ArrayList<Giocatore>();
		
	}

	/**
	 * @return the all_por
	 */
	
	public ArrayList<Portiere> getAll_por() {
		
		return this.all_por;
		
	}

	/**
	 * @param all_por the all_por to set
	 */
	public void setAll_por() {
		
		this.all_por = new ArrayList<Portiere>();
		
	}

	/**
	 * @return the info_squad
	 */
	public ArrayList<String> getInfo_squad() {
		return this.info_squad;
	}

	/**
	 * @param info_squad the info_squad to set
	 */
	public void setInfo_squad() {
		this.info_squad = new ArrayList<String>();
	}

}
