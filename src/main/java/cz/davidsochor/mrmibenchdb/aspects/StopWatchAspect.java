package cz.davidsochor.mrmibenchdb.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class StopWatchAspect {

    private static final Logger logger = LoggerFactory.getLogger(StopWatchAspect.class);

    @Around(value="@annotation(cz.davidsochor.mrmibenchdb.annotations.StopWatch)")
    public Object stopWatchMethod(ProceedingJoinPoint jointPoint) throws Throwable {
        Signature signature = jointPoint.getSignature();
        String methodName = signature.toShortString();

        StopWatch stopWatch = new StopWatch(StopWatchAspect.class.getName());
        stopWatch.start(methodName);

        Object retVal = jointPoint.proceed();

        stopWatch.stop();
        logger.info(stopWatch.prettyPrint());

        return retVal;
    }
}
