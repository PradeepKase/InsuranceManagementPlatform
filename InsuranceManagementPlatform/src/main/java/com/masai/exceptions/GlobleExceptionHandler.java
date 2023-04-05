package com.masai.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import com.masai.models.InsurancePolicy;


@ControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(ClaimNotFoud.class)
	public ResponseEntity<MyerrorDetails> ClaimNotFoudHandler(ClaimNotFoud cnf, WebRequest wr){
		
		MyerrorDetails myerror=new MyerrorDetails();
		myerror.setTimestam(LocalDateTime.now());
		myerror.setMessage(cnf.getMessage());
		myerror.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyerrorDetails>(myerror, HttpStatus.BAD_REQUEST);
	
	}
	
	
	@ExceptionHandler(ClientNotFound.class)
	public ResponseEntity<MyerrorDetails> ClientNotFoundHandler(ClientNotFound cnf, WebRequest wr){
		
		MyerrorDetails myerror=new MyerrorDetails();
		myerror.setTimestam(LocalDateTime.now());
		myerror.setMessage(cnf.getMessage());
		myerror.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyerrorDetails>(myerror, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InsurancePolicyNotFound.class)
	public ResponseEntity<MyerrorDetails> InsuranceNotFoundHandler(InsurancePolicyNotFound ipnf, WebRequest wr){
		
		MyerrorDetails myerror=new MyerrorDetails();
		myerror.setTimestam(LocalDateTime.now());
		myerror.setMessage(ipnf.getMessage());
		myerror.setDetails(wr.getDescription(false));
		return new ResponseEntity<MyerrorDetails>(myerror, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyerrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyerrorDetails err=new MyerrorDetails();
		err.setTimestam(LocalDateTime.now());
		err.setDetails("validation error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyerrorDetails> myExceptionHandler(Exception e,WebRequest req) {
		MyerrorDetails err=new MyerrorDetails();
		err.setTimestam(LocalDateTime.now());
		err.setDetails(e.getMessage());
		err.setMessage(req.getDescription(false));
	return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
	}
	
}
