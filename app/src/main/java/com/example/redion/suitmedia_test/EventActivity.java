package com.example.redion.suitmedia_test;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.example.redion.suitmedia_test.adapter.EventAdapter;
import com.example.redion.suitmedia_test.model.EventModel;

import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EventAdapter adapter;
    private List<EventModel> albumList;
    int position= 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        recyclerView = (RecyclerView) findViewById(R.id.recycler);

        albumList = new ArrayList<>();
        adapter = new EventAdapter(this, albumList);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        eventData();
    }

    private void eventData() {
        int[] covers = new int[]{
                R.mipmap.user_dummy,
                R.mipmap.user_dummy,
                R.mipmap.user_dummy,
                R.mipmap.user_dummy};

        EventModel eventModel = new EventModel("Dev Talks", covers[0], "19 September 2018");
        albumList.add(eventModel);

        eventModel = new EventModel("Hackaton", covers[1], "20 Januari 2019");
        albumList.add(eventModel);

        eventModel = new EventModel("Women Dev Talks", covers[2], "15 Agustus 2018");
        albumList.add(eventModel);

        eventModel = new EventModel("Android Kejar", covers[3], "01 Maret 2018");
        albumList.add(eventModel);

        eventModel = new EventModel("Big Data Talks", covers[3], "01 April 2018");
        albumList.add(eventModel);

        adapter.notifyDataSetChanged();
    }

    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    public void chooseEvent(){
        Intent myIntent = new Intent(this, MainActivity.class);
        myIntent.putExtra("event", albumList.get(position).toString());
        startActivity(myIntent);
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}