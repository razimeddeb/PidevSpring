package tn.esprit.pidev.response;

public class LoginResponse {
    String message;
    String Status;
public LoginResponse(){

}
    public LoginResponse(String message, boolean status) {
        this.message = message;
        this.Status = status ? "Success" : "Failed";
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
