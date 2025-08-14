public class Q3 {
    class test{
        private int a = 10;
        void showValue(){
            System.out.println("Value of a: " + a);
        }
        void setValue(int value) {
            a = value;
        }
    }
    public static void main(String[] args) {
        Q3 obj = new Q3();
        test inner = obj.new test();
        System.out.println("Initial value of a:");
        inner.showValue();
        inner.setValue(20);
        System.out.println("Updated value of a:");
        inner.showValue();

    }
}

