package in.blogspot.tecnopandit.notesapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
FloatingActionButton floatingActionButton;
ListView listView;
    ArrayAdapter<String>arrayAdapter;
    @Override
    protected void onResume() {
        super.onResume();
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Prefrence.arrayList);
        listView.setAdapter(arrayAdapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton=findViewById(R.id.floatingActionButton);
        listView=findViewById(R.id.listnotes);
        Prefrence.arrayList.add("Notes");
        arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,Prefrence.arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),Editnote.class);
                intent.putExtra("key",position);
                startActivity(intent);
            }
        });
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Editnote.class);
                startActivity(intent);
            }
        });



    }
}
