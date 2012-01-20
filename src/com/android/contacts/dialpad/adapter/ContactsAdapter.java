package com.android.contacts.dialpad.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.contacts.R;
import com.android.contacts.dialpad.vo.ContactVO;

public class ContactsAdapter extends ArrayAdapter<ContactVO> {

	private ArrayList<ContactVO> items;

	public ContactsAdapter(Context context, int textViewResourceId, ArrayList<ContactVO> items) {
		super(context, textViewResourceId, items);
		this.items = items;
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
		  contactName.setText(contact.getName());
		}
		TextView contactPhone = (TextView) v.findViewById(R.id.contact_phone);
		if (contactPhone != null) {
		  contactPhone.setText(contact.getNumber()!=null?contact.getNumber():"");
		}

		return v;
	}
}
