package org.aplas.lms.dialogs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.aplas.lms.R;
import org.aplas.lms.activities.CourseActivity;
import org.aplas.lms.configs.ApiUtils;
import org.aplas.lms.configs.SessionManager;
import org.aplas.lms.interfaces.ApiService;
import org.aplas.lms.requests.courses.AddCourseRequest;
import org.aplas.lms.responses.courses.CourseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddCourseDialog#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddCourseDialog extends DialogFragment {
    private Button btn_simpan;
    private EditText et_name;
    private ProgressBar pb_loading;

    private ApiService apiService;
    private SessionManager sessionManager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddCourseDialog() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddCourseDialog.
     */
    // TODO: Rename and change types and number of parameters
    public static AddCourseDialog newInstance(String param1, String param2) {
        AddCourseDialog fragment = new AddCourseDialog();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_add_course_dialog, container, false);
        btn_simpan = (Button) view.findViewById(R.id.btn_simpan);
        et_name = (EditText) view.findViewById(R.id.et_name);
        pb_loading = (ProgressBar) view.findViewById(R.id.pb_loading);
        apiService = ApiUtils.getApiService(getContext());
        sessionManager = new SessionManager(getContext());

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_name = et_name.getText().toString().trim();

                if(!str_name.isEmpty()){
                    createShop(str_name);
                }else{
                    if(str_name.isEmpty()){
                        et_name.setError("Tolong isikan nama mata kuliah");
                    }
                }
            }
        });

        return view;
    }

    private void createShop(String name){
        pb_loading.setVisibility(View.VISIBLE);
        btn_simpan.setVisibility(View.GONE);

        Call<CourseResponse> call = apiService.create_course(new AddCourseRequest(name));
        call.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                CourseResponse addShopResponse = response.body();
                if(response.code() == 201){
                    Toast.makeText(getActivity().getApplicationContext(), "Mata kuliah successfully added!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity().getApplicationContext(), "Mata kuliah add fail!", Toast.LENGTH_SHORT).show();
                }
                Intent intent = new Intent(getView().getContext(), CourseActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                getActivity().finish();
                pb_loading.setVisibility(View.GONE);
                btn_simpan.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {

            }
        });
    }

    public  void  onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}