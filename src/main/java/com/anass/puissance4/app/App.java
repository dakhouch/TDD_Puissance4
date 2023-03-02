package com.anass.puissance4.app;

import com.anass.puissance4.app.classes.beans.IOrdonnanceur;
import com.anass.puissance4.app.classes.beans.impl.Jeton;
import com.anass.puissance4.app.classes.config.AppConfig;
import com.anass.puissance4.app.classes.exceptions.ColumnFullException;
import com.anass.puissance4.app.classes.exceptions.InvalidColonException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;


public class App {


    public static void main(String[] args) throws InvalidColonException, ColumnFullException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        IOrdonnanceur ordonnanceur = context.getBean(IOrdonnanceur.class);
        System.out.println("Partie démarré : " + ordonnanceur.demarrerPartie());
        Scanner scanner = new Scanner(System.in);
        Jeton jeton = null;
        while(!ordonnanceur.isOver()){
            jeton = ordonnanceur.donnerLaMain();
            System.out.print("Player " + (jeton.getContent().equals("x") ? "A" : "B") + " chose a column : ");
            int column = scanner.nextInt();
            ordonnanceur.play(column, jeton);
            ordonnanceur.affiche();
        }
        System.out.println();
        ordonnanceur.result();
        System.out.println("Game over");

    }
}
