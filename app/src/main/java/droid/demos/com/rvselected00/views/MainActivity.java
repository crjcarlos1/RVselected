package droid.demos.com.rvselected00.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import droid.demos.com.rvselected00.R;
import droid.demos.com.rvselected00.adapters.CustomAdapter;
import droid.demos.com.rvselected00.models.Item;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CustomAdapter adapter;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rv);

        itemList=new ArrayList<>();
        for (int i=0;i<20;i++)
        {
            itemList.add(new Item("Name "+i,false));
        }

        adapter=new CustomAdapter(itemList,MainActivity.this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);

    }
}
