package com.example.projectMGMT.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResponseModel {

    private Integer statusCode;
    
    private String message;

    private Integer idVariable;
    
    private String extraVariable;
    
    private Object respObject;
    
    private List<?> respList;
    
    private String[] respArray;

    public ResponseModel(String message, Integer statusCode) {
        this.statusCode = statusCode;
        this.message = message;
    }
public ResponseModel() {
	
}
    public ResponseModel(Integer statusCode, String message, Object respObject) {
        this.statusCode = statusCode;
        this.message = message;
        this.respObject = respObject;
    }
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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
	public Object getRespObject() {
		return respObject;
	}
	public void setRespObject(Object respObject) {
		this.respObject = respObject;
	}
	public List<?> getRespList() {
		return respList;
	}
	public void setRespList(List<?> respList) {
		this.respList = respList;
	}
	public String[] getRespArray() {
		return respArray;
	}
	public void setRespArray(String[] respArray) {
		this.respArray = respArray;
	}

}
