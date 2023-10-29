package ba.unsa.etf.rpr.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Unesite brojeve (ili 'stop' za kraj unosa):");

        while (true) {
            String input = scanner.next();

            if (input.equals("stop")) {
                break;
            }

            input = input.toLowerCase();

            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Unesite valjani broj ili 'stop' za kraj unosa.");
            }
        }

        if (numbers.isEmpty()) {
            System.out.println("Nema unesenih brojeva.");
        } else {
            double min = findMin(numbers);
            double max = findMax(numbers);
            double mean = calculateMean(numbers);
            double standardDeviation = calculateStandardDeviation(numbers, mean);

            System.out.println("Minimum: " + min);
            System.out.println("Maksimum: " + max);
            System.out.println("Srednja vrijednost: " + mean);
            System.out.println("Standardna devijacija: " + standardDeviation);
        }
    }

    private static double findMin(List<Double> numbers) {
        double min = Double.MAX_VALUE;
        for (double number : numbers) {
            if (number < min) {
                min = number;
            }
        }
        return min;
    }

    private static double findMax(List<Double> numbers) {
        double max = Double.MIN_VALUE;
        for (double number : numbers) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }

    private static double calculateMean(List<Double> numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    private static double calculateStandardDeviation(List<Double> numbers, double mean) {
        double sumOfSquaredDifferences = 0;
        for (double number : numbers) {
            double difference = number - mean;
            sumOfSquaredDifferences += difference * difference;
        }
        return Math.sqrt(sumOfSquaredDifferences / numbers.size());
    }
}
