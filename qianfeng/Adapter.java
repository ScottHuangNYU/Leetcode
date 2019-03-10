package qianfeng;

public class Adapter {
    public static void main(String[] args) {
        PowerA powerA = new PowerAImpl();
        work(powerA);

        PowerB powerB = new PowerBImpl();
        Adapter1 adapter = new Adapter1(powerB);
        work(adapter);

    }

    public static void work(PowerA a) {
        a.insert();
    }
}

    //Adapter
    class Adapter1 implements PowerA{

        private PowerB powerB;
        public Adapter1(PowerB powerB){
            this.powerB = powerB;
        }
        public void insert(){
            powerB.connect();
        }
    }
    interface PowerA{
        public void insert();
    }
    class PowerAImpl implements PowerA{
        @Override
        public void insert() {
            System.out.println("power A is working");
        }
    }

    interface PowerB{
        public void connect();
    }
    class PowerBImpl implements PowerB {
        @Override
        public void connect() {
            System.out.println("power B is working");
        }
    }

