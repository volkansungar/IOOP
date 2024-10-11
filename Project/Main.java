import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import static java.lang.Math.abs;


public class Main {
    final static int MAX_CUSTOMER = 200;
    static String[] products = new String[0];
    static String names = "";
    static int productCount = 0;
    static String[][] ratings = new String[0][];
    static CustomerList list = new CustomerList();
    static int lineCount = 0;
    static int customerCount;
    public static void main(String[] args) throws Exception {



        String doContinue;

        do {
            //print the menu
            BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Select your choice from the menu:");
            System.out.println("1) Construct data structures");
            System.out.println("2) Enter a new customer");
            System.out.println("3) Calculate average ratings for each product");
            System.out.println("4) Calculate average ratings for each product for only customers from Turkey");
            System.out.println("5) Calculate average ratings for each product for customers except from Turkey");
            System.out.println("6) Calculate average ratings for each product for only Doctors");
            System.out.println("7) Print the customer info LinkedList");
            System.out.println("8) Print the 2D array");

            String choice = kb.readLine();
            switch (choice) {
                case "1":
                    //read the file and create data structures
                    File file = new File("Firma.txt");
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    names = br.readLine();
                    products = names.split(",");
                    productCount = Integer.parseInt(products[0]);
                    ratings = new String[MAX_CUSTOMER][productCount + 1];

                    String st;
                    lineCount = 0;
                    while ((st = br.readLine()) != null) {
                        String[] customerInfo = st.split(",");
                        if (lineCount % 2 == 0) {
                            ratings[lineCount / 2][0] = customerInfo[0];
                            String name = customerInfo[1];
                            String surname = customerInfo[2];
                            String country = customerInfo[3];
                            String city = customerInfo[4];
                            String occupation = customerInfo[5];
                            //add customers to linkedlist
                            CustomerData customer = new CustomerData(name, surname, country, city, occupation);
                            addOrdered(list, customer, Integer.parseInt(customerInfo[0]));
                        } else {
                            //add customers to 2d array
                            System.arraycopy(customerInfo, 0, ratings[lineCount / 2], 1, productCount);
                        }

                        lineCount++;
                    }
                    customerCount = lineCount / 2;
                    break;
                case "2":
                    String hasNext;
                    do {
                        //get customer data from keyboard
                        System.out.println("Enter name:");
                        String name = kb.readLine();
                        System.out.println("Enter surname:");
                        String surname = kb.readLine();
                        System.out.println("Enter country:");
                        String country = kb.readLine();
                        System.out.println("Enter city:");
                        String city = kb.readLine();
                        System.out.println("Enter occupation:");
                        String occupation = kb.readLine();
                        System.out.println("Enter customer number:");
                        int customerNumber = Integer.parseInt(kb.readLine());
                        //get ratings for the first (n-1) products
                        System.out.println("Enter ratings for the first " + (productCount - 1) + " products (" + names + "):");
                        double[] kbRatings = new double[productCount - 1];
                        //hash map used to store similarity between the keyboard values and file values
                        // as customer data as key
                        HashMap<String, Double> similarity = new HashMap<>();
                        for (int i = 0; i < productCount - 1; i++) {
                            System.out.println("Enter rating for product " + products[i + 1]);
                            String input = kb.readLine();
                            if (input != null) {
                            kbRatings[i] = Double.parseDouble(input);
                            ratings[customerCount][i + 1] = input;
                        }}

                        //minimum difference is set productCount times 5 initially because it needs to get lower
                        // as the program proceeds so the initial value should be the maximum value possible
                        double minDifference = productCount * 5;
                        double forecast = 0;
                        for (int i = 0; i < MAX_CUSTOMER; i++) {
                            double difference = 0;
                            for (int j = 0; j < productCount - 1; j++) {
                                if (ratings[i][j + 1] != null) {
                                    difference += abs(kbRatings[j] - Double.parseDouble(ratings[i][j + 1]));
                                }
                            }
                            if (ratings[i][0] != null && difference < minDifference) {
                                similarity.clear();
                                forecast = 0;
                                minDifference = difference;
                                forecast += Double.parseDouble(ratings[i][ratings[i].length - 1]);
                                similarity.put(ratings[i][0], difference);
                            } else if (ratings[i][0] != null && difference == minDifference) {
                                similarity.put(ratings[i][0], difference);
                                forecast += Double.parseDouble(ratings[i][ratings[i].length - 1]);
                            }
                        }
                        forecast = forecast / similarity.size();

                        System.out.println("The forecast for the last product: ");
                        System.out.printf("%.2f", forecast);
                        System.out.println("");
                        ratings[customerCount][0] = String.valueOf(customerNumber);
                        ratings[customerCount][productCount] = String.valueOf(forecast);

                        CustomerData customer = new CustomerData(name, surname, country, city, occupation);
                        addOrdered(list, customer, customerNumber);


                        System.out.println("Do you want to enter another customer? (Y/N)");
                        hasNext = kb.readLine();
                        customerCount++;

                    } while (hasNext.equalsIgnoreCase("y"));
                    break;

                case "3":
                    calculateAverage("total");
                    break;
                case "4":
                    calculateAverage("turkey");
                    break;
                case "5":
                    calculateAverage("not turkey");
                    break;
                case "6":
                    calculateAverage("doctor");
                    break;
                case "7":
                    list.outputList();
                    break;
                case "8":
                    System.out.println(Arrays.deepToString(ratings));
                    break;
            }
            System.out.println("Continue with another selection? (Y/N)");
            doContinue = kb.readLine();

        }while(doContinue.equalsIgnoreCase("Y"));
    }

