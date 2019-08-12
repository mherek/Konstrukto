package herek.LjetniZadatak;

public class Radnik {

	private String ime;
	private String prezime;
	private String oib;
	private String iban;
	
	public Radnik() {
		
	}
	
	public Radnik(String ime, String prezime) {
		this.ime=ime;
		this.prezime=prezime;
	}
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getOib() {
		return oib;
	}
	public void setOib(String oib) {
		this.oib = oib;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public int getNadredeni() {
		return nadredeni;
	}
	public void setNadredeni(int nadredeni) {
		this.nadredeni = nadredeni;
	}
	private int nadredeni;
}
