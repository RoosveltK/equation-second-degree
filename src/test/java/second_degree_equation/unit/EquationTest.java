package second_degree_equation.unit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EquationTest {

    @Test
    public void test_solve() {
        try {
            Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
            Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();

            double a = 0.0;
            double b = 2.0;
            double c = 5.0;

            double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                    .invoke(dynamicObject, a, b, c);

            if (a == 0 || b * b - 4 * a * c < 0) {
                assertEquals(0, result.length, "Doit retourner un tableau vide");
            } else {
                for (double root : result) {
                    double check_result = a * root * root + b * root + c;
                    assertEquals(0.0, check_result, 0.001, "La racine doit satisfaire l'équation");
                }
            }
        } catch (Exception e) {
            fail("Une exception a été levée lors du test : " + e.getMessage());
        }
    }

}
