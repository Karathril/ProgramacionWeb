package io.bmorenoc.democrud.endpoint;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DeleteUserResponse {
    private int deletedUserId;

    public void setDeletedUserId(int deletedUserId) {
        this.deletedUserId = deletedUserId;
    }
}

