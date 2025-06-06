package com.example.myapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

public class WorkoutListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private WorkoutCardAdapter adapter;
    private List<WorkoutCard> workoutCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workouts);

        Button btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(v -> finish());

        recyclerView = findViewById(R.id.recyclerViewWorkouts);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        Bitmap pushupBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pushup_card);
        Bitmap runningBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.running_card);
        Bitmap plankBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.plank_card);

        workoutCardList = new ArrayList<>();
        workoutCardList.add(new WorkoutCard("Push-ups", "3 sets of 15 reps", 50, pushupBitmap, PushupDetailsActivity.class));
        workoutCardList.add(new WorkoutCard("Running", "5 km run", 300, runningBitmap, RunningDetailsActivity.class));
        workoutCardList.add(new WorkoutCard("Plank", "Hold for 1 minute", 30, plankBitmap, PlankDetailsActivity.class));

        adapter = new WorkoutCardAdapter(workoutCardList);
        recyclerView.setAdapter(adapter);
    }
}
