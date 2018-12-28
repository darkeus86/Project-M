package ApiProjectM;

import java.io.Serializable;

public class CourierInfoOperator implements Serializable {
    private int operatorId;
    private String operatorFirstName;
    private String operatorSecondName;
    private String operatorPhone;


    public int getOperatorId() {return operatorId;}

    public void setOperatorId(int operatorId) {this.operatorId = operatorId;}

    public String getOperatorFirstName() {return operatorFirstName;}

    public void setOperatorFirstName(String operatorFirstName) {this.operatorFirstName = operatorFirstName;}

    public String getOperatorSecondName() {return operatorSecondName;}

    public void setOperatorSecondName(String operatorSecondName) {this.operatorSecondName = operatorSecondName;}

    public String getOperatorPhone() {return operatorPhone;}

    public void setOperatorPhone(String operatorPhone) {this.operatorPhone = operatorPhone;}

}
