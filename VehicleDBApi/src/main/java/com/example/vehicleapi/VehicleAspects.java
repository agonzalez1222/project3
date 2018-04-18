package com.example.vehicleapi;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VehicleAspects
{
    @Pointcut("execution(public * com.example..*(..))")
    public void publicMethod()
    {

    }

    @Before("publicMethod()")
    public void addLog(final JoinPoint joinPoint)
    {
        System.out.println("*** Executing: " + joinPoint.getSignature());
        Object[] arguements = joinPoint.getArgs();
        for(Object argument : arguements)
        {
            System.out.println("*** " + arguements.getClass().getSimpleName() + " = " + argument);
        }
    }
}
