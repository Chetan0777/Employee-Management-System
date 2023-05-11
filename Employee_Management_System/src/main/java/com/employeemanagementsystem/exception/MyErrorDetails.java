package com.employeemanagementsystem.exception;

import java.time.LocalDateTime;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class MyErrorDetails {
	
	private String name;
	private LocalDateTime localDateTime;


}
