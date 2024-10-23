//a.В одномерный числовой массив добавьте число в указанное пользователем место, сдвигая элементы,
//начиная от заданной позиции, вправо;
import java.util.Random;

public class TasksWithArray implements Cloneable{
    private int[] array;

    // Конструктор по умолчанию
    public TasksWithArray(){
        int[] randArray = new int[10];
        Random random = new Random();
        for (int i = 0; i < randArray.length; i++){
            randArray[i] = random.nextInt(10);
        }
        this.array = randArray;
    }

    // Конструктор для записи массива
    public TasksWithArray(int[] array){
        this.array = array;
    }

    // Функция вывода массова
    public void outputArray(){
        for (int i = 0; i < this.array.length; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.print("\n");
    }

    // Функция для вставки числа в массив с сдвигом
    public void getArrayInsert(int number, int position) {
        position--;
        if(position >= 0 && position <= this.array.length) {
            // Новый массив, который на 1 элемент больше
            int[] newArray = new int[this.array.length + 1];

            // Копируем элементы до позиции вставки
            for (int i = 0; i < position; i++) {
                newArray[i] = this.array[i];
            }

            // Вставляем новое число
            newArray[position] = number;

            // Копируем оставшиеся элементы с сдвигом вправо
            for (int i = position; i < this.array.length; i++) {
                newArray[i + 1] = this.array[i];
            }

            this.array = newArray; // Возвращаем новый массив
        }
        else {
            System.out.print("Позиция > 0 и Позиция <= длина массива + 1\n");
            return;
        }
    }

    // Удаление элемента массива
    public void del(int position){
        position--;
        if(position >= 0 && position < this.array.length) { // тут возможны беды
            // Новый массив, который на 1 элемент меньше
            int[] newArray = new int[this.array.length - 1];

            // Копируем элементы до позиции удаления
            for (int i = 0; i < this.array.length; i++) {
                if (i < position){
                    newArray[i] = this.array[i];
                } else if (i > position){
                    newArray[i -1] = this.array[i];
                }
            }

            this.array = newArray; // Возвращаем новый массив
        }
        else {
            System.out.print("Позиция > 0 и Позиция <= длина массива\n");
            return;
        }
    }

    // Добавление в конец
    public void toEnd(int number){
        // Новый массив, который на 1 элемент больше
        int[] newArray = new int[this.array.length + 1];

        // Копируем элементы до позиции вставки
        for (int i = 0; i < this.array.length; i++) {
            newArray[i] = this.array[i];
        }

        // Вставляем новое число в конец
        newArray[this.array.length] = number;

        this.array = newArray; // Возвращаем новый массив
    }

    // Записать массив
    public void setArray(int[] setArr){
        this.array = setArr;
    }

    // Получение массива из объекта
    public int[] getArray (){
        return this.array;
    }

    // Переопределение метода clone()
    @Override
    public TasksWithArray clone() throws CloneNotSupportedException {
        TasksWithArray tasksWithArray = (TasksWithArray) super.clone();
        int[] cloneArr = new int[this.array.length];
        System.arraycopy(this.array, 0, cloneArr, 0, this.array.length);
        tasksWithArray.setArray(cloneArr);
        return (tasksWithArray);
    }
}
