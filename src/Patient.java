import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private double weight;
    private double height;
    private String preexistingConditions;

    public Patient(int patientId, String name, int age, double weight, double height, String preexistingConditions) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.preexistingConditions = preexistingConditions;
    }



    public static void registerPatient(Patient patient, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(patient.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updatePatient(Patient patient, String filename) {
        List<Patient> patients = getAllPatients(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Patient p : patients) {
                if (p.patientId == patient.patientId) {
                    writer.write(patient.toString());
                } else {
                    writer.write(p.toString());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deletePatient(int patientId, String filename) {
        List<Patient> patients = getAllPatients(filename);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Patient p : patients) {
                if (p.patientId != patientId) {
                    writer.write(p.toString());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Patient> getAllPatients(String filename) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                patients.add(new Patient(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
                        Double.parseDouble(data[3]), Double.parseDouble(data[4]), data[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public String toString() {
        return patientId + "," + name + "," + age + "," + weight + "," + height + "," + preexistingConditions;
    }
}
