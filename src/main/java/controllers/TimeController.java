package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeController {

    @GetMapping("/")
    public ModelAndView SetStartPage(){
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping ("/worldClock")
    public ModelAndView responseTime(@RequestParam(name = "city", required = false, defaultValue = "Asian/Ho_Chi_Minh")String city)
    {
        ModelAndView modelAndView = new ModelAndView();
        TimeZone local = TimeZone.getDefault();
        TimeZone locale = TimeZone.getTimeZone(city);
        Date date = new Date();
        long locale_time = date.getTime() + (locale.getRawOffset()- local.getRawOffset());
        date.setTime(locale_time);
        modelAndView.addObject("city", city);
        modelAndView.addObject("date", date);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
