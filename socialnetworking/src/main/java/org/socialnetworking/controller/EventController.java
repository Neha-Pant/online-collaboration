package org.socialnetworking.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.socialnetworking.dao.IBlogDAO;
import org.socialnetworking.dao.IEventDAO;
import org.socialnetworking.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.socialnetworking.model.*;


@CrossOrigin(origins = "http://localhost:8887")
@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	IEventDAO eventDAO;

	@Autowired
	private HttpServletRequest request;

	@GetMapping("/list")
	public ResponseEntity<Event> getEvents() {
		//Response.header("Access-Control-Allow-Origin", "*").build();
		return new ResponseEntity(eventDAO.list(), HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<Event> add(@RequestBody Event event) {
		event.setMembers(10);
		event.setPostDate((Timestamp) new Date());
		event.setStartDate((Timestamp) new Date());
		event.setStartTime((Timestamp) new Date());
		if (eventDAO.addEvent(event)) {

			System.out.println(event);

			event.setResponseMessage("Your event has been successfully registered .");
			return new ResponseEntity<Event>(event, HttpStatus.OK);
		} else {
			return new ResponseEntity<Event>(event, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	public EventController() {
		System.out.println("Instantiating EventController");
	}
}