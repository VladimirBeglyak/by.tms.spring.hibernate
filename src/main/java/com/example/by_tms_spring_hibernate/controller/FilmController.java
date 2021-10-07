package com.example.by_tms_spring_hibernate.controller;

import com.example.by_tms_spring_hibernate.entity.Cinema;
import com.example.by_tms_spring_hibernate.entity.Film;
import com.example.by_tms_spring_hibernate.service.ServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/film")
public class FilmController {

    @Autowired
    @Qualifier("cinemaService")
    private ServiceDao<Long, Cinema> cinemaServiceDao;

    @Autowired
    @Qualifier("filmService")
    private ServiceDao<Long, Film> filmServiceDao;

    @PostMapping("/add")
    public ModelAndView addFilm(@ModelAttribute("film") Film film){
        System.out.println(film);
        filmServiceDao.save(film);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/cinema/"+film.getCinema().getId());

        return modelAndView;
    }

}
