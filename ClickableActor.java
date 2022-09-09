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
        //We ask greenfoot for all available mouse information:
        mouse = Greenfoot.getMouseInfo();
        if(mouse != null)
        {
            //Is the mouse hovering over this actor AND is the primary button being clicked???
            return (this == mouse.getActor() && mouse.getButton() == 1);
        }
        //If there is NO available mouse information we return false!!
        return false;
    }
    
}
