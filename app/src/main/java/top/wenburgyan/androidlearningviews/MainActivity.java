package top.wenburgyan.androidlearningviews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private BaseAdapter adapter;
    private final String[] items = {"view坐标", "view动画","view事件传递","文件选择"};
    private final Class[] activities = {ViewCoordinateActivity.class, AnimatorActivity.class,ViewEventDispatchActivity.class,FileChooseTestActivity.class};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position>=activities.length) return;
                Intent intent = new Intent(getApplicationContext(), activities[position]);
                startActivity(intent);
            }
        });
    }
}
