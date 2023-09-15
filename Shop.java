import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends Actor
{
    /**
     * Act - do whatever the Shop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Shop(double width, double height, double picWidth, double picHeight)
    {
        // Cast doubles to int so Greenfoot accepts it and can be successfully generalized with multiplication margins
        int picWidth2 = (int)picWidth;
        int picHeight2 = (int)picHeight;
        int height2 = (int)height;
        int width2 = (int)width;
        GreenfootImage img = new GreenfootImage(picWidth2,picHeight2);
        img.setColor(Color.GREEN);
        img.drawLine(0, height2,width2,height2);
        setImage(img);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
