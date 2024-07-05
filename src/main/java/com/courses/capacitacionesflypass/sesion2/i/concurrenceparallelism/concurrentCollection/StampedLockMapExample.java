package com.courses.capacitacionesflypass.sesion2.i.concurrenceparallelism.concurrentCollection;

import java.util.concurrent.locks.StampedLock;
import java.util.HashMap;
import java.util.Map;

public class StampedLockMapExample {
    private final Map<String, Integer> map = new HashMap<>();
    private final StampedLock lock = new StampedLock();

    public void put(String key, Integer value) {
        long stamp = lock.writeLock();
        try {
            map.put(key, value);
        } finally {
            lock.unlockWrite(stamp);
        }
    }

    public Integer get(String key) {
        long stamp = lock.tryOptimisticRead();
        Integer value = map.get(key);
        if (!lock.validate(stamp)) {
            stamp = lock.readLock();
            try {
                value = map.get(key);
            } finally {
                lock.unlockRead(stamp);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        StampedLockMapExample example = new StampedLockMapExample();
        example.put("key1", 1);
        System.out.println("Value for key1: " + example.get("key1"));
    }
}
