public class Number {
    private double real;
    private double imaginary;

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public Number(double real) {
        this.real = real;
        this.imaginary = 0;
    }

    public Number(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static Number add(Number left, Number right) {
        return new Number(left.getReal() + right.getReal(), left.getImaginary() + right.getImaginary());
    }

    public static Number subtract(Number left, Number right) {
        return new Number(left.getReal() - right.getReal(), left.getImaginary() - right.getImaginary());
    }

    public static Number multiply(Number left, Number right) {
        return new Number(left.getReal() * right.getReal() - left.getImaginary() * right.getImaginary(),
                left.getReal() * right.getImaginary() + left.getImaginary() * right.getReal());
    }

    @Override
    public String toString() {
        if (this.getImaginary() >= 0) {
            return this.getReal() + " + " + this.getImaginary() + "i";
        } else {
            return this.getReal() + " - " + this.getImaginary() * -1 + "i";
        }
    }
}