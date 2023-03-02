package com.anass.puissance4.test;

import com.anass.puissance4.app.classes.beans.impl.Analyser;
import com.anass.puissance4.app.classes.beans.impl.GameState;
import com.anass.puissance4.app.classes.beans.impl.Grille;
import com.anass.puissance4.app.classes.beans.impl.JetonJoueur;
import com.anass.puissance4.app.classes.exceptions.ColumnFullException;
import com.anass.puissance4.app.classes.exceptions.GridNullException;
import com.anass.puissance4.app.classes.exceptions.InvalidColonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

import static com.anass.puissance4.test.GrilleTest.fillNextLine;

public class AnalyserTest {

    @Test
    public void checkGameShouldThrowExceptionWhenGridIsNull(){
        //given
        Analyser analyser = new Analyser();
        //when
        Executable action = ()->{
            analyser.checkGame(null);
        };
        //then
        Assertions.assertThrows(GridNullException.class,action);
    }


    @Test
    public void checkGameShouldNotThrowExceptionWhenGridIsNotNull(){
        //given
        Analyser analyser = new Analyser();
        Grille grille = new Grille();
        //when
        Executable action = ()->{
            analyser.checkGame(grille);
        };
        //then
        Assertions.assertDoesNotThrow(action);
    }

    @Test
    public void checkGameShouldReturnInProgressWhenGridIsNotFullAndNot4TokensConnected(){
        //given
        Analyser analyser = new Analyser();
        Grille grille = new Grille();
        //when
        GameState state = analyser.checkGame(grille);
        //then
        Assertions.assertEquals(GameState.InProgress, state);
    }
    @Test
    public void checkGameShouldReturnDrawWhenGridIsFullAndNot4TokensConnected(){
        //given
        Analyser analyser = new Analyser();
        Grille grille = new Grille();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        //when
        GameState state = analyser.checkGame(grille);
        //then
        Assertions.assertEquals(GameState.Draw, state);
    }

    @Test
    public void checkGameShouldReturnWinnerWhenGridHave4TokensConnectedOneTheSameLine(){
        //given
        Analyser analyser = new Analyser();
        Grille grille = new Grille();
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille);
        fillNextLine(grille, Arrays.asList(
                new JetonJoueur("o"),
                new JetonJoueur("o"),
                new JetonJoueur("o"),
                new JetonJoueur("o"),
                new JetonJoueur("o"),
                new JetonJoueur("o"),
                new JetonJoueur("o")
        ));
        //when
        GameState state = analyser.checkGame(grille);
        //then
        Assertions.assertEquals(GameState.Winner, state);
    }

    @Test
    public void checkGameShouldReturnWinnerWhenGridHave4TokensConnectedOneTheSameColumn() throws InvalidColonException, ColumnFullException {
        //given
        Analyser analyser = new Analyser();
        Grille grille = new Grille();
        grille.addTocken(3, new JetonJoueur("o"));
        grille.addTocken(3, new JetonJoueur("x"));
        grille.addTocken(3, new JetonJoueur("x"));
        grille.addTocken(3, new JetonJoueur("x"));
        grille.addTocken(3, new JetonJoueur("x"));
        //when
        GameState state = analyser.checkGame(grille);
        //then
        Assertions.assertEquals(GameState.Winner, state);
    }

    @Test
    public void checkGameShouldReturnWinnerWhenGridHave4TokensConnectedOneTheSameDiagonal() throws InvalidColonException, ColumnFullException {
        //given
        Analyser analyser = new Analyser();
        Grille grille = new Grille();
        grille.addTocken(3, new JetonJoueur("o"));
        grille.addTocken(3, new JetonJoueur("x"));
        grille.addTocken(3, new JetonJoueur("x"));
        grille.addTocken(3, new JetonJoueur("x"));
        grille.addTocken(3, new JetonJoueur("x"));
        //when
        GameState state = analyser.checkGame(grille);
        //then
        Assertions.assertEquals(GameState.Winner, state);
    }

}
