public class Q4 {
    static class Shape{
        public void Area(){
            System.out.println("Area is calculated.");
        }
    }
    static class Circle extends Shape{
        @Override
        public void Area(){
            System.out.println("Area is calculated for Circle.");
        }
    }
    static class Rectangle extends Shape{
        @Override
        public void Area(){
            System.out.println("Area is calculated for Rectangle.");
        }
    }

    public static void main(String[] args){
        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.Area();
        r.Area();
    }
}
