package ipsyOA;

public abstract class Animals {
    boolean isMammal;
    boolean isCarnivorous;

    public Animals(boolean isMammal, boolean isCarnivorous){
        this.isMammal = isMammal;
        this.isCarnivorous = isCarnivorous;
    }

    public boolean getIsMammal(){
        return isMammal;
    }
    public boolean getIsCarnivorous(){
        return isCarnivorous;
    }

    abstract String getGreeting();
}
