package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Controller
@RequestMapping("/")
class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String home() {
		return "home";
	}
}

@RestController
@RequestMapping("/rest")
class ResttController {

	@RequestMapping(method = RequestMethod.GET)
	public List<String> home() {
		List<String> d = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			d.add("val " + i);
		}
		return d;
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public void post(@PathVariable String name) {

		System.out.println("Got " + name);
	}

}