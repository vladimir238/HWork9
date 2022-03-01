import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создаем папку в папке  нашего проекта
        File folder = new File("Experiment");

        // Если папка создана не переписываем
        if (!folder.exists()) folder.mkdir();

        //Создаем имя файла
        Calendar calendar = Calendar.getInstance();

        //Имя файла это дата создания
         SimpleDateFormat fileDateName = new SimpleDateFormat("yyyyMdd_HHmmss");
        String fileName = fileDateName.format(calendar.getTime());
        System.out.println(fileName);
        File file = new File(folder, fileName + ".txt");

        // Проверяем результат создания файла
        boolean isCreated = file.createNewFile();
        System.out.println("Файл создан " + isCreated);

        //Можно посмотреть файлы которые мы создали
        String[] filesArr = folder.list();
        for (String b : filesArr)
            System.out.println(b);

        //Абсолютный адрес нашей папки
        System.out.println(folder.getAbsolutePath());

        // Удаляем созданные файлы
        for (String b : filesArr) {
            File fileDel = new File(folder.getAbsolutePath(),b);
            fileDel.delete();
        }
        //Удаляем созданную папку
        folder.delete();



    }
}
