package edu.forty.bits.problemsolving.competitive.esko;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Write a program to sort a set of given units and output a single relationship equation among the
 * units in descending order of size. The input given will be a series of comma separated units and
 * a set of relationship equations between them. From these equations, you are expected to derive a
 * single relationship equation in descending order of the units, with the largest unit on the left.
 * Further, the following are given:
 *
 * <p>The number of equations given will be 1 less than the number of units given
 *
 * <p>To keep it simple, only units that can be expressed as integer multiples of each other should
 * be considered. Meaning, the equations must not contain fractional multipliers
 *
 * <p>--Input-- First line contains name of all the units separated by comma - no spaces If there
 * are M units in the above line then there will be M-1 lines in the input that defines relation
 * between the quanitites. The input format of the relationship between the units is - a = bc where
 * a is the string that denotes unit on the left hand side of the
 * eqquation , then followed by the space is the = symbol , then followed by space is an integer
 * value b and then followed by space is the string c that denotes
 * unit on the right hand side.
 *
 * <p>Output
 *
 * <p>In the output you need to print a single string that denotes
 * relation between all the units in the descending order of their value as per the sample output.
 *
 * <p>Constraint 1 <= M <= 10
 */
public class UnitBalancer {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Set<String> overallUnits = new HashSet<>(Arrays.asList(scanner.nextLine().split(",")));
        int eqnBound = overallUnits.size() - 1;

        // list of equations
        Set<Equation> equations =
                IntStream.range(0, eqnBound)
                        .mapToObj(i -> Arrays.asList(scanner.nextLine().split(" ")))
                        .map(eq -> new Equation(eq.get(0), Integer.parseInt(eq.get(2)), eq.get(3)))
                        .collect(Collectors.toCollection(() -> new HashSet<>(eqnBound)));

        Set<Equation> resolvedEquations = resovleEquationsForMultipleSimilarKeys(equations);

        // create a finalUnit to Equation mapping
        Map<String, Equation> finalUnitToEquaionMapping =
                resolvedEquations.stream()
                        .collect(Collectors.toMap(Equation::getFinalUnit, eq -> eq, (a, b) -> b));

        String iterationUnit = findMaxUnit(overallUnits, equations); // to start iterating downwards

        long multiplier = 1;
        StringBuilder finalRepresentation = new StringBuilder();

        while (true) {
            finalRepresentation.append(multiplier).append(iterationUnit).append(" = ");
            Equation currentEquation = finalUnitToEquaionMapping.get(iterationUnit);
            if (currentEquation == null) break; // no mapping of minUnit
            multiplier = multiplier * currentEquation.getMultiplier();
            iterationUnit = currentEquation.getInitialUnit();
        }
        System.out.println(finalRepresentation.substring(0, finalRepresentation.length() - 3));
    }

    // find the max unit to represented as unity
    private static String findMaxUnit(Set<String> overallUnits, Set<Equation> equations) {
        Set<String> initialUnits = initialUnits(equations);
        overallUnits.removeAll(initialUnits);
        return overallUnits.iterator().next();
    }

    private static Set<String> finalUnits(Set<Equation> equations) {
        return equations.stream().map(Equation::getFinalUnit).collect(Collectors.toSet());
    }

    private static Set<String> initialUnits(Set<Equation> equations) {
        return equations.stream().map(Equation::getInitialUnit).collect(Collectors.toSet());
    }

    private static Set<Equation> resovleEquationsForMultipleSimilarKeys(
            Set<Equation> initialEquation) {
        Map<String, List<Equation>> eqMappings = new HashMap<>();
        for (Equation equation : initialEquation) {
            if (eqMappings.containsKey(equation.getFinalUnit())) {
                List<Equation> updatedEquations = eqMappings.get(equation.getFinalUnit());
                updatedEquations.add(equation);
                eqMappings.put(equation.getFinalUnit(), updatedEquations);
            } else {
                List<Equation> equationList = new ArrayList<>();
                equationList.add(equation);
                eqMappings.put(equation.getFinalUnit(), equationList);
            }
        }

        eqMappings.forEach(
                (key, value) -> {
                    value.sort(Comparator.comparingInt(Equation::getMultiplier));
                    eqMappings.put(key, value);
                });

        Set<Equation> finalEquations = new HashSet<>();

        eqMappings.forEach(
                (key, value) -> {
                    Equation firstEq = value.get(0);
                    finalEquations.add(firstEq);
                    String finalUnit = firstEq.getInitialUnit();
                    int initMul = firstEq.getMultiplier();
                    for (int i = 1; i < value.size(); i++) {
                        Equation currentEq = value.get(i);
                        finalEquations.add(
                                new Equation(
                                        finalUnit, currentEq.getMultiplier() / initMul, currentEq.getInitialUnit()));
                        initMul = currentEq.getMultiplier();
                        finalUnit = currentEq.getInitialUnit();
                    }
                });
        return finalEquations;
    }

    // package private attributes and scope
    private static class Equation {
        String finalUnit;
        int multiplier;
        String initialUnit;

        Equation(String finalUnit, int multiplier, String initialUnit) {
            this.finalUnit = finalUnit;
            this.multiplier = multiplier;
            this.initialUnit = initialUnit;
        }

        String getFinalUnit() {
            return finalUnit;
        }

        int getMultiplier() {
            return multiplier;
        }

        String getInitialUnit() {
            return initialUnit;
        }
    }
}

// day,hour,second,minute
// day = 24 hour
// hour = 60 minute
// minute = 60 second

// day,hour,second,minute
// day = 24 hour
// day = 1440 minute
// day = 86400 second

// day,hour,second,minute
// day = 24 hour
// hour = 60 minute
// hour = 1440 second

// 1day = 24hour = 1440minute = 86400second
