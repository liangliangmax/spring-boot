package com.liang.aop;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcController {

	@RequestMapping("/add/{a}/{b}")
	public int add(@PathVariable("a") int a, @PathVariable("b") int b){

		int result = Calculator.add(a,b);

		return result;

	}
}
