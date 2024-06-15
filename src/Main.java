import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String PATIENTS_FILE = "src/resources/patients.csv";
    private static final String DIETITIANS_FILE = "src/resources/dietitians.csv";
    private static final String DIETPLANS_FILE = "src/resources/dietplans.csv";
    private static final String MEALS_FILE = "src/resources/meals.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Nutrition Management System");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Dietitians");
            System.out.println("3. Manage Diet Plans");
            System.out.println("4. Manage Meals");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    managePatients(scanner);
                    break;
                case 2:
                    manageDietitians(scanner);
                    break;
                case 3:
                    manageDietPlans(scanner);
                    break;
                case 4:
                    manageMeals(scanner);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void managePatients(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("Manage Patients");
            System.out.println("1. Add Patient");
            System.out.println("2. Update Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    updatePatient(scanner);
                    break;
                case 3:
                    deletePatient(scanner);
                    break;
                case 4:
                    viewAllPatients();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter Height: ");
        double height = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Preexisting Conditions: ");
        String preexistingConditions = scanner.nextLine();

        Patient patient = new Patient(patientId, name, age, weight, height, preexistingConditions);
        Patient.registerPatient(patient, PATIENTS_FILE);
    }

    private static void updatePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to Update: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter New Weight: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter New Height: ");
        double height = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter New Preexisting Conditions: ");
        String preexistingConditions = scanner.nextLine();

        Patient patient = new Patient(patientId, name, age, weight, height, preexistingConditions);
        Patient.updatePatient(patient, PATIENTS_FILE);
    }

    private static void deletePatient(Scanner scanner) {
        System.out.print("Enter Patient ID to Delete: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        Patient.deletePatient(patientId, PATIENTS_FILE);
    }

    private static void viewAllPatients() {
        List<Patient> patients = Patient.getAllPatients(PATIENTS_FILE);
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }


    private static void manageDietitians(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("Manage Dietitians");
            System.out.println("1. Add Dietitian");
            System.out.println("2. Update Dietitian");
            System.out.println("3. Delete Dietitian");
            System.out.println("4. View All Dietitians");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDietitian(scanner);
                    break;
                case 2:
                    updateDietitian(scanner);
                    break;
                case 3:
                    deleteDietitian(scanner);
                    break;
                case 4:
                    viewAllDietitians();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addDietitian(Scanner scanner) {
        System.out.print("Enter Dietitian ID: ");
        int dietitianId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialty: ");
        String specialty = scanner.nextLine();

        Dietitian dietitian = new Dietitian(dietitianId, name, specialty);
        Dietitian.registerDietitian(dietitian, DIETITIANS_FILE);
    }

    private static void updateDietitian(Scanner scanner) {
        System.out.print("Enter Dietitian ID to Update: ");
        int dietitianId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter New Specialty: ");
        String specialty = scanner.nextLine();

        Dietitian dietitian = new Dietitian(dietitianId, name, specialty);
        Dietitian.updateDietitian(dietitian, DIETITIANS_FILE);
    }

    private static void deleteDietitian(Scanner scanner) {
        System.out.print("Enter Dietitian ID to Delete: ");
        int dietitianId = scanner.nextInt();
        scanner.nextLine();

        Dietitian.deleteDietitian(dietitianId, DIETITIANS_FILE);
    }

    private static void viewAllDietitians() {
        List<Dietitian> dietitians = Dietitian.getAllDietitians(DIETITIANS_FILE);
        for (Dietitian dietitian : dietitians) {
            System.out.println(dietitian);
        }
    }

    private static void manageDietPlans(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("Manage Diet Plans");
            System.out.println("1. Add Diet Plan");
            System.out.println("2. Update Diet Plan");
            System.out.println("3. Delete Diet Plan");
            System.out.println("4. View All Diet Plans");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDietPlan(scanner);
                    break;
                case 2:
                    updateDietPlan(scanner);
                    break;
                case 3:
                    deleteDietPlan(scanner);
                    break;
                case 4:
                    viewAllDietPlans();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addDietPlan(Scanner scanner) {
        System.out.print("Enter Plan ID: ");
        int planId = scanner.nextInt();
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Dietitian ID: ");
        int dietitianId = scanner.nextInt();
        System.out.print("Enter Daily Calories: ");
        int dailyCalories = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Macronutrient Distribution: ");
        String macronutrientDistribution = scanner.nextLine();
        System.out.print("Enter Specific Recommendations: ");
        String specificRecommendations = scanner.nextLine();

        DietPlan dietPlan = new DietPlan(planId, patientId, dietitianId, dailyCalories, macronutrientDistribution, specificRecommendations);
        DietPlan.registerDietPlan(dietPlan, DIETPLANS_FILE);
    }

    private static void updateDietPlan(Scanner scanner) {
        System.out.print("Enter Plan ID to Update: ");
        int planId = scanner.nextInt();
        System.out.print("Enter New Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter New Dietitian ID: ");
        int dietitianId = scanner.nextInt();
        System.out.print("Enter New Daily Calories: ");
        int dailyCalories = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Macronutrient Distribution: ");
        String macronutrientDistribution = scanner.nextLine();
        System.out.print("Enter New Specific Recommendations: ");
        String specificRecommendations = scanner.nextLine();

        DietPlan dietPlan = new DietPlan(planId, patientId, dietitianId, dailyCalories, macronutrientDistribution, specificRecommendations);
        DietPlan.updateDietPlan(dietPlan, DIETPLANS_FILE);
    }

    private static void deleteDietPlan(Scanner scanner) {
        System.out.print("Enter Plan ID to Delete: ");
        int planId = scanner.nextInt();
        scanner.nextLine();

        DietPlan.deleteDietPlan(planId, DIETPLANS_FILE);
    }

    private static void viewAllDietPlans() {
        List<DietPlan> dietPlans = DietPlan.getAllDietPlans(DIETPLANS_FILE);
        for (DietPlan dietPlan : dietPlans) {
            System.out.println(dietPlan);
        }
    }

    private static void manageMeals(Scanner scanner) {
        boolean back = false;

        while (!back) {
            System.out.println("Manage Meals");
            System.out.println("1. Add Meal");
            System.out.println("2. Update Meal");
            System.out.println("3. Delete Meal");
            System.out.println("4. View All Meals");
            System.out.println("5. Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMeal(scanner);
                    break;
                case 2:
                    updateMeal(scanner);
                    break;
                case 3:
                    deleteMeal(scanner);
                    break;
                case 4:
                    viewAllMeals();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addMeal(Scanner scanner) {
        System.out.print("Enter Meal Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Macronutrients: ");
        String macronutrients = scanner.nextLine();
        System.out.print("Enter Calories: ");
        int calories = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Time of Day: ");
        String timeOfDay = scanner.nextLine();

        Meal meal = new Meal(name, macronutrients, calories, timeOfDay);
        Meal.registerMeal(meal, MEALS_FILE);
    }

    private static void updateMeal(Scanner scanner) {
        System.out.print("Enter Meal Name to Update: ");
        String name = scanner.nextLine();
        System.out.print("Enter Time of Day to Update: ");
        String timeOfDay = scanner.nextLine();
        System.out.print("Enter New Macronutrients: ");
        String macronutrients = scanner.nextLine();
        System.out.print("Enter New Calories: ");
        int calories = scanner.nextInt();
        scanner.nextLine();

        Meal meal = new Meal(name, macronutrients, calories, timeOfDay);
        Meal.updateMeal(meal, MEALS_FILE);
    }

    private static void deleteMeal(Scanner scanner) {
        System.out.print("Enter Meal Name to Delete: ");
        String name = scanner.nextLine();
        System.out.print("Enter Time of Day to Delete: ");
        String timeOfDay = scanner.nextLine();

        Meal.deleteMeal(name, timeOfDay, MEALS_FILE);
    }

    private static void viewAllMeals() {
        List<Meal> meals = Meal.getAllMeals(MEALS_FILE);
        for (Meal meal : meals) {
            System.out.println(meal);
        }
    }
}
