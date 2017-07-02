package test.crypthook.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import test.crypthook.R;

public class MainActivity extends AppCompatActivity {
    private Button system;
    private Button third;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        system=(Button)findViewById(R.id.system);
        third=(Button)findViewById(R.id.third);
        system.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AppActivity.class);
                intent.putExtra("type",0);
                startActivity(intent);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AppActivity.class);
                intent.putExtra("type",1);
                startActivity(intent);
            }
        });
    }
}
