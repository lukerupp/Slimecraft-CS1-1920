/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortnite2;

import java.awt.Color;

/**
 *
 * @author 802811
 */
public class Yuri extends Yeeter {
    private static final int SPEED = 3; 
    private static final Color COLOR = Color.BLUE;
    
    public Yuri(int x, int y) {
        super(SPEED, x, y, COLOR);
    }
    public Yuri reproduce(Yuri mate) {
        int newX = super.getX() + (int) (Math.random() * 30 - 15);
        int newY = super.getY() + (int) (Math.random() * 30 - 15);
        Yuri baby = new Yuri (newX, newY);
        return baby;
    }
}
