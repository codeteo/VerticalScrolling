package css.teo.recyclerviewverticalscrolling;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by css on 9/5/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MyViewHolder> {

    private List<String> moviesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_name);
        }
    }

    public MoviesAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_movie_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String movie = moviesList.get(position);
        holder.title.setText(movie);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
