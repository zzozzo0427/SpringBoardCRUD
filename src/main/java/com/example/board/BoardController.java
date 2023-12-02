package com.example.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Autowired
    BoardServiceImpl boardService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model) {
        model.addAttribute("list", boardService.getBoardList());
        return "list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost() {
        return "addpostform";
    }

    @RequestMapping(value= "/addok", method=RequestMethod.POST)
    public String addPostOk(BoardVO vo) {
        if(boardService.insertBoard(vo) == 0)
            System.out.println("데이터 추가 실패");
        else
            System.out.println("데이터 추가 성공");
        return "redirect:/list";
    }


    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "view";
    }

    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("u", boardVO);
        return "editform";
    }
    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo) {
        if(boardService.updateBoard(vo) == 0)
            System.out.println("데이터 수정 실패");
        else
            System.out.println("데이터 수정 성공!!!");
        return "redirect:list";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePost(@PathVariable("id") int id) {
        if(boardService.deleteBoard(id)== 0)
            System.out.println("데이터 삭제 실패 ");
        else
            System.out.println("데이터 삭제 성공!!!");
        return "redirect:../list";
    }
}
