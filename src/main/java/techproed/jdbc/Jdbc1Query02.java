package techproed.jdbc;


import java.sql.*;


public class Jdbc1Query02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	
		Statement st = con.createStatement();
		/*=======================================================================
//		 ORNEK1: Bolumler tablosundaki tum kayitlari listeleyen bir sorgu yaziniz.
//		========================================================================*/ 
		
		ResultSet tablo = st.executeQuery("select * from bolumler");
		
		while (tablo.next()) {
			
			System.out.println(tablo.getInt(1)+" "+ tablo.getString("bolum_isim")+" "+tablo.getString(3));
		}
		
		/*=======================================================================
//		 ORNEK2: SATIS ve MUHASEBE bolumlerinde calisan personelin isimlerini ve 
//		 maaslarini, maas ters sirali olarak listeleyiniz
//		========================================================================*/ 
		ResultSet tablo2 = st.executeQuery("select isim, maas from personel "
				+ " where bolum_id in(10,30)"
				+ " order by maas desc");
		
		while (tablo2.next()) {
			
			System.out.println(tablo2.getString(1) +"\t"+ tablo2.getInt(2));
		}
		
		System.out.println("=====================================");
//		/*=======================================================================
//		  ORNEK3: Tüm bolumlerde calisan personelin isimlerini, bolum isimlerini 
//		  ve maaslarini, bolum ve maas sirali listeleyiniz. NOT: calisani olmasa 
//		  bile bolum ismi gosterilmelidir.
//		========================================================================*/ 
		
		ResultSet tablo3=  st.executeQuery("select b.bolum_isim, p.isim, p.maas from bolumler b left join personel p "
				  + " on p.bolum_id=b.bolum_id "
				  + " ORDER BY b.bolum_isim, p.maas");
				
				
		 while(tablo3.next()) {
					 
			System.out.println(tablo3.getString(1) + "\t" + tablo3.getString(2)+"\t"+ tablo3.getInt(3));	 
					 	 
		}
		 
		 /*=======================================================================
//		  ORNEK4: Maasi en yuksek 10 kisinin bolumunu,adini ve maasini listeyiniz
//		========================================================================*/ 
		 System.out.println("=====================================");
		 
		 ResultSet tablo4=  st.executeQuery("select b.bolum_isim, p.isim, p.maas from personel p left join bolumler b"
		 		+ " on p.bolum_id=b.bolum_id"
		 		+ " order by maas desc"
		 		+ " limit 10");
		 
		 while(tablo4.next()) {
			 System.out.println(tablo4.getString(1)+" "+tablo4.getString(2)+" "+tablo4.getInt(3));
		 }
		 con.close();
		 tablo.close();
		 tablo2.close();
		 tablo3.close();
		 tablo4.close();
				 

	}

}
