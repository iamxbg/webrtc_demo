package rtc_web_java.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;


@Controller
public class StompController {

	
	@MessageMapping("/send")
	public String receptMessage(String message) {
		
		System.out.println("Message:"+message);

		
		return "OK,got it";
	}
	
}
