package org.aplas.lms.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import org.aplas.lms.R;

public class HomeLectureActivity extends AppCompatActivity {
    private CardView cv_matkul, cv_absen, cv_pengumpulan_tugas, cv_tugas, cv_materi, cv_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_lecture);

        cv_matkul = (CardView) findViewById(R.id.cv_matkul);
        cv_absen = (CardView) findViewById(R.id.cv_absen);
        cv_pengumpulan_tugas = (CardView) findViewById(R.id.cv_pengumpulan_tugas);
        cv_materi = (CardView) findViewById(R.id.cv_materi);
        cv_tugas = (CardView) findViewById(R.id.cv_tugas);
        cv_logout = (CardView) findViewById(R.id.cv_logout);

        cv_matkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeLectureActivity.this, CourseActivity.class);
                startActivity(intent);
            }
        });

        cv_absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cv_pengumpulan_tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cv_materi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cv_tugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cv_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}