import greenfoot.*;

public class Box extends Actor
{
    private boolean containsBlock = false;  // Tracks whether this Box contains a Block

    // Set the Box to contain a Block
    public void setContainsBlock(boolean status)
    {
        containsBlock = status;
    }

    // Get whether this Box contains a Block
    public boolean containsBlock()
    {
        return containsBlock;
    }

    public void act()
    {
        // You can add more behavior for the Box if needed
    }
}

