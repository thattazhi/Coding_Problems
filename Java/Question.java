import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {

    public static List<Integer> chooseFleets(List<Integer> wheels) {
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 0);
        map.put(2, 1);
        map.put(4, 2);

        for(int i: wheels) {
            if(i % 2 == 1){
                ans.add(0);
                continue;
            }

            if(map.containsKey(i)){
                ans.add(map.get(i));
                continue;
            }

            int count = 0;

            int fourWheels = i;

            while(fourWheels >= 4){
                fourWheels -= 4;
                count++;
                
                if(map.containsKey(fourWheels)){
                    count += map.get(fourWheels);
                    break;
                }
            }

            map.put(i, count);
            ans.add(count);
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> wheels = new ArrayList<>();

        wheels.add(10);
        wheels.add(12);
        wheels.add(16);
        
        for(int i: chooseFleets(wheels)){
            System.out.println(i);
        }
    }
}
