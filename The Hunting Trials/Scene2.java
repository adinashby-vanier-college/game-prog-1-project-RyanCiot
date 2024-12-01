import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Optional;

public class Scene2 extends World
{
    public Scene2()
    {    
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PreviousArrow previousArrow = new PreviousArrow();
        addObject(previousArrow,123,286);
        Tutorial2 tutorial2 = new Tutorial2();
        addObject(tutorial2,300,157);
        NextArrow2 nextArrow2 = new NextArrow2();
        addObject(nextArrow2,477,286);
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
    }
}
