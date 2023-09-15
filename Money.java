import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Money here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Money extends Actor
{
    /**
     * Act - do whatever the Money wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int amount;
    private int size;
    public boolean mouseOver;
    public static int MAXTRANS = 255;
    public int spawnCounter = 300;
    public int SPAWNCOUNTER = spawnCounter;
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
        if(Greenfoot.mouseClicked(this))
        {
            Balance.mainbalance += amount;
            getWorld().removeObject(this);
        }
    }
    public Money()
    {
        // If no parameters are filled, create money with this amount and size
        this(20,200);
        GreenfootImage img = getImage();
        img.scale(250,170);
    }
    public Money(int amount, int size)
    {
        this.amount = amount;
        this.size = size;
    }
    public void act()
    {
        checkMouse();
        SPAWNCOUNTER --;
        // If spawncounter is less or equal to zero and the World contains 1 or less money objects
        if(SPAWNCOUNTER <= 0 && getWorld().getObjects(Money.class).size() <= 1)
        {
            spawnMoney();
            SPAWNCOUNTER = spawnCounter;
        }
        else if (SPAWNCOUNTER <= 0)
        {
            SPAWNCOUNTER = spawnCounter;
        }
    }
    // Spawn money at random in the world
    public void spawnMoney()
    {
        Money money = new Money();
        int spawnx = Greenfoot.getRandomNumber(700) + 50;
        int spawny = Greenfoot.getRandomNumber(500) + 50;
        getWorld().addObject(money,spawnx,spawny);
    }
    // Transparency adjuster
    public void adjTrans(int adjust)
    {
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adjust);
    }
    // Get the value of the money spawned
    public int getAmount()
    {
        return amount;
    }
}
