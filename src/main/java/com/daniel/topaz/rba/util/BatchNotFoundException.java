package com.daniel.topaz.rba.util;

public class BatchNotFoundException extends RuntimeException {

    private final String batchId;

    public BatchNotFoundException(String batchId) {
        super("Batch not found, batchId=" + batchId);
        this.batchId = batchId;
    }

    public String getBatchId(){
        return batchId;
    }
}
