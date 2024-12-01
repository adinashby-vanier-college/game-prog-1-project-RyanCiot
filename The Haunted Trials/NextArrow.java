import greenfoot.*;  

public class NextArrow extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Scene2());
        }
    }
}
