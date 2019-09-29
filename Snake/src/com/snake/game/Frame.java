
package com.snake.game;
import com.snake.game.graphics.MouseInput;
import java.awt.GridLayout;
import javax.swing.JFrame;
import com.snake.game.graphics.Screen;



public class Frame extends JFrame{
    
    public Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        
        init();
    }
    
    public void init(){
        
        setLayout(new GridLayout(1,1)); //parameter 0 0 removed
        
        
        this.addMouseListener(new MouseInput());
            
       
       
         
        Screen s = new Screen();
        add(s);
        
        pack();
         
        
        setLocationRelativeTo(null);
        setVisible(true);
        
        
    }
    public static void main(String[] args) {

        new Frame();
    }
             // Variables declaration - do not modify                     
        
}
