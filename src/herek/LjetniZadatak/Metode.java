package herek.LjetniZadatak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Metode {

	public static Connection cn;
	public static PreparedStatement ps;

	public static void promjena() {

	}

	private static void updateradnik() {
		int i;
		try {
			ispisi(" Select * from radnik");
			i = Kontrola.unosInt(" Unesite sifru koju bih ste htjeli mijenjati");
			ps = cn.prepareStatement(" Update radnik set ime = ? where id = ? ");
			ps.setInt(2, i);
			ps.setString(1, Kontrola.unosString(" Unesite novo ime"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno" + ps.executeUpdate());
			PreparedStatement ps1 = cn.prepareStatement(" Update radnik set prezime = ? where id=? ");
			ps1.setInt(2, i);
			ps.setString(2, Kontrola.unosString(" Unesite novo prezime"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno " + ps.executeUpdate());
			PreparedStatement ps2 = cn.prepareStatement(" Update radnik set oib = ? where id = ? ");
			ps2.setInt(2, i);
			ps.setString(3, Kontrola.unosOIB("Unesite novi OIB"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno " + ps.executeUpdate());
			PreparedStatement ps3 = cn.prepareStatement(" Update radnik set iban = ? where id = ?");
			ps3.setInt(2, i);
			ps.setString(4, Kontrola.unosIBAN(" Unesite novi IBAN"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno " + ps.executeUpdate());
			PreparedStatement ps4 = cn.prepareStatement("Update radnik set nadredeni = ? where id= ? ");
			ps4.setInt(2, i);
			ps4.setInt(5, Kontrola.unosInt("Unesite id nadredenog"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno " + ps.executeUpdate());
			ispisi("Select * from radnik");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void updategradiliste() {
		int i;
		try {
			ispisi("Select * from gradiliste");
			i = Kontrola.unosInt(" Unesite broj tablice koji zelite mijenjati");
			ps = cn.prepareStatement(" Update gradiliste set ime = ? where id= ? ");
			ps.setInt(2, i);
			ps.setString(1, Kontrola.unosString(" Unesite novo ime"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno" + ps.executeUpdate());
			PreparedStatement ps1 = cn.prepareStatement(" Update gradiliste set adresa = ? where id = ?");
			ps.setInt(2, i);
			ps.setString(2, Kontrola.unosString(" Unesite novu adresu gradilista"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno" + ps.executeUpdate());
			ispisi(" Select * from gradiliste");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void updatedogadaj() {
		int i,j;
		try {
			ispisi("Select * from dogadaj");
			i=Kontrola.unosInt("Unesite broj tablice koju zelite mijenjati");
			ps=cn.prepareStatement("Update dogadaj set vrijemepocetka = ?  where id = ?");
			ps.setInt(2, i);
			ps.setDate(1, (Date) Kontrola.unosDatuma("Unesite novo vrieme pocetka"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno" + ps.executeUpdate());
			PreparedStatement ps1=cn.prepareStatement(" Update dogadaj set vrijemekraja = ? where id = ?");
			ps.setInt(2, i);
			ps.setDate(2, (Date) Kontrola.unosDatuma(" Unesite novo vrijeme kraja"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno" + ps.executeUpdate());
			PreparedStatement ps3=cn.prepareStatement(" Update dogadaj set gradiliste = ? where id = ?");
			ps.setInt(2, i);
			ps.setString(3, Kontrola.unosString("Unesite novo gradiliste"));
			JOptionPane.showMessageDialog(null, "Uspjesno promjenjeno" + ps.executeUpdate());
		/*	PreparedStatement ps4=cn.prepareStatement("Update dogadaj set radnik= ? where id = ?");
			ps.setInt(2, i);
			j=Integer.parseInt(JOptionPane.showInputDialog("Unesite broj radnika na gradilistu"));
			for(int a=0;a<j;) {
				updateradnik();
			}*/
		} catch (Exception e) {
			e.printStackTrace();
		};
		
	}
	
	public static void unos() {
		izlaz: while (true) {
			System.out.println("\n 1. Radnik \t 2. Gradiliste \t 3. Dogadaj \n4. Izlaz");
			switch (Kontrola.unosInt("Koju tablicu zelite mijenjati?")) {
			case 1:
				try {
					ispisi(" Select * from radnik");
					ps = cn.prepareStatement(
							" Insert into radnik (ime, prezime, oib, iban, nadredeni) " + " values (?,?,?,?,?) ");
					ps.setString(1, Kontrola.unosString(" Unesite ime "));
					ps.setString(2, Kontrola.unosString(" Unesite prezime "));
					ps.setString(3, Kontrola.unosOIB("Unesite oib"));
					ps.setString(4, Kontrola.unosIBAN(" Unesite IBAN"));
					ps.setInt(5, Kontrola.unosInt("Unesite ID nadredenog (default null)"));
					JOptionPane.showMessageDialog(null, " Podaci uspjesno uneseni " + ps.executeUpdate());
					ispisi(" Select * from radnik");

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 2:
				ispisi(" Select * from gradiliste");
				try {
					ps = cn.prepareStatement(" Insert into gradiliste (ime, adresa) values ('?,?)");
					ps.setString(1, Kontrola.unosString("Unesite ime gradilista"));
					ps.setString(2, Kontrola.unosString("Unesite adresu gradilista"));
					JOptionPane.showMessageDialog(null, "Podaci uspjesno uneseni" + ps.executeUpdate());
					ispisi(" Select * from gradiliste");
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				ispisi(" Select * from dogadaj ");
				try {
					ps = cn.prepareStatement(" Insert into dogadaj (vrijemepocetka, vrijemekraja, radnik, gradiliste) "
							+ " values (?,?,?,?)  ");
					ps.setDate(1, (Date) Kontrola.unosDatuma("Unesite vrijeme pocetka"));
					ps.setDate(2, (Date) Kontrola.unosDatuma("Unesite vrijeme kraja"));
					int i = Integer.parseInt("Unesite broj radnika na gradilistu");
					for (int j = 1; j < i; j++) {
						ps.setInt(3, Kontrola.unosInt(" Unesite sifru radnika"));
					}
					ps.setInt(4, Kontrola.unosInt(" Unesite sifru gradilista"));
					JOptionPane.showMessageDialog(null, "Podaci uspjesno uneseni" + ps.executeUpdate());
					ispisi(" Select * from dogadaj");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				break izlaz;
			default:
				System.out.println(" Nepostojeci broj");
				continue;
			}

		}
	}

	public static void brisanje() {
		int delete;
		izlaz: while (true) {
			System.out.println("\n 1. Radnik \t 2. Gradiliste \t 3. Dogadaj \n4. Izlaz");
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
						if (delete == 0) {
							JOptionPane.showInputDialog("Radnja izvrsena" + ps.executeUpdate());
							ispisi(" Select * from gradiliste");
							break izadi;
						}
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
			case 3:
				try {
					ispisi(" Select * from dogadaj");
					ps = cn.prepareStatement(" Delete from dogadaj where id = ? ");
					while (true) {
						ps.setInt(1, Kontrola.unosInt(" Unesite broj reda koji zelite brisati"));
						delete = JOptionPane.showConfirmDialog(null, " Da li ste sigurni?", null,
								JOptionPane.YES_NO_CANCEL_OPTION);
						if (delete == 0) {
							JOptionPane.showInputDialog(" Radnja izvrsena" + ps.executeUpdate());
							ispisi(" Select * from dogadaj");
							break izadi;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 4:
				break izlaz;
			default:
				System.out.println(" Nepostojeci broj");
				continue;
			}
			break izlaz;
		}

	}

	public static void ispisi(String query) {
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
