package com.example.myfirsthead;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    /**
     * @param id идентификатор выбранной позиции в списке
     */
    @Override
    public void onClickItem(Long id) {
        View fragmentContainer = findViewById(R.id.fragment_container);
        if (fragmentContainer != null) {
            //fragment layout-large
            WorkoutDetailFragment detailsFragment = new WorkoutDetailFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            detailsFragment.setWorkoutId(id);
            transaction.replace(R.id.fragment_container,detailsFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            transaction.addToBackStack(null);
            transaction.commit();


        } else {
            Intent detailActivity = new Intent(this, DetailActivity.class);
            detailActivity.putExtra(DetailActivity.WORK_OUT_MENU_ID, id);
            startActivity(detailActivity);
        }
    }
}