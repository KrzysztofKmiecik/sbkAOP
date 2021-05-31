package pl.kmiecik.sbkaop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Zależność umożliwia na między innymi na wykorzystanie trzech kluczowych porad, które w parametrze przyjmują ścieżkę do metody jaka ma zostać przechwycona:
 *
 * @Around – Metoda oznaczona tą adnotacją wykona się przed lub zamiast metody wskazanej w parametrze.
 * @Before – Metoda oznaczona tą adnotacją wykona się przed metodą wskazaną w parametrze.
 * @After – Metoda oznaczona tą adnotacją wykona się po metodzie wskazanej w parametrze.
 */



@Component
@Aspect
public class HelloAspect {

    @Around("@annotation(AspectHello)")
    private void sayAround(ProceedingJoinPoint jointPoint) throws Throwable {
        System.out.println("Around");
       jointPoint.proceed();
    }


    @Before("@annotation(AspectHello)")
    private void sayBefore() {
        System.out.println("before");
    }

    @After("execution(void pl.kmiecik.sbkaop.Hello.sayHello())")
    private void sayAfter() {
        System.out.println("after");
    }

}
