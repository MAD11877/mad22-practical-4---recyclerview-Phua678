package sg.edu.np.mad.practical_mad_phuachengann;

import android.content.ClipData;
import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    ImageView Icon;
    TextView NameNo;
    TextView desc;

    public Holder (View Item){

        super(Item);
        Icon = Item.findViewById(R.id.icon);
        NameNo = Item.findViewById(R.id.nameNo);
        desc = Item.findViewById(R.id.desc);
    }

}
