package com.android.contacts.dialpad.vo;

import java.util.ArrayList;

public class ContactVO implements Comparable<ContactVO> {

	private String _id;
	private String name;
	private ArrayList<PhoneVO> phones;
	private int nameHighlightStart;
	private int nameHighlightEnd;
	private int phoneHighlightStart;
	private int phoneHighlightEnd;
	private String phoneVisible;
	private String photoUri;

	public ContactVO(String _id, String name) {
		this._id = _id;
		this.name = name;
		this.phones = new ArrayList<PhoneVO>();
		this.nameHighlightStart = -1;
		this.nameHighlightEnd = -1;
		this.phoneHighlightStart = -1;
		this.phoneHighlightEnd = -1;
		this.photoUri = null;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<PhoneVO> getPhones() {
		return phones;
	}

	public void setPhones(ArrayList<PhoneVO> phones) {
		this.phones = phones;
	}

	@Override
	public int compareTo(ContactVO another) {
		return name.compareTo(another.getName());
	}

	public void setNameHighlightStart(int nameHighlightStart) {
		this.nameHighlightStart = nameHighlightStart;
	}

	public void setNameHighlightEnd(int nameHighlightEnd) {
		this.nameHighlightEnd = nameHighlightEnd;
	}

	public void setPhoneHighlightStart(int phoneHighlightStart) {
		this.phoneHighlightStart = phoneHighlightStart;
	}

	public void setPhoneHighlightEnd(int phoneHighlightEnd) {
		this.phoneHighlightEnd = phoneHighlightEnd;
	}

	public int getNameHighlightStart() {
		return nameHighlightStart;
	}

	public int getNameHighlightEnd() {
		return nameHighlightEnd;
	}

	public int getPhoneHighlightStart() {
		return phoneHighlightStart;
	}

	public int getPhoneHighlightEnd() {
		return phoneHighlightEnd;
	}

	public ContactVO clone() {
		ContactVO temp = new ContactVO(_id, name);
		temp.setPhones((ArrayList<PhoneVO>) phones.clone());
		temp.setNameHighlightEnd(nameHighlightEnd);
		temp.setNameHighlightStart(nameHighlightStart);
		temp.setPhoneHighlightEnd(phoneHighlightEnd);
		temp.setPhoneHighlightStart(phoneHighlightStart);
		temp.setPhoneVisible(phoneVisible);
		temp.setPhotoUri(photoUri);
		return temp;
	}

	public void addPhone(String phone, int type) {
		phones.add(new PhoneVO(phone, type));
	}

	public void setPhoneVisible(String phoneVisible) {
		this.phoneVisible = phoneVisible;
	}

	public String getPhoneVisible() {
		if (phoneVisible != null && phoneVisible.length() > 0)
			return phoneVisible;
		if (phones != null && phones.size() > 0)
			return phones.get(0).getNumber();
		else
			return null;
	}

	public String getPhotoUri() {
		return photoUri;
	}

	public void setPhotoUri(String photoUri) {
		this.photoUri = photoUri;
	}

}
