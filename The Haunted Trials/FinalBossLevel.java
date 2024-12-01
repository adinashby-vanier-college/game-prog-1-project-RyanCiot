import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FinalBossLevel extends World
{
    public FinalBossLevel()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Dracula dracula = new Dracula();
        addObject(dracula,456,161);
        dracula.setLocation(394,174);
        Gun gun = new Gun();
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
        Player player = new Player();
        player.setLocation(64,212);
        addObject(player,64,212);
        addObject(gun,64,212);
    }
}
