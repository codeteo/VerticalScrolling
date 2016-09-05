package css.teo.recyclerviewverticalscrolling;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by css on 9/5/16.
 */
public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.MyViewHolder> {

    private List<String> daysList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.tv_day);
        }
    }

    public DaysAdapter(List<String> moviesList) {
        this.daysList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_days_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String day = daysList.get(position);
        holder.title.setText(day);
    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }
}
