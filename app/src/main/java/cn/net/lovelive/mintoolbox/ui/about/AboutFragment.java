package cn.net.lovelive.mintoolbox.ui.about;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cn.net.lovelive.mintoolbox.R;

public class AboutFragment extends Fragment {
    private TextView tv_about;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_about, container, false);
        tv_about = (TextView) root.findViewById(R.id.text_about);
        tv_about.setText(
                new StringBuilder()
                        .append("By 溜溜球(Zezen)\n")
                        .append("球球BOX是一个方便的小工具集合应用项目\n")
                        .append("本项目完全开源，且会持续更新\n\n")
                        .append("项目托管于GitHub： https://github.com/icaruszezen/Android_MiniToolBOX \n\n")
                        .append("Github个人主页： https://github.com/icaruszezen \n\n")
                        .append("个人博客： https://lovelive.net.cn \n\n")
                        .append("同时我还和同道中人维护着一个中文OPENCV的Wiki： https://opencv.icu \n\n")
                        .append("B站主页： https://space.bilibili.com/5634507 \n\n")
                        .append("个人邮箱： nxn@lovelive.net.cn\n\n")
                        .append("希望有想交流安卓开发或想共同维护wiki的朋友能联系我")
                        .toString());
        return root;
    }

}