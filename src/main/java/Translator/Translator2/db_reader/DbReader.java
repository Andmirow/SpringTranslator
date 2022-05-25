package Translator.Translator2.db_reader;

import com.MMTR.readers.db_reader.ConnectDB;
import com.MMTR.readers.db_reader.SettingDb;
import com.MMTR.servis.UserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbReader {


    SettingDb settingDb = new SettingDb("flyway.english_words","english_word","flyway.russian_words","russian_word","flyway.english_transtator","english_id","russian_id");
    ConnectDB connectDB = new ConnectDB("postgres","1120697");
    com.MMTR.readers.db_reader.DbReader dbReader = new com.MMTR.readers.db_reader.DbReader(settingDb,connectDB);
    com.MMTR.servis.UserDAO userDAO = new UserDAO(dbReader,connectDB);


}
