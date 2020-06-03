package cn.net.lovelive.mintoolbox.tool.DSTIMAGE;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import cn.net.lovelive.mintoolbox.MainActivity;
import cn.net.lovelive.mintoolbox.R;

import static cn.net.lovelive.mintoolbox.MainActivity.showMyToast;
import static cn.net.lovelive.mintoolbox.tool.DSTIMAGE.MakeDstImage.ChageImage;
import static cn.net.lovelive.mintoolbox.tool.DSTIMAGE.MakeDstImage.saveBitmap;

public class ToolDstImage extends AppCompatActivity {

    private static final int FILE_SELECT_CODE = 0;
    static Bitmap bitmap = null;
    static boolean bm = false;
    static String str_path;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_dstimage);
        final Button btn1 = (Button) findViewById(R.id.btn_chooseimg);
        final Button btn2 = (Button) findViewById(R.id.btn_changeimg);
        final Button btn3 = (Button) findViewById(R.id.btn_saveimg);
        final ImageView img = (ImageView)findViewById(R.id.img_choose);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");//无类型限制
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                //显示文件管理器列表
                try {
                    startActivityForResult(Intent.createChooser(intent, "选择文件"), FILE_SELECT_CODE);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ToolDstImage.this, "木有文件管理器啊", Toast.LENGTH_LONG).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //System.out.println("开始转换图片");
                if(bm == false){
                    Toast.makeText(ToolDstImage.this, "请重新选择图片", Toast.LENGTH_LONG).show();
                }else{
                    bitmap = ChageImage(bitmap);
                    img.setImageBitmap(bitmap);
                    bm = false;
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // System.out.println("开始保存图片");
               // MainActivity.showMyToast(Toast.makeText(ToolDstImage.this, "保存图片", Toast.LENGTH_SHORT), 100);
                try {
                    if (bitmap != null && bm == false) {
                        saveBitmap(bitmap, ToolDstImage.this);
                    }else{
                        Toast.makeText(ToolDstImage.this, "请生成图片后再保存", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final ImageView img = (ImageView)findViewById(R.id.img_choose);
        //System.out.println("进入监听");
        if (resultCode == Activity.RESULT_OK) {
            //System.out.println("返回正确");
            if (requestCode == FILE_SELECT_CODE) {
                // System.out.println("返回路径正确");
                String str_url;
                str_url = data.getData().getPath();
                str_path = str_url.substring(0,str_url.lastIndexOf("/")+1);
                MainActivity.showMyToast(Toast.makeText(ToolDstImage.this, "文件路径：" + str_path, Toast.LENGTH_SHORT), 1000);
                File file = new File(str_url);
                //System.out.println(file.getAbsolutePath());
                ContentResolver cr = this.getContentResolver();
                    try {
                    //获取图片
                    bitmap = BitmapFactory.decodeStream(cr.openInputStream(data.getData()));
                    img.setImageBitmap(bitmap);
                    bm = true;
                    } catch (FileNotFoundException e) {
                    MainActivity.showMyToast(Toast.makeText(ToolDstImage.this, "未选择图片", Toast.LENGTH_SHORT), 1000);
                    }
                } else {
                    //操作错误或没有选择图片
                    MainActivity.showMyToast(Toast.makeText(ToolDstImage.this, "未选择文件", Toast.LENGTH_SHORT), 1000);
                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}

