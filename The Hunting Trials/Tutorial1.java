import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

public class Tutorial1 extends Actor
{
    private String fullText = "You and your friends decided to go to a haunted\n"
                            + " house, and one of them, Jacob, has gone missing.\n"
                            + "You found out that he was murdered by the owner of\n" 
                            + " the house, Dracula. You decided to stay in the\n"
                            + "haunted house to avenge Jacob’s death, even after\n"
                            + "       all your your friends left.\n";
    private int currentIndex = 0;
    public Tutorial1()
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

