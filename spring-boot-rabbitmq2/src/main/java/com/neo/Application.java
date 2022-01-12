package com.neo;

import com.neo.rabbit.fanout.FanoutSender;
import com.neo.rabbit.hello.HelloSender;
import com.neo.rabbit.many.NeoSender;
import com.neo.rabbit.many.NeoSender2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RestController
	@RequestMapping
	class testController {

		@Autowired
		private HelloSender helloSender;
		@Autowired
		private NeoSender neoSender;
		@Autowired
		private NeoSender2 neoSender2;
		@Autowired
		private FanoutSender fanoutSender;

		@GetMapping("hello")
		public String hello() {
			helloSender.send();
			return "hello";
		}

		@GetMapping("many")
		public String many() {
			this.neoSender.send(3);
			return "many";
		}

		@GetMapping("fanout")
		public String fanout() {
			this.fanoutSender.send();
			return "fanout";
		}
	}
}
