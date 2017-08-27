package eu.corstjens.example.spring.aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;


/**
 * Created by koencorstjens on 26/08/17.
 */
@Aspect
@Component
public class LoggingAspect {
    Logger logger = Logger.getLogger(getClass().getName());


    @Before(value = "execution(void eu.corstjens.example.spring.aop..*.set*(*))")
    public void setterLogger(JoinPoint joinPoint) {
        logger.info(String.format("On class: %s Setter %s is called with arguments: %s", joinPoint.getTarget(), joinPoint.getSignature().getName(), joinPoint.getArgs()[0]));
    }

    @Around("execution(String eu.corstjens.example.spring.aop.model.*.get*())")
    public Object getterLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("start getter");
        Object result = proceedingJoinPoint.proceed();
        logger.info("getter: result " + result);
        return result;
    }


}
