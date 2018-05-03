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

    User(EditText username, EditText password)
    {
        currentUsername = username.getText().toString();
        System.out.println("USERNAME IS!!!!!!!!!!!!!!!!!!!!!!!!!! " + currentUsername);
        currentPassword = password.getText().toString();
    //    currentBiography = biography.getText().toString();
        System.out.println("The size is!!!!!!!!!!!!!!!!!!!!!!!!!! " + userList.size());
    }

    public String getUsername()
    {
        return currentUsername;
    }

    private String getCurrentPassword()
    {
        return currentPassword;
    }

    //private void setBiography(String newBio)
    //{
    //    currentBiography = newBio;
    //}

    private boolean isEmpty()
    {
        if(friendList.size() == 0)
        {
            return true;
        }
        else
            return false;
    }

    public static void printUserList()
    {
        for (int i = 0; i < userList.size() ; i++)
        {
            System.out.println("The current user's username is + " + userList.get(i).getUsername() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
        }
    }
}
