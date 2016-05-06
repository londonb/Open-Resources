package com.example.guest.openresources.Models;

import com.google.android.gms.maps.model.LatLng;

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
    double lat;
    double lng;

    public Location() {}

    public Location (String namePlace,String comment, double lat, double lng) {
        this.namePlace = namePlace;
        this.comment = comment;
        this.lat = lat;
        this.lng = lng;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public double getLat() {
        return lat;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {this.comment = comment;}

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

}
