package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Entity.Kullanici_Bilgileri;

public interface Kullanici_BilgileriRepository extends JpaRepository<Kullanici_Bilgileri, Integer> {

    @Query("SELECT kb FROM Kullanici_Bilgileri kb WHERE kb.kull_adi = :kull_adi AND kb.sifre = :sifre")
    Kullanici_Bilgileri findByKullAdiAndSifre(@Param("kull_adi") String kull_adi, @Param("sifre") String sifre);

    @Query("SELECT kb FROM Kullanici_Bilgileri kb WHERE kb.e_posta = :e_posta")
    Kullanici_Bilgileri getReferenceBye_posta(@Param("e_posta") String e_posta);
}
