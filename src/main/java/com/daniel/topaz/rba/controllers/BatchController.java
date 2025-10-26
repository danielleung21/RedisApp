package com.daniel.topaz.rba.controllers;

import com.daniel.topaz.rba.util.BatchNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/run-batch")
public class BatchController {

    @PostMapping("/{batchId}")
    public String runBatch(@PathVariable String batchId) {
        if (!batchId.equals("HSIOPT")) {
            throw new BatchNotFoundException(batchId);
        }




        return "Succeed";
    }
}
