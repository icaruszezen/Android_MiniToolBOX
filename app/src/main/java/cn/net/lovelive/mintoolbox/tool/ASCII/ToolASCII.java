package cn.net.lovelive.mintoolbox.tool.ASCII;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
        final EditText tv_in = (EditText)findViewById(R.id.text_ascii_input);
        final TextView tv_out = (TextView)findViewById(R.id.text_ascii_output);
        final Button btn_StA =  (Button)findViewById(R.id.btn_str_to_ascii);
        final Button btn_AtS =  (Button)findViewById(R.id.btn_ascii_to_str);
        final Button btn_copy =  (Button)findViewById(R.id.btn_ascii_copy);
        btn_StA.setOnClickListener(new View.OnClickListener() {
            @Override
            //点击生成按钮时S to A
            public void onClick(View v){
                String str =  tv_in.getText().toString();
                str = MakeASCII.stringToAscii(str);
                tv_out.setText(str);
            }
        });
        btn_AtS.setOnClickListener(new View.OnClickListener() {
            @Override
            //点击生成按钮时A to S
            public void onClick(View v){
                String str =  tv_in.getText().toString();
                if(MakeASCII.test_ascii(str)) {
                    str = MakeASCII.asciiToString(str);
                    tv_out.setText(str);
                }else{
                    Toast toast=Toast.makeText(ToolASCII.this, "请输入正确的ASCII码格式", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL, 0, 800);
                    MainActivity.showMyToast(toast,1000);
                    tv_in.setText("");
                }
            }
        });
        btn_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            //点击生成按钮时复制
            public void onClick(View v){
                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                // 将文本内容放到系统剪贴板里。
                cm.setText(tv_out.getText());
                // 显示提示消息框
                Toast toast=Toast.makeText(ToolASCII.this, "剪切板君收到", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 800);
                MainActivity.showMyToast(toast,1000);
            }
        });
    }



}
