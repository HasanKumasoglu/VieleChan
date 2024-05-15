package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Mesaj.ozelMesajServis.olusturDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class odaOlusturDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomId;
    private String roomAdi;
    private String mesaj;
    private String odaSifre;

}
