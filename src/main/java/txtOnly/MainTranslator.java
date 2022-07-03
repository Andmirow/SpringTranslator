package txtOnly;

import com.MMTR.readers.TxtReader;
import com.MMTR.readers.db_reader.ConnectDB;
import com.MMTR.readers.db_reader.DbReader;
import com.MMTR.readers.db_reader.SettingDb;
import com.MMTR.servis.UserDAO;

import java.util.List;
import java.util.Scanner;

public class MainTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDAO userDAO;
        System.out.println("введите маску для словаря если она есть");
        String mask = scanner.nextLine();

        System.out.println("введите путь и название словаря");
        String plase = scanner.nextLine();
        TxtReader txtReader = new TxtReader(plase);
        userDAO = new UserDAO(txtReader,mask);

        boolean work = true;
        while (work){
            System.out.println("Команды: \n" +
                    "выбратьВсе \n" +
                    "найти \n" +
                    "удалить \n" +
                    "добавить \n"+
                    "выход");
            String comand = scanner.nextLine();
            if (comand.equals("выбратьВсе")){
                List<String> list = userDAO.selectAll();
                for(String line : list){
                    System.out.println(line);
                }
            }else if (comand.equals("найти")){
                System.out.println("введите слово которое хотите найти");
                System.out.println(userDAO.find(scanner.nextLine()).toString());
            }else if (comand.equals("удалить")){
                System.out.println("введите слово которое хотите удалить");
                boolean res = userDAO.delite(scanner.nextLine());
                if (res){
                    System.out.println("слово успешно удалено");
                }else
                    System.out.println("не удалось удалить слово");
            }else if (comand.equals("добавить")){
                System.out.println("введите слово по словарю");
                String first = scanner.nextLine();
                System.out.println("введите перевод");
                String second = scanner.nextLine();
                boolean res = userDAO.Add(first,second);
                if (res){
                    System.out.println("слово успешно добавлено");
                }else
                    System.out.println("не удалось добавить слово");
            }else if (comand.equals("выход")){
                    work = false;;
            } else
                System.out.println("не правильная команда");
            }


    }
}
