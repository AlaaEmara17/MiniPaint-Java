/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

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

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties map cannot be null");
        }
        
        // Validate that both coordinates are provided
       
        if ( properties.containsKey("centerX")&& properties.containsKey("centerY")) {
              Point center = new Point(properties.get("centerX").intValue(), properties.get("centerY").intValue());
              super.setPosition(center);
        
        }
        
        
        if (properties.containsKey("length")) {
            double lengthValue = properties.get("length");
            if (lengthValue < 0) {
                throw new IllegalArgumentException("Length cannot be negative: " + lengthValue);
            }
            length = lengthValue;
        }
        
        if (properties.containsKey("width")) {
            double widthValue = properties.get("width");
            if (widthValue < 0) {
                throw new IllegalArgumentException("Width cannot be negative: " + widthValue);
            }
            width = widthValue;
        }
    }

    @Override
    public void draw(java.awt.Graphics g) {
        Point position = super.getPosition();
        if (position == null) {
            return; // Cannot draw without position
        }
        
        int x = (int) (position.x - length / 2);
        int y = (int) (position.y - width / 2);
        
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
        
        Point position = super.getPosition();
        if (position != null) {
            properties.put("centerX", (double) position.x);
            properties.put("centerY", (double) position.y);
        }
        
        return properties;
    }
}