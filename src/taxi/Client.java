package taxi;

public class Client {
    private String message;
    private String phone;
    private int target;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean phone_check(){
        if (phone.isEmpty())
            return false;
        return true;
    }
}
