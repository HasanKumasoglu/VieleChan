package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Repository.Kullanici_BilgileriRepository;

@SpringBootApplication
public class ChatlesmeUygulamasiApplication implements CommandLineRunner {
	@Autowired
	Kullanici_BilgileriRepository kullRepo;

	public static void main(String[] args) {
		SpringApplication.run(ChatlesmeUygulamasiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}

}