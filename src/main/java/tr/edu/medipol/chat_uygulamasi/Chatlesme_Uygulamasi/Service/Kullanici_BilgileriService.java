package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Service;

import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Entity.Kullanici_Bilgileri;


public interface Kullanici_BilgileriService {

    Kullanici_Bilgileri bul(String e_posta);
    Kullanici_Bilgileri tara(String kull_adi, String sifre);

    Kullanici_Bilgileri taraChat(String kull_adi);

    Kullanici_Bilgileri kaydet(Kullanici_Bilgileri KulBilgi);
    void sil(Integer id);

}
