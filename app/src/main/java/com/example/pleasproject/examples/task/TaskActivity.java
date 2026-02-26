package com.example.pleasproject.examples.task;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pleasproject.R;
import com.example.pleasproject.examples.dialogs.AddTaskDialogFragment;
import com.example.pleasproject.examples.task.models.TaskModel;
import com.example.pleasproject.examples.task.models.TaskView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskActivity extends AppCompatActivity {

    List<TaskModel> taskModels = new ArrayList<>();
    Button btnAddTask;
    LinearLayout lytContainerTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        init();
    }

    void init() {
        btnAddTask = findViewById(R.id.btnAddTask);
        lytContainerTasks = findViewById(R.id.lytContainerTasks);

        btnAddTask.setOnClickListener(
                v -> {
                    AddTaskDialogFragment addTaskDialogFragment = new AddTaskDialogFragment(
                            task -> {
                                taskModels.add(task);

                                TaskView taskView = new TaskView(this, null);
                                taskView.setDescription(task.description);
                                taskView.setSuccses(false);
                                taskView.setOnCheck((checkBox, isChecked) -> {
                                    task.isSuccess = isChecked;
                                });

                                lytContainerTasks.addView(taskView);
                                return null;
                            }
                    );
                    addTaskDialogFragment.show(getFragmentManager(), "11");
                    /*
                    LocalDate now = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        now = LocalDate.now();
                    }
                    TaskModel task = new TaskModel(now.toString(), now, null);
                    taskModels.add(task);

                    TaskView taskView = new TaskView(this, null);
                    taskView.setDescription("Randon");
                    taskView.setSuccses(false);
                    taskView.setOnCheck((checkBox, isChecked) -> {
                        task.isSuccess = isChecked;
                    });

                    lytContainerTasks.addView(taskView);
                    */
                }
        );
    }
}