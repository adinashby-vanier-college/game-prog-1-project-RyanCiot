import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    /**
     * Constructor for objects of class Level1.
     */
    
    private int keysCollected = 0; // Tracks total keys collected
    private int setsSpawned = 0;   // Tracks how many sets of keys have been spawned
    private int keysInCurrentSet = 0; // Tracks keys collected in the current set
     
    public Level1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,250,183);
        player.setLocation(65,187);
        Ghost ghost = new Ghost();
        addObject(ghost,282,194);
        Ghost ghost2 = new Ghost();
        addObject(ghost2,213,55);
        Ghost ghost3 = new Ghost();
        addObject(ghost3,173,278);
        ghost3.setLocation(132,310);
        Ghost ghost4 = new Ghost();
        addObject(ghost4,452,260);
        Ghost ghost5 = new Ghost();
        addObject(ghost5,394,53);
        player.setLocation(64,199);
        removeObject(player);
        ghost.setLocation(268,205);
        addObject(player,63,203);
        ghost3.setLocation(188,330);
        ghost3.setLocation(188,330);
        removeObject(ghost3);
        spawnKeys();
        ghost2.setLocation(210,70);
        ghost.setLocation(238,331);
        ghost.setLocation(190,306);
        ghost4.setLocation(534,321);
        ghost5.setLocation(435,125);
        ghost2.setLocation(225,68);
        ghost.setLocation(205,287);
        ghost.setLocation(210,304);
        ghost2.setLocation(262,92);
        ghost5.setLocation(301,206);
        ghost4.setLocation(487,236);
        ghost5.setLocation(309,201);
        addObject(ghost,277,201);
        addObject(player,64,212);
        addObject(ghost2,379,84);
        addObject(ghost3,356,322);
        addObject(ghost4,164,114);
        removeObject(ghost3);
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
        removeObject(ghost4);
        ghost.setLocation(465,223);
    }

     public void act() {
          checkKeyCollection();
    }
    
    private void checkKeyCollection()
    {
        if (keysInCurrentSet == 8) {
            keysInCurrentSet = 0;

            if (setsSpawned < 3) {
                spawnKeys();
            } else if (keysCollected == 24) {
                Greenfoot.setWorld(new Level2()); // Transition to Level2
            }
        }
    }

    /**
     * Increments the keys collected count.
     */
    public void collectKey()
    {
        keysCollected++;
        keysInCurrentSet++;
    }
    private void spawnKeys()
    {
        for (int i = 0; i < 8; i++) {
            Key key = new Key(); // Assumes you have a Key class
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(key, x, y);
        }
        setsSpawned++;
    }

}