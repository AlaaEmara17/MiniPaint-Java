# MiniPaint - Vector Drawing Application

**MiniPaint** is a lightweight, Java-based vector drawing application built using **Java Swing** and **AWT**. It allows users to create, manipulate, and persist geometric shapes on a digital canvas. The project demonstrates core Object-Oriented Programming (OOP) principles such as inheritance, polymorphism, and interface-driven design.

---

## Features

### 1. Shape Creation
* **Geometric Primitives:** Draw Circles, Line Segments, Squares, and Rectangles.
* **Coordinate-Based Input:** Precisely place shapes by entering specific X/Y coordinates and dimensions (radius, side length, etc.) via dialog boxes.

### 2. Shape Manipulation
* **Colorize:** Independently set the **Fill Color** and **Outline Color** for any selected shape using a custom color selection interface.
* **Move:** Relocate existing shapes to new coordinates without changing their dimensions.
* **Resize:** Dynamically adjust the size (e.g., radius of a circle or length/angle of a line) after the shape has been created.
* **Delete:** Remove specific shapes from the canvas and the management list.

### 3. Management & Persistence
* **Shape Selection:** A dedicated `JComboBox` tracks all active shapes by name (e.g., "Circle 1", "Rectangle 2").
* **Save/Load:** Export your canvas to a text file and reload it later. The application uses **Regex-based parsing** to reconstruct shape properties and colors exactly as they were saved.

---

## Technical Architecture

The project is structured to be highly extensible through the use of interfaces and abstract classes:

| Component | Responsibility |
| :--- | :--- |
| **`Shape`** | Core interface defining the contract for all drawable objects. |
| **`Drawshape`** | Abstract class implementing common logic for position and color. |
| **`DrawingEngine`** | Interface for managing the collection of shapes and the canvas refresh. |
| **`Drawing`** | Concrete implementation that manages the shape list and handles rendering. |
| **`Draw` (GUI)** | The main JFrame handling user events, buttons, and the rendering panel. |

---

## Installation & Setup

### Prerequisites
* **Java Development Kit (JDK) 8** or higher.
* An IDE (NetBeans is recommended) or a terminal.

### Running the Application
1. **Clone or Copy** the source files into a folder named `minipaint`.
2. **Compile** the package:
   ```bash
   javac minipaint/*.java
   ```
Run the application:

Bash
```
java minipaint.Draw
 ```

### How to Use
1. **Adding a Shape**: Click one of the top buttons (e.g., "Circle"). Enter dimensions and center coordinates in the pop-up (e.g., 100,100).

2. **Selecting a Shape**: Use the dropdown menu on the left to select which shape you want to modify.

3. **Coloring**: Select a shape, click Colorize, and choose colors for both the border and the interior.

4. **Editing**: Use the Move and Resize buttons to modify the selected shape's properties.

5. **Saving Your Work**: Click Save to choose a file destination and export the current state.

Use **Load** to import a previously saved session.

## Persistence Format
The application saves data in a human-readable text format:

```ShapeName{centerX=..., centerY=..., property=...}java.awt.Color[r=...,g=...,b=...]```