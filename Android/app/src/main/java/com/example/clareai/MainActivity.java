package com.example.clareai;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import ai.clare.clarelib.Clare;
import ai.clare.clarelib.ConversationCallback;
import ai.clare.clarelib.ui.ClareBubble;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button btnShowWithoutIcon = (Button)findViewById(R.id.btn_nonwidgetShow);
        btnShowWithoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clare.showWithoutWidget(MainActivity.this.getSupportFragmentManager());
            }
        });

        final Button btnReset = (Button)findViewById(R.id.btn_reset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clare.reSetClare();
                Toast.makeText(MainActivity.this,"Reset",Toast.LENGTH_SHORT).show();
            }
        });

        Clare.setConversationCallback(new ConversationCallback() {
            @Override
            public void onUnreadCountChanged(final int count) {
            }
        });

        //Show the chat Bubble icon on the page.
        ClareBubble.getInstance(getApplicationContext()).show(MainActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
