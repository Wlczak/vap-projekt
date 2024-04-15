package me.projekt.game.levels;

import me.projekt.game.main.Game;
import me.projekt.game.objects.destroyable.GameContainer;
import me.projekt.game.objects.pickable.Potion;
import me.projekt.game.utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static me.projekt.game.utils.Utils.getPlayerSpawnFromImage;

public class Level {

    private BufferedImage img;
    private int[][] lvlData;
    //    private ArrayList<Slime> slimes;
    private ArrayList<Potion> potions;
    private ArrayList<GameContainer> containers;

    private int lvlTilesWide;
    private int maxTilesOffsetX;
    private int maxLvlOffsetX;

    private int lvlTilesHigh;
    private int maxTilesOffsetY;
    private int maxLvlOffsetY;

    private Point spawn;

    public Level(BufferedImage img) {
        this.img = img;
        setLevelData();
        //setEnemies();
        setPotions();
        setContainers();
        setLevelOffsets();
        setPlayerSpawn();
    }


    private void setPotions() {
        this.potions = Utils.getPotionsFromImage(img);
    }

    private void setContainers() {
        this.containers = Utils.getContainersFromImage(img);
    }

    private void setLevelData() {
        this.lvlData = Utils.getLevelDataFromImage(img);
    }

    private void setPlayerSpawn() {
        this.spawn = getPlayerSpawnFromImage(img);
    }

    private void addEnemies() {

    }

    private void setLevelOffsets() {
        lvlTilesWide = img.getWidth();
        maxTilesOffsetX = lvlTilesWide - Game.TILES_IN_WIDTH;
        maxLvlOffsetX = Game.TILES_SIZE * maxTilesOffsetX;

        lvlTilesHigh = img.getHeight();
        maxTilesOffsetY = lvlTilesHigh - Game.TILES_IN_HEIGHT;
        maxLvlOffsetY = Game.TILES_SIZE * maxTilesOffsetY;
    }

    public int getSpriteIndex(int x, int y) {
        return lvlData[y][x];
    }

    public int[][] getLevelData() {
        return this.lvlData;
    }

    public int getMaxLvlOffsetX() {
        return this.maxLvlOffsetX;
    }

    public int getMaxLvlOffsetY() {
        return this.maxLvlOffsetY;
    }

    public Point getSpawn() {
        return this.spawn;
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public ArrayList<GameContainer> getContainers() {
        return containers;
    }
}
