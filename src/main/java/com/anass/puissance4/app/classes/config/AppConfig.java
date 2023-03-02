package com.anass.puissance4.app.classes.config;

import com.anass.puissance4.app.classes.beans.IOrdonnanceur;
import com.anass.puissance4.app.classes.beans.impl.Ordonnanceur;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.anass.puissance4.app.classes.beans.impl")
public class AppConfig {
//
//    @Bean
//    public IOrdonnanceur ordonnanceur(){
//        return new Ordonnanceur();
//    }


}
