package com.anass.puissance4.test;
import com.anass.puissance4.app.classes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.org.webcompere.systemstubs.SystemStubs.tapSystemOut;

public class PrinterTest {

    @Test
    public void printShouldThrowExceptionWhenGridIsNull(){
        //given
        Printer printer = new Printer();
        //when
        Executable action = ()->{
            printer.print(null);
        };
        //then
        Assertions.assertThrows(GridNullException.class,action);
    }

    @Test
    public void printShouldNotThrowExceptionWhenGridIsNotNull(){
        //given
        Printer printer = new Printer();
        Grille grille = new Grille();
        //when
        Executable action = ()->{
            printer.print(grille);
        };
        //then
        Assertions.assertDoesNotThrow(action);
    }

    @Test
    public void printShouldFormatGridProperlyAndImportOutputWithRightParameters() throws Exception {
        //given
        Printer printer = new Printer();
        Grille grille = new Grille();
        //when
        String text = tapSystemOut(() -> {
            printer.print(grille);
        });
        //then
        assertEquals(".......\n.......\n.......\n.......\n.......\n.......\n", text);
    }

    @Test
    public void printShouldFormatGridProperlyAndImportOutputWithFirstLineFilled() throws Exception {
        //given
        Printer printer = new Printer();
        Grille grille = new Grille();
        grille.addTocken(1,new JetonJoueur("o"));
        //when
        String text = tapSystemOut(() -> {
            printer.print(grille);
        });
        //then
        assertEquals(".......\n.......\n.......\n.......\n.......\no......\n", text);
    }

}
