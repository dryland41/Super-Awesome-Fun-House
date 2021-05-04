package com.namespacermcw.my_fun_house;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class ThreeActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three);
        Button btn_Random = findViewById(R.id.btn_random);
        btn_Random.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.println("countNext = " + MainActivity.countNext);
        if (MainActivity.countNext > 2) {
            finishAffinity();
            System.exit(0);
        }

        if (MainActivity.numberList.get(MainActivity.countNext) == 1) {
            MainActivity.countNext++;
            startActivity(new Intent(ThreeActivity.this, OneActivity.class));
        } else if (MainActivity.numberList.get(MainActivity.countNext) == 2) {
            MainActivity.countNext++;
            startActivity(new Intent(ThreeActivity.this, TwoActivity.class));
        } else if (MainActivity.numberList.get(MainActivity.countNext) == 3) {
            MainActivity.countNext++;
            startActivity(new Intent(ThreeActivity.this, ThreeActivity.class));
        }
    }

}



