public class Demo {
    public static void main(String[] args) {
        Stack stack = new Stack(5);

        Customer customer1 = new Customer("1", "Volkan");
        Customer customer2 = new Customer("2", "Mert");
        Customer customer3 = new Customer("3", "Gorkem");

        stack.push(customer1);
        stack.push(customer2);
        stack.push(customer3);

        System.out.println("Stack:");
        stack.printStack();

        int size = stack.getSize();
        for (int i = 0; i< size; i++) {
            stack.pop();
        }

        System.out.println("Stack:");
        stack.printStack();
    }
}