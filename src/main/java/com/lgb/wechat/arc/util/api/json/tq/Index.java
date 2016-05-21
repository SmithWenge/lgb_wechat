package com.lgb.wechat.arc.util.api.json.tq;

public class Index {
    private String title;
    private String zs;
    private String tipt;
    private String des;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setZs(String zs) {
        this.zs = zs;
    }

    public void setTipt(String tipt) {
        this.tipt = tipt;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getTitle() {

        return title;
    }

    public String getZs() {
        return zs;
    }

    public String getTipt() {
        return tipt;
    }

    public String getDes() {
        return des;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append(getTitle() + " : " + getZs()).append(".\n")
                .append(getTipt() + " : " + getDes()).append(".\n");

        return builder.toString();
    }
}
