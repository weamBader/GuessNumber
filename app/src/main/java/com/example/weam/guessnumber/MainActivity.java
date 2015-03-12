package com.example.weam.guessnumber;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    private int num1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roll();
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
    public void roll(){
        Random rand=new Random();
        num1=rand.nextInt(1000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Click in Roll it to start the game", Toast.LENGTH_SHORT).show();

    }

    public void onClick_buttonOne(View view){
        Button button=(Button)findViewById(R.id.buttonTwo);
        button.setClickable(true);
        Toast.makeText(this, "you start new game", Toast.LENGTH_SHORT).show();
        roll();
    }
    public void onClick_checkNumber(View view){

        EditText editText=(EditText)findViewById(R.id.txt2);
        String val=editText.getText().toString();
        int val1=Integer.parseInt(val);
        int diff=num1-val1;
        if(diff==0){
            Toast.makeText(this, "You Got It !!", Toast.LENGTH_SHORT).show();

        }
        else if ( diff>=0 && diff<=5){
            Toast.makeText(this,"the number is very close to random number",Toast.LENGTH_SHORT).show();

        }
        else if ( diff <0){
            Toast.makeText(this,"the number is greater than random number",Toast.LENGTH_SHORT).show();

        }

        else
            Toast.makeText(this,"the number is smaller than random number",Toast.LENGTH_SHORT).show();

    }

}