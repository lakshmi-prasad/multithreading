package com.manib.controller;

import javax.xml.ws.RequestWrapper;

@RestController
public class GIFController {

	@RequestMapping(value = "/gifs", method = RequestMethod.GET,headers="Accept=application/json")
	 public String [] getGIFs() {
	  String [] str = {"1", "2"};
	  return str;
	 }
	
}

