package sportsfanliga.app;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class TopPlayers extends Fragment {

    static ArrayList<Player> players;
    static PlayerAdapter playerAdapter;
    static RecyclerView rv;
    static SQLiteDatabase database;
    static DBHelper dbHelper;


    public TopPlayers() {
        super(R.layout.fragment_top_players);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        players = new ArrayList<>();
        DBHelper dbHelper = new DBHelper(getActivity());
        database= dbHelper.getWritableDatabase();
        rv = view.findViewById(R.id.rvPlayers);
        getPlayers("All");
        playerAdapter = new PlayerAdapter(players); LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);
        rv.setAdapter(playerAdapter);
        ChipGroup chipGroup = view.findViewById(R.id.chipGroup);

    }
    static public void getPlayers(String str){
        if(players!=null)players.clear();
        ContentValues cv = new ContentValues();
        Cursor cursor;
        if(str.equals("All")) cursor = database.query(DBHelper.TABLE_NAME, null, null, null, null, null,"value DESC");
        else{
            cursor = database.query(DBHelper.TABLE_NAME, null, "liga ==\""+str+"\"", null, null, null,"value DESC");
        }
        if(cursor.moveToFirst()){
            int valueIndex =cursor.getColumnIndex(DBHelper.KEY_VALUE);
            int nameIndex =cursor.getColumnIndex(DBHelper.KEY_NAME);
            int teamValue =cursor.getColumnIndex(DBHelper.KEY_TEAM);
            int ageIndex =cursor.getColumnIndex(DBHelper.KEY_AGE);
            int photoIndex =cursor.getColumnIndex(DBHelper.KEY_PHOTO);
            do {
                Player mPlayer = new Player(cursor.getString(nameIndex),cursor.getString(teamValue),cursor.getString(photoIndex),
                        cursor.getInt(ageIndex), cursor.getInt(valueIndex));
                players.add(mPlayer);
            }while(cursor.moveToNext());
        }
        else{
            Log.d("mLog","0 rows");
        }

        cursor.close();

        rv.setAdapter(playerAdapter);
    }
}