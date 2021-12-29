package com.gmpkomputers.gmpkomputerkom.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.gmpkomputers.gmpkomputerkom.Fragments.AdminHomeFragment;
import com.gmpkomputers.gmpkomputerkom.Fragments.AdminVerifyProductsFragment;
import com.gmpkomputers.gmpkomputerkom.Fragments.AdminViewSellersFragment;
import com.gmpkomputers.gmpkomputerkom.Fragments.AdminViewUsersFragment;
import com.gmpkomputers.gmpkomputerkom.Fragments.OrdersFragment;
import com.gmpkomputers.gmpkomputerkom.R;
import com.gmpkomputers.gmpkomputerkom.User.ProductDetailsActivity;
import com.gmpkomputers.gmpkomputerkom.View.ItemsActivity;
import com.gmpkomputers.gmpkomputerkom.View.MainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class AdminPanelActivity extends AppCompatActivity {


    private final String TAG ="theartist";
    DatabaseReference mRootRef;
    FirebaseAuth mAuth;
    Button struk;
    //Texte

    private BottomNavigationView bottomNavigationView;
    private Fragment selectorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_panel);

        //------------------------------------------------------------------------------------

        struk = (Button)findViewById(R.id.struk);

        struk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pindah = new Intent(AdminPanelActivity.this, ItemsActivity.class);
                startActivity(pindah);
                //menghubungkan antar activity dengan intent SellerKirimBuktiBayarActivity
            }
        });

        //------------------------------------------------------------------------------------



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AdminHomeFragment()).commit();
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectorFragment = new AdminHomeFragment();
                        break;
                    case R.id.nav_order:
                        selectorFragment = new OrdersFragment();
                        break;
                    case R.id.nav_product:
                        selectorFragment = new AdminVerifyProductsFragment();
                        break;
                    case R.id.nav_seller:
                       selectorFragment = new AdminViewSellersFragment();
                        break;
                    case R.id.nav_user:
                    selectorFragment = new AdminViewUsersFragment();
                        break;
                }
                if (selectorFragment !=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectorFragment).commit();
                }
                return true;
            }
        });

//
//        Bundle intent = getIntent().getExtras();
//        if(intent!=null){
//            String profileId = intent.getString("publisherId");
//            getSharedPreferences("PROFILE",MODE_PRIVATE).edit().putString("profileId",profileId).apply();
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ProfileFragment()).commit();
//            bottomNavigationView.setSelectedItemId(R.id.person);
//        }else {
//
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
//        }

    }
}


//        total orders this month
//        current online users
//todays slaes and transition hightligts