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
        String solution = result.length > 0 ? String.format("x1=%.4f, x2=%.4f", result[0], result.length > 1 ? result[1] : result[0]) : "Pas de solution";
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
    public void testSolve_a_null_b_proche_de_0_positif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 3.5400130666615377;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_normal_negatif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.799019873857121E-7;
        double b = -464.5416294512524;
        double c = 6.437762127737862E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.9096226596481867E-7;
        double b = -4.2672929587574835;
        double c = 3.6767855227206954;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_tres_proche_de_zero__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.0434654633144085;
        double b = 7.012437836918269E-7;
        double c = -7.08540131924509E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_normal_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.9286124432291536;
        double b = 237.90786419390125;
        double c = 86.8837123258878;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_negatif_grand__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 61.139842325576026;
        double b = -1.92061309955894E8;
        double c = 7.107027130891814E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_null_c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -285.55059285063373;
        double b = 0.0;
        double c = -202.6668623004988;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 5.877680940207778E8;
        double b = -4.90418092932323E-7;
        double c = -4.364400223844436;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_grand_positif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.052286776186626E8;
        double b = 7.885838000682087E8;
        double c = -9.463912498043545E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_null_c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 0.0;
        double c = -8.707786292462298E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_null_c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.3006524012207027E-7;
        double b = 0.0;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_null_c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -9.219196138047828E-7;
        double b = 0.0;
        double c = -4.193813108468037;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_null_c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.2522351909363478;
        double b = 0.0;
        double c = 6.089468180849156E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_null_c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.0343730574683176;
        double b = 0.0;
        double c = 2.013810739774282;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_null_c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 47.44003603221444;
        double b = 0.0;
        double c = 333.82602372038514;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_tres_proche_de_zero__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -335.466581707083;
        double b = 1.3615887769807858E-7;
        double c = -3.9995920970006407;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_null_c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.898439264859993E8;
        double b = 0.0;
        double c = 2.266815432455263E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_null_c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.8901505906356204E8;
        double b = 0.0;
        double c = -6.159905225658568E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_tres_proche_de_0_negatif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -3.308257081992694E-7;
        double c = 77.99567457181381;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_proche_de_0_positif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 6.066326660136957E-7;
        double b = 1.4624955547349652;
        double c = -7.435916014902103E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_proche_de_0_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -3.5716849697879667;
        double c = -5.255192009567226E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_normal_positif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 275.4978045830605;
        double c = 4.161684288494098;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_normal_negatif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -338.24343195444374;
        double c = 6.041645636957766E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_grand_positif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 5.38173671196515E8;
        double c = -2.379029463138588;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_negatif_grand__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = -5.812604112470353E8;
        double c = 6.326662701758252E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_null_b_tres_proche_de_zero__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 4.3278368710058497E-7;
        double c = -365.4834180043816;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.0629251419184184E-7;
        double b = -6.123236531386982E-7;
        double c = -7.461109014869058E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_negatif_grand__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.059605941841684;
        double b = -5.607846599876525E8;
        double c = -9.437074104275452E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_normal_negatif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.5477373757762898;
        double b = -497.7377073729308;
        double c = -3.6737290553134775E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_tres_proche_de_zero__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 372.5063506922662;
        double b = 2.7000048304261043E-7;
        double c = -2.946373516100259E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_proche_de_0_negatif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -405.5049750109471;
        double b = -2.5990125853855406;
        double c = -6.220744151339219E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_normal_positif__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.071143394764629E8;
        double b = 103.97879650025038;
        double c = -3.042598289226301E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_proche_de_0_positif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.249353151153939E8;
        double b = 1.07862278644861;
        double c = 5.976855900303077E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_grand_positif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -402.35037682117354;
        double b = 8.49561297058398E8;
        double c = 7.125052865402116E7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
