package com.example.by_tms_spring_hibernate.controller;

import com.example.by_tms_spring_hibernate.entity.Cinema;
import com.example.by_tms_spring_hibernate.entity.Film;
import com.example.by_tms_spring_hibernate.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CinemaController {

    @Autowired
    @Qualifier("cinemaService")
    private ServiceDao<Long, Cinema> cinemaServiceDao;




    @GetMapping()
    public String AllCinemas(Model model) {

        List<Cinema> cinemas = cinemaServiceDao.getAll();
        model.addAttribute("allCinemas", cinemas);

        return "all-cinemas";
    }

//    @GetMapping("/film/{id}")
//    public String film(@PathVariable("id") long id,Model model){
//        Cinema cinema = serviceDao.getById(id);
//        model.addAttribute("cinema",cinema);
//        return "cinema";
//    }



    @GetMapping("/cinema/{id}")
    public ModelAndView film(@PathVariable("id") long id){

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("cinema");
        Cinema cinema = cinemaServiceDao.getById(id);
        modelAndView.addObject(cinema);

        return modelAndView;
    }











//    @GetMapping ("/map")
//    public String addNewCinema(ModelMap model) {
//
//        Map<String,String> map=new
//
//        Cinema cinema = new Cinema();
//        model.addAttribute("cinema", cinema);
//
//
//        return "add-cinema";
//    }
//
//    @PostMapping("/cinema")
//    public String saveCinema(@ModelAttribute("cinema") Cinema cinema) {
//
//        serviceDao.save(cinema);
//
//        return "redirect:/all-cinemas";
//    }
}
