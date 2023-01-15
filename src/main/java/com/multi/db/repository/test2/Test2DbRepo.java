package com.multi.db.repository.test2;

import com.multi.db.model.TestMultDbsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Test2DbRepo extends JpaRepository<TestMultDbsModel, Long> {
}
