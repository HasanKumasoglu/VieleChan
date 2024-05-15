package tr.edu.medipol.chat_uygulamasi.Chatlesme_Uygulamasi.Service.SifreDogrulama;

import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class SifremiUnuttumServisi {

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    private HttpServletRequest request;

    @SneakyThrows
    public ModelAndView unutulanSifreKodu(String email) throws MessagingException {
        ModelAndView modelAndView = new ModelAndView();

        if (email != null && !email.equals("")) {
            String resetLink = "http://localhost:8080/sifreDuzenleme.html"; // Değiştirmeniz gereken yer

            HttpSession session = request.getSession();
            session.setAttribute("email", email);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("hansyedek@gmail.com");
            helper.setTo(email);
            helper.setSubject("Şifremi Unuttum");
            helper.setText("Şifre sıfırlama linki: " + resetLink);
            javaMailSender.send(message);
            System.out.println("Mesaj Geldi");

            //modelAndView.setViewName("redirect:/kurtarmaLinkiKabul.html"); // Link kabul sayfasına yönlendirme
            modelAndView.addObject("message", "E-Posta adresinize gönderildi");
        } else {
            //modelAndView.setViewName("redirect:/ErrorPage.html");
            modelAndView.addObject("errorMessage", "E-posta gereklidir!");
        }
        return modelAndView;
    }
}


/*
@Service
public class SifremiUnuttumServisi {

    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    private HttpServletRequest request;

    @SneakyThrows
    public ModelAndView unutulanSifreKodu(String email) throws MessagingException {
        ModelAndView modelAndView = new ModelAndView();

        if (email != null && !email.equals("")) {
            Random rand = new Random();
            int otpvalue = rand.nextInt(1255650);

            HttpSession session = request.getSession();
            session.setAttribute("otp", otpvalue);
            session.setAttribute("email", email);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom("hansyedek@gmail.com");
            helper.setTo(email);
            helper.setSubject("Şifremi Unuttum");
            helper.setText("Şifre sıfırlama : " + otpvalue);
            javaMailSender.send(message);
            System.out.println("Mesaj Geldi");

            modelAndView.setViewName("redirect:/kurtarmaKoduKabul.html");
            modelAndView.addObject("message", "E-Posta adresinize gönderildi");
        } else {
            modelAndView.setViewName("redirect:/ErrorPage.html");
            modelAndView.addObject("errorMessage", "E-posta gereklidir!");
        }
        return modelAndView;
    }
}
*/
