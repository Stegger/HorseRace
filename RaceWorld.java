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
    public static final int RUNNER_PADDING = 15;
    public static final int START_BUTTON_OFFSET = 30;
    
    private int totalRunners = 6;
    private int finishedRunners = 0;
    private WinnerList winnerList;
    private StartRaceBtn startRaceBtn;
    
    /**
     * Constructor for objects of class RaceWorld.
     */
    public RaceWorld()
    {    
        super(WIDTH, HEIGHT, 1); 
        setPaintOrder(TextArea.class, Runner.class, Player.class, FinishLine.class);
        
        startRaceBtn = new StartRaceBtn();
        addObject(startRaceBtn, START_BUTTON_OFFSET, START_BUTTON_OFFSET * 3);
        AddPlayerBtn addPlayerBtn = new AddPlayerBtn();
        addObject(addPlayerBtn, START_BUTTON_OFFSET, START_BUTTON_OFFSET);
        
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
            Runner runner = new Runner("Wombat "+i, startRaceBtn);
            addObject(runner, INITIAL_RUNNER_X_OFFSET, yOffset);
            getBackground().setColor(Color.RED);
            getBackground().setFont(new Font(22));
            getBackground().drawString("#"+(totalRunners-i), INITIAL_RUNNER_X_OFFSET, yOffset);
            yOffset -= (runner.getImage().getHeight() + RUNNER_PADDING);
        }
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
     * Register a runner as having finished and returns its position.
     */
    public int runnerHasFinished(Runner runner)
    {
        finishedRunners++;
        winnerList.addRunner(runner);
        return finishedRunners;
    }
}
