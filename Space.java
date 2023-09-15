import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{
    /**
     * Constructor for objects of class Space.
     * 
     */
    // Square distance for the width of the squares
    public double squaredistance = getWidth() * 0.05;
    // Square distance for the hegith of the squares
    public double squaredistancey = getHeight() * 0.20833333333;
    // Multiplier for reference squares since not all the squares would generate all squares
    public int refmultiplier = 0;
    Square square = new Square(getWidth() * 0.1, getHeight() * 0.2);
    public Space()
    {    
        super(800, 600, 1, false); 
        prepare();
        // Force reset the enemy kill count when the world is created.
        Enemy.killCountReset = false;
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        // Add all the necessary objects in prepare
        Shopzone shopzone = new Shopzone(getWidth(),getHeight() * 0.16666666666);
        addShopZone(shopzone, getWidth() * 0.5, getHeight() * 0.91666666666);
        Shop shop = new Shop(getWidth(), getHeight() * 0.90625, getWidth(), getHeight());
        addShopLine(shop,getWidth() / 2, getHeight() * 0.42);
        Buyship buyshipmain = new Buyship(getWidth() * 0.0625, getHeight() * 0.04625);
        addBuyShipButton(buyshipmain,getWidth() * 0.06583333333, getHeight() * 0.955);
        Trash trash = new Trash(getWidth() * 0.05, getHeight() * 0.07);
        addTrash(trash, getWidth() * 0.95833333333, getHeight() * 0.95);
        addRefSquare(square, getWidth() * 0.04933333333, getHeight() * 0.09866666666);
        for(int i = 0; i < 3; i++)
        {
            refmultiplier++;
            Square refHeightSquare = new Square(getWidth() * 0.1, getHeight() * 0.2);
            addRefSquare(refHeightSquare, square.getX(), square.getY() + (int)squaredistancey * refmultiplier);
        }
        addSquares(square.getX() + squaredistance, square.getY() + squaredistance);
        // Dummy trolls to start the game 
        Enemy enemy = new Enemy("trollface.png", 1, 100, 3, 300);
        Enemy enemy2 = new Enemy("trollface.png", 1, 100, 3, 600);
        Enemy enemy3 = new Enemy("trollface.png", 1, 100, 3, 900);
        Enemy dummy = new Enemy("trollface.png",0,100,1000,200);
        addObject(dummy, getWidth() + 200, 0);
        addObject(enemy,getWidth() + 100,226);
        addObject(enemy2,getWidth() + 100, 226);
        addObject(enemy3,getWidth() + 100,226);
        // Off screen money to be referenced
        Money money = new Money();
        addObject(money,-100,0);
        Balance mainbalance = new Balance(100,100, 0);
        addObject(mainbalance, 427, 55);
        Wavebar wavebar = new Wavebar(350, 200);
        addWaveBar(getWidth() * 0.4375,getHeight() * 0.33333333333,getHeight() * 0.16666666666);
    }
    // Methods to add all the needed objects
    public void addWaveBar(double xsize, double ysize, double ypos)
    {
        int x = (int)xsize;
        int y = (int)ysize;
        int yp = (int)ypos;
        Wavebar wavebar = new Wavebar(x,y); // 350 200
        addObject(wavebar,getWidth(),yp); 
    }
    public void addShopZone(Shopzone shopzone, double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        addObject(shopzone, x, y);
    }
    public void addBuyShipButton(Buyship buyship, double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        addObject(buyship, x, y);
    }
    public void addShopLine(Shop shop, double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        addObject(shop, x, y);
    }
    public void addTrash(Trash trash, double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        addObject(trash, x, y); 
    }
    public void addSquares(double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        // For every time this code is run, increase i by 1, and only run if i is less than nine
        for(int i = 0; i < 9; i++)
        {
            // Square distance margin
            squaredistance += getWidth() * 0.10333333333;
            // Create the squares, create a square multiple times at different positions in this for loop, (more efficient than hardcoding)
            Square squares = new Square(getWidth() * 0.1, getHeight() * 0.2);
            // Add the squares based on the original reference square
            addObject(squares, (int)squaredistance, square.getY());
            // Create the height squares
            Square heightsquares = new Square(getWidth() * 0.1, getHeight() * 0.2);
            addObject(heightsquares, squares.getX(), squares.getY() + (int)squaredistancey);
            Square heightsquares2 = new Square(getWidth() * 0.1, getHeight() * 0.2);
            addObject(heightsquares2, squares.getX(), squares.getY() + (int)squaredistancey * 2);
            Square heightsquares3 = new Square(getWidth() * 0.1, getHeight() * 0.2);
            addObject(heightsquares3, squares.getX(), squares.getY() + (int)squaredistancey * 3);
        }
    }
    public void addRefSquare(Square square, double xpos, double ypos)
    {
        int x = (int)xpos;
        int y = (int)ypos;
        addObject(square, x,y); // 0.04933333333 // 0.09866666666
    }
}
