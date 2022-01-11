package techproed.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class kayit {
	static int id = 0;
	static String sql;
	static int pass;
	static String name;
	static String nName;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		menu();

	}

	private static void menu() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root",
				"1234");

		Statement st = con.createStatement();

		System.out.println(
				"=======================================\nLutfen seciminizi yapiniz\n1-Kayit\n2-id ile Listeleme\n3-Butun kayitlari listeleme\n4-id ile kayit silme\n=========================================");
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		switch (key) {
		case 1:
			kayit(st, con);
			break;
		case 2:
			idList(st, con);
			break;
		case 3:
			alleList(st, con);
			break;
		case 4:
			idDelete(st, con);
			break;
		default:
			System.out.println("Yanlis bir giris yaptiniz");
			break;
		}

	}

	private static void kayit(Statement st, Connection con)throws SQLException, ClassNotFoundException {
		PreparedStatement ps=null; // veritabanina gonderilecek bilgileri bu nesne tutacak ve gonderecek
		int i=0;
		String sorgu = "CREATE TABLE kayit" + " (id int ," + " pass int," + " name  varchar(10),"
				+ " nName varchar(10))";
		st.execute(sorgu);
		boolean dongu = true;
		while (dongu) {
			id++;
			pass(st);
			name(st);
			nNahme(st);
ps=con.prepareStatement("insert into kayit(id,pass,name,nName)values(?,?,?,?)");// kayit veritabanina veri gonderecegimi soyluyorum.
			ps.setInt(1, id); // ps nesnesine gelen id yi kayit etti.
			ps.setInt(2, pass);
			ps.setString(3, name);
			ps.setString(4, nName);
			i=ps.executeUpdate();// sorguyu calistirir ve 0 dan buyukse kayit basarili olur.
			System.out.println("Kayit basari ile yapilmistir.\ntekrar giris yapmak istiyor musunuz?E/H");
			String wahl = scan.next().toUpperCase();
			if (wahl.equals("E")) {
				dongu = true;
			} else {
				dongu = false;
				menu();
			}

		}

	}

	private static String nNahme(Statement st) throws SQLException {
	
		System.out.print("Please enter your surName: ");
		nName = scan.next();
		if (nName.matches("[a-zA-Z]+")) {
			nName = nName;
		} else {
			System.out.println("Please enter string data");
			nNahme(st);
		}
		return nName;

	}

	private static String name(Statement st) throws SQLException {

		System.out.print("Please enter your Name: ");
		name = scan.next();
		if (name.matches("[a-zA-Z]+")) {

			name = name;
		} else {
			System.out.println("Please enter string data");
			name(st);
		}
		return name;

	}

	private static int pass(Statement st) throws SQLException {
		System.out.print("please enter four digit:");
		pass = 0;

		if (scan.hasNextInt()) {
			pass = scan.nextInt();
			if (pass < 1000 || pass > 9999) {
				pass(st);
			} 
		} else if (!scan.hasNextInt()) {
			System.out.println("please enter integer nummer");
			pass(st);
		}
		return pass;

	}

	private static void idList(Statement st, Connection con) throws SQLException {
		System.out.println("Lutfen aranacak kayidin idsini giriniz:");
		int id1=scan.nextInt();
		/*ResultSet tablo2=st.executeQuery(“SELECT id FROM personel ”
		while(tablo2.next()) {
			
			tablo2.getString(id)!=id1? ("yanlış girdiniz"): devam
		}*/
		
		ResultSet veri =st.executeQuery("select * from kayit where id='" + id1+ "' ;");
		
	
		while(veri.next()) {
			
			System.out.println("Adi   : "+veri.getString(3)+"\nSoyadi: "+veri.getString(4));
			
		}
		}
	

	private static void alleList(Statement st, Connection con) throws SQLException {
		ResultSet sorgu = st.executeQuery("select * from kayit");
		System.out.println("Id      Adi       Soyadi\n========================");
		while (sorgu.next()) {
			
			System.out.println(sorgu.getInt(1)+"      "+ sorgu.getString(3)+"       "+sorgu.getString(4));
		}

	}

	private static void idDelete(Statement st, Connection con) {
		// TODO Auto-generated method stub

	}

	
}
