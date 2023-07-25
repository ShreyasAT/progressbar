package com.example.progress;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1=(Button) findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            private int progressStatus = 0;
            TextView t1=(TextView) findViewById(R.id.textView4);
            private Handler handler = new Handler();
            @Override

            public void onClick(View v) {

                ProgressBar p1=(ProgressBar) findViewById(R.id.progressBar);
                    p1.setVisibility(View.VISIBLE);
                    t1.setVisibility(View.VISIBLE);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (progressStatus < 100){
                                progressStatus += 1;
                                handler.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        p1.setProgress(progressStatus);

                                        t1.setText(progressStatus+"/"+p1.getMax());
                                    }
                                });
                                try {
                                    Thread.sleep(200);
                                }catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();
            }
        });
    }
}