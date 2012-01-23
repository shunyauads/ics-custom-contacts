package com.android.contacts.dialpad.vo;

public class ContactVO implements Comparable<ContactVO> {

  private String _id;
  private String name;
  private String phone;
  private int nameHighlightStart;
  private int nameHighlightEnd;
  private int phoneHighlightStart;
  private int phoneHighlightEnd;

  public ContactVO(String _id, String name, String phone) {
	this._id = _id;
	this.name = name;
	this.phone = phone;
	this.nameHighlightStart = -1;
	this.nameHighlightEnd = -1;
	this.phoneHighlightStart = -1;
	this.phoneHighlightEnd = -1;
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

  public String getPhone() {
	return phone;
  }

  public void setPhone(String phone) {
	this.phone = phone;
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
	ContactVO temp = new ContactVO(_id, name, phone);
	temp.setNameHighlightEnd(nameHighlightEnd);
	temp.setNameHighlightStart(nameHighlightStart);
	temp.setPhoneHighlightEnd(phoneHighlightEnd);
	temp.setPhoneHighlightStart(phoneHighlightStart);
	return temp;
  }
}
