package com.example.dutyreminder.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelClassPrayer {


    @SerializedName("Rid")
    @Expose
    private String Rid;

    @SerializedName("date")
    @Expose
    private String date;

    public String getRid() {
        return Rid;
    }

    public void setRid(String rid) {
        Rid = rid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIftar() {
        return iftar;
    }

    public void setIftar(String iftar) {
        this.iftar = iftar;
    }

    public String getSehri() {
        return sehri;
    }

    public void setSehri(String sehri) {
        this.sehri = sehri;
    }

    @SerializedName("iftar")
    @Expose
    private String iftar;

    @SerializedName("sehri")
    @Expose
    private String sehri;


    @SerializedName("Etittle")
    @Expose
    private String Etittle;


    @SerializedName("Ebody")
    @Expose
    private String Ebody;

    public String getEtittle() {
        return Etittle;
    }

    public void setEtittle(String etittle) {
        Etittle = etittle;
    }

    public String getEbody() {
        return Ebody;
    }

    public void setEbody(String ebody) {
        Ebody = ebody;
    }

    @SerializedName("Ftitle")
    @Expose
    private String Ftitle;

    public String getFtitle() {
        return Ftitle;
    }

    public void setFtitle(String ftitle) {
        Ftitle = ftitle;
    }

    public String getFbody() {
        return Fbody;
    }

    public void setFbody(String fbody) {
        Fbody = fbody;
    }

    @SerializedName("Fbody")   /*1*/
    @Expose
    private String Fbody;


    @SerializedName("dua")   /*1*/
    @Expose
    private String dua;

    public String getDua() {
        return dua;
    }

    public void setDua(String dua) {
        this.dua = dua;
    }

    @SerializedName("id")   /*1*/
    @Expose
    private String id;

    @SerializedName("area")   /*1*/
    @Expose
    private String area;


    @SerializedName("fajr")   /*1*/
    @Expose
    private String fajr;


    @SerializedName("zuhor")   /*1*/
    @Expose
    private String zuhor;

    @SerializedName("asor")   /*1*/
    @Expose
    private String asor;

    @SerializedName("magriv")   /*1*/
    @Expose
    private String magriv;

    @SerializedName("esha")   /*1*/
    @Expose
    private String esha;


    @SerializedName("response")   /*1*/
    @Expose
    private String response;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFajr() {
        return fajr;
    }

    public void setFajr(String fajr) {
        this.fajr = fajr;
    }

    public String getZuhor() {
        return zuhor;
    }

    public void setZuhor(String zuhor) {
        this.zuhor = zuhor;
    }

    public String getAsor() {
        return asor;
    }

    public void setAsor(String asor) {
        this.asor = asor;
    }

    public String getMagriv() {
        return magriv;
    }

    public void setMagriv(String magriv) {
        this.magriv = magriv;
    }

    public String getEsha() {
        return esha;
    }

    public void setEsha(String esha) {
        this.esha = esha;
    }


    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}