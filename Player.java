/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name = "";
  private double points = 0;

  /* your code here - constructor(s) */
  public Player() {
    System.out.println("Enter player name:");
    Scanner sc = new Scanner(System.in);
    String newName = sc.nextLine();
    name = newName;
    System.out.println("Hello, welcome " + name);
  }
  
  public Player(String inputName) {
    name = inputName;
  }

  /* your code here - accessor(s) */ 
  public String getName() { return name; }
  public double getPoints() { return points; }

  /* your code here - mutator(s) */ 
  public void setName(String s) { name = s; }
  public void addPoints(double p) { points += p; };
}