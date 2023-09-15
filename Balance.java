import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Balance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Balance extends Actor
{
    /**
     * Act - do whatever the Balance wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int width;
    private int height;
    public static int mainbalance = 0;
    private boolean executed = false;
    public void act()
    {
        draw(mainbalance);
        if(!executed)
        {
            resetBalance();
            executed = true;
        }
    }
    public Balance(int width, int height, int balance)
    {
        this.width = width;
        this.height = height;
        this.mainbalance = balance;
    }
    public int width()
    {
        return width;
    }
    public int height()
    {
        return height;
    }
    public void draw(int balancetodraw)
    {
        GreenfootImage myImage = new GreenfootImage(width,height);
        Font font_1 = new Font("Arial",true,false,100);
        String s = Integer.toString(balancetodraw);
        myImage.setColor(Color.RED);
        myImage.drawString(s,55,10);
        myImage.drawString("Balance:",0,10);
        setImage(myImage);
    }
    public void resetBalance()
    {
        mainbalance -= mainbalance;
    }
}
