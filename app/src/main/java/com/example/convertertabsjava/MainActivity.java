package com.example.convertertabsjava;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/** Main Activity that holds the TabLayout and ViewPager2 to manage fragments. */
public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize UI and ViewPager
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(this));
        // Link TabLayout and ViewPager2
        new TabLayoutMediator(tabLayout, viewPager, (tab, pos) -> tab.setText(pos == 0 ? "Temperature" : "Distance")).attach();
    }

    /** Override back button for exit confirmation. */
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this).setTitle("Exit").setMessage("Exit app?")
                .setPositiveButton("Yes", (d, w) -> finish()).setNegativeButton("No", null).show();
    }
}