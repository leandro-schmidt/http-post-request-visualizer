package com.httppostrequestvisualizer.controller;

import java.util.logging.Logger;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	Logger logger = Logger.getLogger(MainController.class.getName());
	
	/**
	 * Receives a POST request and prints it's body and header
	 * @param reqBody
	 * @param headers
	 * @return body and header of the request received
	 */
	 @RequestMapping(path = "/printPostReqHeadAndBody", method=RequestMethod.POST)
	 @ResponseStatus(value = HttpStatus.OK)
	 public String testeConsumoComprovante(@RequestBody String reqBody, 
			 			 @RequestHeader HttpHeaders  headers){
		 
		 
		 Boolean isJson = false;
		 StringBuilder ret = new StringBuilder("Header info: \n");
		 /**
		  * Take all the headers
		  */
		 for (String key : headers.keySet()){
			 ret.append(key + " : " + headers.get(key) + "\n");
			 if (key.equalsIgnoreCase("Content-Type") 
					 && headers.get(key).get(0).equalsIgnoreCase("application/json")){
				 isJson = true;
			 } 
		 }
		 ret.append("\nBody info:\n");
		 ret.append(reqBody);
		 /**
		  * Formats JSON
		  */
		 String output = isJson && !reqBody.contains("\n") ? ret.toString().replaceAll(",", ",\n") : ret.toString();
		 logger.info(output);
		 return output;
	 }
	 
	 
}
