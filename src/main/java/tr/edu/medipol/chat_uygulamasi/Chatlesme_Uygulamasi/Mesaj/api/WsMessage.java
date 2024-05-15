package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Mesaj.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WsMessage {
    private String Sender;
    private String message;

    @Override
    public String toString() {
        return "WsMessage{" +
                "Sender='" + Sender + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
