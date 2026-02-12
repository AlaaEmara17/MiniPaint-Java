package minipaint;

import java.awt.Color;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author alaae
 */
public abstract class Drawshape implements Shape {

    private Point position;
    private Color outline = Color.BLACK;
    private Color fill;

    @Override
      public void setPosition(Point position) {
        if (position == null) {
            throw new IllegalArgumentException("Position cannot be null");
            
        }
        // Defensive copy to prevent external modification
        this.position = new Point(position);
    }

    @Override
    public Point getPosition() {
        if (position == null) {
            return null;
        }
        // Defensive copy to prevent external modification
        return new Point(position);
    }

    @Override
    public void setColor(Color color) {
        if (color == null) {
            throw new IllegalArgumentException("Color cannot be null");
        }
        outline = color;
    }

    @Override
    public Color getColor() {
        return outline;
    }

    @Override
    public void setFillColor(Color color) {
        fill = color;
    }

    @Override
    public Color getFillColor() {
        return fill;
    }

}
