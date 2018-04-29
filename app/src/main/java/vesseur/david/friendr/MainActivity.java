package vesseur.david.friendr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // make constant variables
    String[] name = {" ", "Cersei", "daenerys", "goldenHand", "Lord of the Nord", "jorah", "margaery", "melisandere", "sansa", "Ugly Imp", "knight king"};
    String[] bio = {"a girl has no name","power is power", "Daenerys of the House Targaryen, the First of Her Name, The Unburnt, Queen of the Andals, the Rhoynar and the First Men, Queen of Meereen, Khaleesi of the Great Grass Sea, Protector of the Realm, Lady Regnant of the Seven Kingdoms, Breaker of Chains and Mother of Dragons",
    "Incest is wincest", "He know nothing", "Looks a little gray", "I like your brother better", "looks a lot better with necklace on", "Queen bithc",
            "Drinking and lust. No man can match me in these things. I am the god of tits and wine… I shall build a shrine to myself at the next brothel I visit.", "Cracking open a cold one with the boys"};
    int[] image ={R.drawable.arya, R.drawable.cersei, R.drawable.daenerys, R.drawable.jaime, R.drawable.jon, R.drawable.jorah, R.drawable.margaery,
    R.drawable.melisandre, R.drawable.sansa, R.drawable.tyrion, R.drawable.nightking};
    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < name.length; i++){
            friends.add(new Friend(name[i], bio[i], image[i]));
        }
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);
        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new GridItemClickListener());
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            adapterView.getItemAtPosition(i);
            Friend clickedFriend = (Friend) adapterView.getItemAtPosition(i);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
