/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

import java.awt.*;
import java.util.Map;

/**
 *
 * @author alaae
 */
public interface Shape {

    public void setPostion(Point postion);

    public Point getPostion();

    public void setProperties(Map<String, Double> properties);

    public Map<String, Double> getProperties();

    public void setColor(Color color);

    public Color getColor();

    public void setFillColor(Color color);

    public Color getFillColor();

    public void draw(java.awt.Graphics canvas);

}
