package src.yugioh.board.player;

import src.yugioh.cards.Card;
import src.yugioh.cards.Location;
import src.yugioh.cards.MonsterCard;
import src.yugioh.cards.spells.*;
import src.yugioh.exceptions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class DeckSuperClass {
    protected static ArrayList<Card> monsters;
    protected static ArrayList<Card> spells;
    private static String monstersPath = "Database-Monsters.csv";
    private static String spellsPath = "Database-Spells.csv";
    private final ArrayList<Card> deck;
    protected DeckSuperClass() {
        deck = new ArrayList<Card>();
    }
    protected static ArrayList<Card> getMonsters() { return monsters; }
    protected static void setMonsters(ArrayList<Card> monsters) { DeckSuperClass.monsters = monsters; }
    protected static ArrayList<Card> getSpells() { return spells; }
    protected static void setSpells(ArrayList<Card> spells) { DeckSuperClass.spells = spells; }
    protected static String getMonstersPath() {
        return monstersPath;
    }
    protected static void setMonstersPath(String monstersPath) {
        DeckSuperClass.monstersPath = monstersPath;
    }
    protected static String getSpellsPath() {
        return spellsPath;
    }
    protected static void setSpellsPath(String spellsPath) {
        DeckSuperClass.spellsPath = spellsPath;
    }
    int trials = 0;
    protected ArrayList<Card> loadCardsFromFile(String path) throws IOException, UnexpectedFormatException {
        ArrayList<Card> temp = new ArrayList<Card>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(path));
        int lineNumber = 0;
        while ((line = br.readLine()) != null) {
            lineNumber++;
            String[] cardInfo = line.split(",");

            if (cardInfo.length == 0) {
                br.close();
                throw new MissingFieldException("O número de campos na linha não correspondeu ao esperado.", path, lineNumber);
            } else {
                if (cardInfo[0].equalsIgnoreCase("Monster") && cardInfo.length != 6) {
                    br.close();
                    throw new MissingFieldException("O número de campos na linha não correspondeu ao esperado.", path, lineNumber);
                } else if (cardInfo[0].equalsIgnoreCase("Spell") && cardInfo.length != 3) {
                    br.close();
                    throw new MissingFieldException( "O número de campos na linha não correspondeu ao esperado.", path, lineNumber);
                }
            }

            for (int i = 0; i < cardInfo.length; i++) {
                if (cardInfo[i].equals("") || cardInfo[i].equals(" ")) {
                    br.close();
                    throw new EmptyFieldException("Campo vazio.", path, lineNumber, i + 1);
                }
            }

            if (cardInfo[0].equalsIgnoreCase("Monster")) {
                temp.add(new MonsterCard(cardInfo[1], cardInfo[2],
                        Integer.parseInt(cardInfo[5]), Integer.parseInt(cardInfo[3]),
                        Integer.parseInt(cardInfo[4])));
            } else {
                if (!cardInfo[0].equalsIgnoreCase("Spell")) {
                    br.close();
                    throw new UnknownCardTypeException("Tipo de carta desconhecido.", path, lineNumber, cardInfo[0]);
                }

                switch (cardInfo[1]) {
                    case "Card Destruction":
                        temp.add(new CardDestruction(cardInfo[1], cardInfo[2]));
                        break;
                    case "Change Of Heart":
                        temp.add(new ChangeOfHeart(cardInfo[1], cardInfo[2]));
                        break;
                    case "Dark Hole":
                        temp.add(new DarkHole(cardInfo[1], cardInfo[2]));
                        break;
                    case "Graceful Dice":
                        temp.add(new GracefulDice(cardInfo[1], cardInfo[2]));
                        break;
                    case "Harpie's Feather Duster":
                        temp.add(new HarpieFeatherDuster(cardInfo[1], cardInfo[2]));
                        break;
                    case "Heavy Storm":
                        temp.add(new HeavyStorm(cardInfo[1], cardInfo[2]));
                        break;
                    case "Mage Power":
                        temp.add(new MagePower(cardInfo[1], cardInfo[2]));
                        break;
                    case "Monster Reborn":
                        temp.add(new MonsterReborn(cardInfo[1], cardInfo[2]));
                        break;
                    case "Pot of Greed":
                        temp.add(new PotOfGreed(cardInfo[1], cardInfo[2]));
                        break;
                    case "Raigeki":
                        temp.add(new Raigeki(cardInfo[1], cardInfo[2]));
                        break;
                    default:
                        throw new UnknownSpellCardException("Unknown Spell card", path, lineNumber, cardInfo[1]);
                }
            }
        }
        br.close();
        return (temp);
    }

    protected void buildDeck(ArrayList<Card> Monsters, ArrayList<Card> Spells) {
        int monstersQouta = 15;
        int spellsQouta = 5;
        Random r = new Random();

        for (; monstersQouta > 0; monstersQouta--) {
            MonsterCard monster = (MonsterCard) monsters.get(r.nextInt(monsters.size()));

            MonsterCard clone = new MonsterCard(monster.getName(),
                    monster.getDescription(), monster.getLevel(),
                    monster.getAttackPoints(), monster.getDefensePoints());
            clone.setMode(monster.getMode());
            clone.setHidden(monster.isHidden());
            clone.setLocation(Location.DECK);

            deck.add(clone);
        }

        for (; spellsQouta > 0; spellsQouta--) {
            Card spell = spells.get(r.nextInt(spells.size()));
            SpellCard clone;

            if (spell instanceof CardDestruction) {
                clone = new CardDestruction(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof ChangeOfHeart) {
                clone = new ChangeOfHeart(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof DarkHole) {
                clone = new DarkHole(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof GracefulDice) {
                clone = new GracefulDice(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof HarpieFeatherDuster) {
                clone = new HarpieFeatherDuster(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof HeavyStorm) {
                clone = new HeavyStorm(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof MagePower) {
                clone = new MagePower(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof MonsterReborn) {
                clone = new MonsterReborn(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof PotOfGreed) {
                clone = new PotOfGreed(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }

            if (spell instanceof Raigeki) {
                clone = new Raigeki(spell.getName(), spell.getDescription());
                clone.setLocation(Location.DECK);

                deck.add(clone);
                continue;
            }
        }
    }

    protected void shuffleDeck() { Collections.shuffle(deck); }

    public ArrayList<Card> drawNCards(int n) {
        ArrayList<Card> cards = new ArrayList<Card>(n);

        for (int i = 0; i < n; i++) { cards.add(deck.remove(0)); }

        return (cards);
    }

    protected Card drawOneCard() { return (deck.remove(0)); }

    public ArrayList<Card> getDeck() { return deck; }
}
