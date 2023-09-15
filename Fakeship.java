import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fakeship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fakeship extends Actor
{
    /**
     * Act - do whatever the Fakeship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int transparency;
    public void act()
    {
        adjTrans(transparency);
    }
    public Fakeship(double x, double y, int transparency)
    {
        this.transparency = transparency; 
        int scalex = (int)x;
        int scaley = (int)y;
        GreenfootImage img = getImage();
        img.scale(scalex,scaley);
    }
    public void adjTrans(int adjust)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
    }
}
