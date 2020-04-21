package com.android.zjmediapalyer.playervideo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.android.zjmediapalyer.R;
import com.bumptech.glide.Glide;


import cn.jzvd.Jzvd;
import cn.jzvd.MyJzvdStd;
import cn.jzvd.ZVideoManager;

public class VideoActivity extends AppCompatActivity {
    MyJzvdStd myJzvdStd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        ZVideoManager.setFullScreenBackType(ZVideoManager.FullScreenBackType.CONTINUE_PLAY);
        myJzvdStd = findViewById(R.id.jz_video);
        //http://1252093142.vod2.myqcloud.com/4704461fvodcq1252093142/f865d8a05285890787810776469/playlist.f3.m3u8
        //http://jzvd.nathen.cn/d2e969f2ec734520b46ab0965d2b68bd/f124edfef6c24be8b1a7b7f996ccc5e0-5287d2089db37e62345123a1be272f8b.mp4
        //http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4
        myJzvdStd.setUp("http://vfx.mtime.cn/Video/2019/02/04/mp4/190204084208765161.mp4"
                , "饺子快长大",true);
        Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").placeholder(R.drawable.place).into(myJzvdStd.thumbImageView);

    }

    public void intoRecycle(View view) {
        ZVideoManager.setFullScreenBackType(ZVideoManager.FullScreenBackType.CLOSE_VIDEO);
        startActivity(new Intent(this,ActivityListViewRecyclerView.class));
    }

    public void intoFragment(View view) {
        ZVideoManager.setFullScreenBackType(ZVideoManager.FullScreenBackType.CONTINUE_PLAY);
        startActivity(new Intent(this,ActivityListViewFragmentViewPager.class));
    }


    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.releaseAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void finish() {
        super.finish();
//        overridePendingTransition(0, com.luck.picture.lib.R.anim.a3);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(myJzvdStd!=null){
            myJzvdStd.hideSystemUI();
        }
    }
}
