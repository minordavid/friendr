package vesseur.david.friendr;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gebruiker on 24-4-2018.
 */

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;

    public FriendsAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Friend> objects) {

        super(context, resource, objects);
        friends = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }
        // get desired id's and return
        TextView profileText = convertView.findViewById(R.id.profileText);
        ImageView profileImage = convertView.findViewById(R.id.profileImage);
        profileImage.setImageDrawable(getContext().getDrawable(friends.get(position).getDrawableId()));
        profileText.setText(friends.get(position).getName());

        return convertView;
    }
}
