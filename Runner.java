import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Runner here.
 * 
 * @author Stegger 
 * @version 1
 */
public class Runner extends Actor
{
    public int speed;
    private boolean hasFinished;
    private int position;
    
    public Runner(int speed)
    {
        this.speed = speed;
        hasFinished = false;
        position = 0;
    }
    
    /**
     * Act - do whatever the Runner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isAtFinishLine() && !hasFinished)
        {
            RaceWorld rw = (RaceWorld) getWorld();
            rw.runnerHasFinished(this);
            hasFinished = true;
        }
        
        if(!isAtEdge())
        {
            move(speed + Greenfoot.getRandomNumber(3));
        }
    }
    
    public boolean isAtFinishLine()
    {
        FinishLine fl = (FinishLine) getOneIntersectingObject(FinishLine.class);
        return fl != null;
    }
    
}
