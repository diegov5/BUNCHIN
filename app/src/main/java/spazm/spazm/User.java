package spazm.spazm;

import android.widget.EditText;

import java.util.ArrayList;

public class User
{
    public static ArrayList<User> userList= new ArrayList<User>();


    private ArrayList<User> friendList = new ArrayList<>();
    private String currentUsername;
    private String currentPassword;
    private String currentBiography;

    User(EditText username, EditText password, EditText biography)
    {
        currentUsername = username.toString();
        currentPassword = password.toString();
        currentBiography = biography.toString();
    }

    public String getUsername()
    {
        return currentUsername;
    }

    private String getCurrentPassword()
    {
        return currentPassword;
    }

    private void setBiography(String newBio)
    {
        currentBiography = newBio;
    }
}
