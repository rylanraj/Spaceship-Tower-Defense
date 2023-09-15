import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shopzone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shopzone extends Actor
{
    /**
     * Act - do whatever the Shopzone wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shopzone(double xsize, double ysize)
    {
        int x = (int)xsize;
        int y = (int)ysize;
        GreenfootImage img = new GreenfootImage(x, y);
        img.setColor(Color.WHITE);
        img.fill();
        setImage(img);
    }
    public void act()
    {
        // Add your action code here.
    }
}
