package com.example.guest.openresources.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.openresources.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CommentActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] comments = new String[] {"Owner is nice", "Good place to charge a phone", "Too many people"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);


        mListView = (ListView) findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, comments);
        mListView.setAdapter(adapter);

    }
}
