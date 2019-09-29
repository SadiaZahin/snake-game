/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snake.game.graphics;

import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import com.snake.game.graphics.Screen;

/**
 *
 * @author User
 */
public class MouseInput implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void mousePressed(MouseEvent e) {
        int mx=e.getX();
        int my=e.getY();
        int fla=0;
       /**
        
         public Rectangle playButton=new Rectangle(220+120,150,100,50);
         public Rectangle helpButton=new Rectangle(220+120,250,100,50);
          public Rectangle quitButton=new Rectangle(220+120,350,100,50);
        */
        
         if(mx>=220+120 && mx<=220+220)
        {
          if(my >=150 && my<= 200 )
          {
              //pressed play
             // System.out.println("game");
             Screen.State=Screen.STATE.GAME;
          
             
          }
        }
           if(mx>=220+120 && mx<=220+220)
        {
          if(my >=350 && my<= 400 )
          {
              //pressed play
              Screen s = new Screen();
              //System.out.println("LOAD");
              s.load();
               Screen.State=Screen.STATE.GAME;
              //System.out.println("LOAD");
              
              
          }
        }
            if(mx>=220+120 && mx<=220+220)
        {
          if(my >=250 && my<= 300 )
          {
              Screen x = new Screen();
              System.out.println("SAVED");
              //pressed play
              x.save();
             
          }
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
