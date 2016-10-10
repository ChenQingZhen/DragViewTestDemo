package com.cqz.dragviewtestdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnDraView(View view){
        startActivity(new Intent(this,DragViewTestActivity.class));
    }
    public void btnDragViewGroup(View view){
        startActivity(new Intent(this,DragViewGroupActivity.class));
    }

}
