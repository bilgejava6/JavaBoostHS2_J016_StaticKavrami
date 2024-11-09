package com.satis.service;

import com.satis.entity.Musteri;
import com.satis.repository.VeriDeposu;

public class MusteriService {
    /**
     * musteri ekle
     * musteri listele
     * musteri sil
     * musteri bul
     */
    public void musteriEkle(String ad, String adres, String telefon, double borc){
        Musteri musteri = new Musteri();
        musteri.adres = adres;
        musteri.adSoyad = ad;
        musteri.borc = borc;
        musteri.telefon = telefon;
        musteri.siraNo = VeriDeposu.sayac+1;
        musteri.isActive = true;
        VeriDeposu.musteriListesi[VeriDeposu.sayac++] = musteri;
    }

    public void musteriSil(int siraNo){
        /**
         * list              = {1.müş, 2.müş, 3.müş, 4.müş}
         * list yeni durumu  = {1.müş, null,  3.müş, 4.müş}
         *
         */
       // VeriDeposu.musteriListesi[siraNo-1] = null; // müşteri bilgisini siliyoruz.
        /**
         * DİKKAT!!!
         * hiçbir zaman hiç bir VeriTabanından deposundan veri silinmez, sadece
         * görünmez hale getirilir.
         */
        VeriDeposu.musteriListesi[siraNo-1].isActive = false;
    }


    public void musteriListeleAktif(){
        musteriListele(true);
    }
    public void musteriListelePasif(){
       musteriListele(false);
    }

    public void musteriBul(String ad){
        for(int i=0;i<VeriDeposu.sayac;i++){
            Musteri mst = VeriDeposu.musteriListesi[i];
            if(mst.adSoyad.toLowerCase().contains(ad.toLowerCase()) && mst.isActive){
                musteriYazdir(mst);
            }
        }
    }

    private void musteriYazdir(Musteri mst){
        System.out.println("Müşteri sıra no.......: "+ mst.siraNo );
        System.out.println("Müşteri ad soyad......: "+ mst.adSoyad );
        System.out.println("Müşteri adres.........: "+ mst.adres );
        System.out.println("Müşteri telefon.......: "+ mst.telefon );
        System.out.println("Müşteri borç..........: "+ mst.borc );
    }
    /**
     * Aktif ve Pasif leri listelemek için kullanacağız
     * true gelirse aktifleri
     * false pasifleri listelesin
     * @param isActive
     */
    private void musteriListele(boolean isActive){
        System.out.println("""
                ****** Müşteri Listesi ******
                """);
        for(int i=0;i<VeriDeposu.sayac;i++){
            Musteri mst = VeriDeposu.musteriListesi[i];
            if(mst.isActive == isActive){
                musteriYazdir(mst);
            }
        }
    }

}
