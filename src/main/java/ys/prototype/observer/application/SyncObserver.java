package ys.prototype.observer.application;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;

@Component
public class SyncObserver {

    private final List<BlockingQueue<String>> queueList = Collections.synchronizedList(new ArrayList<>());

    void addQueue(BlockingQueue<String> queue) {
        queueList.add(queue);
    }

    void removeQueue(BlockingQueue<String> queue) {
        queueList.remove(queue);
    }

    void update() throws InterruptedException {
        synchronized (queueList) {

            for (BlockingQueue<String> queue : queueList) {
                queue.put("test_message");
            }
        }
    }
}
