package com.example.servingwebcontent;
public class Book{
    public String masach;
    public String tensach;
    public String tacgia;
    public boolean trangthaiMuon;
    
    public Book(String masach,String tensach, String tacgia){
        this.masach = masach;
        this.tensach = tensach;
        this.tacgia = tacgia;
        this.trangthaiMuon = false;
    }
    public String getMasach(){ return masach;}
    public void setMasach(String id){ this.masach = id; }

    public String getTensach(){ return tensach;}
    public void setTensach(String name){ this.tensach = name;}

    public String getTacgia(){ return tacgia;}
    public void setTacgia(String author){ this.tacgia = author;}

    public boolean trangthaiMuon(){ return trangthaiMuon;}
    public void muonsach(){
        trangthaiMuon = true;
    }
    public void trasach(){
        trangthaiMuon = false;
    }
    public void displayInfo(){
        String trangthai;
        if(trangthaiMuon) 
             trangthai = "'Da duoc muon'";
        else 
             trangthai = "'co san'";
        System.out.println("[" +masach+ "]" +tensach+ "-" + trangthai);
    }
}