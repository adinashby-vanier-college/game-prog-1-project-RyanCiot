import greenfoot.*;  // Import necessary classes

public class MainMenuWorld extends World {
    private World previousWorld;  // Variable to store the previous world

    // Constructor for MainMenuWorld
    public MainMenuWorld(World previousWorld) {
        // Call the super constructor with world size and cell size
        super(600, 400, 1);
        
        // Store the previous world to go back to it later
        this.previousWorld = previousWorld;
        
        // Add the ContinueButton to the world
        ContinueButton continueButton = new ContinueButton(this);
        addObject(continueButton, 300,200);
        prepare();
    }

    // Method to retrieve the previous world
    public World getPreviousWorld() {
        return previousWorld;
    }
    
    private void prepare()
    {
        RestartButton restartButton = new RestartButton();
        addObject(restartButton,300,280);
        SoundButton soundButton = new SoundButton();
        addObject(soundButton,300,120);
    }
}
