package com.example.geoguess;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    //saving the drawable id's in an array
    private int[] imageNames = {R.drawable.img1_yes_denmark,
            R.drawable.img2_no_canada,
            R.drawable.img3_no_bangladesh,
            R.drawable.img4_yes_kazachstan,
            R.drawable.img5_no_colombia,
            R.drawable.img6_yes_poland,
            R.drawable.img7_yes_malta,
            R.drawable.img8_no_thailand};

    //a boolean array to save the answers
    private boolean[] europeImages = {true,
            false,
            false,
            true,
            false,
            true,
            true,
            false};

    private View view;
    private ImageAdapter mAdapter;
    @BindView(R.id.rvImages)
    RecyclerView rvImages;

    @BindView(R.id.textView)
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        view = findViewById(R.id.main_layout);
        mAdapter = new ImageAdapter(imageNames);
        rvImages.setAdapter(mAdapter);
        rvImages.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder
                            target) {
                        return false;
                    }

                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        // swipe left
                        if (swipeDir == ItemTouchHelper.LEFT) {
                            //if the image is in europe a correct snackbar will be shown
                            if (europeImages[position]) {
                                Snackbar
                                        .make(view, "Correct", Snackbar.LENGTH_SHORT)
                                        .show();
                            } else { // show wrong snackbar if wrong
                                Snackbar
                                        .make(view, "False", Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        } else if (swipeDir == ItemTouchHelper.RIGHT) {
                            //if the image is not in europe a correct snackbar will be shown
                            if (!europeImages[viewHolder.getAdapterPosition()]) {
                                Snackbar
                                        .make(view, "Correct", Snackbar.LENGTH_SHORT)
                                        .show();
                            } else { // show wrong snackbar if wrong
                                Snackbar
                                        .make(view, "False", Snackbar.LENGTH_SHORT)
                                        .show();
                            }
                        }

                        mAdapter.notifyItemRemoved(position);
                    }
                };
    }

}
