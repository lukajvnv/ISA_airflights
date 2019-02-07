package com.airFlights.service.avio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.airFlights.dto.ReservationDTO;
import com.airFlights.model.Reservation;
import com.airFlights.model.user.User;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Autowired
	private Environment env;
	
	@Async
	public void sendFriendFlightInvitationNotification(User inviter, Reservation reservation) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		
		
		
		String nameOfUser = reservation.getUser().getFirstName();
		String mail = reservation.getUser().getEmail();
		String arrDestinaitonName = reservation.getTicket().getFlight().getDepartureDestination().getDestinationName();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		LocalDate depDate = reservation.getTicket().getFlight().getDepartureDate();
		String formattedString = depDate.format(formatter);
		// String depDate = reservation.getTicket().getFlight().getDepartureDate().toString();
		
		String message = "Postovani " + nameOfUser + ", vas prijatelj " + inviter.getFirstName() + " " + inviter.getLastName() + " vas je pozvao na putovanje na " +
                arrDestinaitonName + formattedString; 
		
		Integer id = reservation.getReservationId();
		
		String mailMessage = generateMessage(message, id);

		mimeMessage.setContent(mailMessage, "text/html");
		helper.setTo(mail);
		helper.setSubject("Poziv prijatelja na putovanje");
		helper.setFrom(env.getProperty("spring.mail.username"));
		javaMailSender.send(mimeMessage);
		System.out.println("saljem mejl");
			
	}
	
	@Async
	public void sendFinishedReservationNotification(ReservationDTO reservation) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		
		
		String nameOfUser = reservation.getUser().getFirstName();
		String mail = reservation.getUser().getEmail();
		String arrDestinaitonName = reservation.getTicket().getFlight().getDepartureDestination().getDestinationName();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
		LocalDate depDate = reservation.getTicket().getFlight().getDepartureDate();
		String formattedString = depDate.format(formatter);
		// String depDate = reservation.getTicket().getFlight().getDepartureDate().toString();

		
		String mailMessage = "Postovani " + nameOfUser + ", uspesno ste rezervisali putovanje za "+
		                    arrDestinaitonName + formattedString + ". UZIVAJTE!" ; 
				
		mimeMessage.setContent(mailMessage, "text/html");
		helper.setTo(mail);
		helper.setSubject("Uspesna rezervacija");
		helper.setFrom(env.getProperty("spring.mail.username"));
		javaMailSender.send(mimeMessage);
		System.out.println("saljem mejl");
			
	}
	
	private String generateMessage(String message, Integer id) {
		
	
		String mailMessage = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
				"<html>\r\n" + 
				"  \r\n" + 
				"  <head>\r\n" + 
				"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
				"    <title>ISA FTN</title>\r\n" + 
				"  </head>\r\n" + 
				"  \r\n" + 
				"  <body leftmargin=\"0\" marginwidth=\"0\" topmargin=\"0\" marginheight=\"0\" offset=\"0\"\r\n" + 
				"  style=\"margin: 0pt auto; padding: 0px; background:#F4F7FA;\">\r\n" + 
				"    <table id=\"main\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"\r\n" + 
				"    bgcolor=\"#F4F7FA\">\r\n" + 
				"      <tbody>\r\n" + 
				"        <tr>\r\n" + 
				"          <td valign=\"top\">\r\n" + 
				"            <table class=\"innermain\" cellpadding=\"0\" width=\"580\" cellspacing=\"0\" border=\"0\"\r\n" + 
				"            bgcolor=\"#F4F7FA\" align=\"center\" style=\"margin:0 auto; table-layout: fixed;\">\r\n" + 
				"              <tbody>\r\n" + 
				"                <!-- START of MAIL Content -->\r\n" + 
				"                <tr>\r\n" + 
				"                  <td colspan=\"4\">\r\n" + 
				"                    <!-- Logo start here -->\r\n" + 
				"                    <table class=\"logo\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\r\n" + 
				"                      <tbody>\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td colspan=\"2\" height=\"30\"></td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td valign=\"top\" align=\"center\">\r\n" + 
				"                            <a href=\"localhost:4200/home\" style=\"display:inline-block; cursor:pointer; text-align:center;\">\r\n" + 
				"                            </a>\r\n" + 
				"                          </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td colspan=\"2\" height=\"30\"></td>\r\n" + 
				"                        </tr>\r\n" + 
				"                      </tbody>\r\n" + 
				"                    </table>\r\n" + 
				"                    <!-- Logo end here -->\r\n" + 
				"                    <!-- Main CONTENT -->\r\n" + 
				"                    <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" bgcolor=\"#ffffff\"\r\n" + 
				"                    style=\"border-radius: 4px; box-shadow: 0 2px 8px rgba(0,0,0,0.05);\">\r\n" + 
				"                      <tbody>\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td height=\"40\"></td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr style=\"font-family: -apple-system,BlinkMacSystemFont,&#39;Segoe UI&#39;,&#39;Roboto&#39;,&#39;Oxygen&#39;,&#39;Ubuntu&#39;,&#39;Cantarell&#39;,&#39;Fira Sans&#39;,&#39;Droid Sans&#39;,&#39;Helvetica Neue&#39;,sans-serif; color:#4E5C6E; font-size:14px; line-height:20px; margin-top:20px;\">\r\n" + 
				"                          <td class=\"content\" colspan=\"2\" valign=\"top\" align=\"center\" style=\"padding-left:90px; padding-right:90px;\">\r\n" + 
				"                            <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\" bgcolor=\"#ffffff\">\r\n" + 
				"                              <tbody>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td align=\"center\" valign=\"bottom\" colspan=\"2\" cellpadding=\"3\">\r\n" + 
				"                                    <img alt=\"Coinbase\" width=\"80\" src=\"https://www.coinbase.com/assets/app/icon_email-e8c6b940e8f3ec61dcd56b60c27daed1a6f8b169d73d9e79b8999ff54092a111.png\"\r\n" + 
				"                                    />\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"30\" &nbsp;=\"\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td align=\"center\"> <span style=\"color:#48545d;font-size:22px;line-height: 24px;\">\r\n" + 
				"          Imate poziv na putovanje\r\n" + 
				"        </span>\r\n" + 
				"\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"24\" &nbsp;=\"\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"1\" bgcolor=\"#DAE1E9\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"24\" &nbsp;=\"\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td align=\"center\"> <span style=\"color:#48545d;font-size:14px;line-height:24px;\">\r\n" + message + 
				"        </span>\r\n" + 
				"\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"20\" &nbsp;=\"\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td valign=\"top\" width=\"48%\" align=\"center\"> <span>\r\n" + 
				"          <a href=\"http://localhost:4200/invitation/"+id+"\""+" style=\"display:block; padding:15px 25px; background-color:#0087D1; color:#ffffff; border-radius:3px; text-decoration:none;\">Pogledaj detalje</a>\r\n" + 
				"        </span>\r\n" + 
				"\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"20\" &nbsp;=\"\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td align=\"center\">\r\n" + 
				"                                    <img src=\"https://s3.amazonaws.com/app-public/Coinbase-notification/hr.png\" width=\"54\"\r\n" + 
				"                                    height=\"2\" border=\"0\">\r\n" + 
				"                                  </td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                  <td height=\"20\" &nbsp;=\"\"></td>\r\n" + 
				"                                </tr>\r\n" + 
				"                                <tr>\r\n" + 
				"                                </tr>\r\n" + 
				"                              </tbody>\r\n" + 
				"                            </table>\r\n" + 
				"                          </td>\r\n" + 
				"                        </tr>\r\n" + 
				"                        <tr>\r\n" + 
				"                          <td height=\"60\"></td>\r\n" + 
				"                        </tr>\r\n" + 
				"                      </tbody>\r\n" + 
				"                    </table>\r\n" + 
				"                    <!-- Main CONTENT end here -->\r\n" + 
				"                  </td>\r\n" + 
				"                </tr>\r\n" + 
				"              </tbody>\r\n" + 
				"            </table>\r\n" + 
				"          </td>\r\n" + 
				"        </tr>\r\n" + 
				"      </tbody>\r\n" + 
				"    </table>\r\n" + 
				"  </body>\r\n" + 
				"\r\n" + 
				"</html>";
	
		return mailMessage;
	}
}
