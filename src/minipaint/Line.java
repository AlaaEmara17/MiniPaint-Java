/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;


/**
 *
 * @author alaae
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Line extends Drawshape {

    private double length;
    private double angle;

    public Point calculateEndPoint() {
        Point position = super.getPosition();
        if (position == null) {
            return null;
        }
        
        int endX = (int) (position.x + length * Math.cos(Math.toRadians(angle)));
        int endY = (int) (position.y + length * Math.sin(Math.toRadians(angle)));
        return new Point(endX, endY);
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties map cannot be null");
        }
        
       
        if (properties.containsKey("centerX")&&  properties.containsKey("centerY")) {
         Point position = new Point(properties.get("centerX").intValue(), properties.get("centerY").intValue());
        super.setPosition(position);
        }
       
        
        if (properties.containsKey("angle")) {
            double angleValue = properties.get("angle");
            // Normalize angle to 0-360 range
            angle = angleValue % 360;
            if (angle < 0) {
                angle += 360;
            }
        }
        
        if (properties.containsKey("length")) {
            double lengthValue = properties.get("length");
            if (lengthValue < 0) {
                throw new IllegalArgumentException("Length cannot be negative: " + lengthValue);
            }
            length = lengthValue;
        }
    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        properties.put("length", length);
        properties.put("angle", angle);
        
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
        
        Point endPoint = calculateEndPoint();
        if (endPoint == null) {
            return; // Cannot draw without valid endpoint
        }
        
        // Use fill color if available, otherwise use outline color
        if (super.getFillColor() != null) {
            g.setColor(super.getFillColor());
        } else {
            g.setColor(super.getColor());
        }
        
        g.drawLine(position.x, position.y, endPoint.x, endPoint.y);
    }

}