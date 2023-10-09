package com.aj.mvc1.service;

import com.aj.mvc1.constant.EazySchoolConstants;
import com.aj.mvc1.controller.ContactController;
import com.aj.mvc1.model.Contact;
import com.aj.mvc1.repositry.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;

//@Slf4j
@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
public class ContactService {

    //public int counter=0;

    @Autowired
    ContactRepository contactRepository;

    public static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;

        contact.setStatus(EazySchoolConstants.OPEN);
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EazySchoolConstants.ANONYMOUS);
       int result= contactRepository.saveContactMsg(contact);
       if(result>0){
           isSaved=true;
       }
        log.info(contact.toString());

        return isSaved;
    }

//    public int getCounter() {
//        return counter;
//    }
//
//    public void setCounter(int counter) {
//        this.counter = counter;
//    }
}
