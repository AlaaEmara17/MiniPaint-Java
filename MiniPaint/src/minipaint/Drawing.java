/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minipaint;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author alaae
 */
public class Drawing implements DrawingEngine {

    private ArrayList<Shape> shapes = new ArrayList();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void refresh(java.awt.Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        float thick = 3.0f;
        g2d.setStroke(new BasicStroke(thick));
        for (Shape shape : shapes) {

            shape.draw(g2d);
        }
    }

    public Shape[] getShapes() {

        return shapes.toArray(new Shape[0]);
    }

}
