import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Runner here.
 * 
 * @author Stegger 
 * @version 1
 */
public class Runner extends Actor
{
    public static final int RUNNER_BASE_SPEED = 1;
    public static final int BASE_SPEED_ADDITION_RANGE = 3;
    public static final int RANDOM_MOVE_FACTOR = 4;
    
    private int baseSpeed;
    private boolean hasFinished;
    private int position;
    private String name;
    
    /**
     * Construct a new runner
     */
    public Runner(String name)
    {
        this.name = name;
        hasFinished = false;
        position = -1; //Set the position to negative one
        baseSpeed = RUNNER_BASE_SPEED + Greenfoot.getRandomNumber(BASE_SPEED_ADDITION_RANGE);
    }
    
    /**
     * Act - do whatever the Runner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isAtFinishLine() && !hasFinished)
        {
            RaceWorld rw = (RaceWorld) getWorld(); //Get a reference to the RaceWorld
            rw.runnerHasFinished(this); //The runner tells the world that is has finished
            hasFinished = true; //I switch this variable to true so I only finish once
        }
        
        if(!isAtEdge()) //The runner will keep running to the end og the world
        {
            move(baseSpeed + Greenfoot.getRandomNumber(RANDOM_MOVE_FACTOR)-(RANDOM_MOVE_FACTOR/2));
        }
    }
    
    /**
     * Get name of the wombat
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Check to see if the Runner is at the finish line
     */
    public boolean isAtFinishLine()
    {
        FinishLine fl = (FinishLine) getOneIntersectingObject(FinishLine.class);
        return fl != null;
    }
    
}
