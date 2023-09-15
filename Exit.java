import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Exit here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Exit extends ShopButtons
{
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Exit(double scalex, double scaley)
    {
        int x = (int)scalex;
        int y = (int)scaley;
        GreenfootImage img = getImage();
        img.scale(x,y);
    }
    public void act()
    {
        checkMouse();
        // If this object is clicked, exit trash mode
        if(Greenfoot.mouseClicked(this))
        {
            Trash.inTrashMode = false;
            getWorld().removeObjects(getWorld().getObjects(Exit.class));
        }
    }
    
}
