package app;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    // 1. Проверяем, действительно ли метод выдает ошибку при отриц.значении.
    // 2. Проверим, правильный ли размер массива.
    // 3. Проверим работу метода при граничных значениях.
    // 4. Действительно ли соседние элементы отличаются на 1.
    // 5. Точечно проверим внутренние значения в массиве.
    // 6. Проверим, что метод возвращает не null.

    @Test(expected = IllegalArgumentException.class)
    public void checkExpectedException() {
        Main.getArray(-1);
    }

    @Test
    public void checkIfArraySizeIsCorrect() {
        int[] result = Main.getArray(7);
        int expectedSize = 7;
        int actualSize = result.length;
        Assert.assertEquals(expectedSize, actualSize);
    }
}