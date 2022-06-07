 package com.example.notekeeper;

 import android.content.Intent;
 import android.os.Bundle;
 import android.view.View;
 import android.widget.AdapterView;
 import android.widget.ArrayAdapter;
 import android.widget.ListView;

 import androidx.appcompat.app.AppCompatActivity;
 import androidx.navigation.ui.AppBarConfiguration;

 import com.example.notekeeper.databinding.ActivityNoteListBinding;
 import com.google.android.material.floatingactionbutton.FloatingActionButton;

 import java.util.List;

 public class NoteListActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityNoteListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNoteListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);


        FloatingActionButton fab=findViewById(R.id.fab);
        fab.setOnClickListener((view) -> {
           startActivity(new Intent(NoteListActivity.this,NoteActivity.class));
        });

        intializeDisplayContent();
    }

    private void intializeDisplayContent() {
        final ListView listNotes=findViewById(R.id.list_notes);
        List<NoteInfo> notes=DataManager.getInstance().getNotes();
        ArrayAdapter<NoteInfo> adapterNotes=new ArrayAdapter<>(this, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, notes);
        listNotes.setAdapter(adapterNotes);

        listNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long I) {
                Intent intent=new Intent(NoteListActivity.this, NoteActivity.class);
                NoteInfo note=(NoteInfo) listNotes.getItemAtPosition(position);
                intent.putExtra(NoteActivity.NOTE_INFO,note);

                startActivity(intent);
            }
        });

        }
    }



