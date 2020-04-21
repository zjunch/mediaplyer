package com.android.zjmediapalyer.playervideo;


import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.android.zjmediapalyer.R;

import cn.jzvd.Jzvd;

import static android.content.Context.SENSOR_SERVICE;

/**
 * Created by Nathen on 2017/6/9.
 */
public class FragmentDemo extends Fragment {
    RecyclerView recyclerView;
    AdapterRecyclerView adapterVideoList;
    int index;
    Jzvd.JZAutoFullscreenListener sensorEventListener;
    SensorManager sensorManager;
    public FragmentDemo setIndex(int index) {
        this.index = index;
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInastanceState) {
        View view = inflater.inflate(R.layout.layout_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        setRecyclerView();
        return view;
    }


    private  void setRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterVideoList = new AdapterRecyclerView(getContext());
        recyclerView.setAdapter(adapterVideoList);
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {

            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                Jzvd jzvd = view.findViewById(R.id.videoplayer);
                if (jzvd != null && Jzvd.CURRENT_JZVD != null &&
                        jzvd.jzDataSource.containsTheUrl(Jzvd.CURRENT_JZVD.jzDataSource.getCurrentUrl())) {
                    if (Jzvd.CURRENT_JZVD != null && Jzvd.CURRENT_JZVD.screen != Jzvd.SCREEN_FULLSCREEN) {
                        Jzvd.releaseAllVideos();
                    }
                }
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        sensorEventListener = new Jzvd.JZAutoFullscreenListener();
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
        Jzvd.releaseAllVideos();
    }


}
