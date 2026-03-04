package rvt.boxInterface;

public class Box implements Packable{
    double maxCapacity;
    double totalWeight = 0;
    int itemsAmount = 0;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public void add(Packable item){
        if(this.totalWeight + item.weight() < this.maxCapacity){
            this.totalWeight += item.weight();
            this.itemsAmount += 1;
            return;
        }
        System.out.println("Box is overloaded");
    }

    @Override
    public String toString() {
        return "Box:" + this.itemsAmount + " items, total weight " + this.totalWeight + " kg"; 
    }

    @Override
    public double weight() {
        return this.totalWeight;
    }
    
}
