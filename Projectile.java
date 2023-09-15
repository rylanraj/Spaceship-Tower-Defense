import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    private int damage;
    public Projectile(int s, int d)
    {
        speed = s;
        damage = d;
    }
    
    public int getDamage()
    {
        return damage;
    }
    
    public void act()
    {
        move(speed);
        checkBoundaries();
    }
    
    public void checkBoundaries()
    {
        GreenfootImage img = getImage();
        int width = img.getWidth();
        int height = img.getHeight();
    
        World livesIn = getWorld();
        int left = getX() - width/2;
        int right = getX() + width/2;
        int top = getY() - height/2;
        int bottom = getY() + height/2;
        if( left <= 0)
            livesIn.removeObject( this );
    
        else if( right >= livesIn.getWidth())
            livesIn.removeObject( this );
    
        else if(top <= 0)
            livesIn.removeObject( this );
    
        else if(bottom >= livesIn.getHeight())
            livesIn.removeObject( this );       
    }
}
