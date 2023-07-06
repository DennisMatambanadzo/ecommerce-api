package com.epoch.ecommercebackend2.service;

import com.epoch.ecommercebackend2.exception.EmailFailureException;
import com.epoch.ecommercebackend2.model.LocalUser;
import com.epoch.ecommercebackend2.model.VerificationToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
/**
 * Service for handling emails being sent.
 */
@Service
public class EmailService {

    /** The from address to use on emails. */
    @Value("${email.from}")
    private String fromMessage;

    /** The url of the front end for links. */
    @Value("${app.frontend.url}")
    private String url;

    /**The JavaMailSender instance*/
    private JavaMailSender javaMailSender;

    /**
     * Constructor for spring injection
     * @param javaMailSender
     */
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Makes a SimpleMailMessage for sending
     * @return  The SimpleMailMessage created
     */
    private SimpleMailMessage makeMailMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMessage);
        return simpleMailMessage;
    }

    /**
     * Sends a verification email to the user
     * @param verificationToken The verification token to be sent
     * @throws EmailFailureException Thrown if unable to send the email
     */

    public void sendVerificationEmail(VerificationToken verificationToken) throws EmailFailureException {
        SimpleMailMessage message = makeMailMessage();
        message.setTo(verificationToken.getUser().getEmail());
        message.setSubject("Verify your mail to activate your account,");
        message.setText("Please follow the link below to verify your email to activate your account.\n" +
                url + "/auth/verify?token=" + verificationToken.getToken());
        try{
            javaMailSender.send(message);
        }catch(MailException exception){
            throw new EmailFailureException();
        }
    }

    /**
     * Sends a password reset request email to the user.
     * @param user The user to send to.
     * @param token The token to send the user for reset.
     * @throws EmailFailureException
     */
    public void sendPasswordResetEmail(LocalUser user, String token) throws EmailFailureException{
        SimpleMailMessage message = makeMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Your password reset link.");
        message.setText("You requested a password reset on our website. Please " +
                "find the link below to be able to reset your password.\n" + url +
                "/auth/reset?token=" + token);
        try{
            javaMailSender.send(message);
        }catch (MailException exception){
            throw  new EmailFailureException();
        }
    }

}
