import greenfoot.*;  // Import necessary Greenfoot classes

public class Block extends Actor
{
    private int moveSpeed = 5;  // The speed at which the block moves
    
    public void act() 
    {
        // Check if the block is touching the player
        if (isTouching(Player.class)) {
            // If touching, move the block in the opposite direction of the face
            moveBlockOppositeDirection();
        }
    }
    
    // Method to move the block in the opposite direction of the player
    private void moveBlockOppositeDirection() 
    {
        // Get the position of the player and the block
        int playerX = getWorld().getObjects(Player.class).get(0).getX();
        int playerY = getWorld().getObjects(Player.class).get(0).getY();
        int blockX = getX();
        int blockY = getY();
        int blockWidth = getImage().getWidth();   // Get block's width (assuming it's square)
        int blockHeight = getImage().getHeight(); // Get block's height (assuming it's square)

        // Check if player is touching the left, right, top, or bottom face of the block
        if (playerX < blockX - blockWidth / 2) {
            // Player is to the left of the block, move block right
            blockX += moveSpeed;
        } else if (playerX > blockX + blockWidth / 2) {
            // Player is to the right of the block, move block left
            blockX -= moveSpeed;
        } else if (playerY < blockY - blockHeight / 2) {
            // Player is above the block, move block down
            blockY += moveSpeed;
        } else if (playerY > blockY + blockHeight / 2) {
            // Player is below the block, move block up
            blockY -= moveSpeed;
        }

        // Set the new position of the block
        setLocation(blockX, blockY);
    }
}

