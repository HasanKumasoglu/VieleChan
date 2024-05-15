package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Kullanici_Bilgileri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String kull_adi;
    private String e_posta;
    private String sifre;

}
