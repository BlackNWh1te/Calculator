package Calculator;

import java.util.Scanner;


/**
 * @author Джон
 */
public class Calculator {


    public Calculator() {
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Calculator calc = new Calculator();


        while (true) {


            calc.getInstructions();

            int b = scanner.nextInt();


            if (b == 0) break;


            /* Проверка на соответствие диапазону опций
               Выводит на экран результат, в случае соответствия
             */
            else if (b >= 1 && b <= 5) {
                System.out.println("\nEnter first fraction number:");
                double fractionalOne = scanner.nextDouble();

                System.out.println("\nEnter second fraction number:");
                double fractionalTwo = scanner.nextDouble();

                calc.evaluate(b, fractionalOne, fractionalTwo);

            }

            //Выбрана несуществующая опция. Возврат к выводу инструкций
            else
                System.out.println("Incorrect option\n");


        }


    }

    /**
     * @param option        выбор типа оператора в блоке switch
     * @param fractionalOne первый операнд
     * @param fractionalTwo второй операнд
     * @return возвращает результат арифм. выражения
     */

    private void evaluate(int option, double fractionalOne, double fractionalTwo) {


        switch (option) {

            case 1:
                System.out.printf("%f + %f = %.4f", fractionalOne, fractionalTwo, (fractionalOne + fractionalTwo));
                return;
            case 2:
                System.out.printf("%f - %f = %.4f", fractionalOne, fractionalTwo, (fractionalOne - fractionalTwo));
                return;
            case 3:
                System.out.printf("%f * %f = %.4f", fractionalOne, fractionalTwo, (fractionalOne * fractionalTwo));
                return;

            case 4:
                try {

                    if (fractionalTwo == 0.00) {
                        throw new ArithmeticException();
                    } else
                        System.out.printf("%f / %f = %.4f", fractionalOne, fractionalTwo, (fractionalOne / fractionalTwo));

                } catch (ArithmeticException e) {
                    System.out.println("\nCan't divide by zero!");
                    return;
                }


        }
    }


    //выводит инструкции
    private void getInstructions() {
        System.out.println("\nChoose one of the following operations:\n");
        System.out.println("1 for addition\n2 for subtraction\n3 for multiplication\n4 for division\n0 to quit\n");
    }

}

