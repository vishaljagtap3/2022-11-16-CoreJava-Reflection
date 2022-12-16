import in.bitcode.shapes.Circle;
import in.bitcode.shapes.Rect;
import in.bitcode.shapes.Shape;

public class Main {
    public static void main(String[] args) {
        Class c = Shape.class;
        printClassInfo(Shape.class);
        printClassInfo(Circle.class);
        printClassInfo(Rect.class);
        printClassInfo(Product.class);
        printClassInfo(ISO.class);
    }

    public static void printClassInfo(Class c) {
        System.out.println("name: " + c.getName());
        System.out.println("Package name: " + c.getPackageName());
        System.out.println("Is Array: " + c.isArray());
        System.out.println("Is interface: " + c.isInterface());
        System.out.println("-------------------------------------------");
    }
}
