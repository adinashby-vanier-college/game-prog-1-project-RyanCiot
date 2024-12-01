import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blood extends Actor {
    private int speed;
    private double direction;

    public Blood(int speed, double direction) {
        this.speed = speed;
        this.direction = direction;
        setRotation((int) Math.toDegrees(direction));  // Set rotation to the calculated direction in degrees
    }

    public void act() {
        moveBlood();
        checkCollisionWithPlayer(); 
    }
    private void moveBlood() {
        move(speed);  
    }

    // Check if the blood hits the Player and deal damage
    private void checkCollisionWithPlayer() {
        if (isTouching(Player.class)) {
            Player player = (Player) getOneIntersectingObject(Player.class);
            if (player != null) {
                // Deal damage to the player when hit
                player.hit(7);  // Decrease player's health by 10 (you can adjust this value)
                getWorld().removeObject(this);  // Remove the Blood object after it hits the player
            }
        }
    }
}
