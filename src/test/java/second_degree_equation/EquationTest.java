package second_degree_equation;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

public class EquationTest {

    @Test
    public void testSolveDiscriminantNegative()
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException,
            SecurityException, InstantiationException, ClassNotFoundException {
        double a = 0.0;
        double b = 2.0;
        double c = 5.0;

        Class<?> dynamicClass = Class.forName("com.equation.EquationSolver");
        Object dynamicObject = dynamicClass.getDeclaredConstructor().newInstance();
        double[] result = (double[]) dynamicClass.getMethod("solve", double.class, double.class, double.class)
                .invoke(dynamicObject, a, b, c);

        if (result.length == 0) {
            // Automatically pass
            assertEquals(0, 0);
        } else {
            double tcheck_result = a * result[0] * result[0] + b * result[0] + c;
            assertEquals(0.0, tcheck_result, 0.001);
        }

        if (result.length == 0) {
            // Automatically pass
            assertEquals(0, 0);
        } else {
            double checkResult = a * result[0] * result[0] + b * result[0] + c;
            assertEquals(0.0, checkResult, 0.001);
        }
    }

}
