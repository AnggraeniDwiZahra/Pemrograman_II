package soal1;

public class Cylinder extends Shape{
	private double radius;
    private double height;

    public Cylinder(double r, double h) {
        super("Cylinder");
        radius = r;
        height = h;
    }

    protected double area() {
        return 2 * Math.PI * radius * (height + radius);
    }
    
    public String toString() {
        return super.toString() + " with radius " + radius + " and height " + height;
    }
}
