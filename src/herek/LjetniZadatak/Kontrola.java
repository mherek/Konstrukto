package herek.LjetniZadatak;

import javax.swing.JOptionPane;

public class Kontrola {

	public static String unosOIB(String poruka) {
		String oib;
		while (true) {
			oib = JOptionPane.showInputDialog(poruka);
			if (oib.length() != 11 && oib.matches("[a-zA-Z_]+")) {
				System.out.println("Nedozvoljeni unos ");
				continue;
			}
			return oib;
		}

	}

	public static String unosIBAN(String poruka) {
		String iban;
		while (true) {
			iban = JOptionPane.showInputDialog(poruka);
			if (iban.length() != 11 && iban.matches("[a-zA-Z_]+")) {
				System.out.println("Nedozvoljeni unos");
				continue;
			}
			return iban;
		}
	}

	public static String unosString(String poruka) {
		String s;
		while (true) {
			s = JOptionPane.showInputDialog(poruka);

			if (s.trim().length() == 0) {
				JOptionPane.showConfirmDialog(null, "Obavezan unos");
				continue;
			}
			return s;
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
