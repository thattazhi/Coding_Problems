import java.util.HashMap;
import java.util.Map;

public class PoundsPence {
    public static void calculateChange(double purchasePrice, double cash) {
        Map<Double, String> map = new HashMap<>();

        map.put(0.01, "One Pence");
        map.put(0.02, "Two Pence");
        map.put(0.05, "Five Pence");
        map.put(0.1, "Ten Pence");
        map.put(0.2, "Twenty Pence");
        map.put(0.5, "Fifty Pence");
        map.put(1.0, "One Pound");
        map.put(2.0, "One Pound");
        map.put(5.0, "One Pound");
        map.put(10.0, "One Pound");
        map.put(20.0, "One Pound");
        map.put(50.0, "One Pound");

        if(purchasePrice > cash) {
            System.out.println("ERROR");
            return;
        }

        double change = cash - purchasePrice;

        double changes[] = new double[] {
            50.0, 20.0, 10.0, 5.0, 2.0, 1.0,
            0.5, 0.2, 0.1, 0.05, 0.02, 0.01
        };

        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (change > 0) {
            System.out.println(change);
            if(change >= changes[i]) {
                change -= changes[i];
                change = Math.round(change * 100.0) / 100.0;
                sb.append(map.get(changes[i]) + ", ");
                continue;
            }
            i++;
        }

        String ans = sb.toString();

        if(ans.charAt(ans.length() - 1) == ' ')
            ans = ans.substring(0, ans.length() - 2);
        
        System.out.println(ans);
    }

    public static void main(String[] args) {
        calculateChange(11.25, 20);
    }
}