import Task5.DeliveryDepartment;
import Task5.DeparturePoint;
import Task5.ReceivePoint;
import Task5.Shipment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Task 1
        final int a = 78;
        final int b = 5;
        final int c = -8;
        final String plus = "+";
        final String minus = "-";
        final String division = "/";
        final String wrong = "Error";
        //==============================
        System.out.println(" Task 1");
        System.out.println("Addition " + b + " i " + a + " : " + Task1.operation(a, b, plus));
        System.out.println("Subtraction " + c + " i " + a + " : " + Task1.operation(c, a, minus));
        System.out.println("Division by 2 " + a + " i " + c + " : " + Task1.operation(a, c, division));
        System.out.println("Wrong input : " + Task1.operation(a, b, wrong));

        //Task 2
        final String[] unsortedList = {"letters", "Big", "ArRAy", "BY", "SORTED"};
        //==============================
        Task2.bubbleSortByCapitalLetters(unsortedList);
        //==============================
        System.out.println("\n Task 2");
        System.out.println("Sorted array: ");
        for (String currentString : unsortedList) {
            System.out.print(currentString + " ");
        }

        //Task 3
        final String[] emailExamples = {
                "example@gmail.com",
                "exa123mple@gma|il.com",
                "example@gmail.",
                "example@ukr.net",
                "example@gmailcom"};
        //==============================
        System.out.println("\n\n Task 3");
        for (String str : emailExamples) {
            if (Task3.validateEmail(str))
                System.out.print(" Succeed operation ");
            else System.out.print(" Error ");

            System.out.println(" for address " + str);
        }

        //Task 4
        final int[][] matrix1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        final int[][] matrix2 = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        final int[][] matrix3 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        final int[][] matrix4 = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        //==============================
        final int[][] multiplyFirstAndSecond = Task4.multiplyMatrices(matrix1, matrix2);
        final int[][] multiplyThirdAndFourth = Task4.multiplyMatrices(matrix3, matrix4);
        final int[][] wrongMultiply = Task4.multiplyMatrices(matrix1, matrix4);
        //==============================
        System.out.println("\n Task 4");
        System.out.println("Matrix multiplication:");
        Task4.printMatrix(matrix1);
        Task4.printMatrix(matrix2);
        System.out.println("Result:");
        Task4.printMatrix(multiplyFirstAndSecond);
        System.out.println("Matrix multiplication:");
        Task4.printMatrix(matrix3);
        Task4.printMatrix(matrix4);
        System.out.println("Result:");
        Task4.printMatrix(multiplyThirdAndFourth);
        System.out.println("Matrix multiplication");
        Task4.printMatrix(matrix1);
        Task4.printMatrix(matrix4);
        System.out.println("Result:");
        Task4.printMatrix(wrongMultiply);

        //Task5
        final DeliveryDepartment lviv = new DeliveryDepartment("Lviv", true, true, true);
        final DeliveryDepartment kyiv = new DeliveryDepartment("Kyiv", true, true, true);
        final DeliveryDepartment rivne = new DeliveryDepartment("Rivne", false, false, true);
        final DeliveryDepartment khmelnytskyi = new DeliveryDepartment("Khmelnytskyi", true, false, false);
        final ReceivePoint[] receivePoints = {new ReceivePoint(kyiv), new ReceivePoint(khmelnytskyi)};
        final DeparturePoint[] departurePoints = {new DeparturePoint(lviv), new DeparturePoint(rivne), new DeparturePoint(kyiv)};
        final int MAX_SHIPMENTS = 10;
        boolean isContinue = true;
        Shipment[] shipments = new Shipment[MAX_SHIPMENTS];
        Scanner scanner = new Scanner(System.in);
        //==============================
        System.out.println("\n Task 5");
        do {
            System.out.println("Menu:\n1.Check all departures \n2.Add departure\n3.Delete delivery\n0.Exit");
            String choice = scanner.nextLine();
            int countOfShipmens = 0;
            for (Shipment ship : shipments) {
                if (ship != null) {
                    countOfShipmens++;
                }
            }
            switch (choice) {

                case "1": {
                    if (countOfShipmens < 1)
                        System.out.println("There are no departures");
                    for (int i = 0; i < countOfShipmens; i++) {
                        System.out.println("Departure №" + i + 1);
                        shipments[i].printShipment();
                    }
                    break;
                }
                case "2": {

                    if (countOfShipmens >= 10) {
                        System.out.println("Too many departures in array");
                        break;
                    }
                    Shipment newShipment = new Shipment(receivePoints, departurePoints, scanner);
                    if (countOfShipmens > 0)
                        shipments[countOfShipmens - 1] = newShipment;
                    else
                        shipments[0] = newShipment;
                    break;
                }
                case "3": {
                    if (countOfShipmens < 1) {
                        System.out.println("There are no departures");
                        break;
                    }
                    if (countOfShipmens == 1)
                        shipments = new Shipment[MAX_SHIPMENTS];
                    System.out.println("Number of departure ?");
                    int choiceofDelete;
                    try {
                        String receiverName = scanner.nextLine();
                        choiceofDelete = Integer.parseInt(receiverName);
                        if (choiceofDelete > countOfShipmens || choiceofDelete < 0)
                            throw new IllegalArgumentException("Wrong number");

                        shipments[choiceofDelete - 1] = shipments[countOfShipmens - 1];
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case "0":
                {
                    isContinue=false;
                    break;
                }

            }

        } while (isContinue);
        for (int i = 0; i < 5; i++) {
            Shipment shipmentLvivKyiv = new Shipment(receivePoints, departurePoints, scanner);
            shipmentLvivKyiv.printShipment();
            System.out.println("Your delivery!");
        }
        scanner.close();
    }
}