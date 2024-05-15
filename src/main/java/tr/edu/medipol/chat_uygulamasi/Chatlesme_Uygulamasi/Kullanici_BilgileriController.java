package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.DTO.Kullanici_Bilgileri_DTO;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Entity.Kullanici_Bilgileri;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Service.Kullanici_BilgileriService;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Service.SifreDogrulama.SifremiUnuttumServisi;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/kullanici")
public class Kullanici_BilgileriController {

    @Autowired
    Kullanici_BilgileriService kullbilgiSer;

    @PostMapping("/ekle")
    public String kullEkle(@RequestBody Kullanici_Bilgileri_DTO kullaniciBilgileriDto) {

        try{

            Kullanici_Bilgileri kull =  new Kullanici_Bilgileri();
            kull.setKull_adi(kullaniciBilgileriDto.getKull_adi());
            kull.setE_posta(kullaniciBilgileriDto.getE_posta());
            kull.setSifre(kullaniciBilgileriDto.getSifre());
            Kullanici_Bilgileri kayitliKullanici =  kullbilgiSer.kaydet(kull);

        }catch (Exception e) {
            System.out.println("Hata");
        }

        return null;

    }

    @GetMapping("/bul")
    public Kullanici_Bilgileri_DTO aramak(@RequestParam String kull_adi, @RequestParam String sifre) {
        try {
            Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.tara(kull_adi,sifre);
            return new Kullanici_Bilgileri_DTO(kullaniciBilgileri.getId(),kullaniciBilgileri.getKull_adi(),kullaniciBilgileri.getE_posta(),kullaniciBilgileri.getSifre());
        } catch (Exception e) {
            System.out.println("Bir hata var");
            return null;
        }
    }

    @Autowired
    SifremiUnuttumServisi sifremiUnuttumServisi;

    @GetMapping("/sifremiUnuttum")
    public String e_postaKontrol(@RequestParam String e_posta) {

        try{
            Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.bul(e_posta);

            if (kullaniciBilgileri == null) {

                return "böyle bir e-posta yok !";

            }

            sifremiUnuttumServisi.unutulanSifreKodu(e_posta);
            return "E-posta başaralı bir şekilde gönderildi";

        }catch (Exception e){

            return "bir hata var!";

        }

    }

    @PutMapping("/sifreDuzenle/{e_posta}")
    public Kullanici_Bilgileri_DTO sifreGuncelle(@PathVariable String e_posta,
                                                 @RequestBody Kullanici_Bilgileri_DTO kullanici_bilgileri_dto) {

        try{

            Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.bul(e_posta);

            kullaniciBilgileri.setSifre(kullanici_bilgileri_dto.getSifre());

            kullbilgiSer.kaydet(kullaniciBilgileri);

            return new  Kullanici_Bilgileri_DTO(kullaniciBilgileri.getId(),kullaniciBilgileri.getKull_adi(),
                    kullaniciBilgileri.getE_posta(),kullaniciBilgileri.getSifre());

        }catch (Exception e){

            log.error("Hata var");

        }

        return null;

    }

    @GetMapping("/bulChat")
    public Kullanici_Bilgileri_DTO aramak(@RequestParam String kull_adi) {
        try {
            Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.taraChat(kull_adi);
            return new Kullanici_Bilgileri_DTO(kullaniciBilgileri.getId(),kullaniciBilgileri.getKull_adi(),kullaniciBilgileri.getE_posta(),kullaniciBilgileri.getSifre());
        } catch (Exception e) {
            System.out.println("böyle Biri Yok");
            return null;
        }
    }




    /*
    @Autowired
    private SifremiUnuttumServisi sifreservice;

    @GetMapping("/sifreunuttum")
    public ResponseEntity<String> sifremiUnuttum(@RequestParam("email") String email) {
        try {
            Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.bul(email);

            if (kullaniciBilgileri != null) {
                ModelAndView modelAndView = sifreservice.unutulanSifreKodu(email);
                return ResponseEntity.ok().body("Şifre sıfırlama kodu gönderildi.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Böyle bir e-posta bulunamadı.");
            }
        } catch (Exception e) {
            logger.error("Şifre sıfırlama sırasında bir hata oluştu: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Şifre sıfırlama sırasında bir hata oluştu.");
        }
    }
        */


    /*

    @Autowired
    private SifremiUnuttumServisi sifreservice;

    @GetMapping("/sifreunuttum")
    public ModelAndView sifremiUnuttum(@RequestParam("email") String e_posta) throws MessagingException {

        try {

            if (Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.bul(e_posta);) {

                return sifreservice.unutulanSifreKodu(e_posta);
            } else{

                return "Böyle bir e-posta";

            }



        }catch (Exception e) {

            System.out.println("Böyle bir e-posta");
                return null;
        }



    }

    */


    /*

    @GetMapping("/bul/{kull_adi}/{sifre}")
    public Kullanici_Bilgileri_DTO aramak(@PathVariable String kull_adi, @PathVariable String sifre) {
        try {

            Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.tara(kull_adi,sifre);

            return new Kullanici_Bilgileri_DTO(kullaniciBilgileri.getId(),kullaniciBilgileri.getKull_adi(),kullaniciBilgileri.getE_posta(),kullaniciBilgileri.getSifre());

        } catch (Exception e) {
            System.out.println("Bir hata var");

            return null;
        }
    }
*/


    /*
    @PostMapping("/sifreSifirlama/{e_posta}")
    public Kullanici_Bilgileri_DTO sifir(@PathVariable String e_posta, @RequestBody Kullanici_Bilgileri_DTO kullaniciBilgileriDto) {

        Kullanici_Bilgileri kullaniciBilgileri = kullbilgiSer.bul(e_posta);

        kullaniciBilgileri.setSifre(kullaniciBilgileriDto.getSifre());

        kullbilgiSer.kaydet(kullaniciBilgileri);

        return new Kullanici_Bilgileri_DTO(kullaniciBilgileri.getId(),kullaniciBilgileri.getKull_adi(),kullaniciBilgileri.getE_posta(),kullaniciBilgileri.getSifre());

    }
*/
    /*
    @Autowired
    private Kullanici_BilgileriRepository kullaniciRepository;

    public boolean epostaKontrol(String eposta) {
        Kullanici_Bilgileri kullanici = kullaniciRepository.getReferenceBye_posta(eposta);
        return kullanici != null;
    }
    */

}
