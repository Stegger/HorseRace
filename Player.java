import greenfoot.*;

/**
 * A player is an Object that can place bets on the runners.
 * 
 * @author Stegger 
 * @version 2.X
 */
public class Player extends ClickableActor
{
    private String name;
    private int cash;
    
    private TextArea textAreaCash;

    /**
     * Constructor for objects of class Player
     */
    public Player(String name)
    {
        this.name = name;
        cash = 0;
    }

    public void act()
    {
        if(isGettingClicked())
        {
            String betSizeString = Greenfoot.ask("Please enter bet size:");
            int betSize = Integer.parseInt(betSizeString); //OBS This line might throw an error that we do NOT handle!
            getWorld().addObject(new Bet(this,betSize), mouse.getX(), mouse.getY());
            setCash(getCash()-betSize);
        }
        else
        {
            moveAround();
        }
    }
    
    /**
     * Move the player around randomly in the area above the race track.
     */
    private void moveAround()
    {
        if(getY()>75)
        {
            setRotation(270);
        }
        else if(getX()<75)
        {
            setRotation(0);
        }
        else if (getX()>getWorld().getWidth()-50)
        {
            setRotation(180);
        }
        else if (isTouching(Player.class))
        {
            Actor actor = getOneIntersectingObject(Player.class);
            turnTowards(actor.getX(), actor.getY());
            turn(180);
        }
        else if(Greenfoot.getRandomNumber(100) < 3)
        {
            setRotation(Greenfoot.getRandomNumber(360));
        }
        move(1);
    }
    
    public void setCash(int cash)
    {
        this.cash = cash;
        if(textAreaCash != null)
        {
            getWorld().removeObject(textAreaCash);
        }
        textAreaCash = new TextArea(cash + "€", this, -30);
        getWorld().addObject(textAreaCash, 0, 0);
    }
    
    public int getCash()
    {
        return cash;
    }
    
}
