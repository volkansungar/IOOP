import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Rectangle {
    public double width, height = 1;
    //no args constructor
    public Rectangle() {}

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }
    //copy constructor
    public Rectangle(Rectangle rectangle) {
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException();
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
       if (o == this) {
           return true;
       }
       if (!(o instanceof Rectangle)) {
           return false;
       }
       Rectangle r = (Rectangle) o;
       return Double.compare(width, r.width) == 0
               && Double.compare(height, r.height) == 0;
    }


}

class Circle {
    public double radius = 1;
    //No args Constructor
    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }
    //Copy Constructor
    public Circle(Circle circle) {
        this.radius = circle.radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        }
        this.radius = radius;
    }


    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Rectangle)) {
            return false;
        }
        Circle c = (Circle) o;
        return Double.compare(radius, c.radius) == 0;
    }
}

class Demo {
    public static void main(String[] args) {
        try {
            File file = new File("inputQuiz1.txt");
            Scanner sc = new Scanner(file);
            //read file
            while (sc.hasNextLine()) {
                //split line into data array
                String[] data = sc.nextLine().split(",");
                if (data[0].equalsIgnoreCase("rectangle")) {
                    double width = Double.parseDouble(data[1]);
                    double height = Double.parseDouble(data[2]);

                    Rectangle rectangle = new Rectangle(width, height);

                    System.out.println(rectangle+
                            " Area = "+rectangle.getArea()+
                            " Perimeter = "+rectangle.getPerimeter());

                } else if (data[0].equalsIgnoreCase("circle")) {
                    double radius = Double.parseDouble(data[1]);

                    Circle circle = new Circle(radius);

                    System.out.println(circle+
                            " Area = "+String.format("%.2f", circle.getArea())+
                            " Perimeter = "+String.format("%.2f", circle.getPerimeter()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(15);
        rectangle.setHeight(10);
        //copy
        Rectangle clone_rectangle = new Rectangle(rectangle);

        if (rectangle.equals(clone_rectangle)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

        System.out.println(rectangle);
        System.out.println(clone_rectangle);
    }
}
