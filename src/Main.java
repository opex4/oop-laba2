//20)
//a.В одномерный числовой массив добавьте число в указанное пользователем место, сдвигая элементы,
//начиная от заданной позиции, вправо;
//b.разверните указанное слово в предложении справа налево;
//c.добавьте в середину заданного слова предложения указанные символ, если слово состоит из нечетного числа букв,
//то замените в нем центральный символ на указанный символ;
//d.подсчитайте число заглавных букв в предложении.

public class Main {
    public static void main(String[] Args) throws CloneNotSupportedException {
        // Задача A
        TasksWithArray insertArr = new TasksWithArray(new int[]{1, 2, 3, 4, 5});
        insertArr.getArrayInsert(1, 0);
        insertArr.outputArray();

        // Задача B
        TasksWithSentence sentenceReversal = new TasksWithSentence("Мама мыла раму");
        sentenceReversal.outputSentence();
        sentenceReversal.wordReversal(2);
        sentenceReversal.outputSentence();

        // Задача C
        TasksWithSentence sentenceInsert = new TasksWithSentence("Мама мыла, стирала");
        sentenceInsert.insertSymbol(3,'1');
        sentenceInsert.outputSentence();

        // Задача D
        TasksWithSentence sentenceCapital = new TasksWithSentence("After school, Jake plays football.");
        System.out.println("Количество заглавных букв = " + sentenceCapital.countСapital()); // Число заглавных букв

        // Добавление в конец массива числа, созданного конструктором по умолчанию
        TasksWithArray toEnd = new TasksWithArray(new int[]{1, 2, 3, 4, 5});
        toEnd.outputArray();
        toEnd.toEnd(1);
        toEnd.outputArray();

        // Удаление числа из позиции
        TasksWithArray del = new TasksWithArray(new int[]{1, 2, 3, 4, 5});
        del.outputArray();
        del.del(3);
        del.outputArray();

        // Конструкторы по умолчанию
        TasksWithSentence sentenceDefault = new TasksWithSentence();
        sentenceDefault.outputSentence();
        TasksWithArray arrayDefault = new TasksWithArray();
        arrayDefault.outputArray();

        // Клонирование объектов
        TasksWithArray cloneArray = insertArr.clone();
        insertArr.outputArray();
        cloneArray.outputArray();

        TasksWithSentence cloneSentence = sentenceCapital.clone();
        sentenceCapital.outputSentence();
        cloneSentence.outputSentence();
    }
}