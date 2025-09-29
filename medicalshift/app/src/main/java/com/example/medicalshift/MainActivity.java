package com.example.medicalshift;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements InicioFragment.OnNavigationRequest{

    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavigationView;
    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        fragmentAdapter = new FragmentAdapter(this);
        viewPager.setAdapter(fragmentAdapter);

        // Sincronizar barra con desplazamiento horizontal
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        // Sincronizar desplazamiento con barra de navegación inferior
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                viewPager.setCurrentItem(0);
                return true;
            } else if (itemId == R.id.nav_tramites) {
                viewPager.setCurrentItem(1);
                return true;
            } else if (itemId == R.id.nav_cartilla) {
                viewPager.setCurrentItem(2);
                return true;
            } else if (itemId == R.id.nav_perfil) {
                viewPager.setCurrentItem(3);
                return true;
            } else if (itemId == R.id.nav_mas) {
                MenuBottomSheetFragment bottomSheet = new MenuBottomSheetFragment();
                bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
                return true;
            }

            return false;
        });
    }
    // Sobreescritura del método OnNavigationRequest, del fragmento Inicio
    @Override
    public void navegarA(int posicion) {
        viewPager.setCurrentItem(posicion, true);
    }
}