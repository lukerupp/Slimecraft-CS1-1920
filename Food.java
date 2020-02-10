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
public class Food extends Sprite {
     private static final int WIDTH = 10;
    private static final int HEIGHT = 5;
    private static final Color color = Color.GREEN;
    private static final int speed = 4;
    
    
    
    public Food (int x, int y) {
        super (speed, x, y, WIDTH, HEIGHT, color);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
