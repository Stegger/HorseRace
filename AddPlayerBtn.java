import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.*; // Old school GUI components

/**
 * Write a description of class AddPlayerBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddPlayerBtn extends ClickableActor
{    
    private static final int START_CASH_AMOUNT = 10000;
    
    /**
     * Act - do whatever the AddPlayerBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(isGettingClicked())
        {
            String name = javax.swing.JOptionPane.showInputDialog("Please enter player name:");
            if(name != null)
            {
                addNewPlayerToWorld(name);
            }
        }
    }    
    
    private void addNewPlayerToWorld(String name)
    {
        Player player = new Player(name);
        TextArea nameTxtArea = new TextArea(name, player, 30);
        getWorld().addObject(player, getX() + 65, getY()+45);
        getWorld().addObject(nameTxtArea, 0,0);
        player.setCash(START_CASH_AMOUNT);
    }
    
}
