package com.liang.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

@Aspect
@Component
public class CalcLog {

	private static final Logger logger = LoggerFactory.getLogger(CalcLog.class);

	@Pointcut("execution(public * com.liang.aop.CalcController.*(..))")
	public void webLog(){}

	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {

		Signature signature = joinPoint.getSignature();
		System.out.println(signature.getName());
		System.out.println(signature.getDeclaringTypeName());

		Object[] objects = joinPoint.getArgs();

		Arrays.stream(objects).forEach(item -> System.out.println(item) );

		Object target = joinPoint.getTarget();

		System.out.println(target.getClass());

		Object it = joinPoint.getThis();

		System.out.println(it.getClass());

	}

	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(JoinPoint joinPoint,Object ret) throws Throwable {


	}

	@AfterThrowing(throwing="ex",pointcut = "webLog()")
	public void doAfterThrowing(JoinPoint joinPoint,Throwable ex){
		System.out.println(ex.getMessage());

	}


}
