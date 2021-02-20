package HomeWork_22_02;

import java.util.Iterator;

public class FibonacciRange implements Iterable<Integer> { // итерирует до числа N или N чисел Фиббонанчи
    private final int length;
    protected int counter;
    private int firstValue = 0;
    private int secondValue = 1;
    private int sum;

    public FibonacciRange(int length) {
        this.length = length;
        counter = 0;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return counter < length;
            }

            @Override
            public Integer next() {
                switch (counter) {
                    case 0:
                        counter++;
                        return firstValue;
                    case 1:
                        counter++;
                        return secondValue;
                    default:
                        counter++;
                        sum = firstValue + secondValue;
                        firstValue = secondValue;
                        secondValue = sum;
                        return sum;
                }
            }
        };
    }
}


