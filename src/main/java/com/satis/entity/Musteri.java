package com.satis.entity;

public class Musteri {
    public int siraNo;
    public String adSoyad;
    public String adres;
    public String telefon;
    public double borc;
    /**
     * Kullanıcının hesabını aktif mi pasif mi olduğunu tutar
     * true -> aktif
     * false -> pasif
     * boolean primitive bir tipi doğal değeri false yani 0 dır.
     */
    public boolean isActive ;
}
