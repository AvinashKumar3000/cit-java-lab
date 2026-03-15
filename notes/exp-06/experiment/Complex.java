public class Complex {

    private double real;
    private double imag;
    private static int count = 0;

    public Complex() {
        real = 0;
        imag = 0;
        count++;
    }

    public Complex(double r, double i) {
        real = r;
        imag = i;
        count++;
    }

    public Complex add(Complex other) {
        Complex result = new Complex();
        result.real = this.real + other.real;
        result.imag = this.imag + other.imag;
        return result;
    }

    public void display() {
        System.out.println(real + " + " + imag + "i");
    }

    public static int getCount() {
        return count;
    }

    @Override
    protected void finalize() {
        count--;
    }

    public static void main(String[] args) {

        System.out.println("Active Objects: " + Complex.getCount());

        Complex c1 = new Complex(3, 4);
        Complex c2 = new Complex(5, 6);

        System.out.println("After creating c1 and c2:");
        System.out.println("Active Objects: " + Complex.getCount());

        System.out.print("c1 = ");
        c1.display();

        System.out.print("c2 = ");
        c2.display();

        Complex c3 = c1.add(c2);

        System.out.print("c1 + c2 = ");
        c3.display();

        System.out.println("After addition (c3 created):");
        System.out.println("Active Objects: " + Complex.getCount());

        c1 = null;
        c2 = null;
        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // ignored
        }

        System.out.println("After setting c1, c2 to null and calling gc:");
        System.out.println("Active Objects: " + Complex.getCount());
    }
}
