/**
 * Created by David Ihle Local on 4/18/2018. Gives basic outline of the User class. Moving forward,
 * this class will contain more information, like the profile picture, friends list, photos they are
 * tagged in, the message feed etc.
 */


package spazm.spazm;

import android.widget.EditText;

import java.util.ArrayList;

public class User
{
    // The universal ArrayList of users. Will serve as the temporary database
    public static ArrayList<User> userList= new ArrayList<User>();



    //private ArrayList<User> friendList = new ArrayList<>();
    private String currentUsername;
    private String currentPassword;

    /**
     * Will create a user with the input text values in the username/password text fields on
     * SignupActivity
     * @param username, password
     * @returns none
     */
    User(EditText username, EditText password)
    {
        currentUsername = username.getText().toString();
        currentPassword = password.getText().toString();

    }
    /**
     * Get the username of the currentUser
     * @param
     * @returns String, the username of current user
     */
    public String getUsername()
    {
        return currentUsername;
    }




    /**
     * Used in testing, will pring the entire list of registered users based on username
     * @param
     * @returns
     */
    public static void printUserList()
    {
        for (int i = 0; i < userList.size() ; i++)
        {
            System.out.println("User #" + (i+1) + "'s username is + " + userList.get(i).getUsername() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!" );
        }
    }
}
