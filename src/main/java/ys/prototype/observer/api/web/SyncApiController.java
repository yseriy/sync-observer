package ys.prototype.observer.api.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ys.prototype.observer.application.SyncService;

@RestController
public class SyncApiController {

    private final SyncService syncService;

    public SyncApiController(SyncService syncService) {
        this.syncService = syncService;
    }

    @GetMapping(value = "/out")
    public String getResponse() throws InterruptedException {
        return syncService.getResponse();
    }
}
