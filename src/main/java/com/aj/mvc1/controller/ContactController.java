package com.aj.mvc1.controller;

import com.aj.mvc1.model.Contact;
import com.aj.mvc1.service.ContactService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class ContactController {


    public final ContactService contactService;
   public static Logger log = LoggerFactory.getLogger(ContactController.class);
   @Autowired
    public ContactController(ContactService contactService){
        this.contactService=contactService;
    }
    @RequestMapping(path = "/contact")
    public String displayContactPage(Model model){
        System.out.println("Contact Page....");
        model.addAttribute("contact", new Contact());
        return "contact.html";
    }

   /* @RequestMapping(path="/saveMsg", method = RequestMethod.POST)
    public ModelAndView saveMessage(@RequestParam(name = "name") String name,
                                    @RequestParam(value = "mobileNum") String mobile, @RequestParam String email,
                                    @RequestParam String subject, @RequestParam String message){

        log.info("Name: "+name);
        log.info("Mobile: "+mobile);
        log.info("Email: "+email);
        log.info("Subject: "+subject);
        log.info("Message: "+message);

        return new ModelAndView("redirect:/contact");
    }*/

   /* @RequestMapping(path="/saveMsg", method = RequestMethod.POST)
    public ModelAndView saveMessage(Contact contact){
            contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }*/

    @RequestMapping(path="/saveMsg", method = RequestMethod.POST)
    public String saveMessage(@Valid @ModelAttribute(name = "contact") Contact contact, Errors errors){
        if (errors.hasErrors()){
            log.info("\nContact form validation failed due to: "+errors.toString());
            return "contact.html";
        }
        contactService.saveMessageDetails(contact);
        //contactService.setCounter(contactService.getCounter()+1);

        //log.info(">>>>>Number of times the contact form if submitted: "+contactService.getCounter());
        return "redirect:/contact";
    }

    @RequestMapping(path = "/displayMessages", method = RequestMethod.GET)
    public ModelAndView displayMessages(Model model) {
        List<Contact> contactMsgs = contactService.findMsgsWithOpenStatus();
        ModelAndView modelAndView = new ModelAndView("message.html");
        modelAndView.addObject("contactMsgs",contactMsgs);
        return modelAndView;
    }

    @RequestMapping(value = "/closeMsg",method = RequestMethod.GET)
    public String closeMsg(@RequestParam int id, Authentication authentication) {
        contactService.updateMsgStatus(id,authentication.getName());
        return "redirect:/displayMessages";
    }
}
