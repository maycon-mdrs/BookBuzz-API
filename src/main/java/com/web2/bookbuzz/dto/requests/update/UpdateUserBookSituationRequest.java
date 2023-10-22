package com.web2.bookbuzz.dto.requests.update;

public class UpdateUserBookSituationRequest {

    int status_id;

    public UpdateUserBookSituationRequest() {
    }

    public UpdateUserBookSituationRequest(int status_id) {
        this.status_id = status_id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }



}
