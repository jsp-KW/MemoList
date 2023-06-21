package com.jsp.project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.project.Entity.Memo;
import com.jsp.project.Repository.MemoRepository;

@Service
public class MemoService {
	
	 private final MemoRepository memoRepository;

	    @Autowired
	    public MemoService(MemoRepository memoRepository) {
	        this.memoRepository = memoRepository;
	    }

	    public List<Memo> getAllMemos() {
	        return memoRepository.findAll();
	    }

	    public Memo getMemoById(Long id) {
	        Optional<Memo> memoOptional = memoRepository.findById(id);
	        return memoOptional.orElseThrow(() -> new IllegalArgumentException("불러올 메모" + id +"번째가 존재하지 않습니다."));
	    }

	    public Memo createMemo(Memo memo) {
	        return memoRepository.save(memo);
	    }

	    public Memo updateMemo(Long id, Memo memoDetails) {
	        Optional<Memo> memoOptional = memoRepository.findById(id);
	        if (memoOptional.isEmpty()) {
	            throw new IllegalArgumentException("업데이트 하려는" + id +"번째 메모가 존재하지 않습니다.");
	        }

	        Memo memo = memoOptional.get();
	        memo.setTitle(memoDetails.getTitle());
	        memo.setContent(memoDetails.getContent());

	        return memoRepository.save(memo);
	    }

	    public void deleteMemo(Long id) {
	        Optional<Memo> memoOptional = memoRepository.findById(id);
	        if (memoOptional.isEmpty()) {
	            throw new IllegalArgumentException("메모장 " + id + "번째가 존재하지 않습니다.");
	        }

	        Memo memo = memoOptional.get();
	        memoRepository.delete(memo);
	       
	    }

}
