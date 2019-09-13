import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A class to display the order in wich the Runners crossed the road.
 * 
 * @author Stegger 
 * @version 0.4'ish...
 */
public class WinnerList extends Actor
{
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private static final int FONT_SIZE = 32;
    private static final int LINE_SIZE = 45;
    
    private GreenfootImage img;
    private int position;
    
    public WinnerList()
    {
        img = new GreenfootImage(WIDTH,HEIGHT);
        img.setColor(Color.WHITE);
        img.setFont(new Font(FONT_SIZE));
        setImage(img);
        position = 1;
    }
    
    /**
     * Add a runner to the winnerList after it has completed the race.
     */
    public void addRunner(Runner runner)
    {
        img.drawString(runner.getName(), 0, LINE_SIZE*position);
        position++;
    }
}