    public static boolean addOrdered(CustomerList list, CustomerData data, int customerNumber) {
        CustomerList.ListIterator iterator = list.iterator();

        while(iterator.hasNext()) {
            int compareResult = (iterator.next().customerNumber-customerNumber);
            if (compareResult==0){
                iterator.addHere(data, customerNumber);
                return true;
            }else if(compareResult > 0) {
                iterator.previous();
                iterator.addHere(data, customerNumber);
                return true;
            }
        }
        iterator.addHere(data, customerNumber);
        return true;
    }

    public static void calculateAverage(String occupation) {

        for (int i = 0; i < productCount; i++) {
            double totalRating = 0;
            double turkeyTotal = 0;
            double doctorTotal = 0;
            double notTurkeyTotal = 0;
            int totalCustomer = 0;
            int turkeyCustomer = 0;
            int doctorCustomer = 0;
            int notTurkeyCustomer = 0;
            for (int j = 0; j < MAX_CUSTOMER; j++) {
                //iterate in ratings to get the value for each product and add them as totalRating
                if (ratings[j][i + 1] != null) {
                    totalRating += Double.parseDouble(ratings[j][i + 1]);
                    if (list.checkDoctor(Integer.parseInt(ratings[j][0]))) {
                        doctorTotal += Double.parseDouble(ratings[j][i + 1]);
                        doctorCustomer++;
                    }
                    if (list.checkTurkey(Integer.parseInt(ratings[j][0]))) {
                        turkeyTotal += Double.parseDouble(ratings[j][i + 1]);
                        turkeyCustomer++;
                    } else {
                        notTurkeyTotal += Double.parseDouble(ratings[j][i + 1]);
                        notTurkeyCustomer++;
                    }
                    totalCustomer++;

                }
            }
            double averageRating = 0;
            double doctorAverage = 0;
            double turkeyAverage = 0;
            double notTurkeyAverage = 0;
            if (totalCustomer != 0)
                averageRating = totalRating / totalCustomer;
            if (doctorCustomer != 0)
                doctorAverage = doctorTotal / doctorCustomer;
            if (turkeyCustomer != 0)
                turkeyAverage = turkeyTotal / turkeyCustomer;
            if (notTurkeyCustomer != 0)
                notTurkeyAverage = notTurkeyTotal / notTurkeyCustomer;
            if (occupation.equalsIgnoreCase("total")) {
                System.out.println("Average rating for product " + products[i + 1] + ":");
                System.out.printf("%.2f", averageRating);
                System.out.println("");
            } else if (occupation.equalsIgnoreCase("doctor")) {
                System.out.println("Average Doctor rating for product " + products[i + 1] + ":");
                System.out.printf("%.2f", doctorAverage);
                System.out.println("");
            } else if (occupation.equalsIgnoreCase("turkey")) {
                System.out.println("Average Turkey rating for product " + products[i + 1] + ":");
                System.out.printf("%.2f", turkeyAverage);
                System.out.println("");
            } else if (occupation.equalsIgnoreCase("not turkey")) {
                System.out.println("Average rating for product " + products[i + 1] + " for customers outside of Turkey:");
                System.out.printf("%.2f", notTurkeyAverage);
                System.out.println("");
                
            }
        }
    }
}