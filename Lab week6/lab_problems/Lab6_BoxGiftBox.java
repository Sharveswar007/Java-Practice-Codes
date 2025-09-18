// LAB PROBLEM 6: Box and Gift Box Enhancement
class Box {
    public void pack() {
        System.out.println("Packing the box");
    }
    public void unpack() {
        System.out.println("Unpacking the box");
    }
}

class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Adding ribbon and wrapping for gift box");
    }
    @Override
    public void unpack() {
        super.unpack();
        System.out.println("Carefully removing gift wrapping");
    }
    public static void main(String[] args) {
        GiftBox gb = new GiftBox();
        gb.pack();
        gb.unpack();
    }
}
