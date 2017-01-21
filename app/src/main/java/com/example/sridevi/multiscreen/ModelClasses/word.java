package com.example.sridevi.multiscreen.ModelClasses;

/**
 * Created by Sridevi on 12/17/2016.
 */
public class word {

     private String mcaptialletters;
     private String msmallletters;
     private int mimageresource = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public word(String captialletters, String smallletters,int imageresource){
        mcaptialletters = captialletters;
        msmallletters = smallletters;
        mimageresource = imageresource;
    }
    public word(String captialletters, String smallletters){
        mcaptialletters = captialletters;
        msmallletters = smallletters;


    }
    public String getMcaptialletters(){
        return mcaptialletters;
    }

    public String getMsmallletters(){
        return msmallletters;
    }
    public int getMimageresource(){
        return mimageresource;
    }
//    public int getMaudioresourceid(){
//        return maudioresourceid;
//    }

    public boolean hasImage(){
         return mimageresource != NO_IMAGE_PROVIDED;
    }

}

