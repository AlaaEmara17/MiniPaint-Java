/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package minipaint;

/**
 *
 * @author alaae
 */
public interface DrawingEngine {

    public void addShape(Shape shape);

    public void removeShape(Shape shape);

    public Shape[] getShapes();

    public void refresh(java.awt.Graphics canvas);

}
