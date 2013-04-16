package pk.edu.pucit.mc.dialogdemo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class SimpleDialogFragment extends DialogFragment {
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
		adb.setIcon(R.drawable.ic_launcher);
		adb.setTitle(R.string.simple_dialog_title);
		adb.setMessage(R.string.simple_dialog_message);
		adb.setPositiveButton(R.string.simple_dialog_positive_option,
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), ":)", Toast.LENGTH_SHORT).show();
					}
				});
		adb.setNegativeButton(R.string.simple_dialog_negative_option,
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), ":(", Toast.LENGTH_SHORT).show();
					}
				});
		adb.setNeutralButton(R.string.simple_dialog_neutral_option, 
				new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), ":|", Toast.LENGTH_SHORT).show();
					}
				});
		return adb.create();
	}

}
