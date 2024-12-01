import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MenuButton extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            goToMainMenu();
        }
    }
    public void goToMainMenu() {
        // Store the current world before transitioning to the Main Menu
        World currentWorld = getWorld();
    
        // Create a MainMenuWorld, passing the current world as the previous world
        MainMenuWorld mainMenu = new MainMenuWorld(currentWorld);
    
        // Switch to the Main Menu
        Greenfoot.setWorld(mainMenu);
    }
}
