package rvt;
import java.util.HashMap;

public class IOU {
    HashMap<String, Double> ownedTable = new HashMap();

    public void setSum(String toWhom, double amount){
        ownedTable.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom){
        return ownedTable.get(toWhom);
    }

    public static void main(String[] args) {
        IOU mattsIOU = new IOU();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Arthur", 10.5);
            
        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
    }
}
