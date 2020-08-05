package com.example.moringaplantation3;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class GetterSetter {

    @Expose    private String Longitude;
    @SerializedName(" plantno")
    @Expose    private String  plantno;
    @SerializedName("dtvisit")
    @Expose    private String dtvisit;
    @SerializedName("chwname")
    @Expose    private String chwname;
    @SerializedName("teamleadnme")
    @Expose    private String teamleadnme;
    @SerializedName("VillageMohalla")
    @Expose    private String VillageMohalla;
    @SerializedName("uc")
    @Expose    private String uc;
    @SerializedName("sizeplant")
    @Expose    private String sizeplant;
    @SerializedName("locplant")
    @Expose    private String locplant;
    @SerializedName("other")
    @Expose    private String other;
    @SerializedName("qtyplan")
    @Expose    private String qtyplan;
    public void Setplantno(String plantno){ this.plantno= plantno; }
    public String Getplantno(){ return plantno; }

    public void Setdtvisit(String dtvisit){ this.dtvisit= dtvisit; }
    public String Getdtvisit(){ return dtvisit; }

    public void Setchwname(String chwname){ this.chwname= chwname; }
    public String Getchwname(){ return chwname; }

    public void Setteamleadnme(String  teamleadnme){ this.teamleadnme=  teamleadnme; }
    public String Getteamleadnme(){ return  teamleadnme; }

    public void SetVillageMohalla(String  VillageMohalla){ this.VillageMohalla=  VillageMohalla; }
    public String GetVillageMohalla(){ return  VillageMohalla; }

    public void Setuc(String  uc){ this.uc=  uc; }
    public String Getuc(){ return  uc; }

    public void Setsizeplant(String  sizeplant){ this.sizeplant=  sizeplant; }
    public String Getsizeplant(){ return  sizeplant; }

    public void Setlocplant(String  locplant){ this.locplant=  locplant; }
    public String Getlocplant(){ return  locplant; }

    public void Setother(String other){this.other = other;}
    public String Getother(String string){return other;}
    public void Setqtyplan(String  qtyplan){ this.qtyplan=  qtyplan; }
    public String Getqtyplan(){ return  qtyplan; }




}
