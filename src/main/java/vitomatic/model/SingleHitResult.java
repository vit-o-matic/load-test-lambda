package vitomatic.model;

/**
 * @author Hussachai Puripunpinyo
 */
public class SingleHitResult {

    /*
    {
        "clientId": "ID",
        "targetUrl": "URL",
        "statusCode": 200,
        "success": true,
        "totalTime": 123,
        "message": "OK"
    }
     */
    private String clientId;

    private String targetUrl;

    private int statusCode;

    private boolean success;

    private long totalTime;

    private String message;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
