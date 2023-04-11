package sportsfanliga.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>{
    private List<Player> mPlayers;
    public PlayerAdapter(List<Player> players){
        mPlayers =players;
    }
    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListitem = R.layout.player_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(layoutIdForListitem, parent, false);
        PlayerAdapter.PlayerViewHolder viewHolder = new PlayerAdapter.PlayerViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Map<String,Integer> dictionary = new HashMap<String,Integer>();
        dictionary.put("Arsenal FC", R.drawable.arsenal_fc);
        dictionary.put("Manchester City", R.drawable.manchester_city_fc_badge);
        dictionary.put("Brighton and Hove Albion", R.drawable.fc_brighton_hove_albion);
        dictionary.put("Manchester United",R.drawable.manchester_united);
        dictionary.put("Real Madrid",R.drawable.real_madrid);
        dictionary.put("Barcelona",R.drawable.barcelona);
        dictionary.put("Paris Saint-Germain",R.drawable.paris_saint_germain);
        dictionary.put("Stade Rennais",R.drawable.stade);
        dictionary.put("Olympique de Marseille",R.drawable.olympique_marseille);
        dictionary.put("Bayern Munich",R.drawable.bayern);
        dictionary.put("Borussia Dortmund",R.drawable.borussia_dortmund);
        dictionary.put("RB Leipzig",R.drawable.rb_leipzig);
        dictionary.put("Napoli",R.drawable.ssc_neapel);
        dictionary.put("AS Roma",R.drawable.as_roma);
        dictionary.put("Juventus",R.drawable.juventus);
        dictionary.put("AC Milan",R.drawable.ac_milan);
        holder.bind(position);
        Player playerItem = mPlayers.get(position);
        holder.name.setText(playerItem.getName());
        holder.value.setText(String.valueOf(playerItem.getValue()));
        holder.description.setText("Age: "+playerItem.getAge()+"\n"+playerItem.getTeam());
        try{holder.club.setImageResource(dictionary.get(playerItem.getTeam()));}
        catch (Exception e){

        }
        Glide
                .with(holder.itemView.getContext())
                .load(String.valueOf(playerItem.getPhoto()))
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return mPlayers.size();
    }

    class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView name, description, value;
        ImageView photo, club;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tv_name);
            description = itemView.findViewById(R.id.tv_desc);
            photo = itemView.findViewById(R.id.iv_photo);
            value = itemView.findViewById(R.id.valueTV);
            club = itemView.findViewById(R.id.clubIV);
        }
        void bind(int listIndex){
        }
    }
}
