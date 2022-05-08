package sg.edu.np.mad.p05;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class ListActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView btn_image = findViewById(R.id.imageView2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Setting the Title & Message manually
        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);

        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                // User click VIEW button
                Random random = new Random(); // Instance of random class
                int randomNumber = Math.abs(random.nextInt());

                Intent sentIntent = new Intent(ListActivity.this, MainActivity.class);
                sentIntent.putExtra("randomNumber", randomNumber);
                startActivity(sentIntent);
            }
        });

        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int id)
            {
                // User cancelled the dialog
            }
        });

        // Creating the AlertDialog box
        AlertDialog dialog = builder.create();

        btn_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.show();
            }
        });
    }
}