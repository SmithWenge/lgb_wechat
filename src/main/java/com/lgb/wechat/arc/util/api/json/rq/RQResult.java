package com.lgb.wechat.arc.util.api.json.rq;

public class RQResult {
    private String id;
    private String yangli;
    private String yinli;
    private String wuxing;
    private String chongsha;
    private String baiji;
    private String jishen;
    private String yi;
    private String xiongshen;
    private String ji;

    public void setId(String id) {
        this.id = id;
    }

    public void setYangli(String yangli) {
        this.yangli = yangli;
    }

    public void setYinli(String yinli) {
        this.yinli = yinli;
    }

    public void setWuxing(String wuxing) {
        this.wuxing = wuxing;
    }

    public void setChongsha(String chongsha) {
        this.chongsha = chongsha;
    }

    public void setBaiji(String baiji) {
        this.baiji = baiji;
    }

    public void setJishen(String jishen) {
        this.jishen = jishen;
    }

    public void setYi(String yi) {
        this.yi = yi;
    }

    public void setXiongshen(String xiongshen) {
        this.xiongshen = xiongshen;
    }

    public void setJi(String ji) {
        this.ji = ji;
    }

    public String getId() {

        return id;
    }

    public String getYangli() {
        return yangli;
    }

    public String getYinli() {
        return yinli;
    }

    public String getWuxing() {
        return wuxing;
    }

    public String getChongsha() {
        return chongsha;
    }

    public String getBaiji() {
        return baiji;
    }

    public String getJishen() {
        return jishen;
    }

    public String getYi() {
        return yi;
    }

    public String getXiongshen() {
        return xiongshen;
    }

    public String getJi() {
        return ji;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
                .append("阳历 : ").append(getYangli()).append(".\n")
                .append("阴历 : ").append(getYinli()).append(".\n")
                .append("五行 : ").append(getWuxing()).append(".\n")
                .append("冲煞 : ").append(getChongsha()).append(".\n")
                .append("拜祭 : ").append(getBaiji()).append(".\n")
                .append("吉神 : ").append(getJishen()).append(".\n")
                .append("宜 : ").append(getYi()).append(".\n")
                .append("凶神 : ").append(getXiongshen()).append(".\n")
                .append("忌 : ").append(getJi()).append(".\n");

        return builder.toString();
    }
}
