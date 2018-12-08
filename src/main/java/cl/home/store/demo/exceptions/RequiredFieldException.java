package cl.home.store.demo.exceptions;

public class RequiredFieldException extends Exception {
    private static final String MESSAGE = "Field is required ";
    private String fieldName;

    public RequiredFieldException(String fieldName) {
        super(MESSAGE + fieldName);
        this.setFieldName(fieldName);
    }


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}
