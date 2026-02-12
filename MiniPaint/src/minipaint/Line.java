/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

/**
 *
 * @author alaae
 */
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Line extends Drawshape {

    private double length;
    private double angle;

    public Point calculateEndPoint() {
        int endX = (int) (super.getPostion().x + length * Math.cos(Math.toRadians(angle)));
        int endY = (int) (super.getPostion().y + length * Math.sin(Math.toRadians(angle)));
        return new Point(endX, endY);
    }

    @Override
    public void setProperties(Map<String, Double> properties) {
        Point postion;
        if (properties.containsKey("length") && properties.containsKey("angle") && properties.containsKey("startX") && properties.containsKey("startY")) {
            length = properties.get("length");
            angle = properties.get("angle");
            postion = new Point(properties.get("startX").intValue(), properties.get("startY").intValue());
            super.setPostion(postion);
        }
    }

    @Override
    public Map<String, Double> getProperties() {
        Map<String, Double> properties = new HashMap<>();
        properties.put("length", length);
        properties.put("angle", angle);
        properties.put("startX", (double) super.getPostion().x);
        properties.put("startY", (double) super.getPostion().y);
        return properties;
    }

    @Override
    public void draw(Graphics g) {

        //super.setColor(super.getFillColor());
        if (super.getFillColor() != null) {
            g.setColor(super.getFillColor());
            Point endPoint = calculateEndPoint();
            g.drawLine(super.getPostion().x, super.getPostion().y, endPoint.x, endPoint.y);
        } else {
            g.setColor(super.getColor());
            Point endPoint = calculateEndPoint();
            g.drawLine(super.getPostion().x, super.getPostion().y, endPoint.x, endPoint.y);
        }
    }

}
