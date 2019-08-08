package com.parv.izdoo.conf;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class AspectHelper {

/*	final static Logger logger = Logger.getLogger(AspectHelper.class);

	@Pointcut(value = "execution(* com.parv.izdoo.*.*.*(..))")
	public void myPointCut() {

	}

	@Around("myPointCut()")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();

		logger.info("Method invoked: " + methodName + ", Class Name: " + className 
					+ ", arguments: " + mapper.writeValueAsString(array));
		Object object = pjp.proceed();

		logger.info("Class Name: " + className + ", method name: " + methodName 
					+ ", Response: " + mapper.writeValueAsString(object));

		return object;
	}*/

	@Before("execution(* com.parv.izdoo.*.*.*(..))")
	public void beforeMethod(JoinPoint joinpoint) {

		/*
		 * System.out.println("Acpect called before");
		 * System.out.println(joinpoint.getSignature().getName());
		 * System.out.println(Arrays.toString(joinpoint.getArgs()));
		 */
	}

	@After("execution(* com.parv.izdoo.*.*.*(..))")
	public void afterMethod(JoinPoint joinpoint) {
		System.out.println("Aspect called after");
		System.out.println(joinpoint.getSignature().getName());
	}

}
