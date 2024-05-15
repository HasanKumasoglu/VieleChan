package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Mesaj.ozelMesajServis.service;

import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Mesaj.ozelMesajServis.olusturEntity.odaOlusturEntity;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Mesaj.ozelMesajServis.olusturRepository.room_olusturRepository;

public class room_olusturIMPL implements room_olusturService{

    room_olusturRepository roomOlusturRepository;

    @Override
    public odaOlusturEntity odaOlus(odaOlusturEntity roomAdi) {
        return roomOlusturRepository.save(roomAdi);
    }
}
