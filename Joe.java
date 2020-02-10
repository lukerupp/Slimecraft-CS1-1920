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
}
