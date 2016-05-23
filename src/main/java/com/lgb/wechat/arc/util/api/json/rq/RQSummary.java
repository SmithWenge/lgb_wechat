package com.lgb.wechat.arc.util.api.json.rq;

public class RQSummary {
    private String reason;
    private String errorCode;
    private RQResult result;

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setResult(RQResult result) {
        this.result = result;
    }

    public String getReason() {

        return reason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public RQResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return getResult().toString();
    }
}
