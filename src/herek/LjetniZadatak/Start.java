package herek.LjetniZadatak;

import java.awt.Desktop;
import java.net.URI;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Start {

	Desktop dt=Desktop.getDesktop();

	public Start() {
		
	Metode.cn=Baza.getConnection();

		petlja: while (true) {
			izbornik();
			switch (Kontrola.unosInt("Odaberite radnju")) {
			case 1:
			Metode.unos();
				break;
			case 2:
				Metode.prikaz();
				break;
			case 3:
			Metode.promjena();
				break;
			case 4:
				Metode.brisanje();
				break;
			case 5:
				gitera();
				break;
			case 6:
				gitlink();
				break;
			case 7:
				break petlja;
			default:
				break;
			}
		}

	}

private void gitera() {
		try {
			dt.browse(new URI("https://github.com/mherek/Konstrukto/blob/master/konstrukto_era.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

private void gitlink() {
try {
	dt.browse(new URI("https://github.com/mherek/Konstrukto"));
} catch (Exception e) {
	e.printStackTrace();
}
	
}

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
