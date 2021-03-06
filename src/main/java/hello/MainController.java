package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.transaction.Transactional;
import java.util.List;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	private PromotionAppliedRepository promotionAppliedRepository;

	@Autowired
	AppiedService appiedService;
	
//	@GetMapping(path="/add") // Map ONLY GET Requests
//	public @ResponseBody String addNewUser (@RequestParam String name
//			, @RequestParam String email) {
//		// @ResponseBody means the returned String is the response, not a view name
//		// @RequestParam means it is a parameter from the GET or POST request
//
//		User n = new User();
//		n.setName(name);
//		n.setEmail(email);
//		userRepository.save(n);
//		return "Saved";
//	}

	@GetMapping(path="/insert")
	public @ResponseBody Iterable<PromotionApplied> doInsert(Long promotionId, String tmnId, String thaiId, String mobileNo) throws InterruptedException {
		// This returns a JSON or XML with the users
		System.out.println(Thread.currentThread().getId() + " Receive request ##########");
		System.out.println(Thread.currentThread().getId() + " Start insert num applied");
//		PromotionApplied data = new PromotionApplied();
//		data.setTmnId(tmnId);
//		data.setThaiId(thaiId);
//		data.setMobileNo(mobileNo);
//		promotionAppliedRepository.save(data);


		promotionAppliedRepository.initialApplied(promotionId, 0, tmnId, mobileNo, thaiId);
		System.out.println(Thread.currentThread().getId() + " Exit insert num applied");

		updateNumApplied(promotionId, tmnId, thaiId, mobileNo);

		System.out.println(Thread.currentThread().getId() + " End request ##########");

		return null;
	}

	private void updateNumApplied(Long promotionId, String tmnId, String thaiId, String mobileNo) throws InterruptedException {

		System.out.println(Thread.currentThread().getId() + " Start get num applied");
		appiedService.increaseNum(promotionId, tmnId, thaiId, mobileNo);
		System.out.println(Thread.currentThread().getId() + " Exit get num applied");

//		em.getTransaction().begin();
//		List<PromotionApplied> allByPromotionId = promotionAppliedRepository.findAllByPromotionId(1L, "tmn.2", "thai2", "mobile2");
//		em.lock(allByPromotionId, LockModeType.PESSIMISTIC_WRITE);
//		for (PromotionApplied promotionApplied : allByPromotionId) {
//			promotionApplied.setNumApplied(1);
//		}
//		em.getTransaction().commit();
//		em.close();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<PromotionApplied> getAllUsers() {
		// This returns a JSON or XML with the users
		return promotionAppliedRepository.findAll();
	}
}
