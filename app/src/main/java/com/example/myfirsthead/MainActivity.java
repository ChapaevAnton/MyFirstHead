package com.example.myfirsthead;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void onClickItem(Long id) {

    Intent detailActivity = new Intent(this,DetailActivity.class);
    detailActivity.putExtra(DetailActivity.WORK_OUT_MENU_ID, id);
    startActivity(detailActivity);

    }
}