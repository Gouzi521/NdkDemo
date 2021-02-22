package com.hyperfd.ndkdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.PI;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    ImageView sample_image, sample_image2;
    String imagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //开机运行网络监测服务
        Intent intentt = new Intent(this, CheckNetService.class);//启动服务器
        this.startService(intentt);

        sample_image = findViewById(R.id.sample_image);
        sample_image2 = findViewById(R.id.sample_image2);
        //String url = "http://cn.bing.com/az/hprichbg/rb/TOAD_ZH-CN7336795473_1920x1080.jpg";


        RequestOptions ro = new RequestOptions()
                .placeholder(R.mipmap.bg).error(R.mipmap.bg)
                .diskCacheStrategy(DiskCacheStrategy.ALL);

        String url = "https://upload.jianshu.io/users/upload_avatars/6433394/8a0bebf5-fab6-4b1b-8c1e-9b2ebd167f77.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240";
//        // 加载应用资源
        Glide.with(this).load(url)
                .apply(ro)
                .into(sample_image);


        sample_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double lat1 = 34.06081392162242;
                double lng1 = 109.21588341584504;
                double lat2 = 34.06156477589469;
                double lng2 = 109.21575574391011;

                float[] results = new float[1];
                Location.distanceBetween(lat1, lng1, lat2, lng2, results);
                Log.e("distance", "1 distance=" + results[0]);
                String distance = getDistance(lat1, lng1, lat2, lng2);
                Log.e("distance", "2 distance=" + distance);
                double distance4 = getDistance4( lng1,lat1,  lng2,lat2);
                Log.e("distance", "4 distance=" + distance4);










//                if (!TextUtils.isEmpty(imagePath)) {
//                    RequestOptions ro = new RequestOptions()
//                            .placeholder(R.mipmap.bg).error(R.mipmap.bg)
//                            .diskCacheStrategy(DiskCacheStrategy.ALL);
//                    Glide.with(MainActivity.this).load(imagePath)
//                            .apply(ro)
//                            .into(sample_image2);
//                } else {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            try {
//                                String url = "https://www.hhlink.com/hh/css/css-img/world.png";
//                                final Context context = getApplicationContext();
//                                FutureTarget<File> target = Glide.with(context)
//                                        .load(url)
//                                        .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL);
//                                final File imageFile = target.get();
//                                Log.e("imageFile", "path=" + imageFile.getPath());
//                                imagePath = imageFile.getPath();
//
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }).start();
//                }
            }
        });
    }






    private static final double EARTH_RADIUS = 6378137;    //赤道半径
    public static double getDistance4(double lng1, double lat1, double lng2, double lat2) {
        double RAD = PI / 180.0;
        double radLat1 = lat1 * RAD;
        double radLat2 = lat2 * RAD;
        double a = radLat1 - radLat2;
        double b = (lng1 - lng2) * RAD;
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000;
        return s;
    }


    private static final Double PI = Math.PI;

    private static final Double PK = 180 / PI;

    public static String getDistance(double lat_a, double lng_a, double lat_b, double lng_b) {
        double t1 =
                Math.cos(lat_a / PK) * Math.cos(lng_a / PK) * Math.cos(lat_b / PK) * Math.cos(lng_b / PK);
        double t2 =
                Math.cos(lat_a / PK) * Math.sin(lng_a / PK) * Math.cos(lat_b / PK) * Math.sin(lng_b / PK);
        double t3 = Math.sin(lat_a / PK) * Math.sin(lat_b / PK);

        double tt = Math.acos(t1 + t2 + t3);
        String res = (6366000 * tt) + "";
        return res.substring(0, res.indexOf("."));
    }




    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    public native String stringFromText() throws IllegalArgumentException;

    private void callNullPointException() throws NullPointerException {
        throw new NullPointerException("MainActivity NullPointException");
    }

}
