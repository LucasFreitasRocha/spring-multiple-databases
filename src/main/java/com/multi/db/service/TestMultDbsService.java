package com.multi.db.service;

import com.multi.db.model.TestMultDbsModel;
import com.multi.db.repository.test1.Test1DbRepo;
import com.multi.db.repository.test2.Test2DbRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestMultDbsService {


   @Autowired
    private Test1DbRepo test1Repo;

    @Autowired
    private Test2DbRepo test2Repo;



    public List<TestMultDbsModel> test(String test) {
        return (test.equalsIgnoreCase("1"))? test1Repo.findAll() : test2Repo.findAll();
    }
}
