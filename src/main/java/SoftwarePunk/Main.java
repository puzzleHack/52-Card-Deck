package main.java.SoftwarePunk;

class Main {
  public static void main(String[] args) {
    CardGame game = new CardGame();
    game.shuffle();

    System.out.println("Peeking: " + game.peek());
    System.out.println("Shuffling...");
    game.shuffle();
    System.out.println("Peeking: " + game.peek());
    System.out.println("Dealing: " + game.deal());
    System.out.println("Peeking: " + game.peek());
    System.out.println("Cutting deck...");
    try {
      game.cut();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    System.out.println("Dealing: " + game.deal());
  }

}