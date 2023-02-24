package com.anass.puissance4.app.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grille {

    private List<List<Jeton>> lines = new ArrayList<>(Arrays.asList(initLine(), initLine(), initLine(), initLine(), initLine(), initLine()));

    public boolean isEmpty() {
        return lines.stream().flatMap(List::stream).allMatch(item->item instanceof JetonVide);

    }

    public void addTocken(int nbrColone, Jeton jeton) throws InvalidColonException, ColumnFullException {

       if(nbrColone<1 || nbrColone>7){
           throw new InvalidColonException();
       }
        List<Jeton> nextLine = this.lines.stream()
                .filter(line -> line.get(nbrColone - 1) instanceof JetonVide).findFirst()
                .orElseThrow(ColumnFullException::new);

        nextLine.set(nbrColone-1, jeton);


    }
    public List<Jeton> getLine(int line){
        return lines.get(line);

    }

    private static ArrayList<Jeton> initLine() {
        return new ArrayList<>(Arrays.asList(new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide(), new JetonVide()));
    }

    public boolean isFull() {
         return lines.stream().flatMap(List::stream).allMatch(item->item instanceof JetonJoueur);
    }

    public List<Jeton> getColumn(int column) {
        return lines.stream().map(line -> line.get(column-1)).collect(Collectors.toList());
    }

    public List<List<Jeton>> getDiagonals() {
        return Arrays.asList(
                Arrays.asList(this.lines.get(0).get(0),this.lines.get(1).get(1),this.lines.get(2).get(2),this.lines.get(3).get(3),this.lines.get(4).get(4),this.lines.get(5).get(5)),
                Arrays.asList(this.lines.get(1).get(0),this.lines.get(2).get(1),this.lines.get(3).get(2),this.lines.get(4).get(3),this.lines.get(5).get(4))
                );
    }

    public List<List<Jeton>> getAllLines() {
        return lines;
    }

    public List<List<Jeton>> getAllColumns() {
        return IntStream.range(1,8).mapToObj(this::getColumn).collect(Collectors.toList());
    }
}

