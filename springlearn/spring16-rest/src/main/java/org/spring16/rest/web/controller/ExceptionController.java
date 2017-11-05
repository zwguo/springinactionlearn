package org.spring16.rest.web.controller;

import java.net.URI;

import org.spring16.rest.model.Spitter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class ExceptionController {

	@RequestMapping("/ex/find/{id}")
	public Spitter findSpitter(@PathVariable int id) {
		if (id > 100 && id < 1000) {
			throw new SpitterNotFoundException("not found spitter");
		} else if (id >= 1000) {
			throw new SpitterFailException("not valid spitter");
		}
		return new Spitter();
	}

	@ExceptionHandler(SpitterNotFoundException.class)
	public ResponseEntity<?> spitterNotFound(SpitterNotFoundException ex) {
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(SpitterFailException.class)
	@ResponseStatus(HttpStatus.ACCEPTED)
	public String spitterFail(SpitterFailException ex) {
		return ex.getMessage();
	}

	@RequestMapping("/ex/save/{spittle}")
	public ResponseEntity<String> saveSpittle(@PathVariable String spittle, UriComponentsBuilder ucb) {
		URI location = ucb.path("/spitter").path("1").build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		return new ResponseEntity<String>("OK", headers, HttpStatus.CREATED);
	}
}

class SpitterNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpitterNotFoundException(String message) {
		super(message);
	}
}

class SpitterFailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpitterFailException(String message) {
		super(message);
	}
}
