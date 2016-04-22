package com.example.guest.openresources;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.widget.ArrayAdapter;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CommentActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] comments = new String[] {"Owner is nice", "Good place to charge a phone", "Too many people"};
=======

public class CommentActivity extends AppCompatActivity {
>>>>>>> cadf7c5a1732aa26584b9dc0f215fe78b3e0b223

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
<<<<<<< HEAD

        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, comments);
        mListView.setAdapter(adapter);
=======
>>>>>>> cadf7c5a1732aa26584b9dc0f215fe78b3e0b223
    }
}
