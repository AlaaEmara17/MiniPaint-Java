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

    public void setProperties(Map<String, Double> properties) {
        Point center;
        if (properties.containsKey("centerX") && properties.containsKey("centerY")) {
            center = new Point(properties.get("centerX").intValue(), properties.get("centerY").intValue());
            super.setPostion(center);
        }
        if (properties.containsKey("side")) {
            side = properties.get("side");
        }
    }

    public Map<String, Double> getProperties() {

        Map<String, Double> properties = new HashMap<>();
        properties.put("side", side);
        properties.put("centerX", (double) super.getPostion().x);
        properties.put("centerY", (double) super.getPostion().y);
        return properties;
    }

    public void draw(Graphics g) {

        int x = (int) (super.getPostion().x - side / 2);
        int y = (int) (super.getPostion().y - side / 2);
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
