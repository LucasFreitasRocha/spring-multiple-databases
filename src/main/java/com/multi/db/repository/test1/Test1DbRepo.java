package com.multi.db.repository.test1;

import com.multi.db.model.TestMultDbsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Test1DbRepo extends JpaRepository<TestMultDbsModel, Long> {
}
