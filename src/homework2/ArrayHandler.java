package homework2;

public class ArrayHandler {

    public static String[][] fillArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr.length != 4)
                throw new MyArraySizeException("Массив должен быть 4*4");
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i].length != 4)
                    throw new MyArraySizeException("Массив должен быть 4*4");
                arr[i][j] = String.valueOf((int) (Math.random() * 10));
            }
        }
        String b = "bug";
        arr[(int) (Math.random() * arr.length)][(int) (Math.random() * arr.length)] = b;
        return arr;
    }

    public static int calcArray(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    String message = String.format("Найдено некалькулируемое значение в ячейке [%s][%s]", i, j);
                    throw new MyArrayDataException(message, i, j, e);
                }
            }
        }
        return sum;
    }

    public static int calcArrayWithoutBug(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } finally {
                    continue;
                }
            }
        }
        return sum;
    }

    public static void printArray(String[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
