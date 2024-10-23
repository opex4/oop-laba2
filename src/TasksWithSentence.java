//b.разверните указанное слово в предложении справа налево;
//c.добавьте в середину заданного слова предложения указанные символ, если слово состоит из нечетного числа букв,
//то замените в нем центральный символ на указанный символ;
//d.подсчитайте число заглавных букв в предложении.

public class TasksWithSentence implements Cloneable {
    private String sentence;

    // Конструктор ввода предложения по умолчанию
    public TasksWithSentence(){
        this.sentence = "Мама мыла";
    }

    // Конструктор ввода предложения
    public TasksWithSentence(String sentence){
        this.sentence = sentence;
    }

    // Функция вывода предложения
    public  void outputSentence(){
        System.out.println(this.sentence);
    }

    // Функция подсчёта количество заглавных букв
    public int countСapital(){
        // Перевод строки в массив
        char[] arr;
        arr = this.sentence.toCharArray();
        // количество символов в предложении
        int amount = this.sentence.length();

        int capital = 0;
        // Прогоняем предложение
        for (int i = 0; i < amount; i++){
            // Подсчёт заглавных букв
            if ((arr[i] >= 'А' && arr[i] <= 'Я') || (arr[i] >= 'A' && arr[i] <= 'Z')) {
                capital += 1;
            }
        }
        return capital;
    }

    // Проверка на существование слова с таким номером
    public void wordReversal(int nom) {
        // Преобразуем строку в массив символов
        String[] words = this.sentence.split(" ");
        nom--;

        // Проверка на существование слова с таким номером
        if (nom >= 0 && words.length > nom) {
            char[] arr = words[nom].toCharArray();
            int amount = arr.length; // Количество символов в строке

            // Создаем новый массив символов для перевёрнутого предложения
            char[] newArr = new char[amount];

            // Копируем символы справа нале
            for (int i = 0; i < amount; i++) {
                newArr[i] = arr[amount - 1 - i];
            }

            // Заменяем слово на перевернутое
            words[nom] = "";
            for (int i = 0; i < newArr.length; i++) {
                words[nom] += newArr[i];
            }

            // Сборка предложения обратно
            this.sentence = "";
            for (int i = 0; i < words.length; i++) {
                this.sentence += words[i] + " ";
            }
        } else {
            System.out.print("Слова с таким номером нет\n");
        }
    }

    // Вставка символа в слово предложения
    public  void insertSymbol (int nom, char symbol){
        // Разбитие предложения на слова
        String[] words = this.sentence.split(" ");
        nom--;

        // Проверка на существование слова с таким номером
        if(nom >= 0 && words.length > nom){
            String word = words[nom]; // Изменяемое слово
            int amount = word.length(); // Количество символов в слове
            // Проверка на символ в конце слова
            if (word.charAt(amount - 1) == ',' || word.charAt(amount - 1) == '.' || word.charAt(amount - 1) == '?' ||
                    word.charAt(amount - 1) == '!' || word.charAt(amount - 1) == ';' || word.charAt(amount - 1) == ':'){
                // Если четное количество символов
                if ((amount - 1) % 2 == 0){
                    words[nom] = word.substring(0, (amount - 1) / 2);
                    words[nom] += symbol;
                    words[nom] += word.substring((amount - 1) / 2);
                    words[nom] += word.substring(amount);
                }else { // Если нечетное количество символов
                    words[nom] = word.substring(0, (amount - 1) / 2);
                    words[nom] += symbol;
                    words[nom] += word.substring((amount - 1) / 2 + 1);
                    words[nom] += word.substring(amount);
                }
            }
            else {
                // Если четное количество символов
                if (amount % 2 == 0) {
                    words[nom] = word.substring(0, amount / 2);
                    words[nom] += symbol;
                    words[nom] += word.substring(amount / 2);
                }else { // Если нечетное количество символов
                    words[nom] = word.substring(0, amount / 2);
                    words[nom] += symbol;
                    words[nom] += word.substring(amount / 2 + 1);
                }
            }
        }
        else {
            System.out.print("Слова с таким номером нет\n");
        }

        // Сборка предложения обратно
        this.sentence = "";
        for (int i = 0; i < words.length; i++){
            this.sentence += words[i] + " ";
        }
    }

    // Переопределение метода clone()
    @Override
    public TasksWithSentence clone() throws CloneNotSupportedException {
        return (TasksWithSentence) super.clone();
    }
}
