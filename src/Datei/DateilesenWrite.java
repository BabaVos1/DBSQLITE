package Datei;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class DateilesenWrite {

	public void lesen() throws IOException {
		byte[] s;

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Bitte geben Sie die pfad zu Datei");
		String path = input.readLine();
		FileReader fr = new FileReader(path);
		BufferedReader br = new BufferedReader(fr);

		String strng;
		while ((strng = br.readLine()) != null)
			System.out.println(strng);
	}

	   public void WriteObjectToFile(Object serObj) {
		   
	        try {
	 
	            
	            FileOutputStream writeData = new FileOutputStream("C:\\Users\\ahmed.almustafa\\Desktop\\peopledata.txt");
	            ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

	            writeStream.writeObject(serObj);
	            writeStream.flush();
	            writeStream.close();

	        
	 
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	   }

	
}
