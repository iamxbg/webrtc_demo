package rtc_web_java.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class StompController {

	
	@MessageMapping("/send")
	@SendTo("/subscribe")
	public String receptMessage(String message) {
		
		System.out.println("Message:"+message);

		
		return "OK,got it";
	}
	
}
