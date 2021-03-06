package com.example.user.yvd102405;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    CheckBox chk;
    RadioButton rb;
    RadioGroup rg;
    ProgressBar pb, pb2;
    SeekBar sb;
    TextView tv, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chk = (CheckBox) findViewById(R.id.checkBox);
        pb = (ProgressBar) findViewById(R.id.progressBar);
        pb2 = (ProgressBar) findViewById(R.id.progressBar2);
        sb = (SeekBar) findViewById(R.id.seekBar);
        tv = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d("MYLOG", "chk:" + isChecked);
            }
        });
        // chk.isChecked()

        rb = (RadioButton) findViewById(R.id.radioButton);
        rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });

        rg = (RadioGroup) findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton)
                {
                    Log.d("MYLOG", "select 1111");
                }
                else if (checkedId == R.id.radioButton2)
                {
                    Log.d("MYLOG", "select 2222");
                }
            }
        });

    }
    public void click1(View v)
    {
        pb.setVisibility(View.VISIBLE);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }.start();

    }
    public void click2(View v)
    {
        pb2.setProgress(pb2.getProgress()+10);
    }
    public void click3(View v)
    {
        tv2.setText(String.valueOf(sb.getProgress()));
    }
}
