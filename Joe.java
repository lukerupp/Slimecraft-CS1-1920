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
public class Joe extends Yeeter {
    private static final int SPEED = 3;
    private static final Color COLOR = Color.RED;
    
    public Joe(int x, int y) {
        super(SPEED, x, y, COLOR);
    }
    public void fight(Yuri yuri) {
        if (super.collide(yuri)) {
            if (super.getStrength() >= yuri.getStrength()) {
                yuri.die();
                this.didWin(yuri);
            } else {
                this.die();
                yuri.didWin(this);
            }
        }
    }
    public Joe reproduce (Joe mate) {
        int newX = super.getX() + (int) (Math.random() * 10 - 5);
        int newY = super.getY() + (int) (Math.random() * 10 - 5);
        Joe baby = new Joe (newX, newY);
        return baby;
    }
}
