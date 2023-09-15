import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShopButtons here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShopButtons extends Actor
{
    /**
     * Act - do whatever the ShopButtons wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int MAXTRANS = 255;
    public boolean mouseOver;
    public void checkMouse()
    {
        if(Greenfoot.mouseMoved(null))
        // If the mouse is being moved over nothing
        {
            mouseOver = Greenfoot.mouseMoved(this);
            // mouseOver = Greenfoot.mouseMoved boolean, will return true if over the object
        }
        if(mouseOver)
        // If the mouse is over the object
        {
            adjTrans(MAXTRANS / 2);
            // Divide it's transparency by 2
        }
        if(mouseOver == false)
        // If the mouse isn't over the object
        {
            adjTrans(MAXTRANS);
            // Set it's transparency to max if it isn't already
        }
    }
    public void adjTrans(int adjust)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
    }
    public boolean allowedToPlace(Actor actor)
    {
        if(mouseOver)
        {
            return false;
        }
        else if(intersects(actor))
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
