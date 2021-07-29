package com.coronation.sevenupApp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coronation.sevenupApp.model.PaymentInfo;
import com.coronation.sevenupApp.model.PresentUser;
import com.coronation.sevenupApp.model.Region;
import com.coronation.sevenupApp.model.User;
import com.coronation.sevenupApp.service.ApiCallerService;
import com.coronation.sevenupApp.service.UserService;

@Controller
@RequestMapping(value="/portal", method = RequestMethod.GET)
public class SevenupPortalController {

	@Autowired
	UserService userService;
	
	@Autowired
	ApiCallerService apiCallerService;
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home() {
		return "login";
	}
	
	@PostMapping(value="/doLogin")
	public String doLogin(@RequestParam String userEmail, @RequestParam String userPassword, ModelMap model, Pageable pageable, HttpServletRequest request) {
		Boolean valid = userService.doLogin(userEmail, userPassword);
		if(valid) {
			if(PresentUser.getUser() != null) {
				request.getSession().setAttribute("region", PresentUser.getUser().getRegion().getRegionName());
				if(PresentUser.getUser().getRegion().getRegionName().equalsIgnoreCase("national")) {
			     return "portal";
				}else if(PresentUser.getUser().getRegion().getRegionName().equalsIgnoreCase("admin")){
					return "adm";
				}else {
					return "portal";
				}
			}else {
				model.addAttribute("message", "You are not  logged in");
				return "logerr";
			}
		}else {
			model.addAttribute("message", "Invalid Username or Password");
			return "logerr";
		}
	}

	/*
	 * private String loadRegional(ModelMap m, Pageable pageable, String regionCode)
	 * { Page<PaymentInfo> pages=
	 * apiCallerService.getAllPaymentsForRegion(pageable,regionCode);
	 * m.addAttribute("number", pages.getNumber()); m.addAttribute("totalPages",
	 * pages.getTotalPages()); m.addAttribute("totalElements",
	 * pages.getTotalElements()); m.addAttribute("size", pages.getSize());
	 * List<PaymentInfo> payments = pages.getContent();
	 * m.addAttribute("data",payments); return "portal"; }
	 * 
	 * private String loadPortal(ModelMap m, Pageable pageable) { Page<PaymentInfo>
	 * pages= apiCallerService.getAllPayments(pageable); m.addAttribute("number",
	 * pages.getNumber()); m.addAttribute("totalPages", pages.getTotalPages());
	 * m.addAttribute("totalElements", pages.getTotalElements());
	 * m.addAttribute("size", pages.getSize()); List<PaymentInfo> payments =
	 * pages.getContent(); m.addAttribute("data",payments); return "portal"; }
	 */
	
	@RequestMapping(value = "/confirm/{id}", method = RequestMethod.GET)
	public @ResponseBody List<PaymentInfo> confirm(@PathVariable("id") String  id) {
		apiCallerService.updateNotification(id);
		apiCallerService.updatePaymentInfo(id);
		return getPaymentDetails();
	}
	
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") String  id, ModelMap model, Pageable pageable) {
		User user = userService.findUser(id);
		userService.removeUser(user);
		return userMenu(model, pageable);
	}
	
	@RequestMapping(value = "/toUser", method = RequestMethod.GET)
	public String toUser(ModelMap model) {
		model.addAttribute("regions", apiCallerService.getAllRegions());
		return "adduser";
	}
	
	@RequestMapping(value = "/toRegion", method = RequestMethod.GET)
	public String toRegion() {
		return "addRegion";
	}
	
	@RequestMapping(value = "/toAdmin", method = RequestMethod.GET)
	public String toAdmin() {
		return "adm";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		PresentUser.setUser(null);
		request.getSession().removeAttribute("region");
		return "login";
	}
	
	@RequestMapping(value = "/userMenu", method = RequestMethod.GET)
	public String userMenu(ModelMap m, Pageable pageable) {
		Page<User> pages= userService.findAllUsers(pageable);
        m.addAttribute("number", pages.getNumber());
        m.addAttribute("totalPages", pages.getTotalPages());
        m.addAttribute("totalElements", pages.getTotalElements());
        m.addAttribute("size", pages.getSize());
        List<User> users = pages.getContent();
        m.addAttribute("data",users);
		return "user";
	}
	
	@RequestMapping(value = "/regionMenu", method = RequestMethod.GET)
	public String regionMenu(ModelMap m, Pageable pageable) {
		Page<Region> pages= apiCallerService.getAllRegionsPaginated(pageable);
        m.addAttribute("number", pages.getNumber());
        m.addAttribute("totalPages", pages.getTotalPages());
        m.addAttribute("totalElements", pages.getTotalElements());
        m.addAttribute("size", pages.getSize());
        List<Region> regions = pages.getContent();
        m.addAttribute("data",regions);
		return "region";
	}
	
	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String addUser(ModelMap m, Pageable pageable, @RequestParam String useremail, @RequestParam String password, @RequestParam String regioname) {
		User user = new User();
		user.setUserEmail(useremail);
		user.setUserPassword(password);
		user.setRegion(apiCallerService.findRegion(regioname));
		userService.addUser(user);
		return userMenu(m, pageable);
	}
	
	@RequestMapping(value = "/addRegion", method = RequestMethod.GET)
	public String addRegion(ModelMap m, Pageable pageable, @RequestParam String regioname, @RequestParam String regioncode) {
		Region region = new Region();
		region.setRegionName(regioname);
		region.setRegionCode(regioncode);
		apiCallerService.addRegion(region);
		return regionMenu(m, pageable);
	}
	
	 @RequestMapping(value="/getPaymentDetails", method = RequestMethod.GET)
	    public @ResponseBody List<PaymentInfo> getPaymentDetails() {
		 if(PresentUser.getUser().getRegion().getRegionName().equalsIgnoreCase("national")) {
	        return (List<PaymentInfo>)apiCallerService.getAllPaymentInfo();
		 }else {
			 return (List<PaymentInfo>)apiCallerService.findPaymentByRegionName(PresentUser.getUser().getRegion().getRegionName());
		 }
	    }   
	
	 
	 
}
