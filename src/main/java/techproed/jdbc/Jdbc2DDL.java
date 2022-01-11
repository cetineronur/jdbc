package techproed.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc2DDL {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*
	 	A) CREATE TABLE, DROP TABLE, ALTER TABLE gibi DDL ifadeleri icin sonuc kümesi (ResultSet) 
	 	   dondurmeyen metotlar kullanilmalidir. Bunun icin JDBC'de 2 alternatif bulunmaktadir.  
	 	    1) execute() metodu 
	 	    2) excuteUpdate() metodu.  
	 	    
	 	B) - execute() metodu hertur SQL ifadesiyle kullanibilen genel bir komuttur. 
	 	   - execute(), Boolean bir deger dondurur. DDL islemlerinde false dondururken, 
	 	     DML islemlerinde true deger dondurur. 
	 	   - Ozellikle, hangi tip SQL ifadesinin kullanilmasinin gerektiginin belli olmadigi 
	 	     durumlarda tercih edilmektedir.  
	 	     
	 	C) - executeUpdate() metodu ise INSERT, Update gibi DML islemlerinde yaygin kullanilir.
	 	   - bu islemlerde islemden etkilenen satir sayisini dondurur.
	 	   - Ayrıca, DDL islemlerinde de kullanilabilir ve bu islemlerde 0 dondurur.
	 	   
		 */
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?serverTimezone=UTC", "root", "1234");
	
		Statement st = con.createStatement();
		
		/*=======================================================================
		  ORNEK1:isciler adinda bir tablo olusturunuz id int, 
		  birim VARCHAR(10), maas int
		========================================================================*/ 
//	    String sorgu = "CREATE TABLE isciler"
//			 + " (id int primary key,"
//	     + " birim VARCHAR(10),"
//	     + " maas int)";
	    
	    
	    //1.yöntem 
	    
//	    boolean s1=st.execute(sorgu);
//	   
//	    System.out.println("isciler tablosu oluşturuldu" +s1);
	    
	    // 2.yöntem
	    
//	   st.execute(sorgu);
//	   System.out.println("isciler tablosu oluşturuldu");
//	    
	    // 2.yontem 
	    
	    /*======================================================================
		  ORNEK2:isciler tablosunu siliniz 		
		========================================================================*/
	    
	  // st.execute("drop table isciler");
	  // System.out.println("isciler tablosu silindi");
	    
		/*=======================================================================
		  ORNEK3:isciler tablosuna yeni bir sutun {isim Varchar(20)} ekleyiniz.   
		========================================================================*/
//		st.execute("alter table isciler add isim varchar(20)");
//		
//		System.out.println("sutun eklendi");
//		
		/*=======================================================================
//		  ORNEK4:isciler tablosuna soyisim VARCHAR(20) ve sehir VARCHAR(10)) 
//		  adinda 2 yeni sutun ekleyiniz.  
//		========================================================================*/
//		st.execute("alter table isciler ADD (soyisim varchar(20), sehir varchar(20))");
//		System.out.println("islem tamam");
		/*=======================================================================
//		  ORNEK5:isciler tablosundaki soyisim sutunu siliniz.
//		========================================================================*/ 
//		
//		st.execute("ALTER TABLE isciler DROP COLUMN birim");
//////		
//		System.out.println("isciler tablosundan birim sutunu silindi..");
	
//		/*=======================================================================
//		  ORNEK6:isciler tablosunun adini calisanlar olarak degistiriniz.  
		//========================================================================*/
//		String alterQuery4 = "ALTER TABLE isciler RENAME TO calisanlar5";
//		st.execute(alterQuery4);
//		System.out.println("isciler tablosunun adi calisanlar olarak degismistir..");
////		
//		/*=======================================================================
//		  ORNEK7:calisanlar tablosunu siliniz.  
//		========================================================================*/
		String dropQuery2 = "DROP TABLE calisanlar5 ";
		st.execute(dropQuery2);
//
//		System.out.println("calisanlar tablosu silindi..");
//		
	
 
 
	   
	    
	}

}
