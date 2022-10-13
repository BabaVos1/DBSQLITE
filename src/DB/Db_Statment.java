package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Datei.DateilesenWrite;
import EinAusgabe.Einausgabe;
import Person.Person;

public class Db_Statment {
	
	// SQl 
	private Db_con dbcon = new Db_con();
	private Connection con = null;
	private Statement stm = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	
	// Datenbank Atribute
	
	 private final String db_Name = "User";
	
	 private final String  id= "ID" ;
	 private final String  vorname= "Name" ;
	 private final String nachname = "Lastname" ;
	 private final String  handy= "TelefonNummer" ;
	 private final String  email= "Email" ;
	 private final String  land= "City" ;
	 private final String  date = "Registeration";


	 
	
	
	// Conection Testen
	public boolean checkCon() throws SQLException {
		con = dbcon.getconnection();
		
		if (con != null) {
			
			return true;
				
		}else 
			return false;
	}
	
	
	
	//  Datenbank ersttellen
	
	public void createDb() throws SQLException {
		String createdb = "CREATE TABLE IF NOT EXISTS " + db_Name +"("
			 + id 			+ " INTEGER PRIMARY KEY, "
			 + vorname		+ " Varchar(50) NOT NULL,"
			 + nachname     + " Varchar(50) NOT NULL,"
			 + handy		+ " Varchar(50) NULL,"
			 + email		+ " Varchar(50) UNIQUE,"
			 + land			+ " Varchar(50) NOT NULL,"
			 + date			+ " TEXT NULL"
			 
				+ ")";
		
	
		executequery(createdb);
	}
	
	public void insertDate(String array[]) throws SQLException {
		String insert = "INSERT INTO " + db_Name +" VALUES " + "(NULL, ?,?,?,?,?,DATETIME('now','localtime'))";
		
		try {
			con = dbcon.getconnection();
			ps = con.prepareStatement(insert);{
			for (int i = 0; i<array.length ; i++) 
				 ps.setString(i+1, array[i]);
			}
				 ps.execute();
				 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ps.close();
			con.close();
		}
		
					 
					 
						
				 
	
					 
	
	}
	
	public void  executequery(String query) throws SQLException {
		try {
			con = dbcon.getconnection();
			stm = con.createStatement();
			stm.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			stm.close();
			con.close();
		}
	}
	
	public void getData() throws SQLException  {
		String getDate = "SELECT * FROM "+ db_Name;
	
		try {
			con = dbcon.getconnection();
			stm = con.createStatement();
			if (stm != null)
				rs =stm.executeQuery(getDate);
			showData(rs);
		}	finally {
			rs.close();
			stm.close();
			con.close();
		}
		
	
		
		
	}
	
	public void showData(ResultSet rs ) throws SQLException {
	while (rs.next()) {
		System.out.print("ID: ");
		System.out.println(rs.getInt(id));
		System.out.print(" VOrname: ");
		System.out.println(rs.getString(vorname));
		System.out.print(" Nachname: ");
		System.out.println(rs.getString(nachname));
		System.out.print(" Hanydnummer: ");
		System.out.println(rs.getString(handy));
		System.out.print(" Email: ");
		System.out.println(rs.getString(email));
		System.out.print(" Land: ");
		System.out.println(rs.getString(land));
		System.out.print(" RegDatum: ");
		System.out.println(rs.getString(date));
		System.out.print(" ||||||||||||||||||| ");
		System.out.println();
	}
		
	}
	
	public void delteData(int id) throws SQLException {

		String delete = "DELETE FROM " + db_Name + " WHERE ID= " + id ;
		
		 executequery(delete);
		
				
	}

	public void updateData(int id , String coulmn , String upda) throws SQLException {
		String update = "UPDATE "+ db_Name + " SET "+ coulmn  + " = " + "'" + upda + "'"
				+ " WHERE " + this.id + " = " + id; 
		
		try {
			con = dbcon.getconnection();
			stm = con.createStatement();
			stm.executeUpdate(update);
		} finally {
			
			stm.close();
			con.close();
			
		}
		getData();
		
		
	}

	public void createQuery(String query) throws SQLException {
		try {
			con = dbcon.getconnection();
			stm = con.createStatement();
			if (stm != null)
				rs =stm.executeQuery(query);
			showData(rs);
		}	finally {
			rs.close();
			stm.close();
			con.close();
		}
	}

	public void searchData(int id) throws SQLException {
		String suchen = "SELECT * FROM " + db_Name + " WHERE " + this.id + " = " + id;
		try {
			con = dbcon.getconnection();
			stm = con.createStatement();
			if (stm != null && rs.next())
				rs =stm.executeQuery(suchen);
			else 
				System.out.println("Nicht gefunden");
		
		}	finally {
			rs.close();
			stm.close();
			con.close();
		}
		createQuery(suchen);
	}
	 public void saveData() throws SQLException {
			DateilesenWrite ds = new DateilesenWrite();
			String getDate = "SELECT * FROM "+ db_Name;
			Einausgabe einaus = new Einausgabe();
			try {
				con = dbcon.getconnection();
				stm = con.createStatement();
				if (stm != null)
					rs =stm.executeQuery(getDate);
				while (rs.next()) {
				
					einaus.p.add(new Person (rs.getString(vorname),rs.getString(nachname), rs.getString(handy),rs.getString(email),rs.getString(land) ));
				//	System.out.println(einaus.p.toString());
					
				
					
				}
				for (Person s : einaus.p) {
					ds.WriteObjectToFile(s.toString());
					System.out.println(s.toString());
				}
				
				
			}	finally {
				rs.close();
				stm.close();
				con.close();
			}
	 }



	public String getDb_Name() {
		return db_Name;
	}
}


