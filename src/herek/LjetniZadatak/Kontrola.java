package herek.LjetniZadatak;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Kontrola {

	public static final String FORMAT_DATUMA = "dd.MM.yyyy HH:mm";

	public static boolean unosOIB(String oib) {
		while (true) {
			if (oib.trim().length() != 11) {
				return false;
			}
			try {
				Long.parseLong(oib);
			} catch (NumberFormatException e) {
				return false;
			}
			
		}

	}

	public static boolean unosIBAN(String poruka) {
		String iban;
		while (true) {
		
				iban = JOptionPane.showInputDialog(poruka);
				if (iban.trim().length() != 21 ) {
					return false;
				}
				try { Long.parseLong(poruka);
				}
					
					catch (NumberFormatException e) {
						return false;
					}

		
			
		}
	}
	

	public static String unosString(String poruka) {
		String s;
		while (true) {
			s = JOptionPane.showInputDialog(poruka);
			if (s.trim().length() == 0 /* && s.matches("/d")*/) {
				JOptionPane.showConfirmDialog(null, "Obavezan unos");
				continue;
			}
			return s;
		}
	}

	public static Date unosDatuma(String poruka) {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUMA);
		while (true) {
			try {
				return df.parse(JOptionPane.showInputDialog(poruka));

			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Obavezan unos datuma u formatu : " + FORMAT_DATUMA);
			}
		}
	}

	public static int unosInt(String poruka) {
		int i;
		while (true) {
			try {
				i = Integer.parseInt(JOptionPane.showInputDialog(poruka));
				if (i <= 0) {
					JOptionPane.showConfirmDialog(null, "Broj mora biti veci od nule!");
					continue;
				}
				return i;
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, "Unesi broj!");
			}

		}
	}
}
