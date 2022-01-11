package techproed.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc1Query01 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// 1) ilgili driver i yuklemeliyiz. tv'nin fisini tak. mesela baska alet calismasin.
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		// 2) baglanti olusturmaliyiz. 
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	
		// 3) SQL komutlari icin statement nesnesi olustur. 
		Statement st = con.createStatement();
	
		// 4) SQL ifadeleri yazabilir ve calistirabiliriz.
		ResultSet veri =st.executeQuery("select * from personel where id=123456789");
	
		// 5) sonuclari aldik ve isledik.
	
		while(veri.next()) {
			System.out.println(veri.getString("isim")+" "+veri.getInt("maas")+" "+veri.getString("sehir"));
			System.out.println("Personel Adi: "+veri.getString(2)+"\nMaas        : "+veri.getInt(4));
			System.out.println(veri.getString(5));
		}
		
		
	
		// 6) olusturulan nesneleri bellekten kaldiralim
			con.close();
			st.close();
			veri.close();
	
		}

}
