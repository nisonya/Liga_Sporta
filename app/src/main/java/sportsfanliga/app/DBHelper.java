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
        "Gabriel Martinelli","Bruno Fernandes","Vinicius Junior","Jordi Alba","Frenkie De Jong","Sergio Busquets","Karim Benzema","Ronald Araujo","Federico Valverde",
        "Ousmane Dembele","Andreas Christensen","Raphael Dias Belloli","Lionel Messi","Junior Neymar","Kylian Mbappe","Achraf Hakimi","Nuno Alexandre Tavares Mendes","Martin Terrier","Marco Verratti","Nuno Albertino Varela Tavares","Nordi Mukiele","Chancel Mbemba",
                "Joshua Kimmich","Jamal Musiala","Alphonso Davies","Leon Goretzka","Leroy Sane","Benjamin Pavard","Nico Schlotterbeck","Dayotchanculle Upamecano","Willi Orban","Matthijs de Ligt",
                "Khvicha Kvaratskhelia","Min-Jae Kim","Mario Rui Silva Duarte","Paulo Bruno Dybala","Amir Rrahmani","Giovanni Di Lorenzo","Adrien Rabiot","Gleison Bremer Silva Nascimento","Andre Franck Anguissa","Rafael Leao"};


        String[] liga={"Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","Premier League","La Liga","La Liga","La Liga","La Liga","La Liga","La Liga","La Liga","La Liga","La Liga","La Liga","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1","French Ligue 1",
                "Bundesliga","Bundesliga","Bundesliga","Bundesliga","Bundesliga","Bundesliga","Bundesliga","Bundesliga","Bundesliga","Bundesliga",
                "Seria A","Seria A","Seria A","Seria A","Seria A","Seria A","Seria A","Seria A","Seria A","Seria A"};


        String[] team={"Arsenal FC","Manchester City","Manchester City","Manchester City","Arsenal FC","Brighton and Hove Albion","Arsenal FC","Arsenal FC","Arsenal FC",
        "Manchester United","Real Madrid","Barcelona","Barcelona","Barcelona","Real Madrid","Barcelona","Real Madrid","Barcelona","Barcelona","Barcelona",
                "Paris Saint-Germain","Paris Saint-Germain","Paris Saint-Germain","Paris Saint-Germain","Paris Saint-Germain","Stade Rennais","Paris Saint-Germain","Olympique de Marseille","Paris Saint-Germain","Olympique de Marseille",
                "Bayern Munich","Bayern Munich","Bayern Munich","Bayern Munich","Bayern Munich","Bayern Munich","Borussia Dortmund","Bayern Munich","RB Leipzig","Bayern Munich",
                "Napoli","Napoli","Napoli","AS Roma","Napoli","Napoli","Juventus","Juventus","Napoli","AC Milan"};

        Integer[] value={100,100,98,98,96,94,94,94,94,93,94,93,93,92,92,91,91,91,91,91,99,96,92,91,91,90,89,89,89,88,97,97,96,94,94,92,92,91,91,90,94,93,92,91,91,91,90,89,89,89};

        Integer[] age={21,26,31,27,25,28,24,26,21,28,22,34,25,34,35,24,24,25,27,26,35,31,24,24,20,26,30,23,25,28,28,20,22,28,27,27,23,24,30,23,22,26,31,29,29,29,28,26,27,23};

        String[] photo={"https://resources.premierleague.com/premierleague/photos/players/250x250/p223340.png", "https://resources.premierleague.com/premierleague/photos/players/250x250/p220566.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS1EB-24cKsay-wfxrPRucDnHDUZkg_oicMJw&usqp=CAU","https://www.mancity.com/meta/media/qdlbnbg2/jack-grealish.png","https://www.footyrenders.com/render/gabriel-magalhaes-4.png",
        "https://1vs1-7f65.kxcdn.com/img/players/large/png/solly-march-174168_688.png", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTenfTlAnp5CSxy97_TIEpDYhyf1BfnIhxapg&usqp=CAU",
        "data:image/jpeg;base64,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",
        "https://img.a.transfermarkt.technology/portrait/big/655488-1665499061.jpg?lm=1","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoo1qHXRbVFTYmqGfhtJmR-1PlqnpJ27_WXcRNw8dPd4iGmPJVbKxpzikky-fk5K1DmyI&usqp=CAU",
        "https://www.footyrenders.com/render/viniciusjunior-ucl-1.png","https://www.fcbarcelona.com/photo-resources/2022/11/02/15b4a419-cd0a-4278-b1b6-80b0b6df3517/mini_18-JORDI_ALBA.png?width=670&height=790",
        "https://assets.laliga.com/squad/2022/t178/p209712/2048x2048/p209712_t178_2022_1_003_000.png","https://www.fcbarcelona.com/photo-resources/2022/11/02/f77b1b0a-503c-4ef7-953b-d58555324cb6/mini_05-SERGIO.png?width=670&height=790","https://www.footyrenders.com/render/karim-benzema-ucl-home-vs-man-city.png",
        "https://assets.laliga.com/squad/2022/t178/p445087/2048x2048/p445087_t178_2022_1_003_000.png","https://www.footyrenders.com/render/federico-valverde-55.png",
        "https://assets.laliga.com/squad/2022/t178/p219438/1024x1113/p219438_t178_2022_1_001_000.png","https://resources.premierleague.com/premierleague/photos/players/250x250/p135363.png","https://www.fcbarcelona.com/photo-resources/2022/11/02/a82e5b51-cf1d-48ca-872f-753ab665386a/mini_22-RAPHINHA.png?width=670&height=790", "https://1vs1-7f65.kxcdn.com/img/players/large/png/lionel-andres-messi-1548_212.png","https://www.pngmart.com/files/22/Neymar-PSG-PNG-Pic.png","https://www.pngall.com/wp-content/uploads/13/Kylian-Mbappe-Background-PNG.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/achraf-hakimi-271464_212.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/nuno-alexandre-tavares-mendes-1079385_212.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/martin-terrier-379575_213.png","https://images.psg.media/media/27047/card-season-22-23-verratti.png?center=0.5,0.5&mode=crop&width=400&height=600&quality=75","https://1vs1-7f65.kxcdn.com/img/players/large/png/nuno-albertino-varela-tavares-885723_17.png","https://www.footyrenders.com/render/nordi-mukiele-3.png","https://www.footyrenders.com/render/chencel.png",
                "https://img.fcbayern.com/image/upload/t_cms-1x1-seo/v1656614911/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/joshua_kimmich.png","https://img.fcbayern.com/image/upload/t_cms-4x3-seo/v1627302821/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/jamal_musiala.png","https://img.fcbayern.com/image/upload/t_cms-4x3-seo/v1656615722/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/alphonso_davies.png","https://img.fcbayern.com/image/upload/t_cms-1x1-seo/v1660123320/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/leon_goretzka.png","https://img.fcbayern.com/image/upload/t_cms-1x1-seo/v1656615390/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/leroy_sane.png","https://img.fcbayern.com/image/upload/t_cms-4x3-seo/v1656614869/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/benjamin_pavard.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/nico-schlotterbeck-358748_183.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/dayotchanculle-upamecano-217895_152.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/willi-orban-14580_4464.png","https://img.fcbayern.com/image/upload/t_cms-4x3-seo/v1659953193/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/matthijs-de-ligt.png",
                "https://www.footyrenders.com/render/khvicha-kvaratskhelia-4.png","https://www.footyrenders.com/render/kim-min-jae-2.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/mario-rui-silva-duarte-63487.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/paulo-bruno-dybala-88423_284.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/amir-rrahmani-186928_281.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/giovanni-di-lorenzo-84317_281.png","https://www.footyrenders.com/render/Adrien-Rabiot-7.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/gleison-bremer-silva-nascimento-441479_52.png","https://1vs1-7f65.kxcdn.com/img/players/large/png/andre-franck-anguissa-285693.png","https://assets-eu-01.kc-usercontent.com/1293c890-579f-01b7-8480-902cca7de55e/0403d37e-f8ab-4900-a269-b1bf4bafefae/Leao-Large.png"};
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
