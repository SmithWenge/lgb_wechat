package com.lgb.wechat.arc.util.api.json.tq;

import java.util.Date;
import java.util.List;

public class TQSummary {
    private int error;
    private String status;
    private String date;
    private List<Results> results;

    public void setError(int error) {
        this.error = error;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public int getError() {

        return error;
    }

    public String getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public List<Results> getResults() {
        return results;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder()
//                .append("错误数: ").append(getError()).append(".\n")
//                .append("状态: ").append(getStatus()).append(".\n")
                .append("日期: ").append(getDate()).append(".\n");

        for (Results result : getResults()) {
            builder.append(result.toString());
        }

        return builder.toString();
    }
}
