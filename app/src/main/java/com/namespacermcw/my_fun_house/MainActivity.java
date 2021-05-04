package com.namespacermcw.my_fun_house;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {

    public static List<Integer> numberList = new ArrayList<Integer>();
    public static int countNext = 0;
    public static Activity main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findRandom();
        Button btn_Next = findViewById(R.id.btn_next);
        btn_Next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (numberList.get(countNext % 3) == 1) {
            countNext++;
            startActivity(new Intent(MainActivity.this, OneActivity.class));
        } else if (numberList.get(countNext % 3) == 2) {
            countNext++;
            startActivity(new Intent(MainActivity.this, TwoActivity.class));
        } else if (numberList.get(countNext % 3) == 3) {
            countNext++;
            startActivity(new Intent(MainActivity.this, ThreeActivity.class));
        }
    }

    private void findRandom() {
        numberList.clear();
        for (int i = 0; i < 3; i++) {
            numberList.add(i + 1);
        }

        long seed = System.nanoTime();
        Collections.shuffle(numberList, new Random(seed));

        for (int no : numberList) {
            System.out.println("random number:" + no);
        }

    }
}