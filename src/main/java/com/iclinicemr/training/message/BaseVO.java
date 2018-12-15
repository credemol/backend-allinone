package com.iclinicemr.training.message;

import java.util.UUID;

public class BaseVO extends AuditableVO {
    protected UUID id;
    protected int version;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
