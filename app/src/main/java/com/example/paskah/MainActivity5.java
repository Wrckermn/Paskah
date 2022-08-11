package com.example.paskah;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity5 extends AppCompatActivity {
    VideoView vv;
    MediaController mediaController;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().setTitle("Daftar lagu");
        vv = (VideoView) findViewById(R.id.videoView);

        String video = getIntent().getExtras().getString("MyVideo");

        switch (video) {
            case "Karna salibmu":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu1);
                vv.setVideoURI(uri);
                vv.start();
                break;
            case "Dengan apa kan kubalas":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri1 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu2);
                vv.setVideoURI(uri1);
                vv.start();
                break;
            case "Via Dolorossa":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri2 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu3);
                vv.setVideoURI(uri2);
                vv.start();
                break;
            case "Karya Terbesar":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri3 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu4);
                vv.setVideoURI(uri3);
                vv.start();
                break;
            case "Dia Lahir Untuk Kami":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri4 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu5);
                vv.setVideoURI(uri4);
                vv.start();
                break;
            case "Ku Menang Ku Menang":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri5 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu6);
                vv.setVideoURI(uri5);
                vv.start();
                break;
            case "Kasih Allah Sungguh Tlah Terbukti":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri6 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu7);
                vv.setVideoURI(uri6);
                vv.start();
                break;
            case "Firman Jadi Manusia":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri7 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu8);
                vv.setVideoURI(uri7);
                vv.start();
                break;
            case "Kuasa Bilurmu":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri8 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu9);
                vv.setVideoURI(uri8);
                vv.start();
                break;
            case "What A Beutifull Name":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri9 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu10);
                vv.setVideoURI(uri9);
                vv.start();
                break;
            case "Dia Sungguh Baik":
                if (mediaController == null) {
                    mediaController = new MediaController(this);
                    mediaController.setAnchorView(vv);
                }
                vv.setMediaController(mediaController);
                Uri uri10 = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.lagu11);
                vv.setVideoURI(uri10);
                vv.start();
                break;
        }
    }
}