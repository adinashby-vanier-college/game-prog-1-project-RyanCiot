import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameWon extends World
{
    public GameWon()
    {    
        super(600, 400, 1);
        prepare();
        SoundManager.playGameWonSound();
    }
    private void prepare()
    {
        MainMenuButton mainMenuButton = new MainMenuButton();
        addObject(mainMenuButton,314,283);
        RestartButton restartButton = new RestartButton();
        addObject(restartButton,314,338);
        mainMenuButton.setLocation(314,285);
        mainMenuButton.setLocation(317,267);
        mainMenuButton.setLocation(318,267);
        GameWonText gameWonText = new GameWonText();
        addObject(gameWonText,300,147);
        mainMenuButton.setLocation(300,251);
        restartButton.setLocation(316,324);
        restartButton.setLocation(300,314);
    }
}
