package in.bitcode.shapes;

public class Circle extends Shape{
    private int r;

    public Circle() {
        this(0, 0, 0);
    }

    public Circle(int x, int y, int r) {
        super(x, y);
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println(getX() + " " + getY() + " " + r);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
}
