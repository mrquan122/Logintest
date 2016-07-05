package net;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class Response {
    private boolean error;
    private int errorType;
    private String errorMessage;
    private String result;

    public boolean hasError() {
        return error;
    }

    public void setError(boolean haserror) {
        this.error =haserror;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
