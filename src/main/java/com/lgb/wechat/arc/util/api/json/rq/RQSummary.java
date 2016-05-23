package com.lgb.wechat.arc.util.api.json.rq;

public class RQSummary {
    private String reason;
    private String error_code;
    private RQResult result;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setResult(RQResult result) {
        this.result = result;
    }

    public String getReason() {

        return reason;
    }

    public RQResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return getResult().toString();
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_code() {

        return error_code;
    }
}
