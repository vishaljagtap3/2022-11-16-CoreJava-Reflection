import in.bitcode.shapes.Circle;
import in.bitcode.shapes.Rect;
import in.bitcode.shapes.Shape;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        //1
        /*Class c = Shape.class;
        printClassInfo(Shape.class);
        printClassInfo(Circle.class);
        printClassInfo(Rect.class);
        printClassInfo(Product.class);
        printClassInfo(ISO.class);*/


        //3
        try {
            Circle c1 = Circle.class.newInstance();
            Circle c2 = Circle.class.getConstructor().newInstance();
            c1.draw();
            c2.draw();

            Circle c3 = Circle.class.getConstructor(
                    new Class[] { int.class, int.class, int.class}
            ).newInstance( new Object[] { 330, 300, 300});
            c3.draw();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //2
        Product product1 = new Product(101, "Laptop", 10000);
        Product product2 = new Product(202, "Projector", 10000);

        Class classInfoOfProduct = Product.class;
        classInfoOfProduct = product1.getClass();

        System.out.println();
        int choice = 1;
        Object obj;
        switch(choice) {
            case 1:
                obj  = new Circle(100, 100,100);
                break;
            case 2:
                obj = new Rect(10, 10,10, 10);
                break;
            default:
                obj = new Product(11, "NA", 111);
        }

        //if(obj instanceof Circle) {
        System.out.println();
        //if( obj.getClass().getName().equals("in.bitcode.shapes.Circle") ) {
        if( obj.getClass().getName().equals(Circle.class.getName()) ) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }

        try {

            Method methodDisplay = Product.class.getMethod("display", null);
            methodDisplay.invoke(product1);
            methodDisplay.invoke(product2);

            System.out.println();

            Class [] parametersTypes = new Class[3];
            parametersTypes[0] = int.class;
            parametersTypes[1] = String.class;
            parametersTypes[2] = int.class;

            Method methodUpdate = Product.class.getMethod(
                    "update",
                    parametersTypes
            );

            Object [] arguments = new Object[3];
            arguments[0] = 303;
            arguments[1] = "New Laptop";
            arguments[2] = 45000;
            methodUpdate.invoke(
                    product1,
                    arguments
            );

            methodDisplay.invoke(product1);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static void printClassInfo(Class c) {
        System.out.println("name: " + c.getName());
        System.out.println("Package name: " + c.getPackageName());
        System.out.println("Is Array: " + c.isArray());
        System.out.println("Is interface: " + c.isInterface());

        System.out.println("Methods");
        Method [] methods = c.getMethods();
        for(Method m : methods) {
            Class retTypeInfo = m.getReturnType();
            System.out.print( retTypeInfo.getName());
            System.out.print(" " + m.getName() + "(");

            Parameter [] parameters = m.getParameters();
            for(Parameter p : parameters) {
                Class argTypeInfo = p.getType();
                System.out.print(argTypeInfo.getName() + " " + p.getName() + ", ");
            }

            System.out.println(")");
        }

        System.out.println("*** constructors ***");
        Constructor [] constructors = c.getConstructors();
        for(Constructor cons : constructors) {
            System.out.print(cons.getName() + " ( ");
            Parameter [] parameters = cons.getParameters();
            for(Parameter p : parameters) {
                Class argTypeInfo = p.getType();
                System.out.print(argTypeInfo.getName() + " " + p.getName() + ", ");
            }
            System.out.println(")");
        }

        System.out.println("*** Fields ***");
        Field [] fields = c.getFields();
        for(Field field : fields) {
            System.out.println(field.getType().getName()  + " " + field.getName());
        }


        System.out.println("-------------------------------------------");
    }
}