clear            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_negatif_grand__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.7138181589581825;
        double b = -6.069020633597655E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_negatif_grand__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.845958186739643E8;
        double b = -7.549815987929289E8;
        double c = -438.9990295513748;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_proche_de_0_negatif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.086094687129207E-7;
        double b = -4.688444260963236;
        double c = -259.18977301055554;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -2.342279095670671E-8;
        double b = -168.96741251337812;
        double c = -494.6814586605685;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_proche_de_0_positif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.994163081163643;
        double b = 1.781017494051623;
        double c = -416.33058473601204;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_normal_positif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 472.46030961286425;
        double b = 117.131385407086;
        double c = -41.93484563897539;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_grand_positif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.7796811969373086E8;
        double b = 7.158663310178022E7;
        double c = -348.6056665254406;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_normal_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.779383179042836;
        double b = -6.723887999470515E-7;
        double c = -361.350478375413;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_normal_negatif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 37.729038753437976;
        double b = -171.9116800589319;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_normal_positif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.409818663068837E8;
        double b = 317.3394628271108;
        double c = 5.210446729459181E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_normal_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -55.780548434698346;
        double b = -66.00790630538091;
        double c = -6.578649367535799E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_normal_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.58230123538555E8;
        double b = -115.67579753993488;
        double c = 3.2710604873977527;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_normal_negatif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.495200357101785E8;
        double b = -197.5581324094224;
        double c = 209.60482414784818;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_negatif_grand__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.3108969060808324E-7;
        double b = -1.2987369783108962E8;
        double c = -4.156107286857791;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.7439651905568326E-7;
        double b = 235.44891235798153;
        double c = 5.901081677126355E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_normal_positif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.139204468146716;
        double b = 176.02245640606967;
        double c = -1.7062351303776633;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_tres_proche_de_zero__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.1375924657374866E-7;
        double b = 8.250895321549708E-7;
        double c = 239.02591530675917;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_tres_proche_de_0_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -37.437817128645065;
        double b = 4.782971844561621E-9;
        double c = 4.7560678454418035;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_proche_de_0_positif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.37317672080267;
        double b = 3.0257228798127236;
        double c = -4.9349723898667985;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 42.93905383089624;
        double b = -3.256562713265246;
        double c = -1.5107163557655396;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_grand_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.6415587337682744;
        double b = 5.002827739817039E8;
        double c = 468.8424354946719;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 4.9370584851652115;
        double b = -1.0879654588007344;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_proche_de_0_positif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 239.70243649460966;
        double b = 2.3521280286126682;
        double c = 2.7365110971367843E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_normal_positif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.4551738978720074E-7;
        double b = 378.00464658167584;
        double c = -1.4516941996703944E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_tres_proche_de_zero__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.662318697933998E-7;
        double b = 2.7569450822618416E-7;
        double c = 4.827196198857984E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_proche_de_0_positif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.4003643029911882E8;
        double b = 3.675598763378426;
        double c = 1.534804728664922;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_0_negatif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.882715689837131;
        double b = -7.785140168713105E-7;
        double c = 8.230844809958605E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_grand_positif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.213891255812331E8;
        double b = 3.191048400403151E8;
        double c = 2.205393143257745E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_tres_proche_de_zero__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.926180151727979E8;
        double b = 2.1409179619466584E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_tres_proche_de_0_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 177.47551511856457;
        double b = -9.920986630507831E-7;
        double c = -4.3282443707857865E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_grand_positif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.256899901271279;
        double b = 9.665810700595403E8;
        double c = -5.19513625874747E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_negatif_grand__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.325532133882307E-9;
        double b = -2.4971471640963197E8;
        double c = 4.795659458278079E-8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_proche_de_0_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -90.96357786461851;
        double b = 2.605091137377635;
        double c = 448.41147709591223;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_proche_de_0_negatif__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.425777400874376E7;
        double b = -3.0007842642373914;
        double c = 6.133416465801077E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_tres_proche_de_0_negatif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.457796408927171E8;
        double b = -2.9065228612160233E-7;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_grand_positif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 8.144810284788699E-7;
        double b = 7.080317140071411E8;
        double c = 3.4127386812527467;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_zero__b_tres_proche_de_0_negatif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.9048069125637296E-7;
        double b = -5.108045093157288E-7;
        double c = 5.024114021947993E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_grand_positif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -7.570175672474783E-7;
        double b = 3.1266948774940115E8;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_proche_de_0_negatif__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.7076847023093626;
        double b = -3.312222543347543;
        double c = 5.0135702959479153E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_negatif_grand__c_tres_proche_de_zero_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -312.1868745107944;
        double b = -4.3868209867427623E8;
        double c = 6.024364124257866E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_negatif_grand__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.9576143433310637E8;
        double b = -5.702028185459462E8;
        double c = 1.1866157544269988;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_tres_proche_de_zero__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 232.41397874093025;
        double b = 4.385816443758718E-7;
        double c = 2.395615615093056;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_negatif_grand__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -3.4268961541974306E7;
        double b = -6.70960387222656E8;
        double c = 214.55206926273414;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_normal_negatif__c_proche_de_0_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 2.819243210445204;
        double b = -336.84237079615355;
        double c = 3.766216047568938;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_proche_de_0_negatif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.9198977439899143;
        double b = -1.7178902774733622;
        double c = 231.78101790279632;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_proche_de_0_negatif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 7.65799276802652E7;
        double b = -4.216393678755583;
        double c = -8.822196824508526E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_negatif__b_tres_proche_de_zero__c_grand_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -1.4547633490435121;
        double b = 7.561934978676963E-7;
        double c = 1.0152412741110224E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_proche_de_0_positif__c_tres_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.1221742193248135E-7;
        double b = 3.3928399489145766;
        double c = -2.5587698885992534E-7;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_negatif__b_normal_positif__c_null() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -454.4296495570422;
        double b = 350.1075589292916;
        double c = 0.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_negatif_grand__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -8.697050135198476E8;
        double b = -9.089115294452915E-7;
        double c = -2.5654612250640243;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -4.406670244126577E-7;
        double b = 149.7405554422615;
        double c = 285.2333251383714;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_proche_de_0_positif__b_tres_proche_de_0_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 1.8745285166452326;
        double b = -6.114884551693249E-7;
        double c = -2.540363994819333;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_normal_positif__b_grand_positif__c_normal_positif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 205.82567785906548;
        double b = 3.569105322289874E8;
        double c = 360.57420103233426;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_grand_positif__b_tres_proche_de_zero__c_negatif_grand_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = 3.1284434451878715E8;
        double b = 1.818143254594306E-7;
        double c = -7.775960508908151E8;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
    @Test
    public void testSolve_a_tres_proche_de_0_negatif__b_normal_negatif__c_proche_de_0_negatif_() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
        double a = -6.817321944204003E-7;
        double b = -72.16501848671248;
        double c = -4.0608359199069355;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class).invoke(dynamicObject, a, b, c);
        if (a == 0 || b * b - 4 * a * c < 0) {
            assertEquals(0, result.length, "Doit retourner un tableau vide");
        } else {
            for (double root : result) {
                double check_result = a * root * root + b * root + c;
                assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
            }
        }
        saveTestResultToCSV(a, b, c, result, true);
    }
}
