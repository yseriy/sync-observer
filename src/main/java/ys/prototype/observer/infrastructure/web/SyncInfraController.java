package ys.prototype.observer.infrastructure.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ys.prototype.observer.application.SyncService;

@RestController
public class SyncInfraController {

    private final SyncService syncService;

    public SyncInfraController(SyncService syncService) {
        this.syncService = syncService;
    }

    @GetMapping(value = "/in")
    public void receiveRequest() throws InterruptedException {
        syncService.update();
    }
}
