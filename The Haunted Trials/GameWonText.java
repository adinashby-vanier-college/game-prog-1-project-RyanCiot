import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class GameWonText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWonText extends Actor
{
    private String fullText = "Game Won!";
    private int currentIndex = 0;
    public GameWonText()
    { 
        setImage(new GreenfootImage("", 60, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
    public void act ()
    {
        if (currentIndex < fullText.length())
        {
           String currentText = fullText.substring(0, currentIndex + 1);
           setImage(new GreenfootImage(currentText, 60, new Color (255, 255, 255), new Color(0, 0, 0)));
           currentIndex++;
           Greenfoot.delay(2);
        }
    }
}
