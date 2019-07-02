package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import static android.support.constraint.Constraints.TAG;

public class PlaceholderFragment extends Fragment {
    LottieAnimationView lottieAnimationView;
    ListView listView;
    public static final String TAG = "PlaceHolder";
    String msgName;

    public void setMsg(String msg){
        msgName=msg;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v = inflater.inflate(R.layout.fragment_placeholder, container, false);
        lottieAnimationView=v.findViewById(R.id.lodding);
        lottieAnimationView.playAnimation();
        listView = v.findViewById(R.id.listview);
        listView.setAdapter(new myListAdapter(this.getActivity(),msgName));
        listView.setAlpha(0f);
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onActivityCreated() called with: savedInstanceState = [" + savedInstanceState + "]");
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                addAnimation();
            }
        }, 1000);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach() called with: context = [" + context + "]");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    public void addAnimation(){
        ValueAnimator animator = ValueAnimator.ofFloat(0,1);
        animator.setRepeatCount(0);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(500);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                lottieAnimationView.setAlpha(1-(float)animation.getAnimatedValue());
                listView.setAlpha((float)animation.getAnimatedValue());
            }
        });
        animator.start();
    }
}
