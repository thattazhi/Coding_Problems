import java.util.Map;
import java.util.TreeMap;

public class ManageShares {
    public static void matchBenchmark(String input) {
        String x = input.split(":")[0];
        String y = input.split(":")[1];

        Map<String, Integer> portfolioMap = new TreeMap<>();
        Map<String, Integer> benchmarkMap = new TreeMap<>();

        String portfolio[] = x.split("\\|");

        for(String str: portfolio) {
            String details[] = str.split(",");

            portfolioMap.put(details[0] + "," +  details[1], Integer.parseInt(details[2]));
        }

        String benchmark[] = y.split("\\|");

        for(String str: benchmark) {
            String details[] = str.split(",");

            benchmarkMap.put(details[0] + "," +  details[1], Integer.parseInt(details[2]));
        }
        
        for(Map.Entry<String, Integer> entry: benchmarkMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();

            int difference = value - portfolioMap.getOrDefault(key, 0);

            if(difference < 0) {
                difference = -1 * difference;
                System.out.println("SELL," + key + "," + difference);
            }

            else if(difference > 0) {
                System.out.println("BUY," + key + "," + difference);
            }
        }
    }

    public static void main(String[] args) {
        matchBenchmark("Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10");
    }
}