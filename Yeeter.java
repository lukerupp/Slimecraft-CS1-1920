/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortnite2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author 802811
 */
public class Yeeter extends Sprite {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 15;
    private int strength;
    
    
    
    public Yeeter (int speed, int x, int y, Color color) {
        super (speed, x, y, WIDTH, HEIGHT, color);
        this.strength = (int) (Math.random() * 20);
    }
    public void eat(Food food) {
        if(super.getBounds().intersects(food.getBounds()) && food.isAlive()) {
            super.setHeight(super.getHeight() + 5);
            super.setWidth(super.getWidth() + 5);
            food.die();
            
        }
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
    public void didWin (Yeeter other) {
        this.strength += this.strength - other.strength;
        super.grow(1.2);
    }
    public int getStrength() {
        return strength;
    }
    public void getSick(Corona corona) {
        if (super.getBounds().intersects(corona.getBounds())) {
        super.die();
        }
    }
    //public void didWin(Slime other) {
    //
    //}
}
