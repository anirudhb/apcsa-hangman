/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1;
  private Player player2;
  private Board game;
  private boolean solved;

  /* your code here - constructor(s) */
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
    solved = false;
  } 

  /* your code here - accessor(s) */
  public Player getPlayer1() { return player1; }
  public Player getPlayer2() { return player2; }
  public Board getGame() { return game; }
  public boolean getSolved() { return solved; }
  
  /* your code here - mutator(s)  */
  public void setSolved(boolean b) { solved = b; }

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    boolean correct = true;
    while (!solved) 
    {

      /* your code here - game logic */
      if (currentPlayer == 1) {
        System.out.println(getPlayer1().getName());
      } else {
        System.out.println(getPlayer2().getName());
      }
      System.out.println("guess");
      String guess = input.nextLine().strip();
      if (guess.length() == game.getPhrase().length()) {
        for (int i = 0; i < guess.length(); i++) {
          game.guessLetter(guess.substring(i,i+1));
        }
        solved = correct = game.isSolved(guess);
      } else if (guess.length() > 0) {
        correct = game.guessLetter(guess.substring(0,1));
      }
      System.out.println(game.getSolvedPhrase());
      if (correct) {
        if (currentPlayer == 1) {
          player1.addPoints(1);
        } else {
          player2.addPoints(1);
        }
      } else {
        currentPlayer = currentPlayer == 1 ? 2 : 1;
      }
      /* your code here - determine how game ends */
      //solved = game.isSolved(game.getSolvedPhrase());
    }
    System.out.println("congrats");
    System.out.println(player1.getName() + " has " + player1.getPoints() + " points");
    System.out.println(player2.getName() + " has " + player2.getPoints() + " points");
  }
  
}