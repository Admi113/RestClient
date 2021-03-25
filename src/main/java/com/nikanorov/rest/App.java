package com.nikanorov.rest;

import com.nikanorov.rest.model.Communication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.nikanorov.rest.configure.Congigg;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Congigg.class);

        Communication communication = context.getBean("communication",Communication.class);
        System.out.println(communication.showAllUser());
        System.out.println(communication.saveUser());
        System.out.println(communication.editUser());
        System.out.println(communication.deleteUser(3));
    }

}
