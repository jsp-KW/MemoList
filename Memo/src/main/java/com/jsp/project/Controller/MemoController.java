package com.jsp.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.jsp.project.Entity.Memo;
import com.jsp.project.Service.MemoService;

@Controller
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    @Autowired
    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @GetMapping
    public String getAllMemos(Model model) {
        model.addAttribute("memos", memoService.getAllMemos());
        return "memoList";
    }

    @GetMapping("/view/{id}")
    public String viewMemoById(@PathVariable Long id, Model model) {
        Memo memo = memoService.getMemoById(id);
        model.addAttribute("memo", memo);
        return "viewMemoDetail";
    }

    @GetMapping("/new")
    public String createMemoForm(Model model) {
        model.addAttribute("memo", new Memo());
        return "createMemoForm";
    }

    @PostMapping
    public String createMemo(@ModelAttribute("memo") Memo memo) {
        memoService.createMemo(memo);
        return "redirect:/memos";
    }

    @GetMapping("/edit/{id}")
    public String updateMemoForm(@PathVariable Long id, Model model) {
        Memo memo = memoService.getMemoById(id);
        model.addAttribute("memo", memo);
        return "updateMemoForm";
    }

    @PostMapping("/update/{id}")
    public String updateMemo(@PathVariable Long id, @ModelAttribute Memo memoDetails) {
    	memoService.updateMemo(id, memoDetails);
        return "redirect:/memos/view/" + id;
    }


    @PostMapping("/delete/{id}")
    public String deleteMemo(@PathVariable Long id) {
        memoService.deleteMemo(id);
        return "redirect:/memos";
    }
}
