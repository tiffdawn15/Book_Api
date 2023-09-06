package com.book.api.resources;


import com.book.api.models.Book;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OperationResult<T> {

    public boolean worked;
    public HttpStatus httpStatus;
    public boolean partiallySuccessful;
    public Object result;

    public boolean hasWorked() {
        return worked;
    }

    public void setWorked(boolean worked) {
        this.worked = worked;
    }

    public OperationResult worked(boolean worked) {
        this.worked = worked;
        return this;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public OperationResult httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public boolean getPartiallySuccessful() {
        return partiallySuccessful;
    }

    public void setPartiallySuccessful(boolean partiallySuccessful) {
        this.partiallySuccessful = partiallySuccessful;
    }

    public OperationResult partiallySuccessful(boolean partiallySuccessful) {
        this.partiallySuccessful = partiallySuccessful;
        return this;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public OperationResult result(Object result) {
        this.result = result;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OperationResult result1 = (OperationResult) o;
        return worked == result1.worked && httpStatus == result1.httpStatus && Objects.equals(partiallySuccessful, result1.partiallySuccessful) && Objects.equals(result, result1.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(worked, httpStatus, partiallySuccessful, result);
    }


}