import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KeepTrucking {
    public boolean is_blocked(List<String> required_tasks, List<String> task_from, List<String> task_to) {
        Map<String, Integer> taskMap = new HashMap<>();
        Map<Integer, String> fromMap = new HashMap<>();
        Map<String, List<Integer>> toMap = new HashMap<>();

        for(String s: required_tasks) {
            taskMap.put(s, 0);
        }

        for(int i = 0; i < task_from.size(); i++) {
            fromMap.put(i, task_from.get(i));
            List<Integer> indices = toMap.getOrDefault(task_to.get(i), new ArrayList<>());
            indices.add(i);
            toMap.put(task_to.get(i), indices);
        }

        for(String task: required_tasks) {
            if(taskMap.get(task) == 0)
                visit(task, taskMap, fromMap, toMap);
        }

        for(String task: required_tasks) {
            if(taskMap.get(task) == 0)
                return true;
        }

        return false;
    }

    public boolean visit(String task, Map<String, Integer> taskMap, Map<Integer, String> fromMap, Map<String, List<Integer>> toMap) {
        if(taskMap.get(task) == 1) return true;

        if(!toMap.containsKey(task)) {
            taskMap.replace(task, 1);
            return true;
        }

        List<Integer> indices = toMap.get(task);

        for(int i = 0; i < indices.size(); i++) {
            if(indices.get(i) == -1) return false;

            String taskFrom = fromMap.get(indices.get(i));

            if(taskMap.containsKey(taskFrom)) {
                indices.set(i, -1);
                if(!visit(taskFrom, taskMap, fromMap, toMap))
                    return false;
            }
        }

        taskMap.replace(task, 1);
        return true;
    }

    public static void main(String[] args) {
        List<String> required_tasks = new ArrayList<>();
        List<String> tasks_from = new ArrayList<>();
        List<String> tasks_to = new ArrayList<>();
        
        required_tasks.add("get gas");
        required_tasks.add("drive");
        // required_tasks.add("load material");
        required_tasks.add("exit");
        
        tasks_from.add("get gas");
        tasks_from.add("drive");
        tasks_from.add("load material");
        tasks_from.add("exit");
        
        tasks_to.add("drive");
        tasks_to.add("exit");
        tasks_to.add("exit");
        tasks_to.add("load material");
        
        KeepTrucking kt = new KeepTrucking();
        System.out.println(kt.is_blocked(required_tasks, tasks_from, tasks_to));
    }
}