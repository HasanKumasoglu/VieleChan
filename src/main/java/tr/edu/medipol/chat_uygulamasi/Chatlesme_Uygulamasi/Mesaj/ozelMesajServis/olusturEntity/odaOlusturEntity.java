package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Mesaj.ozelMesajServis.olusturEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class odaOlusturEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomAdi;
    private String mesaj;
    private String odaSifre;


}
