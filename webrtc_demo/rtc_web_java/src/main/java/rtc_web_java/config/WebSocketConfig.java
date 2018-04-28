package rtc_web_java.config;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	/**
	 *  handshake part  configuration of Websocket implements with sockJS 
	 */
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub

		
		registry.addHandler(new TextWebSocketHandler() {

			@Override
			public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
				// TODO Auto-generated method stub
				super.afterConnectionClosed(session, status);
				
				System.out.println("connection is closed");
			}

			@Override
			public void afterConnectionEstablished(WebSocketSession session) throws Exception {
				// TODO Auto-generated method stub
				super.afterConnectionEstablished(session);
				System.out.println("connection established");
			}

			@Override
			protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
				// TODO Auto-generated method stub
				super.handleTextMessage(session, message);
				
				System.out.println("Message:"+message+" Uri:"+session.getUri());
				
				
			}
			
		}, "/test")
		.setAllowedOrigins("http://localhost:8080/")
		.addInterceptors(new HttpSessionHandshakeInterceptor(),MyHandshakeInterceptor())
		.withSockJS()
		.setClientLibraryUrl("http://localhost:8080/rtc_web_java/js/sockjs.js")
		.setHeartbeatTime(5000);
		
		
	}
	
	@Bean
	public ServletServerContainerFactoryBean createWebSocketContainer() {
		ServletServerContainerFactoryBean fb=new ServletServerContainerFactoryBean();
			return fb;
	}
	
	@Bean 
	HandshakeInterceptor MyHandshakeInterceptor(){
		return new HandshakeInterceptor() {
			
			private Set<String> connectionMap=new HashSet<>();
			
			@Override
			public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
					Map<String, Object> attributes) throws Exception {
				// TODO Auto-generated method stub
				
				String rawIp=request.getRemoteAddress().getAddress().getHostAddress();
				
				System.out.println("Got Handshake request"+rawIp);
				
				if(connectionMap.contains(rawIp)) {
					System.out.println("Ip exists,refuse");
					return false;
				}
				
				return true;
			}
			
			@Override
			public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
					Exception exception) {
				// TODO Auto-generated method stub
				
				
			}
		};
	}
}
