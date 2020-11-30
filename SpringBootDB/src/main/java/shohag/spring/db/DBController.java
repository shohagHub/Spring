package shohag.spring.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/db")
public class DBController {

	@Autowired
	private UserRepository userRepository;
	//You can call this method
	//curl localhost:8080/demo/add -d name=third -d email=enam@someemailprovider.com
	@PostMapping(path = "/add")
	public @ResponseBody String addUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User>getAllUsers() {
		return userRepository.findAll();
	}
}
