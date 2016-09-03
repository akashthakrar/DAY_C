package com.project.dayc_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
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

    public void searchFood(View view){
        Intent intent = new Intent(this, MapsSearch.class);
        EditText editText = (EditText)findViewById(R.id.searchTerm);
        String local = editText.getText().toString().toLowerCase();
        String desc[] = new String[]{"the grand thakar premium gujarati thali mocktails punjabi south indian italian sizzler chinese pizza pav bhaji",
                                     "mc donald\'s donalds burger premium mcflurry black forest mcveggie schezwan chilli paneer pockets mcchicken chicken maharaja mac non veg sharing packs mc aloo tikki french fries veg supreme mcmuffin fresh brew coffee hash browns coca cola pepsi fanta thums up mazza drive thru",
                                     "dominos margherita veg double cheese margherita country special farm house spicy tripple tango peppi paneer mexican green wave deluxe veggie five pepper veggie paradise veg extravaganza cloud 9 chef\'s veg wonder exotic italian veg roman veg supreme milan veg fantasy cheese and barbeque chicken chicken salami spicy chicken chicken fiesta chicken mexican chicken golden delight chicken lovers chef\'s chicken choice non veg supreme cheese and peperoni chicken dominator seventh heaven florence chicken exotica napples chicken special"};
        int i, j=0;
        ArrayList<Integer> intlist = new ArrayList<Integer>();
        for(i=0;i<desc.length;i++) {
            if (desc[i].indexOf(local) != -1) {
                intlist.add(i);
                j++;
            }
        }
        intent.putIntegerArrayListExtra("pass", intlist);
        startActivity(intent);
    }
}
