package sportsfanliga.app;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public final static int DATABASE_VERSION=1;
    public final static String DATABASE_NAME="my_db";
    public final static String TABLE_NAME="players";


    public final static String KEY_ID="_id";
    public final static String KEY_LIGA="liga";
    public final static String KEY_NAME="name";
    public final static String KEY_VALUE="value";
    public final static String KEY_TEAM="team";
    public final static String KEY_PHOTO="photo";
    public final static String KEY_AGE="age";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String[] name_player={"Bukayo Saka","Rodri","Kevin de Bruyne","Jack Grealish", "Gabriel Magalhaes","Solly March","Martin Odegaard","Gabriel Jesus",
        "Gabriel Martinelli","Bruno Fernandes","Vinicius Junior"};
        String[] liga={"Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League"};
        String[] team={"Arsenal FC","Manchester City","Manchester City","Manchester City","Arsenal FC","Brighton and Hove Albion","Arsenal FC","Arsenal FC","Arsenal FC",
        "Manchester United","Real Madrid"};
        Integer[] value={100,100,98,98,96,94,94,94,94,93,94};
        Integer[] age={21,26,31,27,25,28,24,26,21,28,22};
        String[] photo={"https://resources.premierleague.com/premierleague/photos/players/250x250/p223340.png", "https://resources.premierleague.com/premierleague/photos/players/250x250/p220566.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1EB-24cKsay-wfxrPRucDnHDUZkg_oicMJw&usqp=CAU","https://www.mancity.com/meta/media/qdlbnbg2/jack-grealish.png","https://www.footyrenders.com/render/gabriel-magalhaes-4.png",
        "https://1vs1-7f65.kxcdn.com/img/players/large/png/solly-march-174168_688.png", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTenfTlAnp5CSxy97_TIEpDYhyf1BfnIhxapg&usqp=CAU",
        "data:image/jpeg;base64,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",
        "https://img.a.transfermarkt.technology/portrait/big/655488-1665499061.jpg?lm=1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoo1qHXRbVFTYmqGfhtJmR-1PlqnpJ27_WXcRNw8dPd4iGmPJVbKxpzikky-fk5K1DmyI&usqp=CAU"};
        ContentValues cv = new ContentValues();
        //создаем таблицу
        db.execSQL("create table if not exists "+ TABLE_NAME + "("
                + KEY_ID+" integer primary key autoincrement, "+KEY_LIGA +" text, "
                +KEY_NAME+" text, "+KEY_VALUE+" int, "+KEY_AGE+" int, "+KEY_PHOTO+" text, "+KEY_TEAM+" text"+")");

        Log.d("mLog","Created");
        //заполняем её
        for(int i =0;i< name_player.length;i++){
            cv.clear();
            cv.put(KEY_LIGA, liga[i]);
            cv.put(KEY_NAME, name_player[i]);
            cv.put(KEY_VALUE, value[i]);
            cv.put(KEY_AGE, age[i]);
            cv.put(KEY_PHOTO, photo[i]);
            cv.put(KEY_TEAM, team[i]);
            db.insert(TABLE_NAME, null, cv);
            Log.d("mLog","added");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(db);
    }
}
