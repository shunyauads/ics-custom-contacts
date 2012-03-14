package com.android.contacts.dialpad.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;

import com.android.contacts.ContactPhotoManager;
import com.android.contacts.R;
import com.android.contacts.dialpad.vo.ContactVO;

public class ContactsAdapter extends ArrayAdapter<ContactVO> {
	private static final String TAG = "ContactsAdapter";

	private ArrayList<ContactVO> items;
	private static int MY_BACKGROUD_COLOR;
	private static ContactPhotoManager mPhotoLoader;

	public ContactsAdapter(Context context, int textViewResourceId, ArrayList<ContactVO> items) {
		super(context, textViewResourceId, items);
		this.items = items;
		MY_BACKGROUD_COLOR = this.getContext().getResources().getColor(R.color.call_log_voicemail_highlight_color);
		mPhotoLoader = ContactPhotoManager.getInstance(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.dialpad_row, null);
		}
		ContactVO contact = items.get(position);

		TextView contactName = (TextView) v.findViewById(R.id.contact_name);
		if (contactName != null) {
			SpannableString text = new SpannableString(contact.getName());
			//Log.d(TAG, "Setting span for: " + text + " | Start: " + contact.getNameHighlightStart() + " | End:" + contact.getNameHighlightEnd());
			if (contact.getNameHighlightStart() >= 0 && contact.getNameHighlightEnd() > contact.getNameHighlightStart())
				text.setSpan(new BackgroundColorSpan(MY_BACKGROUD_COLOR), contact.getNameHighlightStart(), contact.getNameHighlightEnd(), 0);
			contactName.setText(text, BufferType.SPANNABLE);
		}
		TextView contactPhone = (TextView) v.findViewById(R.id.contact_phone);
		if (contactPhone != null) {
			SpannableString text = new SpannableString(contact.getPhoneVisible() != null ? contact.getPhoneVisible() : "");
			//Log.d(TAG, "Setting span for: " + text + " | Start: " + contact.getPhoneHighlightStart() + " | End:" + contact.getPhoneHighlightEnd());
			if (contact.getPhoneHighlightStart() >= 0 && contact.getPhoneHighlightEnd() > contact.getPhoneHighlightStart())
				text.setSpan(new BackgroundColorSpan(MY_BACKGROUD_COLOR), contact.getPhoneHighlightStart(), contact.getPhoneHighlightEnd(), 0);
			contactPhone.setText(text, BufferType.SPANNABLE);
		}
		ImageView contactPhoto = (ImageView) v.findViewById(R.id.contact_photo);
		if (contactPhoto != null) {
			String photoUriString = contact.getPhotoUri();
			final Uri photoUri = photoUriString == null ? null : Uri.parse(photoUriString);
//			if (photoUriString!=null) {
//				Log.d(TAG, "adapter photoUri: "+photoUriString);
//			}
			mPhotoLoader.loadPhoto(contactPhoto, photoUri, false, true);
		}

		return v;
	}
}
