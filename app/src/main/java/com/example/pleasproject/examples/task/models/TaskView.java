package com.example.pleasproject.examples.task.models;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.pleasproject.R;

import java.time.LocalDate;

import kotlin.Function;

public class TaskView extends LinearLayout {

    TextView descriptionTextView;
    DatePicker deadlineCalendarView;
    CheckBox succsesCheckBox;

    public TaskView(Context context, AttributeSet attr)
    {
        super(context, attr);
        LayoutInflater.from(context).inflate(R.layout.task_view, this);
        init();
    }

    void init() {
        descriptionTextView = findViewById(R.id.task_description);
        deadlineCalendarView = findViewById(R.id.task_deadlineBy);
        succsesCheckBox = findViewById(R.id.task_success);
    }

    public void setDescription(String description)
    {
        descriptionTextView.setText(description);
    }

    public void setDeadline(LocalDate deadline)
    {
    }

    public void setOnCheck(CompoundButton.OnCheckedChangeListener handlerOnCheck)
    {
        succsesCheckBox.setOnCheckedChangeListener(handlerOnCheck);
    }

    public void setSuccses(boolean state)
    {
        succsesCheckBox.setChecked(state);
    }
}
