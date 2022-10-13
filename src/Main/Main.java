package Main;
import java.io.IOException;
import java.sql.SQLException;

import DB.Db_Statment;
import EinAusgabe.Einausgabe;

public class Main {

	public static void main(String[] args) {
	
		Db_Statment dbstm = new Db_Statment();
		Einausgabe einaus = new Einausgabe();
		boolean loop = true;
			try {
				do {
					einaus.main();
				}
				while(loop);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
