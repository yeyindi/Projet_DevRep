package devrep.project.controller;


import java.io.File;
import java.io.FileNotFoundException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

import devrep.project.model.User;
import devrep.project.util.PdfUtils;
import devrep.project.util.SendMailUtils;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BankController {
	
	private final SendMailUtils MailSender;
	private final PdfUtils PdfMaker;
	
	
	/* Classe pour controller le paiement */
	public BankController(){
		MailSender = new SendMailUtils();
		MailSender.setInitData("devrepsar@gmail.com", "123456789@a");
		PdfMaker = new PdfUtils();
	}
	
	/* Prend en entree un User ou un userid je sais pas lequel tu prefere
	 * j'ai fais avec User
	 * si userid alors faut faire une requete vers api/users/id pour avoir l'instance de l'user
	 * */
	@PostMapping("/api/bank")
    public void paiement(@RequestBody User user) {
		String text = user.getfName()+""+user.getlName()+" your paiement are confirmed"; 
		String text2 = user.getfName()+""+user.getlName()+" had finish his paiement";
		
		try {
			PdfMaker.pdfMake(user.getfName(), user.getlName());
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File f = new File("Facture_"+user.getfName()+"_"+user.getlName()+".pdf"); 
		try {
			MailSender.attachedSend("devrepsar@gmail.com", "paiement confirmed", text2, f.getAbsolutePath());
			MailSender.attachedSend("devrepsar@gmail.com", "paiement confirmed", text, f.getAbsolutePath());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 
    	
    }

}
