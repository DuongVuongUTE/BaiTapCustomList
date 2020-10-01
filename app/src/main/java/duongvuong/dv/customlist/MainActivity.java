package duongvuong.dv.customlist;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listview;
    String sTitle[]={"SPKT Đà Nẵng","BK Đà Nẵng","NN Đà Nẵng","SP Đà Nẵng","KT Đà Nẵng","Facebook","Whatsapp","Twitter","Instagram","Youtube"};
    String sDescription[]={"ĐH SPKT Đà Nẵng","ĐH Bách Khoa Đà Nẵng","ĐH Ngoại Ngữ Đà Nẵng","ĐH Sư Phạm Đà Nẵng","ĐH Kinh Tế Đà Nẵng","Facebook Description","Whatsapp Description","Twitter Description","Instagram Description","Youtube Description"};
    int sImage[]={R.drawable.utelogo,R.drawable.logo_bkdn,R.drawable.ngoaingu,R.drawable.supham,R.drawable.kinhte,R.drawable.facebook,R.drawable.whatsapp,R.drawable.twitter,R.drawable.instagram,R.drawable.youtube};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview=findViewById(R.id.list_view);
        myAdapter adapter=new myAdapter(this,sTitle,sDescription,sImage);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(MainActivity.this,"Facebook Description",Toast.LENGTH_SHORT).show();
                }
                if (position==1){
                    Toast.makeText(MainActivity.this,"Whatsapp Description",Toast.LENGTH_SHORT).show();
                }
                if (position==2){
                    Toast.makeText(MainActivity.this,"Twitter Description",Toast.LENGTH_SHORT).show();
                }
                if (position==3){
                    Toast.makeText(MainActivity.this,"Instagram Description",Toast.LENGTH_SHORT).show();
                }
                if (position==4){
                    Toast.makeText(MainActivity.this,"Youtube Description",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    class myAdapter extends ArrayAdapter<String>{
        Context context;
        String gtitle[];
        String gdescription[];
        int gimage[];
        myAdapter(Context c,String title[],String description[],int image[]){
            super(c,R.layout.row,R.id.textview1,title);
            this.context =c;
            this.gtitle=title;
            this.gdescription=description;
            this.gimage=image;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=layoutInflater.inflate(R.layout.row,parent,false);
            ImageView image= row.findViewById(R.id.image);
            TextView myTitle=row.findViewById(R.id.textview1);
            TextView myDiscription =row.findViewById(R.id.textview2);

            image.setImageResource(gimage[position]);
            myTitle.setText(gtitle[position]);
            myDiscription.setText(gdescription[position]);

            return row;
        }
    }
}