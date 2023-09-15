import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Buyship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Buyship extends ShopButtons
{
    public static boolean Shopping;
    private boolean shipAdded;
    private boolean balanceAdded;
    Fakeship tempShip = new Fakeship(100, 100,55);
    public static int shipCost = 20;
    private int textTimer = 75;
    private int TEXTTIMER = textTimer;
    private boolean showingText;
    private boolean executed;
    public Buyship(double x, double y)
    {
       GreenfootImage img = getImage();
       int scalex = (int)x;
       int scaley = (int)y;
       img.scale(scalex,scaley); //75, 37
    }
    public void act()
    {
        //Reset shopping at the begginning to avoid null pointers
        if(!executed)
        {
            shoppingReset();
            executed = true;
        }
        checkMouse();
        checkShopping();
        checkShip(tempShip,getWorld().getWidth() * 0.125, getWorld().getHeight() * 0.2);
        // If the fake ship has been added and the player's in shopping mode
        if(shipAdded && Shopping)
        {
            // Create a mouse info object
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            // If the mouse position is in the world (not null)
            if(mouseInfo != null)
            {
                // Set location of the ship to the Player's mouse
                tempShip.setLocation(mouseInfo.getX(), mouseInfo.getY());
            }
            addRealShip(mouseInfo,getWorld().getWidth() * 0.1, getWorld().getHeight() * 0.19);
        }
        if(showingText && TEXTTIMER > 0)
        {
            TEXTTIMER --;
            getWorld().showText("You don't have enough money to buy this", getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
        else
        {
            showingText = false;
            getWorld().showText(null, getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            TEXTTIMER = textTimer;
        }
    }
    public void shoppingReset()
    {
        Shopping = false;
        shipAdded = false;
    }
    public void checkShopping()
    {
        // If this button object is clicked
        if(Greenfoot.mouseClicked(this))
        {
            // Player enters shopping mode
            Shopping = true;
        }
    }
    public void checkShip(Fakeship ship, double xscale, double yscale)
    {
        // If the player is in Shopping mode and the temporary fake ship hasn't been added
        if(Shopping && shipAdded == false)
        {
            int x = (int)xscale;
            int y = (int)yscale;
            // Create a mouse info object
            MouseInfo mouseInfo = Greenfoot.getMouseInfo();
            // Add the ship
            getWorld().addObject(ship, mouseInfo.getX(), mouseInfo.getY());
            GreenfootImage img = ship.getImage();
            // Scale the image to what we want in this customized method
            img.scale(x,y);
            // Set its transparency lower so the player knows it's fake
            shipAdded = true;
        }
    }
    public void addRealShip(MouseInfo mouseInfo, double xscale, double yscale)
    {
        int x1 = (int)xscale;
        int y1 = (int)yscale;
        if(Greenfoot.mouseClicked(tempShip))
            {
                final int x = mouseInfo.getX();
                final int y = mouseInfo.getY();
                getWorld().removeObject(tempShip);
                if(allowedToPlace(tempShip) && Balance.mainbalance >= shipCost)
                {
                    Ship realShip = new Ship(100,100, 255,300);
                    getWorld().addObject(realShip, x, y);
                    GreenfootImage img = realShip.getImage();
                    // Scale the image to what we want in this customized method
                    img.scale(x1, y1);
                    Balance.mainbalance -= shipCost;
                    shoppingReset();
                }
                else
                {
                    shoppingReset();
                    showingText = true;
                    // You don't have enough money to buy this
                }
            }
    }
}
