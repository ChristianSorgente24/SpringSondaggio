package com.milano.sondaggio.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable{
	
	private static final long serialVersionUID = 297753010258052125L;
	
	private int code;
	private String message;
	private Object data;
	
	
	
}
