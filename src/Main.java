import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //ANSI escape codes for basic colors:
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        System.out.println

                (YELLOW + "\n━━━━━ Task List ━━━━━\nlc - show the list of commands\n1. Add a new task\n2. Remove a task\n3. Show all tasks\n4. Remove all tasks\n5. Change existing task\n6. Change task status\n0. Exit" + RESET);

        while (true) {
            System.out.print(YELLOW + ": " + RESET);
            String x = scanner.nextLine();
            switch (x) {
                case "lc":
                    System.out.println(YELLOW + "\n━━━━━ commands ━━━━━\n" +
                            "lc - show the list of commands\n1. Add a new task\n2. Remove a task\n" +
                            "3. Show all tasks\n4. Remove all tasks\n5. Change existing task\n" +
                            "6. Change task status\n0. Exit" + RESET);
                    break;
                    
                case "1":
                    while (true) {
                        System.out.print(YELLOW + "\nEnter the task you want to add: " + RESET);
                        String task = scanner.nextLine();
                        tasks.add(task);
                        System.out.println(GREEN + "Task \"" + task + "\" has been added!" + RESET);
                        System.out.println(YELLOW + "Do you want to add a new tasks? (y/n)" + RESET);
                        String taskAdd = scanner.nextLine();

                        if ("n".equalsIgnoreCase(taskAdd)) break;
                    }
                    break;
                    
                case "2":
                    if (tasks.isEmpty()) {
                        System.out.println(YELLOW + "\nThere are no tasks :( " + RESET);
                        break;
                    } else {
                        System.out.println(YELLOW + "\nAll your tasks: " + RESET);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));

                        }

                        System.out.print(YELLOW + "If you want to delete a task based on its name, enter 1," +
                                " if you want to delete a task based on its ID number, enter 0: " + RESET);
                        
                        int nameOrId = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (nameOrId == 1) {
                            System.out.print(YELLOW + "Task name: " + RESET);
                            String taskDelete = scanner.nextLine();
                            System.out.println(RED + "\nTask \" " + taskDelete + "\" has been removed!" + RESET);
                            tasks.remove(taskDelete);
                            break;
                            
                        } else if (nameOrId == 0) {
                            System.out.print(YELLOW + "Task ID: " + RESET);
                            int deleteId = scanner.nextInt();
                            
                            String taskNameDelete = tasks.get(deleteId - 1);
                            tasks.remove(deleteId - 1);
                            
                            System.out.println(RED + "Task \" " + deleteId + " - " + taskNameDelete + " \" has been removed!" + RESET);
                            break;
                        }

                    }
                    break;

                case "3":
                    if (tasks.isEmpty()) {
                        System.out.println(YELLOW + "\nThere are no tasks :( " + RESET);

                    } else {
                        System.out.println(YELLOW + "\nAll your tasks: " + RESET);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                    }
                    break;

                case "4":
                    if (tasks.isEmpty()) {
                        System.out.println(YELLOW + "\nThere are no tasks :( " + RESET);

                    } else {
                        tasks.clear();
                        System.out.println(RED + "\nAll tasks have been removed!" + RESET);
                    }
                    break;
                    
                case "5":
                    if (tasks.isEmpty()) {
                        System.out.println(YELLOW + "\nThere are no tasks :( " + RESET);
                        break;
                    } else {
                        System.out.println(YELLOW + "\nAll your tasks: " + RESET);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                    }

                    System.out.print(YELLOW + "If you want to change a task write its id: " + RESET);
                    int taskIdChange = scanner.nextInt();
                    scanner.nextLine();
                    
                    String beforeDelete = tasks.get(taskIdChange - 1);
                    tasks.remove(taskIdChange - 1);
                    
                    System.out.println(GREEN + "New version of this task: " + RESET);
                    String changedTask = scanner.nextLine();
                    
                    tasks.add(taskIdChange - 1, changedTask);
                    System.out.println(YELLOW + "Changed !\nTask " + RESET + RED + beforeDelete + RESET
                            + YELLOW + " now " + RESET + GREEN + changedTask + YELLOW + "." + RESET);
                    break;

                case "6":
                    if (tasks.isEmpty()) {
                        System.out.println(YELLOW + "\nThere are no tasks :( " + RESET);
                        break;
                        
                    } else {
                        System.out.println(YELLOW + "\nAll your tasks: " + RESET);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                        
                        System.out.print(YELLOW + "Task id: " + RESET);
                        int taskIdStatus = scanner.nextInt();
                        
                        String statusBefore = tasks.get(taskIdStatus - 1);
                        scanner.nextLine();
                        
                        if (taskIdStatus - 1 > tasks.size()) {
                            System.out.println(RED + "Invalid choice !" + RESET);
                            break;
                        }

                        System.out.println(YELLOW + "\nd - Done\ni - in progress\nl - to do later" + RESET);
                        System.out.print("Change status to: ");
                        String status = scanner.nextLine();

                        if (status.equalsIgnoreCase("d")) {
                            if (tasks.get(taskIdStatus - 1).contains(" - in progress.")) {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - in progress.", GREEN + " - done !" + RESET));
                                System.out.println(GREEN + "Task status was changed !" + RESET);
                                break;
                            }
                            if (tasks.get(taskIdStatus - 1).contains(" - to do later !!")) {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - to do later !!", GREEN + " - done !" + GREEN));
                                System.out.println(GREEN + "Task status was changed !" + RESET);
                                break;
                            }

                            tasks.remove(taskIdStatus - 1);

                            tasks.add(taskIdStatus - 1, statusBefore + GREEN + " - done !" + RESET);
                            System.out.println(GREEN + "Task status was changed !" + RESET);
                            break;


                        } else if ((status.equalsIgnoreCase("i"))) {
                            if (tasks.get(taskIdStatus - 1).contains(" - done !")) {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - done !", BLUE + " - in progress." + RESET));
                                System.out.println(GREEN + "Task status was changed !" + RESET);
                                break;
                            }
                            if (tasks.get(taskIdStatus - 1).contains(" - to do later !!")) {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - to do later !!", BLUE + " - in progress." + GREEN));
                                System.out.println(GREEN + "Task status was changed !" + RESET);
                                break;
                            }


                            tasks.remove(taskIdStatus - 1);
                            tasks.add(taskIdStatus - 1, statusBefore + BLUE + " - in progress." + RESET);
                            System.out.println(GREEN + "Task status was changed !" + RESET);
                            break;

                        } else if ((status.equalsIgnoreCase("l"))) {
                            
                            if (tasks.get(taskIdStatus - 1).contains(" - done !")) {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - done !", PURPLE + " - to do later !!" + RESET));
                                System.out.println(GREEN + "Task status was changed !" + RESET);
                                break;
                            }
                            
                            if (tasks.get(taskIdStatus - 1).contains(" - in progress.")) {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - in progress.", PURPLE + " - to do later !!" + GREEN));
                                System.out.println(GREEN + "Task status was changed !" + RESET);
                                break;
                            }

                            tasks.remove(taskIdStatus - 1);
                            tasks.add(taskIdStatus - 1, statusBefore + PURPLE + " - to do later !!" + RESET);
                            System.out.println(GREEN + "Task status was changed !" + RESET);
                            break;

                        } else {
                            System.out.println(RED + "Invalid choice !" + RESET);
                            break;
                        }
                    }

                case "0":
                    System.out.println(GREEN + "\nGoodbye!" + RESET);
                    return;
                default:
                    System.out.println(RED + "\nInvalid choice !" + RESET);
            }
        }
    }
}
