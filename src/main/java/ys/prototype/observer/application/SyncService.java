package ys.prototype.observer.application;

import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@Service
public class SyncService {

    private final static Integer ONE_ELEMENT = 1;
    private final SyncObserver syncObserver;

    public SyncService(SyncObserver syncObserver) {
        this.syncObserver = syncObserver;
    }

    public String getResponse() throws InterruptedException {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(ONE_ELEMENT);
        try {
            syncObserver.addQueue(queue);
            return queue.take();

        } finally {
            syncObserver.removeQueue(queue);
        }
    }

    public void update() throws InterruptedException {
        syncObserver.update();
    }
}
