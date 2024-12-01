import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

public class MenuText extends Actor {
    private String fullText = "The haunted trials";
    private int currentIndex = 0;
    public MenuText()
    { 
        setImage(new GreenfootImage("", 50, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
    public void act ()
    {
        if (currentIndex < fullText.length())
        {
        String currentText = fullText.substring(0, currentIndex + 1);
        setImage(new GreenfootImage(currentText, 50, new Color (255, 255, 255), new Color(0, 0, 0)));
        currentIndex++;
        Greenfoot.delay(2);
        }
    }
}