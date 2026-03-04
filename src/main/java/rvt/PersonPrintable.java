package rvt;

public class PersonPrintable implements Printable, Runnable { // Var implementot vairākus interfeisus vienā klasē
    public void method(){
        System.out.println("Random method");
    }
    
    @Override
    public void print() {
        System.out.println("Print() implemented in PersonPrintable class");
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
