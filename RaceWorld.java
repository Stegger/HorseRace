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
    private WinnerList winnerList;
    
    /**
     * Constructor for objects of class RaceWorld.
     */
    public RaceWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1); 
        setPaintOrder(Runner.class, FinishLine.class);
        addRunnersToStart();
        drawFinishLine();     
        winnerList = new WinnerList();
    }
    
    public void act()
    {
        if(finishedRunners==totalRunners)
        {
            Greenfoot.setWorld(new GameOverWorld(winnerList));
        }
    }
    
    /**
     * Create Runners and add them to the world.
     */
    private void addRunnersToStart()
    {
        int yOffset = HEIGHT - INITIAL_RUNNER_Y_OFFSET;
        for(int i = 0; i < totalRunners; i++)
        {
            Runner runner = new Runner("Wombat "+i);
            addObject(runner, INITIAL_RUNNER_X_OFFSET, yOffset);
            getBackground().setColor(Color.RED);
            getBackground().setFont(new Font(22));
            getBackground().drawString("#"+(totalRunners-i), INITIAL_RUNNER_X_OFFSET, yOffset);
            drawRunnerOnScreen(runner, (totalRunners-i));
            yOffset -= (runner.getImage().getHeight() + RUNNER_PADDING);
        }
    }
    
    /**
     * Draws the Runner on the screen.
     */
    private void drawRunnerOnScreen(Runner runner, int lane)
    {
        int sizePerLane = 15;
        getBackground().setColor(Color.RED);
        getBackground().setFont(new Font(12));
        getBackground().drawString("Lane #" + lane + ": " + runner.getName(), 15, sizePerLane * lane);
    }
    
    /**
     * Draw the finish line across the screen
     */
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
    
    /**
     * Register a runner as having finished
     */
    public void runnerHasFinished(Runner runner)
    {
        finishedRunners++;
        winnerList.addRunner(runner);
    }
}
