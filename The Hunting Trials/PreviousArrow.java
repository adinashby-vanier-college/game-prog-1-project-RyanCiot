import greenfoot.*;  

public class PreviousArrow extends Actor {
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Scene1());
        }
    }
}
