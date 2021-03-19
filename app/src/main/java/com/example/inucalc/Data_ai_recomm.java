package com.example.inucalc;

public class Data_ai_recomm {
    private int btn_detail;
    private String tv1;
    private String tv2;
    private String tv3;
    private String tv4;
    private String tv5;
    private boolean expendable;
    private int header;

    public Data_ai_recomm(int btn_detail, String tv1, String tv2, String tv3, String tv4, String tv5) {
        this.btn_detail = btn_detail;
        this.tv1 = tv1;
        this.tv2 = tv2;
        this.tv3 = tv3;
        this.tv4 = tv4;
        this.tv5 = tv5;
        this.expendable = false;
        this.header = header;
    }

    public boolean isExpendable() {
        return expendable;
    }

    public void setExpendable(boolean expendable) {
        this.expendable = expendable;
    }

    public int getBtn_detail() {
        return btn_detail;
    }

    public void setBtn_detail(int btn_detail) {
        this.btn_detail = btn_detail;
    }

    public String getTv1() {
        return tv1;
    }

    public void setTv1(String tv1) {
        this.tv1 = tv1;
    }

    public String getTv2() {
        return tv2;
    }

    public void setTv2(String tv2) {
        this.tv2 = tv2;
    }

    public String getTv3() {
        return tv3;
    }

    public void setTv3(String tv3) {
        this.tv3 = tv3;
    }

    public String getTv4() {
        return tv4;
    }

    public void setTv4(String tv4) {
        this.tv4 = tv4;
    }

    public String getTv5() {
        return tv5;
    }

    public void setTv5(String tv5) {
        this.tv5 = tv5;
    }

    @Override
    public String toString() {
        return "Data_ai_recomm{" +
                "btn_detail=" + btn_detail +
                ", tv1='" + tv1 + '\'' +
                ", tv2='" + tv2 + '\'' +
                ", tv3='" + tv3 + '\'' +
                ", tv4='" + tv4 + '\'' +
                ", tv5='" + tv5 + '\'' +
                ", expendable=" + expendable +
                '}';
    }
}
