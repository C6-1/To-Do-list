import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //text colours:
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        while (true) {
            System.out.println
                    (yellow + "\n━━━━━ Task List ━━━━━\n1. Add a new task\n2. Remove a task\n3. Show all tasks\n4. Remove all tasks\n5. Change existing task\n6. Change task status\n0. Exit" + reset);

            System.out.print(yellow + "Choose an action (0 - 6): " + reset);
            String x = scanner.nextLine();
            switch(x){
                case "1":
                    while(true){
                    System.out.print(yellow + "\nEnter the task you want to add: " + reset);
                    String task = scanner.nextLine();
                    tasks.add( task );
                    System.out.println(green + "Task \""+ task +"\" has been added!" + reset);
                    System.out.println(yellow + "Do you want to add a new tasks? (y/n)" + reset);
                    String taskAdd = scanner.nextLine();

                        if(taskAdd.equals("n"))
                        {

                            break;
                        }
                    }
                    break;


                case "2":
                    if(tasks.isEmpty()){
                        System.out.println(yellow + "\nThere are no tasks :( " + reset);

                    }else{
                        System.out.println(yellow + "\nAll your tasks: " + reset);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }

                        System.out.print(yellow + "If you want to delete a task based on its name, enter 1, if you want to delete a task based on its ID number, enter 0: " + reset);
                        int nameOrId = scanner.nextInt();
                        scanner.nextLine();
                        if(nameOrId == 1)
                        {
                            System.out.print(yellow + "Task name: " + reset);
                            String taskDelete = scanner.nextLine();
                            System.out.println(red + "\nTask \" " + taskDelete+ "\" has been removed!" + reset);
                            tasks.remove(taskDelete);
                            break;
                        }
                        else if (nameOrId == 0)
                        {
                            System.out.print(yellow + "Task ID: " + reset);
                            int deleteId = scanner.nextInt();
                            String taskNameDelete = tasks.get(deleteId-1);
                            tasks.remove(deleteId-1);
                            System.out.println(red + "Task \" " + deleteId + " - " + taskNameDelete +   " \" has been removed!" + reset);
                            break;
                        }

                    }
                    break;

                case "3":
                    if(tasks.isEmpty()){
                        System.out.println(yellow + "\nThere are no tasks :( " + reset);

                    }else{
                        System.out.println(yellow + "\nAll your tasks: " + reset);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                    }

                    break;

                case "4":
                    if(tasks.isEmpty()){
                        System.out.println(yellow + "\nThere are no tasks :( " + reset);

                    }
                    else
                    {
                        tasks.clear();
                        System.out.println(red + "\nAll tasks have been removed!" + reset);
                    }

                    break;
                case "5":
                    if(tasks.isEmpty()){
                        System.out.println(yellow + "\nThere are no tasks :( " + reset);
                        break;
                    }else{
                        System.out.println(yellow + "\nAll your tasks: " + reset);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                    }

                    System.out.print(yellow + "If you want to change a task write its id: " + reset);
                    int taskIdChange = scanner.nextInt();
                    scanner.nextLine();
                    String beforeDelete = tasks.get(taskIdChange - 1);
                    tasks.remove(taskIdChange - 1);
                    System.out.println(green + "New version of this task: " + reset);
                    String changedTask = scanner.nextLine();
                    tasks.add(taskIdChange - 1, changedTask);
                    System.out.println(yellow + "Changed !\nTask "+ reset  + red + beforeDelete + reset + yellow + " now "+ reset + green + changedTask + yellow +"." + reset);
                    break;

                case "6":
                    if(tasks.isEmpty()){
                        System.out.println(yellow + "\nThere are no tasks :( " + reset);
                        break;
                    }else{
                        System.out.println(yellow + "\nAll your tasks: " + reset);
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + ") " + tasks.get(i));
                        }
                        System.out.print(yellow + "Task id: " + reset);
                        int taskIdStatus = scanner.nextInt();
                        String statusBefore = tasks.get(taskIdStatus - 1);
                        scanner.nextLine();
                        if(taskIdStatus - 1 > tasks.size())
                        {
                            System.out.println(red + "Invalid choice !" + reset);
                            break;

                        }


                        System.out.println(yellow + "\nd - Done\ni - in progress\nl - to do later" + reset);
                        System.out.print("Change status to: ");
                        String status = scanner.nextLine();

                        if (status.equalsIgnoreCase("d")) {
                            if(tasks.get(taskIdStatus - 1).contains(" - in progress."))
                            {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - in progress.", green + " - done !" + reset));
                                System.out.println(green + "Task status was changed !" + reset);
                                break;
                            }
                            if (tasks.get(taskIdStatus - 1).contains(" - to do later !!"))
                            {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - to do later !!", green + " - done !" + green));
                                System.out.println(green + "Task status was changed !" + reset);
                                break;
                            }

                                tasks.remove(taskIdStatus - 1);

                                tasks.add(taskIdStatus - 1, statusBefore + green + " - done !" + reset);
                                System.out.println(green + "Task status was changed !" + reset);
                                break;


                        } else if ((status.equalsIgnoreCase("i"))) {
                            if(tasks.get(taskIdStatus - 1).contains(" - done !"))
                            {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - done !", blue + " - in progress." + reset));
                                System.out.println(green + "Task status was changed !" + reset);
                                break;
                            }
                            if (tasks.get(taskIdStatus - 1).contains(" - to do later !!"))
                            {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - to do later !!", blue + " - in progress." + green));
                                System.out.println(green + "Task status was changed !" + reset);
                                break;
                            }


                            tasks.remove(taskIdStatus - 1);
                            tasks.add(taskIdStatus - 1,  statusBefore + blue + " - in progress." + reset);
                            System.out.println(green + "Task status was changed !" + reset);
                            break;

                        } else if ((status.equalsIgnoreCase("l"))) {
                            if(tasks.get(taskIdStatus - 1).contains(" - done !"))
                            {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - done !", purple + " - to do later !!" + reset));
                                System.out.println(green + "Task status was changed !" + reset);
                                break;
                            }
                            if (tasks.get(taskIdStatus - 1).contains(" - in progress."))
                            {
                                tasks.set(taskIdStatus - 1, tasks.get(taskIdStatus - 1).replace(" - in progress.", purple + " - to do later !!" + green));
                                System.out.println(green + "Task status was changed !" + reset);
                                break;
                            }

                            tasks.remove(taskIdStatus - 1);
                            tasks.add(taskIdStatus - 1, statusBefore +  purple + " - to do later !!" + reset);
                            System.out.println(green + "Task status was changed !" + reset);
                            break;

                        } else {
                            System.out.println(red + "Invalid choice !" + reset);
                            break;

                        }

                    }

                      case "0":
                    System.out.println(green + "\nGoodbye!" + reset);
                    return;
                default:
                    System.out.println(red + "\nInvalid choice !" + reset);
            }
        }
    }
}

