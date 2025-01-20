import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        while (true) {
            System.out.println
                    ("\n----- Task List -----\n1. Add a new task\n2. Remove a task\n3. Show all tasks\n4. Remove all tasks\n0. Exit");

            System.out.print("Choose an action (0 - 4): ");
            byte x = scanner.nextByte();
            scanner.nextLine();
            switch(x){
                case 1:
                    System.out.print("\nEnter the task you want to add: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("Task \""+ task +"\" has been added!");
                    break;

                case 2:
                    if(tasks.isEmpty()){
                        System.out.println("\nThere are no tasks :( ");

                    }else{
                        System.out.println("\nAll your tasks: ");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }

                        System.out.print("If you want to delete a task based on its name, enter 1, if you want to delete a task based on its ID number, enter 0: ");
                        int nameOrId = scanner.nextInt();
                        scanner.nextLine();
                        if(nameOrId == 1)
                        {
                            System.out.print("Task name: ");
                            String taskDelete = scanner.nextLine();
                            System.out.println("\nTask \"" + taskDelete+ "\" has been removed!");
                            tasks.remove(taskDelete);
                            break;
                        }
                        else if (nameOrId == 0)
                        {
                            System.out.print("Task ID: ");
                            int deleteId = scanner.nextInt();
                            String taskNameDelete = tasks.get(deleteId-1);
                            tasks.remove(deleteId-1);
                            System.out.println("Task \"" + deleteId + " - " + taskNameDelete +   "\" has been removed!");
                            break;
                        }

                    }
                    break;

                case 3:
                    if(tasks.isEmpty()){
                        System.out.println("\nThere are no tasks :( ");

                    }else{
                        System.out.println("\nAll your tasks: ");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                    }

                    break;

                case 4:
                    if(tasks.isEmpty()){
                        System.out.println("\nThere are no tasks :( ");

                    }
                    else
                    {
                        tasks.clear();
                        System.out.println("\nAll tasks have been removed!");
                    }

                    break;

                case 0:
                    System.out.println("\nGoodbye!");
                    return;
                default:
                    System.out.println("\nInvalid choice!!!");
            }
        }
    }
}
