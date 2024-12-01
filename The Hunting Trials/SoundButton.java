import greenfoot.*;

public class SoundButton extends Actor
{
    // Constructor: Initializes the button to show sound on by default
    public SoundButton()
    {
        setImage("SoundOnButton.png"); // Initial image when sound is on
    }

    public void act()
    {
        if (Greenfoot.mouseClicked(this))  // Check if the button is clicked
        {
            SoundManager.toggleSound();  // Toggle the sound state

            // Change the button image based on mute state
            if (SoundManager.isMuted())
            {
                setImage("MuteButton.png"); // Image for mute state
            }
            else
            {
                setImage("SoundOnButton.png"); // Image for sound on state
            }
        }
    }
}

