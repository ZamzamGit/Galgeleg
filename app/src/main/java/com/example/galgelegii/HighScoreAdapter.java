package com.example.galgelegii;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.galgelegii.logik.HighScore;

import java.util.ArrayList;

public class HighScoreAdapter extends RecyclerView.Adapter<HighScoreAdapter.ViewHolder> {


    private ArrayList<HighScore> scores;

    public HighScoreAdapter(ArrayList<HighScore> scores) {
        this.scores = scores;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // layout for RecyclerView vælges. Hvert element i RecyclerView er en CardView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_highscore, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // her hentes et highscore objekt fra arraylisten, hvor dens data vil blive sat i TextViews i dens CardView
        HighScore highScore = scores.get(position);
        holder.word.setText("Ord: " + highScore.getWord());
        holder.score.setText("Score: " + highScore.getScore());
        holder.time.setText("Tidspunkt: " + highScore.getTime());

    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView word;
        private TextView score;
        private TextView time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            word = itemView.findViewById(R.id.word);
            score = itemView.findViewById(R.id.score);
            time = itemView.findViewById(R.id.time);
        }
    }
}
