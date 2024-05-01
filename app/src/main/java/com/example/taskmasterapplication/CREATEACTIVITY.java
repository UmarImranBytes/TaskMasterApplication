package com.example.taskmasterapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class CREATEACTIVITY extends AppCompatActivity {
    FragmentManager manager;
    Fragment activityfrag,listfrag,manageActFrag;
    View ListView,ActivityView,ManageView;
    EditText etTaskTitle,etDescription,etAdditionalNotes,etDueDate;
    Button btnSaveTask,btnCreateact,btnPrevousTask;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        init();

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tasktitle=etTaskTitle.getText().toString().trim();
                String desctiption=etDescription.getText().toString().trim();
            }
        });
        btnCreateact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .show(activityfrag)
                        .hide(listfrag)
                        .hide(manageActFrag)
                        .commit();
            }
        });

        btnPrevousTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.beginTransaction()
                        .show(listfrag)
                        .hide(manageActFrag)
                        .hide(activityfrag)
                        .commit();
            }
        });

    }
    private void init()
    {
        manager=getSupportFragmentManager();
        activityfrag=manager.findFragmentById(R.id.activityfrag);
        listfrag=manager.findFragmentById(R.id.listfrag);
        manageActFrag=manager.findFragmentById(R.id.manageActFrag);
        assert listfrag != null;
        ListView=listfrag.getView();
        ActivityView=activityfrag.getView();
        ManageView=manageActFrag.getView();

        assert ActivityView != null;
        etTaskTitle=ActivityView.findViewById(R.id.etTaskTitle);
        etDescription=ActivityView.findViewById(R.id.etDescription);
        etAdditionalNotes=ActivityView.findViewById(R.id.etAdditionalNotes);
        etDueDate=ActivityView.findViewById(R.id.etDueDate);
        btnSaveTask=ActivityView.findViewById(R.id.btnSaveTask);
        btnCreateact=ManageView.findViewById(R.id.btnCreateact);
        btnPrevousTask=ManageView.findViewById(R.id.btnPrevousTask);

    }

}
