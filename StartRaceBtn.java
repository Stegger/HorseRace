import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartRaceBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartRaceBtn extends ClickableActor
{
    private boolean isRaceOn;
    
    /**
     * Constructs a button/light that signals if the race is on or not. 
     * Start state is that the race is not on.
     */
    public StartRaceBtn()
    {
        isRaceOn = false;
    }
    
    /**
     * Act - do whatever the StartRaceBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!isRaceOn && isGettingClicked())
        {
            isRaceOn = true;
            setImage("button-green.png");
        }
    }    
    
    /**
     * Checks to see if the race is on.
     */
    public boolean isRaceOn()
    {
        return isRaceOn;
    }
    
}
