package com.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

public class TestCodeGenerator {

    public static void main(String[] args) {
        String filePath = "src/test/java/second_degree_equation/EquationSolverTest.java";
        String testPrefixMethod = "testSolve";
        String testCaseFile = "src/test/resources/second_degree_equation/test-case.txt";

        String saveTestResultToCSVMethod = "private void saveTestResultToCSV(double a, double b, double c, double[] result, boolean testPassed) {\n"
                +
                "    try {\n" +
                "        boolean fileExists = new File(\"test_report.csv\").exists();\n" +
                "        FileWriter fileWriter = new FileWriter(\"test_report.csv\", true);\n" +
                "        CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);\n" +
                "\n" +
                "        if (!fileExists) {\n" +
                "            csvPrinter.printRecord(\"Équation\", \"Solution\", \"Statut du test\");\n" +
                "        }\n" +
                "\n" +
                "        String equation = String.format(\"%.1fx^2 + %.1fx + %.1f = 0\", a, b, c);\n" +
                "        String solution = result.length > 0 ? String.format(\"x1=%.4f, x2=%.4f\", result[0], result.length > 1 ? result[1] : result[0]) : \"Pas de solution\";\n"
                +
                "        String testStatus = testPassed ? \"OK\" : \"KO\";\n" +
                "        csvPrinter.printRecord(equation, solution, testStatus);\n" +
                "\n" +
                "        csvPrinter.close();\n" +
                "    } catch (IOException e) {\n" +
                "        e.printStackTrace();\n" +
                "    }\n" +
                "}";

        String assertEqualsWithToleranceMethod = "private boolean assertEqualsWithTolerance(double expected, double actual, double tolerance) {\n"
                +
                "    return Math.abs(expected - actual) <= tolerance;\n" +
                "}";

        String fileHeader = String.format("package second_degree_equation;\n" +
                "import org.apache.commons.csv.CSVFormat;\n" +
                "import org.apache.commons.csv.CSVPrinter;\n" +
                "import java.lang.reflect.InvocationTargetException;\n" +
                "import java.io.File;\n" +
                "import java.io.FileWriter;\n" +
                "import java.io.IOException;\n" +
                "import static org.junit.jupiter.api.Assertions.*;\n" +
                "import org.junit.jupiter.api.Test;\n" +
                "public class EquationSolverTest {\n" +
                "%s\n\n" +
                "%s\n\n",
                saveTestResultToCSVMethod,
                assertEqualsWithToleranceMethod);

        String fileFooter = "}\n";

        String fileContent = "";

        try (BufferedReader br = new BufferedReader(new FileReader(testCaseFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");

                HashMap<String, Double> a = generateRadonValueInIntervalle(values[1]);
                HashMap<String, Double> b = generateRadonValueInIntervalle(values[2]);
                HashMap<String, Double> c = generateRadonValueInIntervalle(values[3]);

                String testName = testPrefixMethod;
                String a_key = "";
                String b_key = "";
                String c_key = "";

                for (String key : a.keySet()) {
                    a_key = key;
                }

                for (String key : b.keySet()) {
                    b_key = key;
                }

                for (String key : c.keySet()) {
                    c_key = key;
                }

                fileContent += generateTestCode(testName + a_key + b_key + c_key, a.get(a_key), b.get(b_key),
                        c.get(c_key));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(fileHeader + fileContent + fileFooter);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String generateTestCode(String testName, double a, double b, double c) {
        return String.format(
                "    @Test\n" +
                        "    public void %s() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {\n"
                        +
                        "        double a = %s;\n" +
                        "        double b = %s;\n" +
                        "        double c = %s;\n\n" +
                        "        Class<?> dynamicClass = Class.forName(\"com.equation.EquationSolver\");\n" +
                        "        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();\n" +
                        "        double[] result = (double[]) dynamicClass.getMethod(\"solve\", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);\n"
                        +
                        "        if (a == 0 || b * b - 4 * a * c < 0) {\n" +
                        "            assertEquals(0, result.length, \"Doit retourner un tableau vide\");\n" +
                        "        } else {\n" +
                        "            for (double root : result) {\n" +
                        "                double check_result = a * root * root + b * root + c;\n" +
                        "                assertEquals(0.0, check_result, 0.001, \"La racine doit satisfaire l'équation\");\n"
                        +
                        "            }\n" +
                        "        }\n" +
                        "        saveTestResultToCSV(a, b, c, result, true);\n" +
                        "    }\n",
                testName, a, b, c);
    }

    public static HashMap<String, Double> generateRadonValueInIntervalle(String input) {
        // Associer chaque lettre à l'intervalle correspondant
        HashMap<String, Double> intervalValue = new HashMap<>();

        char letter = input.charAt(input.length() - 1); // Dernier caractère de la chaîne
        String prefix = input.contains("1") ? "_a_" : input.contains("2") ? "_b_" : "_c_";
        switch (letter) {
            case 'a':
                intervalValue.put(prefix + "null", 0.0);
                break;
            case 'b':
                intervalValue.put(prefix + "tres_proche_de_zero_", getRandomValue(1e-7, 1e-6));
                break;
            case 'c':
                intervalValue.put(prefix + "tres_proche_de_0_negatif_", getRandomValue(-1e-6, 1e-7));
                break;
            case 'd':
                intervalValue.put(prefix + "proche_de_0_positif_", getRandomValue(1.0, 5.0));
                break;
            case 'e':
                intervalValue.put(prefix + "proche_de_0_negatif_", getRandomValue(-5.0, -1.0));
                break;
            case 'f':
                intervalValue.put(prefix + "normal_positif_", getRandomValue(10.0, 500.0));
                break;
            case 'g':
                intervalValue.put(prefix + "normal_negatif_", getRandomValue(-500.0, -10.0));
                break;
            case 'h':
                intervalValue.put(prefix + "grand_positif_", getRandomValue(1e6, 1e9));
                break;
            case 'i':
                intervalValue.put(prefix + "negatif_grand_", getRandomValue(-1e9, -1e6));
                break;
            default:
                throw new IllegalArgumentException("Caractère invalide dans la chaîne d'entrée.");
        }

        return intervalValue;
    }

    public static double getRandomValue(double min, double max) {
        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
    }

}
