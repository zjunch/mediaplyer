package com.android.zjmediapalyer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.zjmediapalyer.playervideo.VideoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toPlayer(View view) {
        Intent intent = new Intent(this, VideoActivity.class);
        startActivity(intent);
    }
}
