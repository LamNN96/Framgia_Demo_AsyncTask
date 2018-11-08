package com.example.lamnn.demoasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView mTextView;
    private ProgressBar mBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.button_start).setOnClickListener(this);
        mTextView = findViewById(R.id.text_status);
        mBar = findViewById(R.id.progress_bar);
    }

    @Override public void onClick(View v) {
        mTextView.setText("Napping...");
        new DemoAsyncTask(mTextView, mBar).execute();
    }


}
