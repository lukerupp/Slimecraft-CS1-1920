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
    private static final Color color = Color.GREEN;
     private static final int WIDTH = 5;
    private static final int HEIGHT = 5;
    private static final int speed = 0;
   

    
    
    
    public Food (int x, int y) {
        super (speed, x, y, WIDTH, HEIGHT, color);
    }
    public Corona infect (Corona corona) {
        if (corona.getBounds().intersects(this.getBounds())) this.die();
            int newX = this.getX();
            int newY = this.getY();
            Corona infectedFood = new Corona (newX, newY);
            return infectedFood;
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getX(), super.getY(), super.getWidth(), super.getHeight());
    }
}
