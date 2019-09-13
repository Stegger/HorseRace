import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TextArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TextArea extends Actor
{
    public static final int TEXT_AREA_WIDTH = 125;
    public static final int TEXT_AREA_HEIGHT = 25;
    public static final int UNICODE_WIDTH = 5;
    
    private Actor anchor;
    private int yOffset;
    
    public TextArea(String text)
    {
        GreenfootImage img = new GreenfootImage(TEXT_AREA_WIDTH,TEXT_AREA_HEIGHT);
        img.setColor(Color.RED);
        int x = (TEXT_AREA_WIDTH/2) - ((text.length()*UNICODE_WIDTH)/2);
        img.drawString(text, x, TEXT_AREA_HEIGHT-UNICODE_WIDTH*2);
        setImage(img);
    }
    
    public TextArea(String text, Actor anchor, int yOffset)
    {
        this(text);
        this.anchor = anchor;
        this.yOffset = yOffset;
    }
    
    /**
     * Act - do whatever the TextArea wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(anchor != null)
        {
            setLocation(anchor.getX(), anchor.getY()-yOffset);
        }
    }    
}
