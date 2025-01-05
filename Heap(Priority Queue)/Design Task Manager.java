/*

*/

class TaskManager {

    class Task{
        int userId;
        int taskId;
        long priority;
        boolean removed;
        Task(int u, int t, long p){
            this.userId = u;
            this.taskId = t;
            this.priority = p;
            removed = false;
        }

    }

    PriorityQueue<Task> taskQueue;
    Map<Integer, Task> taskMap;

    public TaskManager(List<List<Integer>> tasks) {
        
        taskQueue = new PriorityQueue<>((a,b)->{
            if(a.priority != b.priority){
                return Long.compare(b.priority, a.priority);
            }
            return Integer.compare(b.taskId, a.taskId);
        });

        taskMap = new HashMap<>();

        for(List<Integer> triple : tasks){
            add(triple.get(0), triple.get(1), triple.get(2));
        }
    }
    
    public void add(int userId, int taskId, int priority) {
        
        Task newData = new Task(userId, taskId, priority);
        taskQueue.add(newData);
        taskMap.put(taskId, newData);
    }
    
    public void edit(int taskId, int newPriority) {
        
        Task oldData = taskMap.get(taskId);
        oldData.removed = true;

        Task newData = new Task(oldData.userId, oldData.taskId, newPriority);
        taskMap.put(taskId, newData);
        taskQueue.add(newData);
    }
    
    public void rmv(int taskId) {
        
        Task data = taskMap.get(taskId);
        data.removed = true;
        taskMap.remove(taskId);
    }
    
    public int execTop() {
        
        while(!taskQueue.isEmpty()){
            Task top = taskQueue.peek();

            if(top.removed == false){

                taskQueue.poll();
                top.removed = true;
                taskMap.remove(top.taskId);
                return top.userId;
            }

            taskQueue.poll();
        }

        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */
