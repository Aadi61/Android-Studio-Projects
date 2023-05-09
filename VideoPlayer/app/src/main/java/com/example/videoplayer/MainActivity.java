package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    VideoView vd1;
    VideoView vd2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vd1=findViewById(R.id.vd1);
        vd2=findViewById(R.id.videoView2);

        vd1.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.video1);
        MediaController mc =new MediaController(this);
        mc.setAnchorView(vd1);
        vd1.setMediaController(mc);
        Uri uri= Uri.parse("http://techslides.com/demos/sample-videos/small.mp4");
        vd2.setVideoURI(uri);
        MediaController mc2=new MediaController(this);
        mc2.setAnchorView(vd2);
        vd2.setMediaController(mc2);

        vd2.start();




    }
}