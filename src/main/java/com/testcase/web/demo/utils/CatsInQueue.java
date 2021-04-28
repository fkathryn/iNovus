package com.testcase.web.demo.utils;

import com.testcase.web.demo.entity.Cats;
import com.testcase.web.demo.repository.CatsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedList;
import java.util.Queue;

@Component
@Data
public class CatsInQueue {
    private CatsRepository catsRepository;
    private Queue<Cats> queue;

    @Autowired
    public CatsInQueue(CatsRepository catsRepository) {
        this.catsRepository = catsRepository;
        this.queue = new LinkedList<>();
        catsInQueue();
    }

    private void catsInQueue() {
        Iterable<Cats> allCats = catsRepository.findCatsByRand();
        queue = new LinkedList<>();
        for (Cats cat : allCats) {
            queue.add(cat);
        }
        if (queue.size() % 2 != 1) {
            queue.poll();
        }
    }
}
