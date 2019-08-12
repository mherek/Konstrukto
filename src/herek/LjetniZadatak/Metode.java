package herek.LjetniZadatak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Metode {

	public static Connection cn;
	public static PreparedStatement ps;

	public void unos() {
		izlaz: while (true) {
			System.out.println("\n 1. Radnik \t 2. Gradiliste \t 3. Dogadaj \n5. Izlaz");
			switch (Kontrola.unosInt("Koju tablicu zelite mijenjati?")) {
			case 1:
				try {
					ispisi(" Select * from radnik");
					ps = cn.prepareStatement(" Insert into radnik (ime, prezime, oib, iban, nadredeni) " + " values (?,?,?,?,?) ");
					ps.setString(1, Kontrola.unosString(" Unesite ime "));
					ps.setString(2, Kontrola.unosString(" Unesite prezime "));
					ps.setString(3, Kontrola.unosOIB("Unesite oib"));
					ps.setString(4, Kontrola.unosIBAN(" Unesite IBAN"));
					ps.setInt(5, Kontrola.unosInt("Unesite ID nadredenog (default null"));
					JOptionPane.showMessageDialog(null, " Podaci uspjesno uneseni " + ps.executeUpdate());
					ispisi(" Select * from radnik");

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			
			case 2:
			ispisi(" Select * from gradiliste");
				try {
					ps=cn.prepareStatement(" Insert into gradiliste (ime, adresa) values ('?,?)");
					ps.setString(1, Kontrola.unosString("Unesite ime gradilista"));
					ps.setString(2, Kontrola.unosString("Unesite adresu gradilista"));
					JOptionPane.showMessageDialog(null, "Podaci uspjesno uneseni" + ps.executeUpdate());
					ispisi(" Select * from gradiliste");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void brisanje() {
		int delete;
		izlaz: while (true) {
			System.out.println("\n 1. Radnik \t 2. Gradiliste \t 3. Dogadaj \n5. Izlaz");
			izadi: switch (Kontrola.unosInt("Koju tablicu zelite mijenjati?")) {
			case 1:
				try {
					ispisi("Select * from radnik");
					ps = cn.prepareStatement(" Delete from radnik where id = ? ");
					while (true) {
						ps.setInt(1, Kontrola.unosInt(" Unesite broj reda koji zelite brisati "));
						delete = JOptionPane.showConfirmDialog(null, " Da li ste sigurni?", null,
								JOptionPane.YES_NO_CANCEL_OPTION);
						if (delete == 0) {
							JOptionPane.showInputDialog("Radnja izvrsena" + ps.executeUpdate());
							ispisi(" Select * from radnik");
							break izadi;
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					ispisi(" Select * from gradiliste ");
					ps = cn.prepareStatement(" Delete from gradiliste where id = ?");
					while (true) {
						ps.setInt(1, Kontrola.unosInt(" Unesite broj reda koji zelite brisati"));
						delete = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", null,
								JOptionPane.YES_NO_CANCEL_OPTION);
						delete = JOptionPane.showConfirmDialog(null, " Da li ste sigurni?", null,
								JOptionPane.YES_NO_CANCEL_OPTION);
						if (delete == 0) {
							JOptionPane.showInputDialog("Radnja izvrsena" + ps.executeUpdate());
							ispisi(" Select * from gradiliste");
							break izadi;
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println(" Nepostojeci broj");
				break;
			}
		}

	}

	private static void ispisi(String query) {
		try {
			PreparedStatement ps = cn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnnumber = rsmd.getColumnCount();
			for (int i = 1; i < columnnumber; i++) {
				System.out.print(rsmd.getColumnName(i));
			}
			System.out.println("");
			while (rs.next()) {
				for (int j = 1; j < columnnumber; j++) {
					if (j > 1) {
						System.out.print(" / ");
						System.out.println(rs.getString(j));
					}
					System.out.println("");
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
