package com.example.projectMGMT.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RequestModel {

    private String userId;

    private Object userType;

    private Integer idVariable;

    private String extraVariable;

    private Object reqObject;

    private List<?> reqList;

    private String[] reqArray;
    
   
   
public String getUserId() {
	return userId;
}

public void setUserId(String userId) {
	this.userId = userId;
}

public Object getUserType() {
	return userType;
}

public void setUserType(Object userType) {
	this.userType = userType;
}

public Integer getIdVariable() {
	return idVariable;
}

public void setIdVariable(Integer idVariable) {
	this.idVariable = idVariable;
}

public String getExtraVariable() {
	return extraVariable;
}

public void setExtraVariable(String extraVariable) {
	this.extraVariable = extraVariable;
}

public Object getReqObject() {
	return reqObject;
}

public void setReqObject(Object reqObject) {
	this.reqObject = reqObject;
}

public List<?> getReqList() {
	return reqList;
}

public void setReqList(List<?> reqList) {
	this.reqList = reqList;
}

public String[] getReqArray() {
	return reqArray;
}

public void setReqArray(String[] reqArray) {
	this.reqArray = reqArray;
}


}
