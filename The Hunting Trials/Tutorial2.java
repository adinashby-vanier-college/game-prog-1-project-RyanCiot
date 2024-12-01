import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

public class Tutorial2 extends Actor
{
    private String fullText = " To reach Dracula you must go through all three levels\n"
                            + "and collect all keys, if you are touched by a ghost then\n"
                            + "  you lose the game. Use the arrow keys or wasd to move\n" 
                            + "            around. Good luck!\n";
    private int currentIndex = 0;
    public Tutorial2()
    { 
        setImage(new GreenfootImage("", 18, new Color(255, 255, 255), new Color(0, 0, 0)));
    }
    public void act ()
    {
        if (currentIndex < fullText.length())
    {
        String currentText = fullText.substring(0, currentIndex + 1);
        setImage(new GreenfootImage(currentText, 18, new Color (255, 255, 255), new Color(0, 0, 0)));
        currentIndex++;
        Greenfoot.delay(2);
    }
    }
}
