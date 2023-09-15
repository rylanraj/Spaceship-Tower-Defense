import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Square here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Square extends Actor
{
    /**
     * Act - do whatever the Square wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int MAXTRANS = 255;
    public boolean mouseOver;
    public Square(double xlen, double ylen)
    {
        int x = (int)xlen;
        int y = (int)ylen;
        GreenfootImage img = new GreenfootImage(x,y); //150 150
        img.setColor(Color.WHITE);
        img.fill();
        setImage(img);
        img.setTransparency(20);
    }
    public void adjTrans(int adjust)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
    }
    public void act()
    {
    
    }
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
}
