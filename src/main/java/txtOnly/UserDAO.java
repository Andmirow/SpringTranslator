package txtOnly;

import com.MMTR.readers.db_reader.DB_Interfase;
import com.MMTR.servis.CRUD_Interface;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDAO{

    private CRUD_Interface reader;
    private String mask;

    public UserDAO(CRUD_Interface reader){
        this.reader = reader;
    }

    public UserDAO(CRUD_Interface reader, String mask){
        this.reader = reader;
        if (!mask.equals("")){
            this.mask = mask;
        }
   }

    public boolean Add(String word, String translete) {
        if (mask != null){
            Pattern pattern = Pattern.compile(mask);
            Matcher matcher = pattern.matcher(word);
            if (matcher.matches()){
                return reader.Add(word,translete);
            }else{
                return false;
            }
        }else {
            return reader.Add(word,translete);
        }
    }

    public List find(String word) {
        return reader.find(word);
    }


    public List selectAll() {
        return reader.selectAll();
    }


    public boolean delite(String word) {
        return reader.delite(word);
    }



}

