package devrep.project.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfUtils {
	
	
	/*Faire un pdf avec le nom et prenom*/
	public void pdfMake(String nom, String prenom) throws FileNotFoundException, DocumentException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream("Facture_"+nom+"_"+prenom+".pdf"));
		 
		document.open();
		
		/* la police des mots*/
		Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
		
		/* Contenu du pdf : ci dessous des text */
		Chunk tete = new Chunk("Hello "+nom +" "+prenom, font);
		Paragraph corps = new Paragraph("Ton inscription au conf a bien été prise en compte",font);
		Chunk pied= new Chunk("Bonne journée",font);
		 
		document.add(tete);
		document.add(corps);
		document.add(pied);
		document.close();
	}
	
	

}
