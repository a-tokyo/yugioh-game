package src.yugioh.board.player;

import src.yugioh.exceptions.UnexpectedFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Deck extends DeckSuperClass {

    public Deck() throws IOException, NumberFormatException, UnexpectedFormatException {
        super();
        if ((monsters == null) || (spells == null)) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    monsters = loadCardsFromFile(Deck.getMonstersPath());
                    spells = loadCardsFromFile(Deck.getSpellsPath());
                    break;
                } catch (UnexpectedFormatException e) {
                    if (trials >= 3) {
                        sc.close();
                        throw e;
                    }
                    System.out.println("Erro ao ler do arquivo "
                            + e.getSourceFile() + " Na Linha "
                            + e.getSourceLine());
                    System.out.println(e.getMessage());
                    System.out.println("Por favor insira outro caminho: ");
                    trials++;

                    if (e.getSourceFile().equalsIgnoreCase(Deck.getMonstersPath())) {
                        Deck.setMonstersPath(sc.nextLine());
                    }

                    if (e.getSourceFile().equalsIgnoreCase(Deck.getSpellsPath())) {
                        Deck.setSpellsPath(sc.nextLine());
                    }
                } catch (FileNotFoundException e) {
                    if (trials >= 3) {
                        sc.close();
                        throw e;
                    }
                    String s = (monsters == null) ? Deck.getMonstersPath() : Deck.getSpellsPath();

                    System.out.println("O arquivo \"" + s + "\" não funciona.");
                    System.out.println("Por favor insira outro caminho: ");
                    trials++;
                    String path = sc.nextLine();

                    if (monsters == null) {
                        Deck.setMonstersPath(path);
                    } else {
                        Deck.setSpellsPath(path);
                    }
                }
            }
            sc.close();
        }
        buildDeck(monsters, spells);
        shuffleDeck();
    }
}
