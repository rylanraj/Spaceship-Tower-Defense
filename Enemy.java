import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int speed;
    public int health;
    public final int MAXHEALTH;
    public int size;
    public static int enemiesDead = 0;
    public boolean moved;
    private boolean converted;
    public int randomNumber = Greenfoot.getRandomNumber(3) + 1;
    public int spawnDelay;
    public static boolean killCountReset;
    public static int MAXTRANS = 255;
    public int spawnCounter = 300;
    public int SPAWNCOUNTER = spawnCounter;
    private boolean wave1completed;
    private boolean wave2completed;
    private int timesExecuted;
    // Constructer
    public Enemy(String img, int speed, int size, int health, int spawnDelay)
    {
        // Set attributes in the constructor
        this.health = health;
        MAXHEALTH = health;
        this.speed = speed;
        this.size = size;
        this.spawnDelay = spawnDelay;
        GreenfootImage enemyImage = new GreenfootImage(img);
        enemyImage.scale(size, size);
        setImage(enemyImage);
    }
    public void act()
    {
        checkGameOver();
        checkContact();
        SPAWNCOUNTER --;
        // If the enemies kill count hasn't been reset (has to be reset at the begginning since it's static)
        if(!killCountReset)
        {
            // Reset it
            resetKillCount();
            // It has been reset so this is true, it doesn't need to be executed anymore
            killCountReset = true;
        }
        // If the enemy hasn't been moved to their spawn location
        if(moved == false)
        {
            // Move them, to one of the lanes at random
            double lane1 = getWorld().getHeight() * 0.11666666666,lane2 = getWorld().getHeight() * 0.325,lane3 = getWorld().getHeight() * 0.53333333333,lane4 = getWorld().getHeight() * 0.74166666666;
            if(randomNumber == 1)
            {
                setLocation(getWorld().getWidth() + spawnDelay, (int)lane1);
            }
            else if(randomNumber == 2)
            {
                setLocation(getWorld().getWidth() + spawnDelay, (int)lane2);
            }
            else if(randomNumber == 3)
            {
                setLocation(getWorld().getWidth() + spawnDelay, (int)lane3);
            }
            else if(randomNumber == 4)
            {
                setLocation(getWorld().getWidth() + spawnDelay, (int)lane4);
            }
            // They have now been moved, so move = true, meaning they'll only be moved once when act is called
            moved = true;
        }
        // If speed hasn't been converted to a negative, convert it
        if(converted == false)
        {
            speed *= -1;
            // Convert the image to a generalized size as well
            scaleEnemy(getWorld().getWidth() * 0.125,getWorld().getHeight() * 0.125);
            converted = true;
        }
        // If the spawn timer is less than or equal to zero, and the world contains only 1 Enemy object, and wave one hasn't been completed
        if(SPAWNCOUNTER <= 0 && enemyCount() <= 1)
        {
            // Spawn wave one
            waveOne();
            // Reset the counter
            SPAWNCOUNTER = spawnCounter;
            // Wave has been executed, and will be completed
            wave1completed = true;
            // Spawn wave two if it's been executed 2 or more times
            if(timesExecuted >= 2)
            {
                waveTwo();
            }
            // Spawn wave three it's been executed 3 or more times
            if(timesExecuted >= 3)
            {
                waveThree();
            }
            // Spawn wave four if it's been executed 4 or more times
            if(timesExecuted >= 4)
            {
                waveFour();
            }
        }
        else if (SPAWNCOUNTER <= 0)
        {
            // Don't spawn more if there is more than one or less than 1 (chose 1 because the dummy Enemy never dies)
            SPAWNCOUNTER = spawnCounter;
        }
    }
    public void moveEnemy()
    {
        
    }
    public void scaleEnemy(double xs, double ys)
    {
        GreenfootImage img = getImage();
        img.scale((int)xs, (int)ys);
    }
    public int enemyCount()
    {
        return getWorld().getObjects(Enemy.class).size();
    }
    public int getHealth()
    {
        return health;
    }
    public int getSpeed()
    {
        return speed;
    }
    public void checkContact()
    {
        // If not touching the ship, move
        if(!isTouching(Ship.class))
        {
            move(speed);
        }
        //Check if this object is in contact with any projectiles, and take damage if it is
        if (isTouching(Projectile.class))
        {
            Projectile tempProjectile = (Projectile)getOneIntersectingObject(Projectile.class);
            health -= tempProjectile.getDamage();
            removeTouching(Projectile.class);
        }
        // Add to the dead enemy counter, and remove the enemy if it has no health left.
        if(health <=0)
        {
            enemiesDead += 1;
            getWorld().removeObject(this);
        }
        // if health is less or equal to two thirds of it's max health
        if(health <= MAXHEALTH * 0.66)
        {
            // Adjusts it's transparency by that much
            adjTrans(MAXTRANS * 0.66);
        }
        // if health is less or equal to one third of it's max health
        if(health <= MAXHEALTH * 0.33)
        {
            // Adjusts it's transparency by that much
            adjTrans(MAXTRANS * 0.33);
        }
    }
    // Check if the enemy reaches the player's size, and if they are, end the game (gameover)
    public void checkGameOver()
    {
        if(getX() <= 0)
        {
            Text txt = new Text("GAMEOVER", 0, 50);
            getWorld().addObject(txt, getWorld().getWidth() / 2 , getWorld().getHeight() / 2 );
            Greenfoot.stop();
        }
    }
    // Getters, Setters, and reseter
    public static int getKillCount()
    {
        return enemiesDead;
    }
    public int returnKillCount()
    {
        return enemiesDead;
    }
    public void resetKillCount()
    {
        enemiesDead -= enemiesDead;
    }
    // Transparency adjuster
    public void adjTrans(double adjust)
    {
        int adj = (int)adjust;
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(adj);
    }
    // Spawn a white enemy
    public void spawnWhiteEnemy()
    {
        Troll enemyToSpawn = new Troll();
        getWorld().addObject(enemyToSpawn,getWorld().getWidth() + 100, 0);
    }
    // Spawn a blue enemy
    public void spawnBlueEnemy()
    {
        Bluetroll trollToSpawn = new Bluetroll();
        {
            getWorld().addObject(trollToSpawn,getWorld().getWidth() + 100, 0);
        }
    }
    // Spawn a red enemy
    public void spawnRedEnemy()
    {
        Redtroll trollToSpawn = new Redtroll();
        {
            getWorld().addObject(trollToSpawn,getWorld().getWidth() + 100, 0);
        }
    }
    // Spawn a custom enemy
    public void spawnCustomEnemy(String img, int health, int speed, int delay)
    {
        Enemy enemy = new Enemy(img,speed,100,health,delay);
        getWorld().addObject(enemy, getWorld().getWidth() + 100, 0);
    }
    // Waves, made custom for difficulty
    public void waveOne()
    {
        timesExecuted+=1;
        spawnCustomEnemy("bluetroll.png",3,5,100);
        spawnCustomEnemy("bluetroll.png",3,5,125);
        spawnCustomEnemy("bluetroll.png",3,5,150);
    }
    public void waveTwo()
    {
        spawnCustomEnemy("redtroll.png",6,2,125);
        spawnCustomEnemy("redtroll.png",6,2,175);
        spawnCustomEnemy("redtroll.png",6,2,225);
    }
    public void waveThree()
    {
        spawnCustomEnemy("bluetroll.png",3,5,100);
        spawnCustomEnemy("bluetroll.png",3,5,200);
        spawnCustomEnemy("redtroll.png",6,1,300);
        spawnCustomEnemy("trollface.png",3,2,400);
    }
    public void waveFour()
    {
        spawnCustomEnemy("bluetroll.png",3,5,100);
        spawnCustomEnemy("bluetroll.png",3,5,200);
        spawnCustomEnemy("bluetroll.png",3,5,300);
        spawnCustomEnemy("bluetroll.png",3,5,400);
        spawnCustomEnemy("redtroll.png",6,1,500);
        spawnCustomEnemy("redtroll.png",6,1,600);
        spawnCustomEnemy("redtroll.png",6,1,700);
        spawnCustomEnemy("redtroll.png",6,1,800);
        spawnCustomEnemy("trollface.png",3,2,900);
        spawnCustomEnemy("trollface.png",3,2,1000);
    }
}