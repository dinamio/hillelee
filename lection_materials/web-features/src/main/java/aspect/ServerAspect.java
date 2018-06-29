package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by eugen on 11/26/17.
 */
@Aspect
public class ServerAspect {

    @Before("execution(* dao.ServerDao.findAll(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("Runned find all servers" + joinPoint.getSignature().getName());
    }
}
