package com.equation;

public class EquationSolver implements IEquationSolver {
    @Override
    public double[] solve(double a, double b,double c) {
        double discriminant = b * b - 4 * a * c;

        // Vérification des coefficients
        if (a == 0) {
            return new double[0];
        }
        
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            return new double[]{root1, root2};
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            return new double[]{root};
        } else {
            return new double[0];
        }
    }


}