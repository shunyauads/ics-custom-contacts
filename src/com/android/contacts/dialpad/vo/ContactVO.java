package com.android.contacts.dialpad.vo;

public class ContactVO implements Comparable<ContactVO> {
  
  private String _id;
  private String name;
  private String number;
  
  public ContactVO(String _id, String name, String number) {
	super();
	this._id = _id;
	this.name = name;
	this.number = number;
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
  public String getNumber() {
    return number;
  }
  public void setNumber(String number) {
    this.number = number;
  }

  @Override
  public int compareTo(ContactVO another) {
	return name.compareTo(another.getName());
  }

  
}
