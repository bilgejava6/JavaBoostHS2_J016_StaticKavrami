package com.satis.controller;

import com.satis.service.MusteriService;

import java.util.Scanner;

public class MusteriController {
    private MusteriService musteriService = new MusteriService();
    int sayi = 5;
    public void basla(){
        int secim;
        do{
            secim = secimYap();
            switch (secim){
                case 1: musteriEkle(); break;
                case 2: musteriSil(); break;
                case 3: musteriListele(); break;
                case 4: musteriBul(); break;
                case 0:
                    System.out.println("ÇIKIŞ YAPILDI"); break;
                default:
                    System.out.println("Lütfen geçerli bir seçim yapınız.");
            }
        }while (secim!=0);
    }

    private void musteriEkle(){
        System.out.println("""
                ******** Müşteri Ekleme ********
                """);
        System.out.print("Müşteri adı soyadı....: ");
        String adSoyad = new Scanner(System.in).nextLine();
        System.out.print("Müşteri adresi........: ");
        String adres = new Scanner(System.in).nextLine();
        System.out.print("Müşteri telefonu......: ");
        String telefon = new Scanner(System.in).nextLine();
        System.out.print("Müşteri borcu.........: ");
        double borc = new Scanner(System.in).nextDouble();
        musteriService.musteriEkle(adSoyad,adres,telefon,borc);
    }

    private void musteriSil(){

        System.out.println("""
                ******* Müşteri Silme ********
                """);
        System.out.print("Müşteri sıra no......: ");
        int siraNo = new Scanner(System.in).nextInt();
        musteriService.musteriSil(siraNo);
    }
    private void musteriListele(){
        musteriService.musteriListeleAktif();
    }
    private void musteriBul(){
        System.out.print("Aranan Müşteri bilgisi.....: ");
        String ad = new Scanner(System.in).nextLine();
        musteriService.musteriBul(ad);
    }
    private int secimYap(){
        System.out.println("""
                ********** Müşteri Takip Sistemi **********
                *************  ANA SAYFA  *****************
                1- Müşteri Ekle
                2- Müşteri Silme
                3- Müşteri Listeleme
                4- Müşteri Arama
                0- ÇIKIŞ
                """);
        System.out.print("Lütfen seçiniz.....: ");
        int secim = new Scanner(System.in).nextInt();
        return secim;
    }
}
