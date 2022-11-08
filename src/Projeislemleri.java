
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Projeislemleri {
private PreparedStatement preparedStatement= null;
private Statement statement=null;
Connection con =null;
public void MusteriGuncelle (int id,String yeniad,String yenisoyad,String yenitcno,String yeniadres){

    try {String sorgu="UPDATE  musteri_tanim SET madi = ?,msoyad = ?,tcno = ?, Adres = ? WHERE  mid = ?";
        preparedStatement=con.prepareStatement(sorgu);
        preparedStatement.setString(1, yeniad);
        preparedStatement.setString(2, yenisoyad);
        preparedStatement.setString(3, yenitcno);
        preparedStatement.setString(4, yeniadres);
        preparedStatement.setInt(5, id);
        preparedStatement.executeUpdate();      
        
    } catch (SQLException ex) {
        Logger.getLogger(Projeislemleri.class.getName()).log(Level.SEVERE, null, ex);
    }
}

 
public void MusteriEkle(String ad,String soyad,String tcno,String adres){
  
    try {String sorgu="INSERT INTO musteri_tanim (madi,msoyad,tcno,adres) VALUES (?,?,?,?)" ;
        preparedStatement=con.prepareStatement(sorgu);
        preparedStatement.setString(1, ad);
        preparedStatement.setString(2, soyad);
        preparedStatement.setString(3, tcno);
        preparedStatement.setString(4, adres);
        preparedStatement.executeUpdate();
        
        
        
    } catch (SQLException ex) {
        Logger.getLogger(Projeislemleri.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 public ArrayList<musteri>  MusteriGetir(){
    ArrayList<musteri> sonuc= new ArrayList<>();
    try {
        statement=con.createStatement();
        String sorgu="select * from musteri_tanim";
        ResultSet rs=statement.executeQuery(sorgu);
        while (rs.next()) { 
         int id=rs.getInt("mid");
         String ad=rs.getString("madi");
         String soyad=rs.getString("msoyad");
         String adres=rs.getString("adres");
         String tcno=rs.getString("tcno");
         sonuc.add(new musteri(id, ad, tcno, soyad, adres));
            }
        return sonuc;
        
    } catch (SQLException ex) {
        Logger.getLogger(Projeislemleri.class.getName()).log(Level.SEVERE, null, ex);
     return null;
    }
     
 }
 public boolean Girisyap(String kadi,String sifre){
     String sorgu="Select * From kullanicilar where adi = ? and parola = ?" ;
    try {
        preparedStatement=con.prepareStatement(sorgu);
        preparedStatement.setString(1, kadi);
        preparedStatement.setString(2, sifre);
        ResultSet rs=preparedStatement.executeQuery();
        return rs.next();
        
    } catch (SQLException ex) {
        Logger.getLogger(Projeislemleri.class.getName()).log(Level.SEVERE, null, ex);
         return false;
    }
 

 }
 public Projeislemleri() {
      String url="jdbc:mysql://"+database.host+":"+database.port+"/"+database.db_ismi;
    try {
       
        
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
        System.out.println("driver bulanamadı.");
    }
    
    try {
        con=DriverManager.getConnection(url,database.kullanici_adi,database.parola);
        System.out.println("bağlantı başarılı..");
    } catch (SQLException ex) {
        System.out.println("bağlantı başarısız..");
    }
        
    
     
        
           
    }
 public static void main(String[] args) {
        Projeislemleri islemler= new Projeislemleri();
        
    }
    
    
}
