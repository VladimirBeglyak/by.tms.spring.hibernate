package com.example.by_tms_spring_hibernate.controller;

import com.example.by_tms_spring_hibernate.dao.BaseDao;
import com.example.by_tms_spring_hibernate.entity.Cinema;
import com.example.by_tms_spring_hibernate.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    @Autowired
    @Qualifier("cinemaService")
    private ServiceDao<Long,Cinema> serviceDao;

    @GetMapping("/hello")
    public String showFirstMessage(){
        return "hello";
    }

    @RequestMapping("/all-cinemas")
    public String getAllCinemas(Model model){

        List<Cinema> cinemas = serviceDao.getAll();
        model.addAttribute("allCinemas",cinemas);

        return "all-cinemas";
    }

    @RequestMapping("/addNewCinema")
    public String addNewCinema(Model model){

        Cinema cinema=new Cinema();
        model.addAttribute("cinema",cinema);


        return "add-cinema";
    }

    @RequestMapping("/saveCinema")
    public String saveCinema(@ModelAttribute("cinema") Cinema cinema){

        serviceDao.save(cinema);

        return "redirect:/all-cinemas";
    }
}
