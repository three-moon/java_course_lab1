import javax.annotation.processing.SupportedSourceVersion;

public class Main {
    public static void main(String[] args) {
        //Создание вещественного числа
        System.out.println("Num1:");
        Number num1 = new Number(1);
        System.out.println(num1);

        //Создание комплексного числа
        System.out.println("Num2:");
        Number num2 = new Number(3,1);
        System.out.println(num2);

        //Сложение, вычитание, умножение
        System.out.println("Add, subtract, multiply results:");
        System.out.println(Number.add(num1, num2));
        System.out.println(Number.subtract(num1, num2));
        System.out.println(Number.multiply(num1, num2));

        //Создание матриц и заполнение рандомными числами
        Matrix matrix1 = new Matrix(8, 8);
        matrix1.fillRandom();
        System.out.println("Matrix 1:");
        System.out.println(matrix1);

        Matrix matrix2 = new Matrix(8, 8);
        matrix2.fillRandom();
        System.out.println("Matrix 2:");
        System.out.println(matrix2);

        //Пример удачного сложения
        try {
            Matrix matrix3 = Matrix.add(matrix1, matrix2);
            System.out.println("Matrix 3 (Matrix 1 add Matrix 2)");
            System.out.println(matrix3);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Matrix matrix4 = new Matrix(2, 2);
        matrix4.fillRandom();

        //Пример неудачного действия с обработкой исключения
        try {
            Matrix matrix5 = Matrix.add(matrix1, matrix4);
            System.out.println("Matrix 5 (Matrix 1 add Matrix 4):");
            System.out.println(matrix5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        Matrix matrix6 = new Matrix(2, 6);
        matrix6.fillRandom();

        //Пример умножения
        try {
            Matrix matrix7 = Matrix.multiply(matrix4, matrix6);
            System.out.println("Matrix 7 (Matrix 4 multiply Matrix 6):");
            System.out.println(matrix7);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        //Пример транспонирования
        try {
            Matrix matrix8 = Matrix.transpose(matrix6);
            System.out.println("Matrix 8 (transpose Matrix 6):");
            System.out.println(matrix8);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}