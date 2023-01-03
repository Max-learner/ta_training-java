package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        Scanner scanner = new Scanner(System.in);
        int scannedNumber;
        int maximumNumber = scanner.nextInt();

        while (scanner.hasNext()) {
            scannedNumber = scanner.nextInt();
            if (scannedNumber != 0) {
                if (scannedNumber > maximumNumber) {
                    maximumNumber = scannedNumber;
                }
            } else {
                break;
            }
        }
        return maximumNumber;
    }

    public static void main(String[] args) {
        System.out.println("Test your code here!\n");
        System.out.println(max());
    }
}
