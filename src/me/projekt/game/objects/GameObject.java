package me.projekt.game.objects;

import me.projekt.game.main.Game;
import me.projekt.game.utils.Constants;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GameObject {

    protected int x,y;
    protected ObjectType objectType;
    protected Rectangle2D.Float hitbox;
    protected boolean doAnimation, active = true;
    protected int animTick, animIndex;

    protected int xDrawOffset, yDrawOffset;

    public GameObject(int x, int y, ObjectType objectType) {
        this.x = x;
        this.y = y;
        this.objectType = objectType;
    }

    protected void updateAnimationTick() {
        animTick++;
        if (animTick >= Constants.ANIMATION_SPEED) {
            animTick = 0;
            animIndex++;
            if (animIndex >= objectType.getSpriteAmount()) {
                animIndex = 0;
                if (objectType == ObjectType.BARREL || objectType == ObjectType.BOX) {
                    doAnimation = false;
                    active = false;
                }
            }
        }
    }

    protected void initHitbox(int width, int height) {
        hitbox = new Rectangle2D.Float(x, y, (int) (width * Game.SCALE), (int) (height * Game.SCALE));
    }

    public void drawHitbox(Graphics g, int xLvlOffset, int yLvlOffset) {
        // for debugging hitbox
        g.setColor(Color.PINK);
        g.drawRect((int) hitbox.x - xLvlOffset, (int) hitbox.y - yLvlOffset, (int) hitbox.width, (int) hitbox.height);
    }

    public void reset() {
        animIndex = 0;
        animTick = 0;
        active = true;

        if (objectType == ObjectType.BARREL || objectType == ObjectType.BOX) {
            doAnimation = false;
        } else {
            doAnimation = true;
        }
    }

    public void setAction(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }

    public boolean doAnimation() {
        return doAnimation;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public int getXDrawOffset() {
        return xDrawOffset;
    }

    public int getYDrawOffset() {
        return yDrawOffset;
    }
}