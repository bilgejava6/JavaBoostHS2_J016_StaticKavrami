package com.muhammet;

public class Runner {
    public static void main(String[] args) {
        /**
         * Static, bir method ya da bir değişkenin sabit bir adrese sahip olması ve
         * istenilen yerden çağırımının yapılabiliyor olmasıdır.
         * static method ya da değişkenler uygulamanız ayağa kalkarken, JVM içerisindeki
         * class loader tarafından adreslenir ve uygulamanın diğer bileşenleri çalıştırılır.
         *
         * JVM - Garbage Collectors - Çöp Toplayıcıları
         * referans adresi olmayan değerleri heap ten temizlemekle görevliler.
         */
        Musteri musteri = new Musteri();
        musteri.add();
        System.out.println(musteri);
        musteri = new Musteri();
        musteri.add();
        System.out.println(musteri);


        System.out.println("eklenen müşteri...: "+ StaticValues.sayac);
    }
}