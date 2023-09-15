import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buyship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buyship extends ShopButtons
{
    /**
     * Act - do whatever the Buyship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private boolean Shopping;
    private boolean Moveable;
    public void act()
    {
        checkMouse();
        if(Greenfoot.mouseClicked(this))
        {
            Shopping = true;
        }
        if(Shopping)
        {
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            addShip(mouseInfo.getX(), );
        }
        
        
        
        
    }
    public void addShip(int pos1, int pos2)
    {
        Ship tempShip = new Ship();
        getWorld().addObject(tempShip, pos1, pos2);
    }
    
}
