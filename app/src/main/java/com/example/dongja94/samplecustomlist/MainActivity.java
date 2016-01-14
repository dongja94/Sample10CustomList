package com.example.dongja94.samplecustomlist;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    PersonAdapter mAdapter;
    static final int[] ICON_IDS = {R.drawable.sample_thumb_0,
            R.drawable.sample_thumb_1,
            R.drawable.sample_thumb_2,
            R.drawable.sample_thumb_3,
            R.drawable.sample_thumb_4,
            R.drawable.sample_thumb_5,
            R.drawable.sample_thumb_6,
            R.drawable.sample_thumb_7
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new PersonAdapter();
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Person p = (Person)listView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "name : " + p.getName(), Toast.LENGTH_SHORT).show();
            }
        });

        initData();
    }

    private void initData() {
        Random r = new Random();
        for (int i = 0; i < 20; i++) {
            int age = 20 + r.nextInt(20);
            Drawable d = getResources().getDrawable(ICON_IDS[age % ICON_IDS.length]);
            if (age % 3 == 0) {
                d = null;
            }
            Person p = new Person(d, "name" + i, age, "desc : " + i);
            mAdapter.add(p);
        }
    }
}
