import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceNameSystem {
    public static List<String> deviceNameSystem(List<String> devicenames) {
        Map<String, Integer> map = new HashMap<>();
        List<String> finalnames = new ArrayList<>();

        for(String device: devicenames) {
            map.put(device, map.getOrDefault(device, 0) + 1);
            String name = device;

            if(map.get(device) != 1) {
                name = device + (map.get(device) - 1);
            }

            finalnames.add(name);
        }
        return finalnames;
    }

    public static void main(String[] args) {
        List<String> devicenames = new ArrayList<>();

        // devicenames.add("switch");
        devicenames.add("lamp");
        devicenames.add("lamp");
        devicenames.add("tv");
        devicenames.add("lamp");
        // devicenames.add("tv");
        // devicenames.add("switch");
        // devicenames.add("tv");

        List<String> finalnames = deviceNameSystem(devicenames);

        System.out.println(finalnames);
    }
}