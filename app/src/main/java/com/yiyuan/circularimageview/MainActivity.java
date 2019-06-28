package com.yiyuan.circularimageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.yiyuan.imageviewcircular.YiYuanTextView;

public class MainActivity extends AppCompatActivity {
    YiYuanTextView sjrView;
    Button btnStart;
    Button btnStop;
    Button btnReStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sjrView = findViewById(R.id.sjrView);
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnReStart = findViewById(R.id.btnReStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sjrView.startRun();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sjrView.stopRun();
            }
        });
        btnReStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sjrView.reStartRun();
            }
        });
    }
}
