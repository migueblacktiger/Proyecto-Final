import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dietitian {
    private int dietitianId;
    private String name;
    private String specialty;

    public Dietitian(int dietitianId, String name, String specialty) {
        this.dietitianId = dietitianId;
        this.name = name;
        this.specialty = specialty;
    }


    public static void registerDietitian(Dietitian dietitian, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(dietitian.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateDietitian(Dietitian dietitian, String filename) {
        List<Dietitian> dietitians = getAllDietitians(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Dietitian d : dietitians) {
                if (d.dietitianId == dietitian.dietitianId) {
                    writer.write(dietitian.toString());
                } else {
                    writer.write(d.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDietitian(int dietitianId, String filename) {
        List<Dietitian> dietitians = getAllDietitians(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Dietitian d : dietitians) {
                if (d.dietitianId != dietitianId) {
                    writer.write(d.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Dietitian> getAllDietitians(String filename) {
        List<Dietitian> dietitians = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                dietitians.add(new Dietitian(Integer.parseInt(data[0]), data[1], data[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dietitians;
    }

    @Override
    public String toString() {
        return dietitianId + "," + name + "," + specialty;
    }
}
