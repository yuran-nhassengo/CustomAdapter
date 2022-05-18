package com.lamarck.customadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView list ;
    String[] memeTitles;
    String[] memeDescripions;
    int[] images = {R.drawable.avatar,R.drawable.ic_facebook,R.drawable.avatar,R.drawable.avatar1,R.drawable.avatar3,R.drawable.ic_google,R.drawable.about,R.drawable.call,R.drawable.help,R.drawable.avatar};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        memeTitles = resources.getStringArray(R.array.titles);
        memeDescripions = resources.getStringArray(R.array.descriptions);

        list = (ListView) findViewById(R.id.listView);
        LAdapter adapter = new LAdapter(this,memeTitles,images,memeDescripions);
        list.setAdapter(adapter);


    }
}

class LAdapter extends ArrayAdapter<String>
{
    Context context;
    int[]  images;
    String[] titleArray;
    String[] descArray;
    LAdapter(Context c,String[] titles,int imgs[],String[] desc)
    {
        super(c,R.layout.single_row,R.id.textView,titles);
        this.context =c;
        this.images=imgs;
        this.titleArray =titles;
        this.descArray = desc;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.single_row,parent,false);
        ImageView myImage = row.findViewById(R.id.imageView);
        TextView myTitle = row.findViewById(R.id.textView);
        TextView myDesc = row.findViewById(R.id.textView2);

        myImage.setImageResource(images[position]);
        myTitle.setText(titleArray[position]);
        myDesc.setText(descArray[position]);
        return row;
    }
}