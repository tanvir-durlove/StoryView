package com.example.td.messengerstoryview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import jp.shts.android.storiesprogressview.StoriesProgressView;

public class MainActivity extends AppCompatActivity {

    StoriesProgressView storiesProgressView;
    ImageView imageView;

    int counter = 0;
    int[] resource = new int[]{

            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d
    };

    @Override
    protected void onDestroy() {
        storiesProgressView.destroy();
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storiesProgressView = (StoriesProgressView) findViewById(R.id.storiesProgressView);
        storiesProgressView.setStoriesCount(4);
        storiesProgressView.setStoryDuration(2000L);

        storiesProgressView.setStoriesListener(new StoriesProgressView.StoriesListener() {
            @Override
            public void onNext() {
                imageView.setImageResource(resource[++counter]);
            }

            @Override
            public void onPrev() {

            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "You're story is complete", Toast.LENGTH_SHORT).show();
            }
        });
        storiesProgressView.startStories();

        imageView = (ImageView) findViewById(R.id.imageView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storiesProgressView.skip();
            }
        });
        imageView.setImageResource(resource[counter]);
    }
}
