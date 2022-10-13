package Person;

public class Person {
	private String vorname;
	private String nachname;
	private String handy;
	private String email;
	private String land;
	
	
	
	public Person() {
		
	}
	public Person(String vorname, String nachname, String handy,String email,String land )
	{
		this.vorname=vorname;
		this.nachname= nachname;
		this.handy =handy;
		this.email=email;
		this.land= land;
		
	}
	
	
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getHandy() {
		return handy;
	}
	public void setHandy(String handy) {
		this.handy = handy;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	
	  public String toString() 
	  {
		  return "Vorname: " + this.getVorname() + "\nNachname: " +this.getNachname()
		  + "\nTelefonnummer: " + this.getHandy() + "\nEmail: " +this.getEmail()
		  + "\nLand: "  + this.getLand() + "\n";
		  

	  }
	 
}
