import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    /**
     * Constructor for objects of class Level2.
     * 
     */
    private boolean keyCollected = false; 
    public Level2()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        spawnKey(); 
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,295,37);
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
        
        wall wall = new wall();
        wall wall2 = new wall();
        wall wall3 = new wall();
        wall wall4 = new wall();
        wall wall5 = new wall();
        wall wall6 = new wall();
        wall wall7 = new wall();
        wall wall8 = new wall();
        wall wall9 = new wall();
        
        WallUp wallUp = new WallUp();
        WallUp wallUp2 = new WallUp();
        WallUp wallUp3 = new WallUp();
        WallUp wallUp4 = new WallUp();
        WallUp wallUp5 = new WallUp();
        WallUp wallUp6 = new WallUp();
        WallUp wallUp7 = new WallUp();
        WallUp wallUp8 = new WallUp();
        WallUp wallUp9 = new WallUp();
        WallUp wallUp10 = new WallUp();
        WallUp wallUp11 = new WallUp();
        WallUp wallUp12 = new WallUp();
        WallUp wallUp13 = new WallUp();
        
        addObject(wall,44,221);
        addObject(wall2,222,172);
        addObject(wall3,311,172);
        addObject(wall4,401,304);
        addObject(wall5,452,304);
        addObject(wall6,223,83);
        addObject(wall7,294,83);
        addObject(wall8,472,84);
        addObject(wall9,133,311);
        
        addObject(wallUp,88,46);
        addObject(wallUp2,88,92);
        addObject(wallUp3,88,267);
        addObject(wallUp4,177,266);
        addObject(wallUp5,177,218);
        addObject(wallUp6,269,308);
        addObject(wallUp7,269,355);
        addObject(wallUp8,356,217);
        addObject(wallUp9,356,261);
        addObject(wallUp10,496,260);
        addObject(wallUp11,249,39);
        addObject(wallUp12,427,125);
        addObject(wallUp13,427,39);
    }

     public void act() {
        checkKey();  // Continuously check if the key has been collected
    }
    private void spawnKey() {
        Key key = new Key();
        addObject(key, 39, 265);  // Place the key at the center of the screen
    }
    private void checkKey() {
        if (keyCollected) {
            Greenfoot.setWorld(new Level3());  // After collecting the 25th key, move to Level 3
        }
    }
    public void collectKey() {
        keyCollected = true;
    }
}
