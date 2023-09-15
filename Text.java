import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    public Text(String text, double textposx, double textposy)
    {
        int x = (int)textposx;
        int y = (int)textposy;
        GreenfootImage img = new GreenfootImage(100,100);
        setImage(img);
        Font font = new Font("Arial",true,true, 12);
        img.setFont(font);
        img.setColor(Color.BLACK);
        img.drawString(text,x,y);
    }
}
