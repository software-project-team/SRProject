package com.yunuscagliyan.socialreader.groups;

public class MesajModel {
    private String text;

    public  MesajModel(){

    }
    public MesajModel( String text) {
     //   this.from = from;
        this.text = text;
    }



    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "MesajModel{" +
              //  "from='" + from + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

