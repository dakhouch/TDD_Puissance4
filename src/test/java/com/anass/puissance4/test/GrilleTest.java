package com.anass.puissance4.test;
import com.anass.puissance4.app.classes.InvalidColonException;
import com.anass.puissance4.app.classes.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GrilleTest{
    @Test
    public  void newGrillShouldBeEmptyWhenInstancieted(){
        //given

        //when
        Grille grille=new Grille();
        //then
        Assertions.assertEquals(true,grille.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {Integer.MIN_VALUE,0,8,Integer.MAX_VALUE})
    public  void addTokenToInvalidColonShouldThrowException(int colone){
        //given
        Grille grille=new Grille();
        Jeton jeton=new JetonJoueur();
        //when
        Executable action = () -> {
            grille.addTocken(colone, jeton);
        };
        //then
        Assertions.assertThrows(InvalidColonException.class, action);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToValidColonShouldNotThrowException(int colone){
        //given
        Grille grille=new Grille();
        Jeton jeton=new JetonJoueur();
        //when
        Executable action = () -> {
            grille.addTocken(colone, jeton);
        };
        //then
        Assertions.assertDoesNotThrow(action);
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToEmptyColonShouldBeIncertedInFirstLine(int colone) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        Jeton jeton=new JetonJoueur();
        //when
            grille.addTocken(colone, jeton);
           List<Jeton> jetonLine= grille.getLine(0);
        //then
         Assertions.assertEquals(colone-1,jetonLine.indexOf(jeton));
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToColonShouldBeInsertedInSecondLineWhenFirstLineIsFull(int colone) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        IntStream.range(1,8).forEach(col-> {
            try {
                grille.addTocken(col, new JetonJoueur());
            } catch (InvalidColonException e) {
                throw new RuntimeException(e);
            } catch (ColumnFullException e) {
                throw new RuntimeException(e);
            }
        });
        Jeton jeton=new JetonJoueur();
        //when
        grille.addTocken(colone, jeton);
        //then
        List<Jeton> firstLine= grille.getLine(0);
        List<Jeton> secondLine= grille.getLine(1);
        Assertions.assertEquals(colone-1,secondLine.indexOf(jeton));
        Assertions.assertEquals(-1,firstLine.indexOf(jeton));


    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToColonShouldBeInsertedInThirdLineWhenFirstAndSecondLineAreFull(int colone) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        fillNextLine(grille);
        fillNextLine(grille);

        Jeton jeton=new JetonJoueur();
        //when
        grille.addTocken(colone, jeton);
        //then
        List<Jeton> firstLine= grille.getLine(0);
        List<Jeton> secondLine= grille.getLine(1);
        List<Jeton> thirdLine= grille.getLine(2);
        Assertions.assertEquals(colone-1,thirdLine.indexOf(jeton));
        Assertions.assertEquals(-1,firstLine.indexOf(jeton));
        Assertions.assertEquals(-1,secondLine.indexOf(jeton));


    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToColonShouldBeInsertedInFourthLineWhenPreviousLinesAreFull(int colone) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);

        Jeton jeton=new JetonJoueur();
        //when
        grille.addTocken(colone, jeton);
        //then
        List<Jeton> firstLine= grille.getLine(0);
        List<Jeton> secondLine= grille.getLine(1);
        List<Jeton> thirdLine= grille.getLine(2);
        List<Jeton> fourthLine= grille.getLine(3);
        Assertions.assertEquals(colone-1,fourthLine.indexOf(jeton));
        Assertions.assertEquals(-1,firstLine.indexOf(jeton));
        Assertions.assertEquals(-1,secondLine.indexOf(jeton));
        Assertions.assertEquals(-1,thirdLine.indexOf(jeton));

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToColonShouldBeInsertedInFifthLineWhenPreviousLinesAreFull(int colone) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);

        Jeton jeton=new JetonJoueur();
        //when
        grille.addTocken(colone, jeton);
        //then
        List<Jeton> firstLine= grille.getLine(0);
        List<Jeton> secondLine= grille.getLine(1);
        List<Jeton> thirdLine= grille.getLine(2);
        List<Jeton> fourthLine= grille.getLine(3);
        List<Jeton> fifthLine= grille.getLine(4);
        Assertions.assertEquals(colone-1,fifthLine.indexOf(jeton));
        Assertions.assertEquals(-1,firstLine.indexOf(jeton));
        Assertions.assertEquals(-1,secondLine.indexOf(jeton));
        Assertions.assertEquals(-1,thirdLine.indexOf(jeton));
        Assertions.assertEquals(-1,fourthLine.indexOf(jeton));

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToColonShouldBeInsertedInSixthLineWhenPreviousLinesAreFull(int colone) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);


        Jeton jeton=new JetonJoueur();
        //when
        grille.addTocken(colone, jeton);
        //then
        List<Jeton> firstLine= grille.getLine(0);
        List<Jeton> secondLine= grille.getLine(1);
        List<Jeton> thirdLine= grille.getLine(2);
        List<Jeton> fourthLine= grille.getLine(3);
        List<Jeton> fifthLine= grille.getLine(4);
        List<Jeton> sixthLine= grille.getLine(5);
        Assertions.assertEquals(colone-1,sixthLine.indexOf(jeton));
        Assertions.assertEquals(-1,firstLine.indexOf(jeton));
        Assertions.assertEquals(-1,secondLine.indexOf(jeton));
        Assertions.assertEquals(-1,thirdLine.indexOf(jeton));
        Assertions.assertEquals(-1,fourthLine.indexOf(jeton));
        Assertions.assertEquals(-1,fifthLine.indexOf(jeton));

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void addTokenToColonShouldThrowExceptionWhenAllLinesAreFull(int colone) throws InvalidColonException {
        //given
        Grille grille=new Grille();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);


        Jeton jeton=new JetonJoueur();
        //when
        Executable action = ()-> grille.addTocken(colone, jeton);
        //then


        Assertions.assertThrows(ColumnFullException.class,action);

    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    public  void isEmptyShouldNotReturnTrueWhenAnElmentIsPresent(int colone) throws InvalidColonException, ColumnFullException {

        //given
        Grille grille=new Grille();
        Jeton jeton=new JetonJoueur();
        //when

        grille.addTocken(3,jeton);

        //then

        Assertions.assertFalse(grille.isEmpty());

    }

    @Test
    public  void isFullShouldReturnTrueWhenAnGridIsFull() throws InvalidColonException, ColumnFullException {

        //given
        Grille grille=new Grille();
        Jeton jeton=new JetonJoueur();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);

        //when


        //then

        Assertions.assertTrue(grille.isFull());

    }

    @Test
    public  void isFullShouldNotReturnTrueWhenGridIsNotFull() throws InvalidColonException, ColumnFullException {

        //given
        Grille grille=new Grille();

        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);


        //when


        //then

        Assertions.assertFalse(grille.isFull());

    }

    @Test
    void getLineShouldReturnTheSpecificLine() throws InvalidColonException, ColumnFullException {
        //Given
        Grille grille=new Grille();
        Jeton jeton=new JetonJoueur();
        fillNextLine(grille);
        fillNextLine(grille);

        grille.addTocken(3,jeton);

        List<Jeton> line = grille.getLine(2);
        Assertions.assertTrue(line.get(0) instanceof JetonVide);
        Assertions.assertTrue(line.get(1) instanceof JetonVide);
        Assertions.assertTrue(line.get(2).equals(jeton));
        Assertions.assertTrue(line.get(3) instanceof JetonVide);
        Assertions.assertTrue(line.get(4) instanceof JetonVide);
        Assertions.assertTrue(line.get(5) instanceof JetonVide);
        Assertions.assertTrue(line.get(6) instanceof JetonVide);

    }

    @Test
    void getColumnShouldReturnTheSpecificColumn() throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        Jeton jeton1=new JetonJoueur();
        Jeton jeton2=new JetonJoueur();

        //when
        grille.addTocken(3,jeton1);
        grille.addTocken(3,jeton2);
        //then
        List<Jeton> column = grille.getColumn(3);
        Assertions.assertEquals(jeton1,column.get(0) );
        Assertions.assertEquals(jeton2,column.get(1) );
        Assertions.assertTrue(column.get(2) instanceof JetonVide);
        Assertions.assertTrue(column.get(3) instanceof JetonVide);
        Assertions.assertTrue(column.get(4) instanceof JetonVide);
        Assertions.assertTrue(column.get(5) instanceof JetonVide);


    }

    @Test
    void getDaigonalShouldReturnAllDiagonal() throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();

        IntStream.range(1,8).forEach((colum->{IntStream.range(1,7).forEach((line->{
            try {
                grille.addTocken(colum,new JetonJoueur(line+""+colum));
            } catch (InvalidColonException e) {
                throw new RuntimeException(e);
            } catch (ColumnFullException e) {
                throw new RuntimeException(e);
            }
        }));}));
        //when
        List<List<Jeton>> jetonDiagonals=grille.getDiagonals();
        List<Jeton> firstDaigonal=jetonDiagonals.get(0);
        List<Jeton> secondDaigonal=jetonDiagonals.get(1);
        //then
        List<String> expectedFirstDiagonal= Arrays.asList("11","22","33","44","55","66");
        List<String> expectedSecondDiagonal= Arrays.asList("21","32","43","54","65");

        Assertions.assertLinesMatch(expectedFirstDiagonal,firstDaigonal.stream().map(JetonJoueur.class::cast).map(JetonJoueur::getContent).collect(Collectors.toList()));
        Assertions.assertLinesMatch(expectedSecondDiagonal,secondDaigonal.stream().map(JetonJoueur.class::cast).map(JetonJoueur::getContent).collect(Collectors.toList()));


    }
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3,4,5})
    void getAllLinesShouldReturnAllGridLines(int line) throws InvalidColonException, ColumnFullException {
        //given
        Grille grille=new Grille();
        //when
        List<List<Jeton>> allLines=grille.getAllLines();

        //then
       Assertions.assertEquals(grille.getLine(line), allLines.get(line));

    }




    private static void fillNextLine(Grille grille) {
        IntStream.range(1,8).forEach(col-> {
            try {
                grille.addTocken(col, new JetonJoueur());
            } catch (InvalidColonException | ColumnFullException e) {
                throw new RuntimeException(e);
            }
        });
    }

}