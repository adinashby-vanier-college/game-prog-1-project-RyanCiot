import greenfoot.*;  // Import necessary classes

public class ContinueButton extends Actor {
    private World mainMenuWorld;

    // Constructor for ContinueButton, accepts the MainMenuWorld
    public ContinueButton(World mainMenuWorld) {
        this.mainMenuWorld = mainMenuWorld;
    }

    public void act() {
        // Check if the user clicks the button
        if (Greenfoot.mouseClicked(this)) {
            // Retrieve the previous world from MainMenuWorld
            World previousWorld = ((MainMenuWorld) mainMenuWorld).getPreviousWorld();

            // Ensure previousWorld is not null
            if (previousWorld != null) {
                // Switch to the previous world
                Greenfoot.setWorld(previousWorld);
            } else {
                // If previousWorld is null, print an error message
                System.out.println("Error: previousWorld is null.");
            }
        }
    }
}



