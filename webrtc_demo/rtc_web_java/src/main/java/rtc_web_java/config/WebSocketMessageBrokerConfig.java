package rtc_web_java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketTransportRegistration;

@EnableWebSocketMessageBroker
@Configuration
@ComponentScan(basePackages= {"rtc_web_java.web"})
public class WebSocketMessageBrokerConfig  extends AbstractWebSocketMessageBrokerConfigurer{



	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		// TODO Auto-generated method stub
		registry.addEndpoint("/testStomp").withSockJS();
	}
	
	

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// TODO Auto-generated method stub
		super.configureMessageBroker(registry);
		
		//URI for client to send message to server.
		registry.setApplicationDestinationPrefixes("/topic");
	
		//URI which client subscribing.
		registry.enableSimpleBroker("/subscribe");
	
	}



	@Override
	public void configureWebSocketTransport(WebSocketTransportRegistration registration) {
		// TODO Auto-generated method stub
		super.configureWebSocketTransport(registration);
	}
	
	

	
}
