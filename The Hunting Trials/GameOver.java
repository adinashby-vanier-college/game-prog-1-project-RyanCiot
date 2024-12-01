import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{
    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver() {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        SoundManager.playGameLostSound();
        prepare();  // Prepare other objects in the world
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        MainMenuButton mainMenuButton = new MainMenuButton();
        addObject(mainMenuButton,314,283);
        RestartButton restartButton = new RestartButton();
        addObject(restartButton,314,338);
        mainMenuButton.setLocation(314,285);
        mainMenuButton.setLocation(317,267);
        mainMenuButton.setLocation(318,267);
        GameOverText gameOverText = new GameOverText();
        addObject(gameOverText,300,147);
        mainMenuButton.setLocation(300,251);
        restartButton.setLocation(316,324);
        restartButton.setLocation(300,314);
    }
    
}
