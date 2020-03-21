package cn.net.lovelive.mintoolbox.tool.ASCII;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cn.net.lovelive.mintoolbox.MainActivity;
import cn.net.lovelive.mintoolbox.R;
import cn.net.lovelive.mintoolbox.tool.UUID.Create_UUID;
import cn.net.lovelive.mintoolbox.tool.UUID.ToolUUID;

public class ToolASCII extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_acsii);
//        final TextView tv = (TextView)findViewById(R.id.text_uuid);
//        tv.setText("点按钮才能生成哦>o<"); //初始化文本框内容
//        final Button btn1 =  (Button)findViewById(R.id.btn_create_uuid);
//        final Button btn2 =  (Button)findViewById(R.id.btn_fz_uuid);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            //点击生成按钮时生成UUID
//            public void onClick(View v){
//                String str = Create_UUID.Create_UUID();
//                tv.setText(str);
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            //点击生成按钮时生成UUID
//            public void onClick(View v){
//                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
//                // 将文本内容放到系统剪贴板里。
//                cm.setText(tv.getText());
//                // 显示提示消息框
//                Toast toast=Toast.makeText(ToolUUID.this, "剪切板君收到", Toast.LENGTH_LONG);
//                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 700);
//                MainActivity.showMyToast(toast,1000);
//            }
//        });
    }
}
