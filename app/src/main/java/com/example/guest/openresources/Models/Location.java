package com.example.guest.openresources.Models;

import org.parceler.Parcel;
import org.w3c.dom.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 5/6/16.
 */
@Parcel
public class Location {
    String namePlace;
    String comment;
    String latLong;

    public Location() {}

    public Location (String namePlace,String comment, String latLong) {
        this.namePlace = namePlace;
        this.latLong = latLong;
        this.comment = comment;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public String getLatLong() {
        return latLong;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public void setLatLong(String latLong) {
        this.latLong = latLong;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {this.comment = comment;}

}
