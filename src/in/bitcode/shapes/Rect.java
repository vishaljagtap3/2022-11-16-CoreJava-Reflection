package in.bitcode.shapes;

public class Rect extends Shape {
    private int w, h;

    public Rect(int x, int y, int w, int h) {
        super(x, y);
        this.w = w;
        this.h = h;
    }

    @Override
    public void draw() {
        System.out.println(getX() + " " + getY() + " " + w + " " + h);
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
