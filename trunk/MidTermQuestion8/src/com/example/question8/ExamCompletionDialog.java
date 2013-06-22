package com.example.question8;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

@SuppressLint("NewApi")
public class ExamCompletionDialog extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
		adb.setTitle(R.string.dialog_title);
		adb.setMessage(R.string.dialog_message);
		adb.setPositiveButton(R.string.positive_label, null);
		adb.setNegativeButton(R.string.negative_label, null);
		return adb.create();
	}

}
