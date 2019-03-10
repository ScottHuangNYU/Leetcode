package qianfeng;

public class StrategyPattern {
    public static void main(String[] args) {
        BasicSeriver user = new UserSeriver();
        user.setiSave(new CloudSave());
        user.save("hahah");
    }
}

// Strategy : save to file and save to cloud.
interface ISave{
    public void save(String data);
}

class FileSave implements ISave {
    public void save(String data){
        System.out.println("data have been saved to file" + data);
    }
}

class CloudSave implements ISave{
    public void save(String data){
        System.out.println("data have been saved to cloud" + data);
    }
}

abstract class BasicSeriver{

    private ISave iSave; //面向接口编程

    public void setiSave(ISave iSave) {
        this.iSave = iSave;
    }

    public void save(String data){
        iSave.save(data);
    }
}

class UserSeriver extends BasicSeriver{

}


