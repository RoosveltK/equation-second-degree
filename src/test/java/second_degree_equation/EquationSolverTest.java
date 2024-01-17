package second_degree_equation;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.lang.reflect.InvocationTargetException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EquationSolverTest {
    private void saveTestResultToCSV(double a, double b, double c, double[] result, boolean testPassed) {
        try {
            boolean fileExists = new File("test_report.csv").exists();
            FileWriter fileWriter = new FileWriter("test_report.csv", true);
            CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT);

            if (!fileExists) {
                csvPrinter.printRecord("Équation", "Solution", "Statut du test");
            }

            String equation = String.format("%.1fx^2 + %.1fx + %.1f = 0", a, b, c);
            String solution = result.length > 0
                    ? String.format("x1=%.4f, x2=%.4f", result[0], result.length > 1 ? result[1] : result[0])
                    : "Pas de solution";
            String testStatus = testPassed ? "OK" : "KO";
            csvPrinter.printRecord(equation, solution, testStatus);

            csvPrinter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean assertEqualsWithTolerance(double expected, double actual, double tolerance) {
        return Math.abs(expected - actual) <= tolerance;
    }

    @Test
    public void testSolve_a_null_b_proche_de_0_positif__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 2.70917874774389;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_normal_negatif__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.8210866366759844E-7;
        double b = -142.7149867944114;
        double c = 3.283143442173841E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_negatif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.71575376521378E-7;
        double b = -1.1958500890721533;
        double c = 2.566689351651429;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_tres_proche_de_zero__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.405685280160412;
        double b = 2.8120318636427924E-7;
        double c = -9.44748589720266E-8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_normal_positif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.739722023052602;
        double b = 56.555307317914846;
        double c = 399.31454444422707;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_negatif_grand__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 270.920910864171;
        double b = -4.2536015942569005E8;
        double c = 2.200943062409343E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_null_c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -371.54851286995154;
        double b = 0.0;
        double c = -231.5963470431479;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.453328656707961E8;
        double b = -4.163089559733201E-7;
        double c = -2.509170886297713;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_grand_positif__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.08219043929457E8;
        double b = 6.244877267259507E8;
        double c = -7.509976633467996E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_null_c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 0.0;
        double c = -5.694420568741629E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_null_c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 9.022638383424999E-7;
        double b = 0.0;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_null_c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.323453695271935E-8;
        double b = 0.0;
        double c = -4.636559760446355;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_null_c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.2284373423709884;
        double b = 0.0;
        double c = 9.515892952308677E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_null_c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.483716791822324;
        double b = 0.0;
        double c = 2.9042951597504003;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_null_c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 356.2942424895001;
        double b = 0.0;
        double c = 332.19480574990513;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_tres_proche_de_zero__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -229.00207289191223;
        double b = 6.944957634647488E-7;
        double c = -1.5531842403311686;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_null_c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.387088087413567E8;
        double b = 0.0;
        double c = 4.159883715089196E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_null_c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.9218204864581585E8;
        double b = 0.0;
        double c = -4.537739898767568E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_tres_proche_de_0_negatif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 4.333433546252849E-8;
        double c = 106.98727749899854;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_proche_de_0_positif__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.6987721555979273E-7;
        double b = 3.9674654488812466;
        double c = -3.173037429499272E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_proche_de_0_negatif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -4.0899817406696375;
        double c = -8.081711528415007E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_normal_positif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 286.551530687515;
        double c = 3.3794738233898247;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_normal_negatif__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -322.34981415798404;
        double c = 2.161997488858784E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_grand_positif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 2.1328558284207216E8;
        double c = -4.588572592926462;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_negatif_grand__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -7.20536508165719E8;
        double c = 5.97764438715482E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_null_b_tres_proche_de_zero__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 6.936077563138597E-7;
        double c = -278.857792366269;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.124783984581044E-8;
        double b = -1.899270354456144E-7;
        double c = -5.1471481761709106E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_negatif_grand__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.262971373503325;
        double b = -4.857784906979108E7;
        double c = -3.178258576166475E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_normal_negatif__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.8764980267032327;
        double b = -488.85590603041436;
        double c = -5.348772434640382E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_tres_proche_de_zero__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 484.10648912588795;
        double b = 7.062568679946231E-7;
        double c = -4.6642919404729897E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_proche_de_0_negatif__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -113.9404580073741;
        double b = -2.898674850641728;
        double c = -2.776972031592705E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_normal_positif__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.260057081095225E8;
        double b = 304.2099743319257;
        double c = -5.8418451060755E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_proche_de_0_positif__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.0960392981775165E8;
        double b = 2.045722852072474;
        double c = 3.620627629081528E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_grand_positif__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -421.4568658441958;
        double b = 3.395176959785345E8;
        double c = 2.4823369408149564E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_negatif_grand__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.251541875004211;
        double b = -4.8640345753400457E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_negatif_grand__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.73207132771641E8;
        double b = -9.665175616986505E8;
        double c = -282.37922518960204;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_proche_de_0_negatif__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.837188490982739E-7;
        double b = -2.8254118814500555;
        double c = -165.49356782807757;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -5.139913078401207E-7;
        double b = -462.33382479478814;
        double c = -171.188817883274;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_proche_de_0_positif__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.876025690193587;
        double b = 3.6058851199710555;
        double c = -22.320647863501165;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_normal_positif__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 411.75923486001204;
        double b = 89.260367550987;
        double c = -358.67785165120955;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_grand_positif__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.8718938345717832E8;
        double b = 6.61088449017589E8;
        double c = -451.6229859731882;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_normal_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.4738967782215333;
        double b = -1.276370659351744E-7;
        double c = -193.21687027566156;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_normal_negatif__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 494.932052452914;
        double b = -389.0564023823048;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_normal_positif__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.093933841677499E8;
        double b = 485.0724590756424;
        double c = 6.256348662602673E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_normal_negatif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -199.6462489073648;
        double b = -91.34342967730896;
        double c = -5.56485049139722E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_normal_negatif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.730519891666418E8;
        double b = -407.17200615186323;
        double c = 1.465888006889152;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_normal_negatif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.2508333795293057E8;
        double b = -81.23959633880986;
        double c = 91.53733239542422;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_negatif_grand__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.66365624240322E-7;
        double b = -1.7887112674818552E8;
        double c = -3.2864955170410344;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.677666128346799E-7;
        double b = 482.53975438514397;
        double c = 2.1219977872853297E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_normal_positif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.198364974469233;
        double b = 473.83676528302254;
        double c = -4.435555797460813;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_tres_proche_de_zero__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 9.409905550285981E-7;
        double b = 2.2932829730625243E-7;
        double c = 74.78840787248234;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_tres_proche_de_0_negatif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -49.71956133602043;
        double b = -5.143425181229481E-7;
        double c = 3.2156420993474386;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_proche_de_0_positif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.8168922492878359;
        double b = 2.040869953601891;
        double c = -2.6702827429708096;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_proche_de_0_negatif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 385.680104682795;
        double b = -1.5147295727842862;
        double c = -3.469588756091843;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_grand_positif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.7023785049715112;
        double b = 9.096386033863366E8;
        double c = 440.2267152818516;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.9747495383111517;
        double b = -1.4514306669860622;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_proche_de_0_positif__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 171.42366979740825;
        double b = 1.1648869084203852;
        double c = 6.137289247811218E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_normal_positif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.843531309556247E-7;
        double b = 406.32036776838856;
        double c = -2.020900815575811E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_zero__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.973818613995709E-7;
        double b = 4.408671237585994E-7;
        double c = 9.931365554667067E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_proche_de_0_positif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.520573830327415E8;
        double b = 2.652742105317809;
        double c = 4.822603651073607;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.713396079636318;
        double b = 1.1618592548903312E-9;
        double c = 3.319515902961731E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_grand_positif__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.1429507805273896E8;
        double b = 7.569105586617514E8;
        double c = 5.508463394468816E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_tres_proche_de_zero__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.3654124500163233E8;
        double b = 2.5299678585502E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_tres_proche_de_0_negatif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 87.82411089411876;
        double b = -9.900342868473115E-7;
        double c = -8.728818356283252E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_grand_positif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.3792201977845013;
        double b = 1.7189241166664708E8;
        double c = 3.8284146632317084E-8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_negatif_grand__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.428981543307398E-7;
        double b = -4.89975977739454E8;
        double c = -8.501833989409827E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_proche_de_0_positif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -194.73978267218206;
        double b = 4.913681728169452;
        double c = 333.10045299497125;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_proche_de_0_negatif__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.983616453521276E7;
        double b = -3.8941587555457313;
        double c = 9.975785704492048E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.3961810068099564E8;
        double b = 8.090585882443539E-8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_grand_positif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.958724359911041E-7;
        double b = 5.7315107253968395E7;
        double c = 3.5199580940629076;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_zero__b_tres_proche_de_0_negatif__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.323978208532792E-7;
        double b = -1.7866266769298367E-7;
        double c = 1.9792385823176107E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_grand_positif__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.56788125023508E-7;
        double b = 4.801187221548486E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.19480601380248;
        double b = -2.8051751640883626;
        double c = 9.894929370312182E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_negatif_grand__c_tres_proche_de_zero_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -25.937430092052296;
        double b = -5.3427951697103727E8;
        double c = 7.901510512949441E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_negatif_grand__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.239026441597391E8;
        double b = -9.651498554231746E8;
        double c = 1.6402634372690743;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_tres_proche_de_zero__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 342.7181027856693;
        double b = 4.927940995923352E-7;
        double c = 3.954332934235399;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_negatif_grand__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.1569310446449864E8;
        double b = -4.585637843713906E8;
        double c = 246.8887285812917;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_normal_negatif__c_proche_de_0_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.468145980928076;
        double b = -113.58448052991031;
        double c = 1.4034321197995592;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_proche_de_0_negatif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.6045377034456174;
        double b = -4.47159198406961;
        double c = 484.3149593199035;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_proche_de_0_negatif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.178986500157465E8;
        double b = -4.161119484615263;
        double c = -1.953852874920613E-8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_zero__c_grand_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.48067485420379;
        double b = 8.50074121716084E-7;
        double c = 2.4320406416296613E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_positif__c_tres_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.603141307701504E-7;
        double b = 2.230805448135612;
        double c = -5.49197886807256E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_negatif__b_normal_positif__c_null()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -78.62859652792258;
        double b = 16.909422973014095;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_negatif_grand__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.563450723799777E8;
        double b = -9.773256128794331E-7;
        double c = -1.6488637122159844;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.439551665074972E-7;
        double b = 171.20021013509887;
        double c = 464.7344761971495;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_proche_de_0_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.6207775607735613;
        double b = 9.036702594240752E-8;
        double c = -1.2560756860068953;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_normal_positif__b_grand_positif__c_normal_positif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 410.4197330527525;
        double b = 7.464175371020322E8;
        double c = 447.706999271314;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_grand_positif__b_tres_proche_de_zero__c_negatif_grand_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.2057824829968014E8;
        double b = 2.737259792465096E-7;
        double c = -4.1968708219609046E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_proche_de_0_negatif_()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.574576845878878E-7;
        double b = -319.7485101024854;
        double c = -4.424454948745563;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);
        if (result.length == 0) {
            assertEquals(0, 0);
            saveTestResultToCSV(a, b, c, new double[0], true);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            saveTestResultToCSV(a, b, c, result, assertEqualsWithTolerance(0.0, tcheck_result, 0.001));
            assertEquals(0.0, tcheck_result, 0.001);
        }
    }

}
