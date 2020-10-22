package com.example.myfirsthead;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String WORK_OUT_MENU_ID ="WORK_OUT_MENU_ID" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment fragment = (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_frag);

        int workoutIdMenu =(int)((long) getIntent().getExtras().get(WORK_OUT_MENU_ID));

        fragment.setWorkoutId(workoutIdMenu);


    }
}