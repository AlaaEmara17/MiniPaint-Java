/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alaae
 */
public class Square extends Drawshape {

    private double side;

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
        
        if (properties.containsKey("side")) {
            double sideValue = properties.get("side");
            if (sideValue < 0) {
                throw new IllegalArgumentException("Side length cannot be negative: " + sideValue);
            }
            side = sideValue;
        }
    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        properties.put("side", side);
        
        Point position = super.getPosition();
        if (position != null) {
            properties.put("centerX", (double) position.x);
            properties.put("centerY", (double) position.y);
        }
        
        return properties;
    }

    @Override
    public void draw(Graphics g) {
        Point position = super.getPosition();
        if (position == null) {
            return; // Cannot draw without position
        }
        
        int x = (int) (position.x - side / 2);
        int y = (int) (position.y - side / 2);
        
        if (super.getFillColor() != null) {
            g.setColor(super.getFillColor());
            g.fillRect(x, y, (int) side, (int) side);
            g.setColor(super.getColor());
            g.drawRect(x, y, (int) side, (int) side);
        } else {
            g.setColor(super.getColor());
            g.drawRect(x, y, (int) side, (int) side);
        }
    }

}