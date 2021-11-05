package com.bytedance.search;


import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
    EditText textBox;
    TextView text;
    ListView list;
    String country[]={"这是第1行","这是第2行","这是第3行","这是第4行","这是第5行","这是第6行"};
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textBox=(EditText)findViewById(R.id.textBox);
        text=(TextView)findViewById(R.id.text);
        list=(ListView)findViewById(R.id.list);

        adapter=new ArrayAdapter(this,R.layout.list_item,R.id.text,country);
        list.setAdapter(adapter);


        textBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                adapter.getFilter().filter(s);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}