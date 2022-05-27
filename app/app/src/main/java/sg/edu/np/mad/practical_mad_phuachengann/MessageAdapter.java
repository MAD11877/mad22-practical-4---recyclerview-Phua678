package sg.edu.np.mad.practical_mad_phuachengann;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<Holder> {

    ArrayList<User> list1;

    public MessageAdapter(ArrayList<User> list){
       this.list1 = list;
    }

    @Override
    public int getItemViewType(int position){
        User a = list1.get(position);
        if (a.name.endsWith("7")){
            return 1;
        }
        else{
            return 2;
        }
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item =  null;
        if (viewType == 2 )
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,null,false);
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview2,parent,false);
        }
        return new Holder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        User a = list1.get(position);

        holder.NameNo.setText(a.name);
        holder.desc.setText(a.description);

        holder.Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(holder.Icon.getContext());
                dialog.setTitle("Profile");
                dialog.setMessage(a.name);
                dialog.setNegativeButton("close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Bundle bundle = new Bundle();
                        bundle.putInt("posi", position);
                        bundle.putString("randomvalue", a.name);
                        bundle.putString("desc", a.description);
                        Intent next = new Intent(holder.Icon.getContext(), MainActivity.class);

                        next.putExtras(bundle);

                        holder.Icon.getContext().startActivity(next);

                    }
                });
                AlertDialog alert = dialog.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {

        return list1.size();

    }
}
