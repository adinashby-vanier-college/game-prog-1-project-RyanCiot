import greenfoot.*;  // Required for Greenfoot classes like Actor, World, etc.

public class Level3 extends World
{
    private Box box1, box2, box3;

    public Level3()
    {    
        super(600, 400, 1); 
        prepare();

        // Initialize Box actors
        box1 = new Box(); // Creating instance of Box class
        box2 = new Box(); // Creating instance of Box class
        box3 = new Box(); // Creating instance of Box class

        // Add Boxes to the world
        addObject(box1, 308, 87);
        addObject(box2, 483, 148);
        addObject(box3, 323, 239);

        // Add Blocks (or let the player drop them into the boxes)
        Block block1 = new Block();
        Block block2 = new Block();
        Block block3 = new Block();

        // Add Blocks to the world
        addObject(block1, 197, 293);
        addObject(block2, 234, 330);
        addObject(block3, 499, 288);
    }
    
    private void prepare()     
    {         
        MenuButton menuButton = new MenuButton();
        addObject(menuButton,37,37);
        Player player = new Player();
        addObject(player,64,212);
    }

    public void act()
    {
        checkBoxForBlock(box1);
        checkBoxForBlock(box2);
        checkBoxForBlock(box3);

        // Check if all 3 boxes contain blocks
        if (box1.containsBlock() && box2.containsBlock() && box3.containsBlock())
        {
            Greenfoot.setWorld(new BreakWorld());  // Transition to the 'Break' world
        }
    }
    private void checkBoxForBlock(Box box)
    {
        // Get all objects at the Box's location and check if any of them is a Block
        for (Object obj : getObjectsAt(box.getX(), box.getY(), Block.class))
        {
            // If a Block is found, set the Box to contain a Block
            box.setContainsBlock(true);
            return;  // We only need one Block in the Box, so return early
        }

        // If no Block was found, set the Box to not contain a Block
        box.setContainsBlock(false);
    }
}


