import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BreakWorldArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BreakWorldArrow extends Actor
{
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new FinalBossLevel());
        }
    }
}
