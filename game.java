/*This file was made by Hannah Connolly and Dallas Zinn on 2/25/20 as part of a puzzleHack club meeting
* to practice interview coding questions
*/

import java.util.ArrayList;
import java.util.Collections;

class Card {
  public int val;
  public String suite;

  Card(int val, String suite) {
    this.val = val;
    this.suite = suite;
  }

  @Override
  public String toString() {
    String cardNo = Integer.toString(val);
    if (val == 0) {
      cardNo = "A";
    } else if (val == 10) {
      cardNo = "J";
    } else if (val == 11) {
      cardNo = "Q";
    } else if (val == 12) {
      cardNo = "C";
    }

    return "card " + cardNo + "\t of suite " + suite;
  }
}

public class game {
	
  public static final int NUMBER_OF_CARDS_DEALT = 7;

  public static ArrayList<Card> deck = new ArrayList<Card>();
  
  // Players
  public static ArrayList<Card> playerOne = new ArrayList<Card>();
  public static ArrayList<Card> playerTwo = new ArrayList<Card>();
  public static ArrayList<Card> playerThree = new ArrayList<Card>();
  public static ArrayList<Card> playerFour = new ArrayList<Card>();

  public static void main(String[] args) {

    deck = buildDeck();

    shuffle();
    printDeck();
    sort();
    printDeck();
  }

  public static ArrayList<Card> buildDeck() {

    ArrayList<Card> newDeck = new ArrayList<Card>();
    for (int i = 0; i < 13; i++) {
      newDeck.add(new Card(i, "Spade"));
    }
    for (int i = 0; i < 13; i++) {
      newDeck.add(new Card(i, "Diamond"));
    }
    for (int i = 0; i < 13; i++) {
      newDeck.add(new Card(i, "Club"));
    }
    for (int i = 0; i < 13; i++) {
      newDeck.add(new Card(i, "Heart"));
    }
    return newDeck;
  }

  public static void printDeck() {
    for (Card card : deck) {
      System.out.println(card);
    }
  }

  public static void shuffle() {
    Collections.shuffle(deck);
  }

  public static void reset() {
    deck = buildDeck();
  }

  public static void sort() {

    ArrayList<Card> newDeck = new ArrayList<Card>();

    // sort cards in deck
    for (Card card : deck) {
      if (card.suite.equals("Spade")) {
        newDeck.add(card);
        // deck.remove(card);
      }
    }
    for (Card card : deck) {
      if (card.suite.equals("Diamond")) {
        newDeck.add(card);
        // deck.remove(card);
      }
    }
    for (Card card : deck) {
      if (card.suite.equals("Club")) {
        newDeck.add(card);
        // deck.remove(card);
      }
    }
    for (Card card : deck) {
      if (card.suite.equals("Heart")) {
        newDeck.add(card);
        // deck.remove(card);
      }
    }
    deck = newDeck;
  }
  
  public static Card peek() {
	  return deck.get(0);
  }
  
  public static void cut() {
	  // TODO
  }
  
  public static void deal() {
	  shuffle();
	  cut();
	  
	  ArrayList<ArrayList<Card>> players = new ArrayList<ArrayList<Card>>();
	  players.add(playerOne);
	  players.add(playerTwo);
	  players.add(playerThree);
	  players.add(playerFour);
	  
	  for(int i = 0; i < NUMBER_OF_CARD_DEALT; i++) {
		  for(ArrayList<Card> player : players) {
			  player.add(deck.remove(0));
		  }
	  }
  }
  
}
