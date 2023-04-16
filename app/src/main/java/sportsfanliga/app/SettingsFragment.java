package sportsfanliga.app;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.android.material.slider.Slider;



public class SettingsFragment extends Fragment {



    private static final String FILE_NAME1="MY_FILE";
    private static final String MODE_THEME="SIZE_THEME";
    SharedPreferences sPrefTheme;
    SharedPreferences.Editor edTheme;
    public static Slider slider;
    public SettingsFragment() {
        super(R.layout.fragment_settings);
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_settings, container, false);
        ImageView ivText = v.findViewById(R.id.ivText);
        ImageView ivTheme = v.findViewById(R.id.ivTheme);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RadioButton rdDay = view.findViewById(R.id.dayBtn);
        RadioButton rdNight = view.findViewById(R.id.nightBtn);
        ImageView ivText = view.findViewById(R.id.ivText);
        ImageView ivTheme = view.findViewById(R.id.ivTheme);
        Slider slider = view.findViewById(R.id.slider);
        getFontSize(view);
        slider.addOnSliderTouchListener(new Slider.OnSliderTouchListener() {
            @Override
            public void onStartTrackingTouch(@NonNull Slider slider) {

            }

            @Override
            public void onStopTrackingTouch(@NonNull Slider slider) {
                int font_size =(int) slider.getValue();
                System.out.println(font_size);
                setFontSize(font_size);
                Fragment fragment = new SettingsFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentCV, fragment);
                fragmentTransaction.commit();

            }
        });
       //MainActivity2.binding.bottomNavigationView.setSelectedItemId(R.id.settings);
        //MainActivity2.binding.bottomNavigationView.setSelected();
        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){
           rdNight.setChecked(true);
           rdDay.setChecked(false);
            ivText.setImageResource(R.drawable.ic_baseline_format_size_24_white);
            ivTheme.setImageResource(R.drawable.ic_baseline_brightness_4_24_white);
            getFontSize(view);
        }
        else{
            rdNight.setChecked(false);
            rdDay.setChecked(true);
            ivText.setImageResource(R.drawable.ic_baseline_format_size_24);
            ivTheme.setImageResource(R.drawable.ic_baseline_brightness_4_24);
            getFontSize(view);
        }
    }
    public void getFontSize(View view){

        Slider slider = view.findViewById(R.id.slider);
        sPrefTheme = getActivity().getSharedPreferences(FILE_NAME1,MODE_PRIVATE);
        String textSize = sPrefTheme.getString(MODE_THEME,"");
        System.out.println(textSize+"!!!!!!!!!!!!!!!!!!!!!!");
        switch (textSize) {
            case "":
                slider.setValue(1);
                setFontSize(1);
                break;
            case "0":
                slider.setValue(0);
                setFontSize(0);
                break;
            case "1":
                slider.setValue(1);
                setFontSize(1);
                break;
            case "2":
                slider.setValue(2);
                setFontSize(2);
                break;
            case "3":
                slider.setValue(3);
                setFontSize(3);
                break;
        }

    }
    public void setFontSize(int font_size){
        edTheme = sPrefTheme.edit();
        //edTheme.putString(MODE_THEME, String.valueOf(font_size));
        switch (font_size) {
            case 0:
                getActivity().setTheme(R.style.Theme_ЛигаСпорта_Small);
                edTheme.putString(MODE_THEME, "0");
                edTheme.apply();
                break;
            case 1:
                getActivity().setTheme(R.style.Theme_ЛигаСпорта);
                edTheme.putString(MODE_THEME, "1");
                edTheme.apply();
                break;
            case 2:
                getActivity().setTheme(R.style.Theme_ЛигаСпорта_Big);
                edTheme.putString(MODE_THEME, "2");
                edTheme.apply();
                break;
            case 3:
                getActivity().setTheme(R.style.Theme_ЛигаСпорта_Biggest);
                edTheme.putString(MODE_THEME, "3");
                edTheme.apply();
                break;
        }
        sPrefTheme = getActivity().getSharedPreferences(FILE_NAME1,MODE_PRIVATE);
        String textSize = sPrefTheme.getString(MODE_THEME,"");
        System.out.println(textSize+"@@@@@@@@@@@@@");
    }

}