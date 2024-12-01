import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Scene1 extends World {

    /**
     * Constructor for objects of class Scene1.
     */
    public Scene1() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        prepare();
    }

    public void act() {
        // You can add other actions here if needed
    }
    private void prepare()
    {
        NextArrow nextArrow = new NextArrow();
        addObject(nextArrow,477,286);
        Tutorial1 tutorial1 = new Tutorial1();
        addObject(tutorial1,300,157);
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
    }
}