package com.raulavila.spring.mvc.websockets;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Reference: http://spring.io/guides/gs/messaging-stomp-websocket/
@Controller
public class GreetingController {

	@RequestMapping("/websockets")
	public ModelAndView index() {
		return new ModelAndView("websockets");
	}

	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		Thread.sleep(3000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

}
