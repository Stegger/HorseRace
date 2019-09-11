/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player  
{
    // instance variables - replace the example below with your own
    private int cash;

    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        cash = 0;
    }

    public void addWinning(int amount)
    {
        cash = cash + amount;
    }
    
    
}
