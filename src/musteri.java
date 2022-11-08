
public class musteri {
    private int id;
    private String ad;
    private String Tcno;
    private String soyad;
    private String adres;

    public musteri(int id, String ad, String Tcno, String soyad, String adres) {
        this.id = id;
        this.ad = ad;
        this.Tcno = Tcno;
        this.soyad = soyad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getTcno() {
        return Tcno;
    }

    public void setTcno(String Tcno) {
        this.Tcno = Tcno;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    
    
    
    
}
