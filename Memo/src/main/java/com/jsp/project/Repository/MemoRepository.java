package com.jsp.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jsp.project.Entity.Memo;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long>{

}
