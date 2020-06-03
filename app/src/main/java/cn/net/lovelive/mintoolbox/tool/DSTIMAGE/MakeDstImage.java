package cn.net.lovelive.mintoolbox.tool.DSTIMAGE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import static android.support.v4.app.ActivityCompat.startActivityForResult;
import static cn.net.lovelive.mintoolbox.MainActivity.verifyStoragePermissions;
import static cn.net.lovelive.mintoolbox.tool.DSTIMAGE.ToolDstImage.str_path;

public class MakeDstImage {

    //bitmap转换为灰度图
    static public Bitmap ChageImage(Bitmap bmpOriginal){
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }

    //保存图片
    static public void saveBitmap(Bitmap bitmap, Context context) throws IOException
    {
        String fileName = UUID.randomUUID().toString();
        fileName = fileName.substring(0,13);
        //String nomeImagem = Environment.getExternalStorageState().toString()+"/"+fileName+".jpg";
        String nomeImagem = context.getFilesDir().getAbsolutePath()+fileName+".jpg";

        System.out.println(nomeImagem);
        File file = new File(nomeImagem);
        if(file.exists()){
            file.delete();
        }
        FileOutputStream out;
        try{
            //6.0以上安卓请求存储权限
            verifyStoragePermissions((Activity)context);
            out = new FileOutputStream(file);
            if(bitmap.compress(Bitmap.CompressFormat.PNG, 90, out))
            {
                Toast.makeText(context, "图片保存为"+nomeImagem, Toast.LENGTH_LONG).show();
                //发送广播更新数据
                Uri uri = Uri.fromFile(file);
                context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
                out.flush();
                out.close();
            }
        }
        catch (IOException e)
        {
            Toast.makeText(context, "权限不足，请开启存储权限", Toast.LENGTH_LONG).show();
        }
    }

}
