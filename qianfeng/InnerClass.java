package qianfeng;

public class InnerClass {
    public static void main(String[] args){
        Outer outer = new Outer();
        //Outer.Inner inner = outer.new Inner();
        //inner.print();
        outer.innerPrint();
    }
}

class Outer{
    private String name;

    //---------member inner class--------
    public void innerPrint(){
        Inner inner = new Inner();
        inner.print();
    }
    //member inner class
    private class Inner{
        public void print(){
            System.out.println("inner");
        }
    }


    //---------method inner class--------
    // method inner class: only can be instantiation in the method which it belong to
    public void show(){

        class Inner2{
            public void print(){
                System.out.println("method inner class");
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.print();
    }
}