package vesseur.david.friendr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    public Friend retrievedFriend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get intent and save in retrievedFriend
        Intent intent = getIntent();
        retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // get viewID
        TextView profileText = findViewById(R.id.nameView);
        ImageView profileimage = findViewById(R.id.profileView);
        TextView bioText = findViewById(R.id.bioView);

        // set text and images to given intent
        profileText.setText(retrievedFriend.getName());
        profileimage.setImageDrawable(getDrawable(retrievedFriend.getDrawableId()));
        bioText.setText(retrievedFriend.getBio());

        // get ratingbar and make listener
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBarClickListener());

        // get saved rating or set 0
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        float rating = prefs.getFloat(retrievedFriend.getName(),0);
        ratingBar.setRating(rating);

        // get saved message or set standard message
        String message = prefs.getString(retrievedFriend.getName()+ "message","write a massage for your friend here!");
        TextView messageText = findViewById(R.id.messageText);
        messageText.setText(message);


    }
    private class RatingBarClickListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
            // make shared preferences and safe
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putFloat(retrievedFriend.getName(), v);
            editor.apply();
        }
    }

    public void onClickSafe(View view) {
        // get message and safe it
        EditText messageText = findViewById(R.id.messageText);
        Editable text = messageText.getText();
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(retrievedFriend.getName()+ "message", String.valueOf(text));
        editor.apply();
    }
}
