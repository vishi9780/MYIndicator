package app.com.myindicator.expandabletxt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

import app.com.myindicator.R;
import app.com.myindicator.expandabletxt.adapter.RecyclerViewAdapter;

public class RecyclerViewModeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        String text = getString(R.string.tips);
        String textShort = getString(R.string.tips_short);
        ArrayList<ContentModel> lists = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ContentModel cm = new ContentModel();
            cm.setText(i + "    " + text);
            if (i == 10) cm.setText(i + "    " + textShort);
            cm.setShrink(true);
            lists.add(cm);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(lists);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    }
}
