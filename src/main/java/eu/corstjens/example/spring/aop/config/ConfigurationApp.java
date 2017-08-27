package eu.corstjens.example.spring.aop.config;

import eu.corstjens.example.spring.aop.aspects.LoggingAspect;
import eu.corstjens.example.spring.aop.model.Aap;
import eu.corstjens.example.spring.aop.model.Horse;
import org.springframework.context.annotation.*;

/**
 * Created by koencorstjens on 26/08/17.
 */

@Configuration
@Import(LoggingAspect.class)
@ComponentScan("eu.corstjens.example.aop")
@EnableAspectJAutoProxy
public class ConfigurationApp {

    @Bean
    public Aap aap() {
        return new Aap();
    }

    @Bean
    public Horse horse() {
        return new Horse();
    }

}
