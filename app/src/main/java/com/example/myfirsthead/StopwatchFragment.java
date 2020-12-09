package com.example.myfirsthead;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;

public class StopwatchFragment extends Fragment implements View.OnClickListener {
    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);
        Button start_button = (Button)layout.findViewById(R.id.start_button);
        start_button.setOnClickListener(this::onClick);
        Button stop_button = (Button)layout.findViewById(R.id.stop_button);
        stop_button.setOnClickListener(this::onClick);
        Button reset_button = (Button)layout.findViewById(R.id.reset_button);
        reset_button.setOnClickListener(this::onClick);



        runTimer(layout);
        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);
        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.start_button:
                onClickStart();
                break;

            case R.id.stop_button:
                onClickStop();
                break;
            case R.id.reset_button:
                onClickReset();
                break;
        }
    }

    //TODO: Start the stopwatch running when the Start button is clicked.
    private void onClickStart() {
        running = true;
    }

    //TODO: Stop the stopwatch running when the Stop button is clicked.
    private void onClickStop() {
        running = false;
    }

    //TODO: Reset the stopwatch when the Reset button is clicked.
    private void onClickReset() {
        running = false;
        seconds = 0;
    }

    //TODO: Sets the number of seconds on the timer.
    private void runTimer(View view) {
        final TextView timeView = (TextView) view.findViewById(R.id.time_view);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if (running) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }


}
