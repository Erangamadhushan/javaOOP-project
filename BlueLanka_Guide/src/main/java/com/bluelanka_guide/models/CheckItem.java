package com.bluelanka_guide.models;

import java.util.Date;

public class CheckItem {
    private boolean isChecked;
    private String note;
    private Date date;

    public CheckItem(boolean isChecked, String note, Date date) {
        this.isChecked = isChecked;
        this.note = note;
        this.date = date;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public String getNote() {
        return note;
    }

    public Date getDate() {
        return date;
    }
}
