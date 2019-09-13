import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*;

/**
 * Write a description of class Runner here.
 * 
 * @author Stegger 
 * @version 1
 */
public class Runner extends ClickableActor
{
    public static final int RUNNER_BASE_SPEED = 1;
    public static final int BASE_SPEED_ADDITION_RANGE = 4;
    public static final int RANDOM_MOVE_FACTOR = 3;
    
    private int baseSpeed;
    private boolean hasFinished;
    private int position;
    private String name;
    private StartRaceBtn startRaceBtn;
    private TextArea txtArea;
    private int odds;

    /**
     * Construct a new runner
     */
    public Runner(String name, StartRaceBtn startRaceBtn)
    {
        this.name = name;
        this.startRaceBtn = startRaceBtn;
        hasFinished = false;
        position = -1; //Set the position to negative one
        odds = 2;
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
            position = rw.runnerHasFinished(this); //The runner tells the world that is has finished
            hasFinished = true; //I switch this variable to true so I only finish once
        }
        
        if(!startRaceBtn.isRaceOn() && isGettingClicked())
        {
            String name = javax.swing.JOptionPane.showInputDialog("Please enter name");
            if(name != null)
            {
                setName(name);
            }
        }
        
        if(startRaceBtn.isRaceOn() && !isAtEdge()) //The runner will keep running to the end of the world
        {
            move(baseSpeed + Greenfoot.getRandomNumber(RANDOM_MOVE_FACTOR)-(RANDOM_MOVE_FACTOR/2));
        }
    }
    
    public int getOdds()
    {
        return odds;
    }
    
    public int getPosition()
    {
        return position;
    }
    
    /**
     * Get name of the wombat
     */
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
        if(txtArea != null)
        {
            getWorld().removeObject(txtArea);
        }
        txtArea = new TextArea(name, this, 25);
        getWorld().addObject(txtArea,0,0);
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
