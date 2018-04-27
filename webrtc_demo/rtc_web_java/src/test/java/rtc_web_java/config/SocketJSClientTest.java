package rtc_web_java.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;
import org.springframework.web.socket.sockjs.transport.SockJsServiceConfig;
import org.springframework.web.socket.sockjs.transport.handler.DefaultSockJsService;
import org.springframework.web.socket.sockjs.transport.handler.SockJsWebSocketHandler;

@RunWith(SpringJUnit4ClassRunner.class)
public class SocketJSClientTest {

	
	
	@Test
	public void testHandshake() {
		
		
		SockJsClient client=new SockJsClient(Arrays.asList(
				new WebSocketTransport(new StandardWebSocketClient()))) ;
		
		SockJsServiceConfig config=new DefaultSockJsService
		
		client.doHandshake(new SockJsWebSocketHandler(serviceConfig, webSocketHandler, sockJsSession), uriTemplate, uriVars);
		
	}
	
	
	
}
