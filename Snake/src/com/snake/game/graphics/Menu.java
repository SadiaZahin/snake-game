/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snake.game.graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import static javafx.scene.paint.Color.color;

/**
 *
 * @author Sadia Zahin
 */
public class Menu {
    public Rectangle playButton=new Rectangle(220+120,150,100,50);
    public Rectangle helpButton=new Rectangle(220+120,250,100,50);
    public Rectangle quitButton=new Rectangle(220+120,350,100,50);
    public void render (Graphics g){
        Graphics2D g2d=(Graphics2D)g;
        Font fnt0=new Font("arial",Font.BOLD,50);
                g.setFont(fnt0);
                g.setColor(Color.green);
                g.drawString("Snake Game", 260, 100);
                
                Font fnt1=new Font("arial",Font.BOLD,30);
                g.setFont(fnt1);
                g.drawString("Play", playButton.x+19,playButton.y+30);
                g.drawString("Save", helpButton.x+19,helpButton.y+30);
                g.drawString("Load", quitButton.x+19,quitButton.y+30);
               
                g2d.draw(playButton);
                g2d.draw(helpButton);
                g2d.draw(quitButton);
                
        
    }    
}
