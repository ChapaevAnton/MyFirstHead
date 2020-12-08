package com.example.myfirsthead;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class WorkoutDetailFragment extends Fragment {

    private static final String TAG = "TAG";
    private static final String WORKOUT_ID = "WORKOUT_ID";
    private long workoutId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null){
            workoutId = savedInstanceState.getLong(WORKOUT_ID);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.title);
            TextView description = (TextView) view.findViewById(R.id.description);

            try {

                WorkOut workOut = WorkOut.workOut[(int) workoutId];

                title.setText(workOut.getName());
                description.setText(workOut.getDescription());

            } catch (ArrayIndexOutOfBoundsException e) {
                Log.d(TAG, "onStart: "+e);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }


    public void setWorkoutId(long id) {
        this.workoutId = id;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putLong(WORKOUT_ID,workoutId);
    }
}