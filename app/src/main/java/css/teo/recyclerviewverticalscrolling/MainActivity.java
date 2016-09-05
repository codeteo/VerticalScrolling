package css.teo.recyclerviewverticalscrolling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MAIN-ACTIVITY";

    RecyclerView rvFirst;
    RecyclerView rvSecond;

    MoviesAdapter moviesAdapter;
    DaysAdapter daysAdapter;

    ArrayList<String> movieList = new ArrayList<String>() {{
        add("movie1");
        add("movie2");
        add("movie3");
        add("movie4");
        add("movie5");
    }};

    ArrayList<String> daysList = new ArrayList<String>() {{
        add("Monday");
        add("Tuesday");
        add("Wednesday");
        add("Thursday");
        add("Friday");
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvFirst = (RecyclerView) findViewById(R.id.rv_first);
        rvSecond = (RecyclerView) findViewById(R.id.rv_second);

        moviesAdapter = new MoviesAdapter(movieList);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvFirst.setLayoutManager(mLayoutManager);
        rvFirst.setAdapter(moviesAdapter);

        daysAdapter = new DaysAdapter(daysList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvSecond.setLayoutManager(layoutManager);
        rvSecond.setAdapter(daysAdapter);

        rvFirst.addOnScrollListener(new FirstScrollListener());
        rvSecond.addOnScrollListener(new SecondScrollListener());

    }

    public class FirstScrollListener extends RecyclerView.OnScrollListener {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                rvSecond.removeOnScrollListener(this);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            Log.i(TAG, "onScrolled First dy: "+ dy );
            rvSecond.removeOnScrollListener(this);
            rvSecond.scrollBy(dx, dy);
            rvSecond.addOnScrollListener(this);
        }
    }

    public class SecondScrollListener extends RecyclerView.OnScrollListener {

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                rvFirst.removeOnScrollListener(this);
            }
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            Log.i(TAG, "onScrolled Second dy: "+ dy );
            rvFirst.removeOnScrollListener(this);
            rvFirst.scrollBy(dx, dy);
            rvFirst.addOnScrollListener(this);
        }
    }

}
