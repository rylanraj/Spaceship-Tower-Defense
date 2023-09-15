import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wavebar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wavebar extends Actor
{
    /**
     * Act - do whatever the Wavebar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int width,height;
    public void act()
    {
        draw();
    }
    public Wavebar(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
    public void draw()
    {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(Color.BLACK);
        img.fillRect(0,10,100, 20);
        img.setColor(Color.RED);
        img.fillRect(0,10,Enemy.getKillCount(), 20);
        setImage(img);
    }
}
