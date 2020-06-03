//By Zezen
package cn.net.lovelive.mintoolbox.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import cn.net.lovelive.mintoolbox.R;
import cn.net.lovelive.mintoolbox.tool.ASCII.ToolASCII;

public class HomeFragment extends Fragment {

    //主页按钮事件
    private Button button1,button2,button3,button4;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        button1 = root.findViewById(R.id.btn_UUID);
        button2 = root.findViewById(R.id.btn_ASCII);
        button3 = root.findViewById(R.id.btn_DstImage);
        button4 = root.findViewById(R.id.btn_file);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),cn.net.lovelive.mintoolbox.tool.UUID.ToolUUID.class);
                getActivity().startActivity(intent);//当然也可以写成getContext()
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ToolASCII.class);
                getActivity().startActivity(intent);//当然也可以写成getContext()
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),cn.net.lovelive.mintoolbox.tool.DSTIMAGE.ToolDstImage.class);
                getActivity().startActivity(intent);//当然也可以写成getContext()
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(),cn.net.lovelive.mintoolbox.tool.FILE.ToolFile.class);
                getActivity().startActivity(intent);//当然也可以写成getContext()
            }
        });
        return root;
    }

}
