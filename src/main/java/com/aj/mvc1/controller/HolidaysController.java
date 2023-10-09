package com.aj.mvc1.controller;

import com.aj.mvc1.model.Holiday;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HolidaysController {


    //http://localhost:8080/holidays?festival=true&federal=true (Query Param)

   /* @GetMapping(path = "/holidays")
    public String displayHolidays(Model model) {
        List<Holiday> holidays = Arrays.asList(
                new Holiday("Jan 1", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types){
            System.out.println("Types>>> "+type);
        }

        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),holidays.stream().filter(holiday -> holiday.getType().equals(type))
                    .collect(Collectors.toList()));

        }
        return "holidays.html";
    }*/



    /*@GetMapping(path = "/holidays")
    public String displayHolidays(@RequestParam(required = false) boolean festival,
                                  @RequestParam(required = false) boolean federal, Model model) {

        model.addAttribute("festival", festival);
        model.addAttribute("federal", federal);
        List<Holiday> holidays = Arrays.asList(
                new Holiday("Jan 1", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types){
            System.out.println("Types>>> "+type);
        }

        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),holidays.stream().filter(holiday -> holiday.getType().equals(type))
                    .collect(Collectors.toList()));

        }
        return "holidays.html";
    }*/


    // path variable

    /**
     *
     * @param dispaly
     * @param model
     * @return
     *
     *
     */

    @GetMapping(path = "/holidays/{display}")
    public String displayHolidays(@PathVariable(name = "display") String dispaly, Model model) {
            if(dispaly != null && dispaly.equals("all")){
                model.addAttribute("festival",true);
                model.addAttribute("federal",true);
            }else if(dispaly != null && dispaly.equals("festival")){
                model.addAttribute("festival",true);
            }else if(dispaly != null && dispaly.equals("federal")){
                model.addAttribute("federal",true);
            }

        List<Holiday> holidays = Arrays.asList(
                new Holiday("Jan 1", "New Year's Day", Holiday.Type.FESTIVAL),
                new Holiday(" Oct 31 ", "Halloween", Holiday.Type.FESTIVAL),
                new Holiday(" Nov 24 ", "Thanksgiving Day", Holiday.Type.FESTIVAL),
                new Holiday(" Dec 25 ", "Christmas", Holiday.Type.FESTIVAL),
                new Holiday(" Jan 17 ", "Martin Luther King Jr. Day", Holiday.Type.FEDERAL),
                new Holiday(" July 4 ", "Independence Day", Holiday.Type.FEDERAL),
                new Holiday(" Sep 5 ", "Labor Day", Holiday.Type.FEDERAL),
                new Holiday(" Nov 11 ", "Veterans Day", Holiday.Type.FEDERAL)
        );
        Holiday.Type[] types = Holiday.Type.values();
        for (Holiday.Type type : types){
            System.out.println("Types>>> "+type);
        }

        for (Holiday.Type type : types) {
            model.addAttribute(type.toString(),holidays.stream().filter(holiday -> holiday.getType().equals(type))
                    .collect(Collectors.toList()));

        }
        return "holidays.html";
    }
}
