package main.java.SoftwarePunk;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class CardGame {
  /** List of cards represented by Integers 
   * so that the key is the order in the deck
   * and the vaule is the card id.
   */
  private ArrayList<Integer> deck;

  public CardGame() {
    this.reset();
  }

  public void shuffle() {
    ArrayList<Integer> newDeck = new ArrayList<>();
    int startSize = deck.size();
    while(!deck.isEmpty()) {
      int randomIndex = this.getRandomNumberInclusive(0, deck.size() - 1);
      newDeck.add(this.deck.remove(randomIndex));
    }
    this.deck = newDeck;
  }
  
  /**
   * cut the deck at either a given or randomly generated number
    first we cut it at a rando number then we shuffle each halves to then put it back together 
   */
  public void cut() throws Exception {
    Random rand = new Random();
    //Split the deck by a random number.
    int randomSplitIndex = getRandomNumberInclusive(0,52);
    this.cut(randomSplitIndex);

  }

  public void cut(int splitIndex) throws Exception {
    if(this.deck.size() < 2) {
      throw new Exception("Can't split a deck less than two!");
    }
    if(splitIndex < 0 || splitIndex >= this.deck.size()) {
      throw new Exception("Out of bounds of the deck!");
    }
    if(splitIndex == 0 || splitIndex == (this.deck.size() - 1)) {
      throw new Exception("Can't split at the ends!");
    }

    if(this.deck.size() == 2 && splitIndex == 0) {
      splitIndex = 1;
    }

    ArrayList<Integer> newDeck = new ArrayList<>();
    for(int x = splitIndex; x < this.deck.size(); x++) {
      newDeck.add(this.deck.get(x));
    }
    for(int x = 0; x < splitIndex; x++) {
      newDeck.add(this.deck.get(x));
    }
    this.deck = newDeck;
  }

  //Sorts the arraylist 
  public void sort(){
   // deck.sort();
  }
  
  //Rest the deck to a default state
  public void reset(){
    deck = new ArrayList<>();
    for(int i = 0; i < 52; i++) {
      deck.add(i);
    }
  }

  // Removes the top of the deck to give the player
  public String deal(){
    //removes and returns the number value from the top of the deck
    return this.getCardName(deck.remove(0));
  }
  
  //Looks at the top of the deck 
  public String peek(){
    int cardID = deck.get(0);
    return this.getCardName(cardID);
  }

  private String getSuite(Integer cardID) throws Exception {
    String[] suiteNames = {"Diamonds", "Spades", "Hearts", "Clovers"};
    int suiteID = cardID / 13;
    if(suiteID > 3 || suiteID < 0) {
      throw new Exception("What deck of cards do you use? (Invalid cardID");
    }
    return suiteNames[suiteID];
  }

  private String getCardValueName(Integer cardID) throws Exception {
    String[] cardValueNames = {
            "Ace",
            "One",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Jack",
            "Queen",
            "King"
    };

    int cardValueNameID = cardID % 13;

    if(cardValueNameID > 12 || cardValueNameID < 0) {
      throw new Exception("What deck of cards do you use? (Invalid cardID");
    }
    return cardValueNames[cardValueNameID];
  }

  private String getCardName(int cardID) {
    try {
      return this.getCardValueName(cardID) + " of " + this.getSuite(cardID);
    } catch (Exception e) {
      return "Unknown card";
    }
  }

  private int getRandomNumberInclusive(int min, int max) {

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    return ThreadLocalRandom.current().nextInt(min, max + 1);
  }

}