package cn.net.lovelive.mintoolbox.tool.FILE;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.net.lovelive.mintoolbox.MainActivity;
import cn.net.lovelive.mintoolbox.R;

import static cn.net.lovelive.mintoolbox.tool.FILE.MakeFlie.getRealPathFromUri;

public class ToolFile  extends AppCompatActivity {

    private static final int FILE_SELECT_CODE = 0;
    static String str_path,str_savetime,str_size,str_name;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_file);
        final Button btn = (Button) findViewById(R.id.btn_chooseFile);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//无类型限制
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                //显示文件管理器列表
                try {
                    startActivityForResult(Intent.createChooser(intent, "选择文件"), FILE_SELECT_CODE);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ToolFile.this, "木有文件管理器啊", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final TextView tvfile = (TextView)findViewById(R.id.tv_file);
        final TextView tvpath = (TextView)findViewById(R.id.tv_path);
        final TextView tvdate = (TextView)findViewById(R.id.tv_time);
        final TextView tvsize = (TextView)findViewById(R.id.tv_size);
        final CheckBox cbh = (CheckBox)findViewById(R.id.cb_hidden);
        final CheckBox cbr = (CheckBox)findViewById(R.id.cb_read);
        final CheckBox cbw = (CheckBox)findViewById(R.id.cb_write);

        //System.out.println("进入监听");
        if (resultCode == Activity.RESULT_OK) {
            //System.out.println("返回正确");
            if (requestCode == FILE_SELECT_CODE) {
                // System.out.println("返回路径正确");
                Uri uri = data.getData();
                String str_url;
                str_url = getRealPathFromUri(ToolFile.this,uri);
                str_path = str_url.substring(str_url.lastIndexOf("/")+1,str_url.length());
                //MainActivity.showMyToast(Toast.makeText(ToolFile.this, "文件路径：" + str_url, Toast.LENGTH_SHORT), 1000);
                File file = new File(str_url);
                str_name = file.getName();
                str_size = ShowLongFileSzie(file.length());
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                str_savetime = format.format(new Date(file.lastModified()));
                //System.out.println("name "+file.canWrite()+" size "+file.canRead()+" data "+file.isHidden());

                //操作控件
                tvfile.setText(str_path);
                tvpath.setText(str_url);
                tvdate.setText(str_savetime);
                tvsize.setText(str_size);
                cbh.setChecked(file.isHidden());
                cbr.setChecked(file.canRead());
                cbw.setChecked(file.canWrite());


            } else {
                //操作错误或没有选择
                MainActivity.showMyToast(Toast.makeText(ToolFile.this, "未选择文件", Toast.LENGTH_SHORT), 1000);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    //计算文件大小
    String ShowLongFileSzie(Long length) {
        if (length >= 1048576) {
            return (length / 1048576) + "MB";
        } else if (length >= 1024) {
            return (length / 1024) + "KB";
        } else if (length < 1024) {
            return length + "B";
        } else {
            return "0KB";
        }
    }


}
