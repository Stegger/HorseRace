import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bet extends ClickableActor
{
    private Player player;
    private Runner runner;
    private int betSize;
    
    /**
     * Creates a bet of a size of cash by a player, ready to be placed on a runner.
     */
    public Bet(Player player, int betSize)
    {
        this.player = player;
        this.betSize = betSize;
    }
    
    /**
     * Act - do whatever the Bet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(runner == null)
        {
            mouse = Greenfoot.getMouseInfo();
            if(mouse != null)
            {
                setLocation(mouse.getX(), mouse.getY());
            }
            if(getOneIntersectingObject(Runner.class) != null)
            {
                runner = (Runner) getOneIntersectingObject(Runner.class);
            }
        }
        else
        {
            if(runner.getPosition()>-1)//Has the runner reached the finish line?
            {
                if(runner.getPosition()==1) //We register a win! YAY!
                {
                    player.setCash(player.getCash() + betSize * runner.getOdds());
                }
                getWorld().removeObject(this); //The bet is over
            }
        }
    }    
}
