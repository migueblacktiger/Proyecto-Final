import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DietPlan {
    private int planId;
    private int patientId;
    private int dietitianId;
    private int dailyCalories;
    private String macronutrientDistribution;
    private String specificRecommendations;

    public DietPlan(int planId, int patientId, int dietitianId, int dailyCalories, String macronutrientDistribution, String specificRecommendations) {
        this.planId = planId;
        this.patientId = patientId;
        this.dietitianId = dietitianId;
        this.dailyCalories = dailyCalories;
        this.macronutrientDistribution = macronutrientDistribution;
        this.specificRecommendations = specificRecommendations;
    }



    public static void registerDietPlan(DietPlan dietPlan, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(dietPlan.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateDietPlan(DietPlan dietPlan, String filename) {
        List<DietPlan> dietPlans = getAllDietPlans(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (DietPlan dp : dietPlans) {
                if (dp.planId == dietPlan.planId) {
                    writer.write(dietPlan.toString());
                } else {
                    writer.write(dp.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDietPlan(int planId, String filename) {
        List<DietPlan> dietPlans = getAllDietPlans(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (DietPlan dp : dietPlans) {
                if (dp.planId != planId) {
                    writer.write(dp.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DietPlan> getAllDietPlans(String filename) {
        List<DietPlan> dietPlans = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                dietPlans.add(new DietPlan(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]),
                        Integer.parseInt(data[3]), data[4], data[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dietPlans;
    }

    @Override
    public String toString() {
        return planId + "," + patientId + "," + dietitianId + "," + dailyCalories + "," + macronutrientDistribution + "," + specificRecommendations;
    }
}
