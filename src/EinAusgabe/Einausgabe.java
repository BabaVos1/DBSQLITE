package EinAusgabe;
import java.io.IOException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import DB.Db_Statment;
import Datei.DateilesenWrite;
import Person.Person;

public class Einausgabe {
	private int id;
	private String coulm;
	private String update;
	public ArrayList <Person> p = new ArrayList<Person>();
	
	
	private Db_Statment dbstm = new Db_Statment();
	public	Scanner sc = new Scanner(System.in);
	
	public String [] daten = new String[5];
	
	public void eingabe() {
		Person p = new Person();
		
		String vorname;
		String nachname;
		String handy;
		String email;
		String land;
	
		
		
		
		sc.nextLine();
		System.out.println("Bitte geben Sie ihre Vorname");
		vorname = sc.nextLine();
		System.out.println("Bitte geben Sie ihre Nachname");
		nachname = sc.nextLine();
		System.out.println("Bitte geben Sie ihre Handynummer");
		handy = sc.nextLine();
		System.out.println("Bitte geben Sie ihre Email");
		email = sc.nextLine();
		System.out.println("Bitte geben Sie ihre Land");
		land = sc.nextLine();
	
		
			
		p.setVorname(vorname);
		p.setNachname(nachname);
		p.setHandy(handy);
		p.setEmail(email);
		p.setLand(land);
		
	
		
		daten[0] = p.getVorname();
		daten[1] = p.getNachname(); 
		daten[2] = p.getHandy();
		daten[3] = p.getEmail();
		daten[4] = p.getLand();
		
		
	}

	public void deleteEingabe() {
		System.out.println("Bitte geben Sie ID zu löschen");
		id = sc.nextInt();
	}
	
	public void updateEingabe() {
		System.out.println("Bitte geben Sie ID Nummer zu Update ");
		 id = sc.nextInt();
		System.out.println("Bitte geben Sie Ihre  Auswähl ");
		System.out.print("1 - Vorname" + "\n"+ "2 - Nachname " + "\n"+ "3 - Handy" 
				+ "\n"+ "4 - Email"+  "\n"+ "5 - Land");
		System.out.println();
		int col = sc.nextInt();
		
		switch(col) {
		case 1 :
			coulm =  "Name" ;
			break;
		case 2:
			coulm = "Lastname";
			break;
		case 3:
			coulm =  "TelefonNummer";
			break;
		case 4:
			coulm =   "Email"  ;
			break;
		case 5:
			coulm =  "City" ;
			break;
			
		}
		sc.nextLine();
		System.out.println("Bite geben Sie die Neu Daten");
		update = sc.nextLine();
		
	
		
		
		
		
	}
	
	public void searcheEingabe() {
		System.out.println(" Bitte geben Sie id zu suchen");
		id = sc.nextInt();
	}
	
	public void main() throws SQLException, IOException {
		System.out.println("Bitte geben Sie Ihre Auswähl");
		System.out.println("________________________________");
		System.out.println("1- Daten Listen " + "\n" 
						 + "2- Daten Hinzufügen " + "\n"
						 + "3- Daten Update " + "\n"
						 + "4- Daten Löschen " + "\n"
						 + "5- Daten Suchen " + "\n"
						 + "6- Daten in File speichern" + "\n"
						 + "7- Datei lesen "+ "\n"
						 + "8- Exit\n");
		int auswahl = sc.nextInt();
		
		switch(auswahl) {
		case 1:
			dbstm.getData();
			break;
		case 2:
			boolean nochmal = true;
			do {
			eingabe();
			dbstm.insertDate(daten);
			
	
			System.out.println("Nochmal 1- ja / 2- nein");
			
			int temp = sc.nextInt();
				if (temp == 2) {
				nochmal = false;
				}
			}while(nochmal);
			
			
			break;
		case 3:
			updateEingabe();
			dbstm.updateData(getId(), getCoulm(), getUpdate());
			break;
		case 4:
			boolean noch = true;
			do {
				deleteEingabe();
				dbstm.delteData(getId());
				System.out.println("Nochmal 1- ja / 2- nein");
				int temp = sc.nextInt();
					if (temp == 2) {
					noch = false;
					}
				}while(noch);
				

			
			break;
		case 5:
			boolean nochm = true;
			do {
				searcheEingabe();
				dbstm.searchData(getId());
				System.out.println("Nochmal 1- ja / 2- nein");
				int temp = sc.nextInt();
					if (temp == 2) {
					nochm = false;
					}
				}while(nochm);
			
			break;
	
		case 6:
			
			/*
			 * Db_con dbcon = new Db_con(); Db_Statment dbstm = new Db_Statment(); ResultSet
			 * rs = null; Connection con = null; Statement stm = null;
			 * 
			 * String getDate = "SELECT * FROM "+ dbstm.getDb_Name();
			 * 
			 * try { con = dbcon.getconnection(); stm = con.createStatement(); if (stm !=
			 * null) rs =stm.executeQuery(getDate); while (rs.next()) { Einausgabe einaus =
			 * new Einausgabe(); einaus.p.add(new Person (rs.getString(1),rs.getString(2),
			 * rs.getString(3),rs.getString(4),rs.getString(5) ));
			 * 
			 * System.out.println(this.p.toString()); } } finally { rs.close(); stm.close();
			 * con.close(); }
			 * 
			 */
			dbstm.saveData();
			
			
			break;
		case 7:
			DateilesenWrite ds = new DateilesenWrite();
			ds.lesen();
			break;
		case 8:
			System.exit(0);
			break;
		
			
			
		
		}
	}


	
	
	public int getId() {
		return id;
	}

	public String getCoulm() {
		return coulm;
	}

	public String getUpdate() {
		return update;
	}
 
}


