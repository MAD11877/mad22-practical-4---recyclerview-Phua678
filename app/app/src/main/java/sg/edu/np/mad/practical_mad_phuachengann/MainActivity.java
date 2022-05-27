package sg.edu.np.mad.practical_mad_phuachengann;

import static sg.edu.np.mad.practical_mad_phuachengann.ListActivity.list1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.view.View;
import android.widget.TextView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] ToastMsg = new String[1];
        Intent receivingEnd = getIntent();
        int pos = receivingEnd.getIntExtra("posi",0);
        User newUser = list1.get(pos);
        Button FollowButton = findViewById(R.id.FollowUnFollowButton);
        Integer message = receivingEnd.getIntExtra("Key",0);
        TextView txt = findViewById(R.id.nameNo);
        txt.setText(newUser.name);
        TextView txt2 = findViewById(R.id.desc);
        txt2.setText(newUser.description);
        if(newUser.followed){
            FollowButton.setText("Unfollow");
        }
        else{
            FollowButton.setText("follow");
        }

        Button MessageButton = findViewById(R.id.MsgButton);
        MessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityName2 = new Intent(MainActivity.this, MessageGroup.class);
                activityName2.putExtra("message", "value");
                startActivity(activityName2);

            }
        });


        FollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (list1.get(pos).followed == true) {
                    FollowButton.setText("Follow");
                    newUser.followed = false;
                    ToastMsg[0] = "Followed";
                } else if (list1.get(pos).followed == false) {
                    FollowButton.setText("Unfollow");
                    newUser.followed = true;
                    ToastMsg[0] = "UnFollowed";
                }
                Toast.makeText(MainActivity.this, ToastMsg[0], Toast.LENGTH_SHORT).show();
            }

        });

    }

}