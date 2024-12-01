import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BreakWorld extends World
{
    public BreakWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }
    
    private void prepare()
    {
        Player player = new Player();
        addObject(player,199,203);
        Gun gun = new Gun();
        addObject(gun,334,140);
        player.setLocation(64,212);
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
        gun.setLocation(393,143);
    }
}
