/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transpayv1.data.response.errors;

import transpayv1.data.response.AbstractResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Work
 */
public class GeneralError extends AbstractResponse {
    private String ErrorCode;
    private String Message;
    private List<TransPayError> BusinessErrors = new ArrayList<>();
    private List<TransPayError> DataValidationErrors = new ArrayList<>();

    /**
     * @return the BusinessErrors
     */
    public List<TransPayError> getBusinessErrors() {
        return BusinessErrors;
    }

    /**
     * @param BusinessErrors the BusinessErrors to set
     */
    public void setBusinessErrors(List<TransPayError> BusinessErrors) {
        this.BusinessErrors = BusinessErrors;
    }

    /**
     * @return the DataValidationErrors
     */
    public List<TransPayError> getDataValidationErrors() {
        return DataValidationErrors;
    }

    /**
     * @param DataValidationErrors the DataValidationErrors to set
     */
    public void setDataValidationErrors(List<TransPayError> DataValidationErrors) {
        this.DataValidationErrors = DataValidationErrors;
    }

    /**
     * @return the ErrorCode
     */
    public String getErrorCode() {
        return ErrorCode;
    }

    /**
     * @param ErrorCode the ErrorCode to set
     */
    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    /**
     * @return the Message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * @param Message the Message to set
     */
    public void setMessage(String Message) {
        this.Message = Message;
    }
}
