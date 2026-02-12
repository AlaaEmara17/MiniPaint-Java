/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

import java.awt.*;
import java.util.*;

/**
 *
 * @author alaae
 */
public class Circle extends Drawshape {

    private double raduis;

    public void setProperties(Map<String, Double> properties) {
        Point center;
        if (properties.containsKey("raduis") && properties.containsKey("centerX") && properties.containsKey("centerY")) {
            raduis = properties.get("raduis");
            center = new Point(properties.get("centerX").intValue(), properties.get("centerY").intValue());
            super.setPostion(center);
        }
    }

    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        properties.put("raduis", raduis);
        return properties;
    }

    public void draw(java.awt.Graphics g) {
        int x = (int) (super.getPostion().x - raduis);
        int y = (int) (super.getPostion().y - raduis);
        int diameter = (int) (2 * raduis);
        if (super.getFillColor() != null) {
            g.setColor(super.getFillColor());
            g.fillOval(x, y, diameter, diameter);
            g.setColor(super.getColor());
            g.drawOval(x, y, diameter, diameter);

        } else {
            g.setColor(super.getColor());
            g.drawOval(x, y, diameter, diameter);
        }
    }

}
