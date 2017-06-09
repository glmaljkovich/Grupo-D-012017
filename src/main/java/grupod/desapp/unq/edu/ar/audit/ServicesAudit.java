package grupod.desapp.unq.edu.ar.audit;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by gabriel on 09/06/17.
 */
@Component
@Aspect
public class ServicesAudit {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* grupod.desapp.unq.edu.ar.services.*.*(..))")
    public void logMethodCall(JoinPoint joinPoint){
        List<Object> arguments = Arrays.asList(joinPoint.getArgs());
        logger.info("Method: " + joinPoint.getSignature().toShortString() + " Arguments: " + arguments.toString());
    }
}
