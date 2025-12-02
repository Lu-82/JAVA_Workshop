package Exercise;

 interface Shape {
    void draw();
}

 class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");

    }
}

 class Rectagle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangel");
    }
}

class DrawingTool {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}
public class InterfaceAsParameter {
    public static void main(String[] args) {
        DrawingTool tool = new DrawingTool();

        Shape circle = new Circle();
        Shape rectangle = new Rectagle();

        tool.drawShape(circle);
        tool.drawShape(rectangle);
    }
}
