package rtc_web_java.config;


import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.concurrent.FailureCallback;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.SuccessCallback;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.sockjs.client.SockJsClient;
import org.springframework.web.socket.sockjs.client.WebSocketTransport;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class,WebConfig.class})
public class SocketJSClientTest {

	
	
	@Test
	public void testHandshake() {
		
		
		SockJsClient client=new SockJsClient(Arrays.asList(
				new WebSocketTransport(new StandardWebSocketClient()))) ;
		
		//SockJsServiceConfig config=new DefaultSockJsService
		
		ListenableFuture<WebSocketSession> future=client.doHandshake(new WebSocketHandler() {
			
			@Override
			public boolean supportsPartialMessages() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
				// TODO Auto-generated method stub
				System.out.println("message:"+message);
			}
			
			@Override
			public void afterConnectionEstablished(WebSocketSession session) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
				// TODO Auto-generated method stub
				
			}
		},"http://localhost:8080/rtc_web/test");
		
		future.addCallback(new SuccessCallback<Object>() {

			@Override
			public void onSuccess(Object result) {
				// TODO Auto-generated method stub
				System.out.println("success");
				
			}
		}, new FailureCallback() {
			
			@Override
			public void onFailure(Throwable ex) {
				// TODO Auto-generated method stub
				System.out.print("fail");
			}
		});
		
	}
	
	
	
	
	
}
