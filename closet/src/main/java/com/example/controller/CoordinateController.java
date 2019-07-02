package com.example.controller;

import com.example.model.Coordinate;
import com.example.model.CoordinateForm;
import com.example.service.CoordinateService;
import com.example.service.CoordinateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/coordinate")
public class CoordinateController {

    @Autowired
    CoordinateService coordinateService;

    @GetMapping(value = {"/add"})
    public ModelAndView coordinateAdd(){
        ModelAndView mav = new ModelAndView();
        mav.addObject(new CoordinateForm());
        mav.setViewName("/coordinate/code_add");
        return mav;
    }

    @PostMapping(value = {"/add", "/edit"})
    public ModelAndView coordinateAdd(ModelAndView mav, CoordinateForm coordinateForm, @AuthenticationPrincipal UserDetails userDetails){
        //登録の処理を書く
        Integer coordinateId = coordinateService.coordinateSave(coordinateForm, userDetails);
        mav.setViewName("/coordinate/only_code_dsc/" + coordinateId);
        return mav;
    }

    @GetMapping(value = {"/edit{id}"})
    public ModelAndView coordinateEdit(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView();
        CoordinateForm form = coordinateService.coordinateUpdate(id);
        mav.addObject("form", form);
        mav.setViewName("/coordinate/code_add");
        return mav;
    }

    @GetMapping(value = {"/list"})
    public ModelAndView coordinateList(ModelAndView mav){
        mav.setViewName("/coordinate/code_list");
        return mav;
    }

    @GetMapping(value = {"/details{coordinateId}"})
    public ModelAndView coordinateDetails(@PathVariable Integer coordinateId){
        ModelAndView mav = new ModelAndView();
        Coordinate coordinate = coordinateService.coordinateDetails(coordinateId);
        mav.addObject(coordinate);
        mav.setViewName("/coordinate/only_code_dsc");
        return mav;
    }
}
