package homework2;

public class TestClass {
    public static void main(String[] args) {
        String[][] arr = ArrayHandler.fillArray(new String[4][4]);
        ArrayHandler.printArray(arr);
        try {
            System.out.println("Сумма всех элементов массива = " + ArrayHandler.calcArray(arr));
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Сумма всех элементов массива, исключая некалькулируемый элемент [" + e.getX() + "][" + e.getY() + "], равна " + ArrayHandler.calcArrayWithoutBug(arr));
        }
    }
}
