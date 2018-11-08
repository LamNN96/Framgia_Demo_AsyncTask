package com.example.lamnn.demoasynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.Random;

public class DemoAsyncTask extends AsyncTask<Void, Integer, Long> {
    private WeakReference<TextView> mTextStatus;
    private WeakReference<ProgressBar> mBarWeakReference;

    public DemoAsyncTask(TextView textStatus, ProgressBar progressBar) {
        mTextStatus = new WeakReference<>(textStatus);
        mBarWeakReference = new WeakReference<>(progressBar);
    }

    @Override protected void onPreExecute() {
        super.onPreExecute();
        mTextStatus.get().setText("Loading...");
        mBarWeakReference.get().setMax(100);
    }

    @Override protected Long doInBackground(Void... voids) {
        Random r = new Random();
        int n = r.nextInt(11);
        int s = n * 1000;
        Log.v("TAG", s+"");
        long result = 0;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i <= s; i++) {
            publishProgress((int) ((i / (float) s) * 100));
        }
        return result;
    }

    @Override protected void onProgressUpdate(Integer... values) {
        mBarWeakReference.get().setProgress(values[0]);
        mTextStatus.get().setText(values[0]+"%");
    }

    @Override protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        mTextStatus.get().setText("DONE!");
    }
}
