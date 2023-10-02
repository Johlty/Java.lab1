package Task5;

import java.util.Scanner;
public class Shipment {
    private static final int MAX_ITEMS = 11;
    private Item[] items;
    private Customer sender, receiver;
    private DeparturePoint departure;
    private ReceivePoint receive;
    private double maxWeight;
    private double totalWeight;

    public Shipment(Customer sender, Customer receiver, DeparturePoint departure, ReceivePoint receive) {
        this.items = new Item[MAX_ITEMS];
        this.totalWeight = 0;
        this.sender = sender;
        this.receiver = receiver;
        this.departure = departure;
        this.receive = receive;
        this.maxWeight = Math.max(departure.getMaxWeight(), receive.getMaxWeight());
    }

    public Shipment(ReceivePoint[] receivePoints, DeparturePoint[] departurePoints, Scanner scanner) {
        this.createShipment(receivePoints, departurePoints, scanner);
    }

    public void createShipment(ReceivePoint[] receivePoints, DeparturePoint[] departurePoints, Scanner scanner) {
        try {

            System.out.println("Input initials of sender:");
            String senderName = scanner.nextLine();
            sender = new Customer(senderName);
            System.out.println("Input initials of recipient:");
            String receiverName = scanner.nextLine();
            receiver = new Customer(receiverName);
            boolean good = false;
            do {
                System.out.println("List of available addresses to send:");
                for (DeparturePoint departurePoint : departurePoints) {
                    System.out.print(departurePoint.getAddress() + " ");
                }
                System.out.println();
                System.out.println("Input address of sender:");
                String senderAddress = scanner.nextLine();
                for (DeparturePoint departurePoint : departurePoints) {
                    if (senderAddress.equalsIgnoreCase(departurePoint.getAddress())) {
                        departure = departurePoint;
                        good = true;
                        break;
                    }
                }


            } while (!(good));
            good = false;
            do {
                System.out.println("List of available addresses to receive in department:");
                for (ReceivePoint receivePoint : receivePoints) {
                    System.out.print(receivePoint.getAddress() + " ");
                }
                System.out.println();
                System.out.println("Input address of receiver:");
                String receiverAddress = scanner.nextLine();
                for (ReceivePoint receivePoint : receivePoints) {
                    if (receiverAddress.equalsIgnoreCase(receivePoint.getAddress())) {
                        receive = receivePoint;
                        good = true;
                        break;
                    }
                }
                if (good)
                    break;
                System.out.println("Department not found, send by courier? (y/n)");
                String isCourier = scanner.nextLine();
                if (isCourier.equalsIgnoreCase("y")) {
                    receive = new ReceivePoint(new Courier(receiverAddress));
                    good = true;
                }
            } while (!(good));
            maxWeight = Math.max(departure.getMaxWeight(), receive.getMaxWeight());

            items = new Item[MAX_ITEMS];
            totalWeight = 0;
            while (AddItemFromConsole(scanner)) ;
            //this.printShipment();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void printShipment() {
        System.out.println("Number of items: " + totalItems());
        for (Item item : items) {
            if (item != null)
                System.out.println("Weight: " + item.getWeight() + " kilograms, description: " + item.getDescription());
        }
        System.out.println("Total weight : " + totalWeight);
        System.out.println("Sender: " + sender.getInitials());
        System.out.println("Receiver: " + receiver.getInitials());
        System.out.println("Address of sender: " + departure.getAddress());
        System.out.print("Address of receiver: " + receive.getAddress());
        if (receive.getIsCourier())
            System.out.println("By courier");
        else
            System.out.println("Department");
        System.out.println("Total weight: " + maxWeight);
    }

    public boolean AddItemFromConsole(Scanner scanner) {
        System.out.println("Add items? (y/n)");
        String isCourier = scanner.nextLine();
        if (isCourier.equalsIgnoreCase("y")) {
            System.out.println("Description: ");
            String description = scanner.nextLine();
            System.out.println("Weight: ");
            double weight = Double.parseDouble(scanner.nextLine());
            System.out.println(weight);
            AddItem(new Item(weight, description));
            return true;
        }
        return false;
    }

    public void AddItem(Item item) {

        if (totalWeight + item.getWeight() > maxWeight) {
            System.out.println("Too much weight!");
            return;
        }
        if (totalItems() >= MAX_ITEMS) {
            System.out.println("Too many items for one delivery!");
            return;
        }
        items[totalItems()] = item;
        totalWeight += item.getWeight();
    }

    public int totalItems() {
        int count = 0;
        for (Item item : items) {
            if (item != null) {
                count++;
            }
        }
        return count;
    }
}