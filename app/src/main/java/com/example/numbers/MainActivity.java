package com.example.numbers;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private TextView number;
    int count;
    int secret = new Random().nextInt(10)+1;
    String TAG = MainActivity.class.getSimpleName();
    private ImageView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        Log.d(TAG,"secret"+secret);
        result = findViewById(R.id.result_image);
        setSupportActionBar(toolbar);
        number = findViewById(R.id.num);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                number.setText(String.valueOf(count));
                result.setAlpha(0.1f);
                result.setVisibility(View.VISIBLE);
                if(count == secret){
                    Toast.makeText(MainActivity.this,"haha",Toast.LENGTH_LONG).show();
                    result.setImageResource(R.drawable.shocked);

                }else{
                    result.setImageResource(R.drawable.smile);
                    result.animate().alpha(0.0f).setDuration(1200);
                }
            }

        });
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

    public void zero(View view){
       count=0;
       number.setText(String.valueOf(count));
    }
}
