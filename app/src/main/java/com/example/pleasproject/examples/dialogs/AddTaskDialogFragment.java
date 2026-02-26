package com.example.pleasproject.examples.dialogs;

import android.app.DialogFragment;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.pleasproject.R;
import com.example.pleasproject.examples.task.models.TaskModel;

import java.time.LocalDate;
import java.util.function.Function;

public class AddTaskDialogFragment extends DialogFragment {

    Button closeBtn;
    Button saveBtn;
    EditText descriptionEditText;
    DatePicker deadlineDatePicker;
    Function<TaskModel, Void> handlerSave;
    public AddTaskDialogFragment(Function<TaskModel, Void> handlerSave) {
        this.handlerSave = handlerSave;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.modal_add_task, container);

        descriptionEditText = view.findViewById(R.id.task_add_description);
        deadlineDatePicker = view.findViewById(R.id.task_add_deadline);

        closeBtn = view.findViewById(R.id.task_add_cancel);
        closeBtn.setOnClickListener(
                v -> {
                    dismiss();
                }
        );

        saveBtn = view.findViewById(R.id.task_add_save);
        saveBtn.setOnClickListener(
                v -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        TaskModel model = new TaskModel(
                                descriptionEditText.getText().toString(),
                                LocalDate.now(),
                                null);
                        handlerSave.apply(model);
                    }
                    dismiss();
                }
        );

        return view;
    }
}
