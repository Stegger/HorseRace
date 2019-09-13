import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ClickableActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class ClickableActor extends Actor
{   
    protected MouseInfo mouse;
    
    /**
    * Checks to see if the user is clicking the wombat
    */
    public boolean isGettingClicked()
    {
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            return (this == mouse.getActor() && mouse.getButton() == 1);
        }
        return false;
    }
}
