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

    private double radius;

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties map cannot be null");
        }
        
        // Validate that both coordinates are provided
        boolean hasX = properties.containsKey("centerX");
        boolean hasY = properties.containsKey("centerY");
        
        if (hasX && !hasY) {
            throw new IllegalArgumentException("Missing centerY coordinate. Both centerX and centerY are required.");
        }
        if (!hasX && hasY) {
            throw new IllegalArgumentException("Missing centerX coordinate. Both centerX and centerY are required.");
        }
        if (!hasX && !hasY) {
            throw new IllegalArgumentException("Missing center coordinates. Both centerX and centerY are required.");
        }
        
        // Set position - we now know both coordinates exist
        Point center = new Point(properties.get("centerX").intValue(), properties.get("centerY").intValue());
        super.setPosition(center);
        
        if (properties.containsKey("radius")) {
            double radiusValue = properties.get("radius");
            if (radiusValue < 0) {
                throw new IllegalArgumentException("Radius cannot be negative: " + radiusValue);
            }
            radius = radiusValue;
        }
    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        
        Point position = super.getPosition();
        if (position != null) {
            properties.put("centerX", (double) position.x);
            properties.put("centerY", (double) position.y);
        }
        properties.put("radius", radius);
        
        return properties;
    }

    @Override
    public void draw(java.awt.Graphics g) {
        Point position = super.getPosition();
        if (position == null) {
            return; // Cannot draw without position
        }
        
        int x = (int) (position.x - radius);
        int y = (int) (position.y - radius);
        int diameter = (int) (2 * radius);
        
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