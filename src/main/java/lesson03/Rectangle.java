package lesson03;

public class Rectangle {

    final private double length;
    final private double width;

    public Rectangle(double length, double width) {
        if (length <= 0 || width <= 0) {
            throw new IllegalArgumentException("Rectangle sides must be positive");
        }

        this.length = length;
        this.width = width;
    }


    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double calculateSquare() {
        return length * width;
    }

    public double calculatePerimeter() {
        return 2 * (length + width);
    }
}
