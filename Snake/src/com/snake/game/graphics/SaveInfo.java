/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.snake.game.graphics;

import java.io.Serializable;

/**
 *
 * @author Sadia Zahin
 */
public class SaveInfo implements Serializable{
    
         int savex ,savey ,saves,savescore ;

    public int getSavex() {
        return savex;
    }

    @Override
    public String toString() {
        return "SaveInfo{" + "savex=" + savex + ", savey=" + savey + ", saves=" + saves + ", savescore=" + savescore + '}';
    }
    

    public SaveInfo() {
    }

    public int getSavey() {
        return savey;
    }

    public int getSaves() {
        return saves;
    }

    public int getSavescore() {
        return savescore;
    }

    public SaveInfo(int savex, int savey, int saves, int savescore) {
        this.savex = savex;
        this.savey = savey;
        this.saves = saves;
        this.savescore = savescore;
    }
         
}
