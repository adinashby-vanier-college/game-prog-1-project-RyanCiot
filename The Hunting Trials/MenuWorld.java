import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuWorld extends World
{
    private GreenfootSound backgroundMusic; // Declare the sound variable

    public MenuWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        // Initialize the background music
        backgroundMusic = new GreenfootSound("ghost-atmosphere-ghostly-singing-188635.wav");
        backgroundMusic.playLoop();  // Play the music in a loop

        // Initialize the SoundManager with the background music, key collection sound, and game won sound
        GreenfootSound keyCollectSound = new GreenfootSound("retro-coin-4-236671.mp3");
        GreenfootSound gameWonSound = new GreenfootSound("game won_mp3.mp3"); 
        GreenfootSound gameLostSound = new GreenfootSound("game-over-arcade-6435.mp3");
        GreenfootSound gunCollectedSound = new GreenfootSound("retro-coin-4-236671.mp3");
        GreenfootSound shootGarlic = new GreenfootSound("346373__denao270__throwing-whip-effect.aup3");
        SoundManager.initialize(backgroundMusic, keyCollectSound, gameWonSound, gameLostSound, gunCollectedSound, shootGarlic);

        prepare();  // Prepare the world with buttons and objects
    }

    private void prepare()
    {
        StartGameButton startGameButton = new StartGameButton();
        addObject(startGameButton, 300, 314);
        TutorialButton tutorialButton = new TutorialButton();
        addObject(tutorialButton, 300, 251);
        MenuText menuText = new MenuText();
        addObject(menuText, 300, 145);
    }
}

