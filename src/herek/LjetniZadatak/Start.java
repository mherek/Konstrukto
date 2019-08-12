package herek.LjetniZadatak;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Start {
//	private Connection connection;


	public Start() {
		radnici = new ArrayList<Radnik>();
	//	connection = Baza.getConnection();

		petlja: while (true) {
			izbornik();
			switch (Kontrola.unosInt("Odaberite radnju")) {
			case 1:
			unosOsobe();
				break;
			case 2:
				izlistajOsobe();
				break;
			case 3:
				izmjenaOsobe();
				break;
			case 4:
				//brisanjeOsobe();
				break;
			case 5:

				break;
			case 7:
				break petlja;
			default:
				break;
			}
		}

	}

//	private void brisanjeOsobe() {
//		izlistajOsobe();
//		radnici.remove(Kontrola.unosInt(" Unesite osobu koju zelite obrisai"));
//
//	}


	private void izbornik() {
		System.out.println("Konstrukto!");
		System.out.println("1. Unos nove osobe");
		System.out.println("2. Pregled svih unesenih osoba");
		System.out.println("3. Izmjena dodane osobe");
		System.out.println("4. Brisanje postojece osobe");
		System.out.println("5. ERA");
		System.out.println("6. Github");
		System.out.println(" 7. Izlaz ");
	}

	public static void main(String[] args) {
		new Start();
	}

}
