/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author alaae
 */
public abstract class Drawshape implements Shape {

    private Point postion;
    private Color outline = Color.BLACK;
    private Color fill;

    public void setPostion(Point postion) {
        this.postion = postion;
    }

    public Point getPostion() {
        return postion;
    }

    public void setColor(Color color) {
        outline = color;
    }

    @Override
    public Color getColor() {
        return outline;
    }

    @Override
    public void setFillColor(Color color) {
        fill = color;

    }

    @Override
    public Color getFillColor() {
        return fill;
    }

}
