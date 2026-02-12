/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alaae
 */
public class Rectangle extends Drawshape {

    private double length;
    private double width;

    public void setProperties(Map<String, Double> properties) {
        Point center;
        if (properties.containsKey("length") && properties.containsKey("width")) {
            length = properties.get("length");
            width = properties.get("width");
        }
        if (properties.containsKey("centerX") && properties.containsKey("centerY")) {
            center = new Point(properties.get("centerX").intValue(), properties.get("centerY").intValue());
            super.setPostion(center);
        }

    }

    public void draw(java.awt.Graphics g) {

        int x = (int) (super.getPostion().x - length / 2);
        int y = (int) (super.getPostion().y - width / 2);
        if (super.getFillColor() != null) {
            g.setColor(super.getFillColor());
            g.fillRect(x, y, (int) length, (int) width);
            g.setColor(super.getColor());
            g.drawRect(x, y, (int) length, (int) width);
        } else {
            g.setColor(super.getColor());
            g.drawRect(x, y, (int) length, (int) width);
        }

    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        properties.put("length", length);
        properties.put("width", width);
        properties.put("centerX", (double) super.getPostion().x);
        properties.put("centerY", (double) super.getPostion().y);
        return properties;

    }
}
