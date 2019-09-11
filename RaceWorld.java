import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class RaceWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RaceWorld extends World
{
    public static final int WIDTH = 800;
    public static final int HEIGHT = 500;
    public static final int INITIAL_RUNNER_Y_OFFSET = 40;
    public static final int INITIAL_RUNNER_X_OFFSET = 30;
    public static final int RUNNER_PADDING = 5;
    
    private int totalRunners = 6;
    private int finishedRunners = 0;
    
    /**
     * Constructor for objects of class RaceWorld.
     * 
     */
    public RaceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        setPaintOrder(Runner.class, FinishLine.class);
        addRunnersToStart();
        drawFinishLine();     
    }
    
    public void act()
    {
        if(finishedRunners==totalRunners)
        {
            Greenfoot.setWorld(new GameOverWorld());
        }
    }
    
    private void addRunnersToStart()
    {
        int yOffset = HEIGHT - INITIAL_RUNNER_Y_OFFSET;
        for(int i = 0; i < totalRunners; i++)
        {
            Runner runner = new Runner(1);
            addObject(runner, INITIAL_RUNNER_X_OFFSET, yOffset);
            yOffset -= (runner.getImage().getHeight() + RUNNER_PADDING);
        }
    }
    
    private void drawFinishLine()
    {
        int xPosOfFinishLine = WIDTH - 75;
        int y = 0;
        for(int i = 0;y < HEIGHT; i++)
        {
            FinishLine fl = new FinishLine();
            addObject(fl, xPosOfFinishLine, y);
            y = (fl.getImage().getHeight() * i) - fl.getImage().getHeight()/2;
        }   
    }
    
    public void runnerHasFinished(Runner runner)
    {
        finishedRunners++;
    }
}
