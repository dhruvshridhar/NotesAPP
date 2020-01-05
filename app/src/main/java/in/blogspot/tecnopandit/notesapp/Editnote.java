package in.blogspot.tecnopandit.notesapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class Editnote extends AppCompatActivity {
EditText editText;
Intent intent;
String note="note";
int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editnote);
        editText=findViewById(R.id.editText);
        intent=getIntent();
        int k=intent.getIntExtra("key",0);
        if (k!=0)
        {
            editText.setText(Prefrence.arrayList.get(k));
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Prefrence.arrayList.add(editText.getText().toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(editText.getText().toString().isEmpty())
        {
            finish();
        }
        else {
            Prefrence.arrayList.add(editText.getText().toString());

        }
    }
}
