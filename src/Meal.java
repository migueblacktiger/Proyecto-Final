import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Meal {
    private String name;
    private String macronutrients;
    private int calories;
    private String timeOfDay;

    public Meal(String name, String macronutrients, int calories, String timeOfDay) {
        this.name = name;
        this.macronutrients = macronutrients;
        this.calories = calories;
        this.timeOfDay = timeOfDay;
    }


    public static void registerMeal(Meal meal, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(meal.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateMeal(Meal meal, String filename) {
        List<Meal> meals = getAllMeals(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Meal m : meals) {
                if (m.name.equals(meal.name) && m.timeOfDay.equals(meal.timeOfDay)) {
                    writer.write(meal.toString());
                } else {
                    writer.write(m.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteMeal(String name, String timeOfDay, String filename) {
        List<Meal> meals = getAllMeals(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Meal m : meals) {
                if (!(m.name.equals(name) && m.timeOfDay.equals(timeOfDay))) {
                    writer.write(m.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Meal> getAllMeals(String filename) {
        List<Meal> meals = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                meals.add(new Meal(data[0], data[1], Integer.parseInt(data[2]), data[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return meals;
    }

    @Override
    public String toString() {
        return name + "," + macronutrients + "," + calories + "," + timeOfDay;
    }
}
