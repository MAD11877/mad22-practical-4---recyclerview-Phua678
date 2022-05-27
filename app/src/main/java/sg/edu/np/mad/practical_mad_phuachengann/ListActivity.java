package sg.edu.np.mad.practical_mad_phuachengann;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    public static ArrayList<User> list1 = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        for (int i = 0; i < 20; i++)
        {
            String N = "Name ";
            String D = "Description ";
            Random rand = new Random();
            int RN = rand.nextInt();
            int RD = rand.nextInt();
            int id = rand.nextInt();
            boolean followed;
            followed = rand.nextBoolean();

            String NRN = (N + RN);
            String NRD = (D + RD);
            User user1 = new User(NRN,NRD,id,followed);
            list1.add(user1);
            Log.v("list",user1.description);
        }

        RecyclerView rv = findViewById(R.id.view);
        MessageAdapter msg = new MessageAdapter(list1);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(msg);



//        ImageView icon = findViewById(R.id.imageView3);
//        icon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Create the object of
//                // AlertDialog Builder class
//                AlertDialog.Builder builder
//                        = new AlertDialog
//                        .Builder(ListActivity.this);
//
//                builder.setMessage("MADness");
//
//                builder.setTitle("Profile");
//
//                builder.setCancelable(false);
//
//                builder
//                        .setPositiveButton(
//                                "View",
//                                new DialogInterface
//                                        .OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog,
//                                                        int which)
//                                    {
//
//                                        // When the user click View button
//                                        // then app will go to main activity
//                                        Intent activityName = new Intent(ListActivity.this, MainActivity.class);
//                                        Random rand = new Random();
//                                        int randomNo = rand.nextInt();
//                                        activityName.putExtra("Key", randomNo);
//                                        startActivity(activityName);
//
//                                    }
//                                });
//
//                // Set the Negative button with No name
//                // OnClickListener method is use
//                // of DialogInterface interface.
//                builder
//                        .setNegativeButton(
//                                "Close",
//                                new DialogInterface
//                                        .OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog,
//                                                        int which)
//                                    {
//
//                                        // If user click no
//                                        // then dialog box is canceled.
//                                        //dialog.cancel();
//                                        finish();
//                                    }
//                                });
//
//                // Create the Alert dialog
//                AlertDialog alertDialog = builder.create();
//
//                // Show the Alert Dialog box
//                alertDialog.show();
//            }
//        });

    }
}