package com.example.pleasproject.examples;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.pleasproject.R;

public class ClickerActivity extends AppCompatActivity {

    Integer count = 0;
    TextView labelCounter;
    Button incrementCounterButton;

    // класс AppCompatActivity содережит м реализуем методы жизненого цикла приложения

    // Метод, который вызывается в момент когда приложения ставят на паузу(сворачивают)
    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("OnPause");
    }

    // Метод, который вызывается в момент когда приложения выводят из паузы(разворачивают)
    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("OnStart");
    }

    /*
        onResume - Когда Activity готова к взаимодействию с пользователем
        onDestroy - запускается перед окончательным уничтожением Activity,
            Уничтожение различных ресурсов
        onStart - метод, вызывающийся после onCreate, когда пользователь увидел картинку
     */


    // Метод, который вызывается 1 раз при запуске приложение
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_clicker);

        /**
         * findViewById - найти инстанс виджета по его ID
         */
        labelCounter = findViewById(R.id.labelCounter);
        incrementCounterButton = findViewById(R.id.incrementCounterButton);
        init();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    void init()
    {
        updateUi();
        // Реализация паттерана НАБЛЮДАТЕЛЬ(OBSERVER)
        incrementCounterButton.setOnClickListener(this::incrementHandler);
    }

    void incrementHandler(View v)
    {
        count += 1;
        updateUi();
    }

    void updateUi() {
        labelCounter.setText(count.toString());
    }
}