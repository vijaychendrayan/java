import sun.security.provider.SHA;

/**
 * Created by VC024129 on 5/4/2017.
 */

interface Shape{
    void draw();
}


class Rectangle implements Shape{
    public void draw(){
        System.out.println("In Rectangle");
    }
}

class Circle implements  Shape{
    public  void draw(){
        System.out.println("In Circle");

    }
}
class  Square implements Shape{
    public void draw(){
        System.out.println("In Squre");
    }
}

class ShapeFactory{
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equals("CIRCLE")){
            return new Circle();
        }
        if(shapeType.equals("SQURE")){
            return new Square();
        }
        if(shapeType.equals("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}
public class FactoryClassDemo {

    public static void main(String []args){
        ShapeFactory shape = new ShapeFactory();
        Shape shape1 = shape.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shape.getShape("RECTANGLE");
        shape2.draw();
        Shape shape3 = shape.getShape("SQURE");
        shape3.draw();
    }

}

