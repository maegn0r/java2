package homework5;

public class TestClass {

    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) throws InterruptedException {
        createLongArr(size);
        extendedCreateLongArr(size);
    }

    public static void createLongArr(int size) {

        float[] longArr = new float[size];
        for (int i = 0; i < longArr.length; i++) {
            longArr[i] = 1;

        }
        long startTimeMeasurement = System.currentTimeMillis();
        for (int i = 0; i < longArr.length; i++) {
            longArr[i] = (float) (longArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long stopTimeMeasurement = System.currentTimeMillis();
        System.out.println(stopTimeMeasurement - startTimeMeasurement);
    }

    public static void extendedCreateLongArr(int size) throws InterruptedException {
        float[] firstHalfOfLongArr = new float[h];
        float[] secondHalfOfLongArr = new float[h];

        float[] longArr = new float[size];
        for (int i = 0; i < longArr.length; i++) {
            longArr[i] = 1;
        }

        long startTimeMeasurement = System.currentTimeMillis();

        System.arraycopy(longArr, 0, firstHalfOfLongArr, 0, h);
        System.arraycopy(longArr, h, secondHalfOfLongArr, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < firstHalfOfLongArr.length; i++) {
                firstHalfOfLongArr[i] = (float) (firstHalfOfLongArr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < secondHalfOfLongArr.length; i++) {
                secondHalfOfLongArr[i] = (float) (secondHalfOfLongArr[i] * Math.sin(0.2f + (i + h) / 5) * Math.cos(0.2f + (i + h) / 5) * Math.cos(0.4f + (i + h) / 2));
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.arraycopy(firstHalfOfLongArr, 0, longArr, 0, h);
        System.arraycopy(secondHalfOfLongArr, 0, longArr, h, h);

        long stopTimeMeasurement = System.currentTimeMillis();

        System.out.println(stopTimeMeasurement - startTimeMeasurement);
    }
}
