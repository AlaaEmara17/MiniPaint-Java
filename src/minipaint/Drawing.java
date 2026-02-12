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

    // Configurable constants instead of magic numbers
    public static final float DEFAULT_STROKE_THICKNESS = 3.0f;
    public static final String DEFAULT_FONT_NAME = "Arial";
    public static final int DEFAULT_FONT_STYLE = Font.PLAIN;
    public static final int DEFAULT_FONT_SIZE = 12;

    private ArrayList<Shape> shapes = new ArrayList<>();
    private float strokeThickness = DEFAULT_STROKE_THICKNESS;
    private Font font = new Font(DEFAULT_FONT_NAME, DEFAULT_FONT_STYLE, DEFAULT_FONT_SIZE);

    @Override
    public void addShape(Shape shape) {
        if (shape == null) {
            throw new IllegalArgumentException("Cannot add null shape");
        }
        shapes.add(shape);
    }

    @Override
    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    @Override
    public void refresh(java.awt.Graphics g) {
        if (g == null) {
            return;
        }
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(font);
        g2d.setStroke(new BasicStroke(strokeThickness));
        
        for (Shape shape : shapes) {
            shape.draw(g2d);
        }
    }

    @Override
    public Shape[] getShapes() {
        return shapes.toArray(new Shape[0]);
    }

    /**
     * Set the stroke thickness for drawing shapes
     * @param thickness the stroke thickness (must be positive)
     */
    public void setStrokeThickness(float thickness) {
        if (thickness <= 0) {
            throw new IllegalArgumentException("Stroke thickness must be positive: " + thickness);
        }
        this.strokeThickness = thickness;
    }

    /**
     * Get the current stroke thickness
     * @return the current stroke thickness
     */
    public float getStrokeThickness() {
        return strokeThickness;
    }

    /**
     * Set the font for text rendering
     * @param font the font to use (cannot be null)
     */
    public void setFont(Font font) {
        if (font == null) {
            throw new IllegalArgumentException("Font cannot be null");
        }
        this.font = font;
    }

    /**
     * Get the current font
     * @return the current font
     */
    public Font getFont() {
        return font;
    }

}
