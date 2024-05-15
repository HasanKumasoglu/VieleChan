package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Kullanici_Bilgileri_DTO {

    private Integer id;
    private String kull_adi;
    private String e_posta;
    private String sifre;

}
