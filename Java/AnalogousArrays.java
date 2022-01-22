import java.util.ArrayList;
import java.util.List;

public class AnalogousArrays {
    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {

        int l = lowerBound, u = upperBound;
        int x = l;

        while(l < u) {
            boolean flag = true;
            int y = x;
            for(int i = 0; i < consecutiveDifference.size(); i++){
                y -= consecutiveDifference.get(i);
                if(y > upperBound || y < lowerBound){
                    flag = false;
                    break;
                }
            }

            if(flag){
                if(x == l){
                    x = u;
                } else {
                    break;
                }
            }

            if(x == l) {
                x = ++l;
            } else {
                x = --u;
            }
        }

        return u - l + 1;
    }

    public static void main(String[] args) {
        
        List<Integer> consecutiveDifference = new ArrayList<>();

        consecutiveDifference.add(-1);
        consecutiveDifference.add(-3);
        consecutiveDifference.add(2);
        // consecutiveDifference.add(5);
        // consecutiveDifference.add(16);
        
        System.out.println(countAnalogousArrays(consecutiveDifference, 2, 8));
    }
}
        
// for(int x = lowerBound; x <= upperBound; x++) {
//     boolean flag = true;
//     int y = x;
//     for(int i = 0; i < consecutiveDifference.size(); i++){
//         y -= consecutiveDifference.get(i);
//         if(y > upperBound || y < lowerBound){
//             flag = false;
//             break;
//         }
//     }

//     if(flag) count++;
// }

// return count;
