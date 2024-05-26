package Spring.controllers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Spring.models.User;

@Controller
@ComponentScan
public class HomeController {
	@Autowired
	private EntityManager em;

//	@RequestMapping(value="/")
//	public String get() {
//		return "Demo";
//	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
	public String getTable() {
		EntityTransaction et = em.getTransaction();
		et.begin();
		User u = new User("nithin", "9490920897");
		em.persist(u);
		et.commit();
		System.out.println(u.toString());
//		System.out.println("asjdhfiasgd")/;
		return "Display";
	}
}