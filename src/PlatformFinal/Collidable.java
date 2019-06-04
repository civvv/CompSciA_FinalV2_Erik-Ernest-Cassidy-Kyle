package PlatformFinal;


import java.awt.Color;
import java.awt.Graphics;

public interface Collidable {
    //old Collidable methods from Pong
    public abstract boolean didCollideLeft(Object obj);
    public boolean didCollideRight(Object obj);
    boolean didCollideTop(Object obj);
    boolean didCollideBottom(Object obj);
    
    //new Collidable methods - Not Active yet due to time restrictions
    //public abstract boolean didCollideAnyWay(Object obj);
    //public abstract boolean stateOfLevel(Object obj);
}
