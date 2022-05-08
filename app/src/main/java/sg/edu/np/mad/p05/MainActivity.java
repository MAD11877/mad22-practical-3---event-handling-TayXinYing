package sg.edu.np.mad.p05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Receiving data from ListActivity
        int number = getIntent().getIntExtra("randomNumber", 0);
        TextView text = findViewById(R.id.textView);
        text.setText(MessageFormat.format("{0}","MAD " + number));

        Button btn_message = findViewById(R.id.message_button);
        btn_message.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent activity = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(activity);
            }
        });
    }

    public void follow(View view)
    {
        Button btn_follow = findViewById(R.id.follow_button);
        User user = new User("username", "desc", 1, false);
        follow_condition(user, btn_follow);

        btn_follow.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                // Perform action on click
                if (!user.followed)
                {
                    user.followed = true;
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    user.followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                follow_condition(user, btn_follow);
            }
        });
    }

    public void follow_condition(User user, Button btn)
    {
        if (!user.followed)
        {
            btn.setText("FOLLOW");
        }
        else
        {
            btn.setText("UNFOLLOW");
        }
    }
}
