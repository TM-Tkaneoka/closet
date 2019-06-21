package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Calendar;
import com.example.service.CalendarService;

@Controller
public class CalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	@GetMapping("/calendar")
	public ModelAndView showCalendarTest(ModelAndView mav) {
		List<Calendar> calendarlist = calendarService.getAllCalendar();
		
		mav.addObject("calendarlist", calendarlist);
		mav.setViewName("calendar/calendar");
		return mav;
	}
	
	@ResponseBody
	@GetMapping("/calendar/getcode")
	public ResponseEntity<List<Calendar>> json(){
 
		List<Calendar> calendarlist = null;
//		if(key.isPresent()) {
			//calendarlist = calendarService.getMonthCalendar(key.get());
			calendarlist = calendarService.getAllCalendar();
//		}
 
		return ResponseEntity.ok(calendarlist);
	}
}
