package pr11.task1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskInfo {
    public static void main(String[] args){
        String developer = "Иванов";

        long receivedTime = System.currentTimeMillis() -
                (5 * 24 * 60 * 60 * 1000);
        long submissionTime = System.currentTimeMillis();

        Date receivedDate = new Date(receivedTime);
        Date submissionDate = new Date(submissionTime);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy'г.' HH:mm:ss");

        System.out.println("Фамилия разработчика: " + developer);
        System.out.println("Дата и время получения задания: " + dateFormat.format(receivedDate));
        System.out.println("Дата и время сдачи задания: " + dateFormat.format(submissionDate));
    }
}
