import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class TaskManager implements Serializable{
    private static final long serialVersion = 1L;
    private List<Task> tasks;
    private String taskFilePath;
    private int nextId;


    public TaskManager(String taskFilePath){
        this.taskFilePath = taskFilePath;
        this.tasks = new ArrayList<>();
        this.nextId = 1;
        loadTasks();
    }
    public void addTask(Task task){
        task.setId(nextId);
        nextId++;
        tasks.add(task);
        saveTasks();
    }

    public boolean deleteTask(int id){
        for(int i = 0; i< tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.remove(i);
                saveTasks();
                return true;
            }
        }
        return false;
    }

    public boolean completeTask(int id){
        for(int i = 0; i < tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                tasks.get(i).setIsComplete(true);
                saveTasks();
                return true;
            }
        }
        return false;
    }

    public List<Task> getAllTasks(){
        return tasks;
    }

    public List<Task> sortByPriority(){
        List<Task> sorted = new ArrayList<>(tasks);
        for(int i = 0; i < sorted.size()-1; i++){
            for(int j = 0; j<sorted.size() - 1; j++){
                if(sorted.get(j).getPriorityLevel() < sorted.get(j+1).getPriorityLevel()){
                    Task temp = sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1, temp);
                }
            }
        }
        return sorted;
    }

    public List<Task> sortByDueDate(){
        List<Task> sorted = new ArrayList<>(tasks);
        for(int i = 0; i < sorted.size() - 1; i++){
            for(int j = 0; j<sorted.size() - 1 - i; j++){
                if(sorted.get(j).getDueDate().compareTo(sorted.get(j+1).getDueDate()) > 0){
                    Task temp = sorted.get(j);
                    sorted.set(j, sorted.get(j+1));
                    sorted.set(j+1, temp);
                }
            }
        }
        return sorted;

    }
    public void saveTasks(){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(taskFilePath))) {
            out.writeObject(tasks);
            out.writeObject(nextId);
        } catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }

    }
    public void loadTasks(){
        File file = new File(taskFilePath);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(taskFilePath))) {
            tasks = (List<Task>) in.readObject();
            nextId = (int) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading tasks: " + e.getMessage());
        }

    }

}
