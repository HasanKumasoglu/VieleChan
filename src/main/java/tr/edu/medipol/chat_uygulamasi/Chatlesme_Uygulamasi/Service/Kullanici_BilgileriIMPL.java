package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Entity.Kullanici_Bilgileri;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Repository.Kullanici_BilgileriRepository;


@Service
public class Kullanici_BilgileriIMPL implements Kullanici_BilgileriService {
    @Autowired
    Kullanici_BilgileriRepository kullbilRepo;

    @Override
    public Kullanici_Bilgileri bul(String e_posta) {
        return kullbilRepo.getReferenceBye_posta(e_posta);
    }

    @Override
    public Kullanici_Bilgileri tara(String kull_adi, String sifre) {
        return kullbilRepo.findByKullAdiAndSifre(kull_adi, sifre);
    }

    @Override
    public Kullanici_Bilgileri taraChat(String kull_adi) {
        return null;
    }

    @Override
    public Kullanici_Bilgileri kaydet(Kullanici_Bilgileri KulBilgi)
    { return kullbilRepo.save(KulBilgi);}

    @Override
    public void sil(Integer id) { kullbilRepo.deleteById(id); }

}
