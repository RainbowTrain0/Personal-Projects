import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {
    private static final long serialVersion = 1L;
    private int id;
    private String title;
    private String description;
    private Priority priority;
    private int priorityLevel;
    private LocalDate dueDate;
    private boolean isComplete;

    public Task(int id, String title, String description, Priority priority, LocalDate dueDate, boolean isComplete){
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.isComplete = isComplete;
        setPriorityLevel(priority);
    }

    public int getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public Priority getPriority(){
        return priority;
    }
    public int getPriorityLevel(){
        return priorityLevel;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    public boolean getIsComplete(){
        return isComplete;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setPriority(Priority priority){
        this.priority = priority;
    }
    public void setPriorityLevel(Priority priority){
        if(priority == Priority.HIGH){
            this.priorityLevel = 3;
        }else if(priority == Priority.MEDIUM)
            this.priorityLevel = 2;
        else
            this.priorityLevel = 1;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate = dueDate;
    }
    public void setIsComplete(boolean isComplete){
        this.isComplete = isComplete;
    }
    public String toString(){
        return "Priority: " + priority + " Task: " + title + " " +
                "Due Date: " + dueDate + " Description: " + description +
                " Completed Status: " + isComplete;
    }






}
