/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fortnite2;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.TimerTask;
import javax.swing.JPanel;
import java.util.Timer;

/**
 *
 * @author 802811
 */
public class World extends JPanel {
    private ArrayList<Joe> joes = new ArrayList<>();    
    private ArrayList<Yuri> yuris = new ArrayList<>();    
    private ArrayList<Sprite> sprites = new ArrayList<>();
    private ArrayList<Food> foods = new ArrayList<>();
    private ArrayList<Yeeter> yeeters = new ArrayList<>();
    private ArrayList<Corona> coronas = new ArrayList<>();
    Timer timer;

    public World() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), 100, 1000/30);
        super.setSize(800, 600);
        for (int i = 0; i < 40; i++) {
            int x = (int) (Math.random() * 400);
            int y = (int) (Math.random() * 600);
            Joe joe = new Joe(x,y);
            yeeters.add(joe);
            sprites.add(joe);
            joes.add(joe);
        }
        for (int i = 0; i < 40; i++) {
            int x = (int) (Math.random() * 400) + 400;
            int y = (int) (Math.random() * 600);
            Yuri yuri = new Yuri(x,y);
            yeeters.add(yuri);
            sprites.add(yuri);
            yuris.add(yuri);
        }
        for (int i = 0; i < 80; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            Food food = new Food(x,y);
            foods.add(food);
            sprites.add(food);
        }
        for (int i = 0; i < 10; i++) {
            int x = (int) (Math.random() * 800);
            int y = (int) (Math.random() * 600);
            Corona corona = new Corona (x,y);
            coronas.add(corona);
            sprites.add(corona);
        }
    }
    //blob = joe glob = yuri 
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for (Yeeter yeeter : yeeters) {
            for (Food food : foods) {
                yeeter.eat(food);
            }
        }
    ArrayList<Joe> newJoes = new ArrayList<>();
    ArrayList<Yuri> newYuris = new ArrayList<>();
    
    for (Joe joe : joes) {
        for(Yuri yuri : yuris) {
            joe.fight(yuri);
        }
        //for (Joe otherJoe : joes) {
            //if (joe == otherJoe) continue;
            //if (joe.collide(otherJoe) && Math.random() < .01)
                //newJoes.add(joe.reproduce(otherJoe));
        //}
    //}
    //for (Yuri yuri : yuris) {
        //for (Yuri otherYuri : yuris) {
            //if (yuri == otherYuri) continue;
            //if (yuri.collide(otherYuri) && Math.random() < .05)
                //newYuris.add(yuri.reproduce(otherYuri));
        //}
    }
    for (Sprite sprite : sprites) {
        sprite.draw(g);
        sprite.update();
        sprite.collideWorldBounds(800, 600);
    }
    for (Yeeter yeeter : yeeters) {
        for (Corona corona : coronas) {
        yeeter.getSick(corona);
    }
    }
    for (Food food : foods){
        for (Corona corona : coronas) {
            food.infect(corona);
        }
    }
    

    takeOutTheTrash();
    addNewYeeters(newJoes, newYuris);
    }
    private void addNewYeeters (ArrayList<Joe> newJoes, ArrayList<Yuri> newYuris) {
        joes.addAll(newJoes);
        yuris.addAll(newYuris);
    }
    private void takeOutTheTrash() {
        ArrayList<Sprite> trash = new ArrayList<>();
        for (Sprite sprite : sprites) {
            if (!sprite.isAlive())
                trash.add(sprite);
        }
        sprites.removeAll(trash);
        trash.clear();
        for (Food food : foods) {
            if (!food.isAlive())
                trash.add(food);
        }
        foods.removeAll(trash);
        trash.clear();
        for (Joe joe : joes) {
            if (!joe.isAlive())
                trash.add(joe);
        }
        joes.removeAll(trash);
        trash.clear();
        for (Yuri yuri : yuris) {
            if (!yuri.isAlive())
                trash.add(yuri);
        }
        yuris.removeAll(trash);
        trash.clear();       
    }
    
    
    private class ScheduleTask extends TimerTask {
        @Override
        public void run() {
            repaint();
        }
    }
            
}
