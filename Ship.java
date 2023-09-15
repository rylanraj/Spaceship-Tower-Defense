import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ship here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ship extends Actor
{
    /**
     * Act - do whatever the Ship wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private final int RELOADL = 100;
    private int reloadTimerL;
    public int transparency = 255;
    public int sizex = 0, sizey = 0;
    public boolean rescaled;
    public int scale1, scale2;
    public boolean snapped;
    public int health;
    public static int MAXTRANS = 255;
    public final int MAXHEALTH;
    // Contructor I use for real ships
    public Ship(double x, double y, int transparency, int health)
    {
        this.transparency = transparency;
        this.health = health;
        MAXHEALTH = health;
        GreenfootImage img = getImage();
        int scalex = (int)x;
        int scaley = (int)y;
        img.scale(scalex,scaley);
        reloadTimerL = RELOADL;
    }
    // Transparency adjuster method
    public void adjTrans(double adjust)
    {
        int adj = (int)adjust;
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adj);
    }
    public void act()
    {
        if(getWorld() != null)
        {
            checkContact();
        }
        checkMouseClick();
        reloadTimerL--;
        if(snapped == false)
        {
            gridSnap();
            snapped = true;
        }
        if(getWorld() != null && reloadTimerL <= 0)
        {
            shoot(new Laser(10));
            reloadTimerL = RELOADL;
        }
    }
    // Check if the ship has been clicked in Trash mode (for it to be removed)
    public void checkMouseClick()
    {
        if(Greenfoot.mouseClicked(this) && Trash.inTrashMode)
        {
            getWorld().removeObject(this);   
        }
    }
    // Mr Rowell's shoot method
    public void shoot(Projectile fireThis)
    {
        fireThis.setRotation( getRotation() );//match ship’s rotation
        // Fire the projectile in that direction at the x and y position of the ship
        getWorld().addObject( fireThis, getX(), getY() );
        // move distance is this image's width/2 so it remains generalized
        fireThis.move( getImage().getWidth()/2 );
    }
    public void gridSnap()
    {
        // If the the Ship is placed and not touching the Shopzone
        if(this.isTouching(Shopzone.class) == false)
        {
            // Set it's location to the nearest square object it is near, (snap to grid)
            Actor location = getOneObjectAtOffset(5,5, Square.class);
            if(location != null)
            {
                setLocation(location.getX(), location.getY()); 
            }
            // If the player misses the grid somehow(nullpointer)
            else
            {
                // Remove the ship
                getWorld().removeObject(this);
                // Refund the player their money
                Balance.mainbalance += Buyship.shipCost;
            }
        }
        // Else if it's touching the shopping zone and the player isn't in shopping mode(meaning it's somewhere it shouldn't belong)
        else if(this.isTouching(Shopzone.class) == true && Buyship.Shopping == false)
        {
            // Remove it
            getWorld().removeObject(this);
            // Refund the player their money
            Balance.mainbalance += Buyship.shipCost;
        }
    }
    public void checkContact()
    {
        // If the ship is touching an enemy       
        if (this.isTouching(Enemy.class))
        {
            // Take damage // Decrease health by 1
            health -= 1;
        }
        if(health <= 0)
        {
            getWorld().removeObject(this);
        }
        // if health is less or equal to two thirds of it's max health
        else if(health <= MAXHEALTH * 0.66)
        {
            // Adjusts it's transparency by that much
            adjTrans(MAXTRANS * 0.66);
        }
        // if health is less or equal to one third of it's max health
        else if(health <= MAXHEALTH * 0.33)
        {
            // Adjusts it's transparency by that much
            adjTrans(MAXTRANS * 0.33);
        }
    }
}    
