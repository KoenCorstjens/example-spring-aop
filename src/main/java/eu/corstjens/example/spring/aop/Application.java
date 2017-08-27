package eu.corstjens.example.spring.aop;

import eu.corstjens.example.spring.aop.config.ConfigurationApp;
import eu.corstjens.example.spring.aop.model.Aap;
import eu.corstjens.example.spring.aop.model.Horse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by koencorstjens on 26/08/17.
 */
public class Application {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApp.class);
        //print all beans
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName);
        }
        System.out.println();
        System.out.println();

        //run the aplication

        Aap aap = context.getBean("aap", Aap.class);
        aap.setName("appie");

        Horse horse = context.getBean("horse", Horse.class);
        horse.setName("zita");


        System.out.println(aap.getName());
        System.out.println(horse.getName());
    }

}
