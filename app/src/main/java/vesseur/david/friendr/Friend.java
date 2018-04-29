package vesseur.david.friendr;

import java.io.Serializable;

/**
 * Created by Gebruiker on 23-4-2018.
 */

public class Friend implements Serializable {
    private String name, bio;
    private int drawableId;

    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getDrawableId() {
        return drawableId;
    }
}
