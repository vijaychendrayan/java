/**
 * Created by VC024129 on 5/4/2017.
 */


interface Color{
    public void fill();
}


class Red implements Color{
    public void fill(){
        System.out.println("Red::fill");
    }
}

class Green implements Color{
    public void fill(){
        System.out.println("Green::fill");
    }
}

class Blue implements Color{
    public void fill(){
        System.out.println("Blue:fill");
    }
}

abstract class AbstractFactory{
    abstract Color getColor(String colorType);
    abstract Shape getShape(String shapeType);
}


class ShapeFactory1 extends AbstractFactory{
    public Shape getShape(String shapeType){
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equals("CIRCLE")){
            return new Circle();
        }
        if (shapeType.equals("RECTANGLE")){
            return new Rectangle();
        }
        if (shapeType.equals("SQUARE")){
            return new Square();
        }
        return null;
    }
    public Color getColor(String colorType){
        return null;
    }

}

class  ColorFactory extends AbstractFactory{
    public Shape getShape(String shapeType){
        return null;
    }

    public Color getColor(String colorType){
        if(colorType== null){
            return null;
        }
        if(colorType.equals("RED")){
            return new Red();
        }
        if(colorType.equals("GREEN")){
            return new Green();
        }
        if(colorType.equals("BLUE")){
            return new Blue();
        }
        return null;
    }
}

class FactoryProducer{
    public static AbstractFactory getFactory(String choice){
        if(choice.equals("SHAPE")){
            return new ShapeFactory1();
        }
        if(choice.equals("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
public class AbstractFactoryPatternDemo {
    public static void main(String []args){
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("SQUARE");
        shape2.draw();
        Shape shape3 = shapeFactory.getShape("RECTANGLE");
        shape3.draw();
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color = colorFactory.getColor("BLUE");
        color.fill();
        Color color2 = colorFactory.getColor("GREEN");
        color2.fill();
        Color color3 = colorFactory.getColor("RED");
        color3.fill();
    }
}
