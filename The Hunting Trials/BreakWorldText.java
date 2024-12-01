import greenfoot.*;  
import greenfoot.Color;

public class BreakWorldText extends Actor
{
    private String fullText;
    private int currentIndex = 0;
    private int messageDuration = 0;
    private static final int MESSAGE_DISPLAY_DURATION = 200; // Number of frames to show the message after it's done typing
    public BreakWorldText(String message)
    {
        this.fullText = message;
        setImage(new GreenfootImage("", 18, Color.WHITE, Color.BLACK));  // Initialize with empty image
    }

    public void act() 
    {
        if (currentIndex < fullText.length())
        {
            String currentText = fullText.substring(0, currentIndex + 1);  // Add one more character each frame
            setImage(new GreenfootImage(currentText, 24, Color.WHITE, Color.BLACK));  // White text, black background
            currentIndex++;
        }
        
        // Remove the message after it finishes typing (optional, change duration here)
        if (currentIndex >= fullText.length()) {
            if (messageDuration < MESSAGE_DISPLAY_DURATION) {
                messageDuration++;
            } else {
                // After the message is done and displayed for a short time, add the RightArrow
                showRightArrow();
                getWorld().removeObject(this);  // Remove the message after it has shown long enough
            }
        }
    }

    private void showRightArrow()
    {
        if (getWorld() instanceof BreakWorld) {
            // Add the right arrow to the world
            BreakWorldArrow breakWorldArrow = new BreakWorldArrow();
            int arrowX = 477;  // Position on the right edge
            int arrowY = 200;  // Position in the middle vertically 
            getWorld().addObject(breakWorldArrow, arrowX, arrowY);  // Add to the world
        }
    }
}