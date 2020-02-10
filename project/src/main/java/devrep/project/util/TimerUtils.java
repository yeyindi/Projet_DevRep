package devrep.project.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.web.client.RestTemplate;

import devrep.project.model.User;

public class TimerUtils {
	
	private Map<Long,Timer> timerPool = new HashMap<Long,Timer>();
	private final SendMailUtils MailSender;
	
	public TimerUtils(){
		MailSender = new SendMailUtils();
    	MailSender.setInitData("devrepsar@gmail.com", "123456789@a");
	}
	
	/*Ajouter un timer pour le paiement
	 * TODO : à annuler le timer quand le paiement est effectuer avant mais je ne sais pas ou
	 * userid : id de l'user
	 * delay : le delay du paiement en milisecond , à cherche si ya pas une méthode genre Day.getMilisecond()?
	 */
	public void addTimer(long userid,long delay) {
		TimerTask task = new TimerTask() {
	        public void run() {
	            System.out.println("Paid is not done on: " + new Date() + "n" +
	              "Thread's name: " + Thread.currentThread().getName());
	            final String uri = "http://localhost:8080/api/users/"+userid;
	            
	            Map<String, String> params = new HashMap<String, String>();
	            params.put("id", ""+userid);
	             
	            RestTemplate restTemplate = new RestTemplate();
	            User u = restTemplate.getForObject(uri, User.class ,params );
	            String text = u.getfName()+" "+u.getlName()+" you do not paid in time, please retry for demand"; 
	        	MailSender.simpleMailSend("devrepsar@gmail.com", "Paid link expired", text);
	        	timerPool.remove(userid);
	        	System.out.println("Pool size "+timerPool.size());
	        }
	    };
	    Timer timer = new Timer("Timer_"+userid);
	    timerPool.put(userid, timer);
	    timer.schedule(task, delay);
	}
	
	/*Arreter le timer de paiement pour userid*/
	public void stopTimer(long userid) {
		Timer timer = timerPool.get(userid);
		timer.cancel();
		timerPool.remove(userid);
	}

	public Map<Long, Timer> getTimerPool() {
		return timerPool;
	}

}
