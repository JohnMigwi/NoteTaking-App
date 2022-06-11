package com.example.notekeeper;

import android.os.Bundle;

import androidx.lifecycle.ViewModel;

public class NoteActivityViewModel extends ViewModel {
    public static final String ORIGINAL_NOTE_COURSE_ID="com.example.notekeeper.ORIGINAL_NOTE_COURSE_ID";
    public static final String ORIGINAL_NOTE_TITle="com.example.notekeeper.ORIGINAL_NOTE_TITLE";
    public static final String ORIGINAL_NOTE_TEXT="com.example.notekeeper.ORIGINAL_NOTE_TEXT";

    public String mOriginalCourseNoteId;
    public String mOriginalNoteTitle;
    public String mOriginalNoteText;
    public boolean mIsNewlyCreated=true;

    public void saveState(Bundle outState) {
        outState.putString(ORIGINAL_NOTE_COURSE_ID,mOriginalCourseNoteId);
        outState.putString(ORIGINAL_NOTE_TITle,mOriginalNoteTitle);
        outState.putString(ORIGINAL_NOTE_TEXT,mOriginalNoteText);
    }
    public void restoreState(Bundle inState){
        mOriginalCourseNoteId= inState.getString(ORIGINAL_NOTE_COURSE_ID);
        mOriginalNoteText= inState.getString(ORIGINAL_NOTE_TEXT);
        mOriginalNoteTitle= inState.getString(ORIGINAL_NOTE_TITle);
    }
}
