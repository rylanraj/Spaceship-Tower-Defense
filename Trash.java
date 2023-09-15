import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Trash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trash extends ShopButtons
{
    /**
     * Act - do whatever the Trash wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static boolean inTrashMode = false;
    public Trash(double scalex, double scaley)
    {
        // Attributes to scale by
        int x = (int)scalex;
        int y = (int)scaley;
        GreenfootImage img = getImage();
        img.scale(x,y);
    }
    public void act()
    {
        checkMouse();
        checkTrashMode(getWorld().getWidth() * 0.875,getWorld().getHeight() * 0.95);
    }
    public void checkTrashMode(double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        // If this button object is clicked
        if(Greenfoot.mouseClicked(this))
        {
            // Player enters trashing mode where they can remove ships they no longer want
            Trash.inTrashMode = true;
            if(inTrashMode)
            {
                getWorld().setBackground("grey.jpg");
                Exit exitbutton = new Exit(getWorld().getWidth() * 0.08333333333, getWorld().getHeight() * 0.0625);
                getWorld().addObject(exitbutton, x, y); //700 570
            }
        }
        if(inTrashMode == false)
        {
            getWorld().setBackground("blackspacebg.png");
        }
    }
    
}
