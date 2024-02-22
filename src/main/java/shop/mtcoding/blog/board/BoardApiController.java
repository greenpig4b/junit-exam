package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//데이터 보내는 컨트롤러
@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardRepository boardRepository;

    @DeleteMapping("/api/boards/{id}")
    public ApiUtil<List<?>> deleteId(@PathVariable Integer id ,HttpServletResponse response){
        //제약조건
        Board board = boardRepository.selectOne(id);
        if (board == null){
            response.setStatus(404);
            return new ApiUtil<>(404,"내용없습니다");
        }


        boardRepository.deleteById(id);
        return new ApiUtil<>(null);
    }

    @GetMapping("/api/boards")
    public ApiUtil<List<?>> findAll(){
        //상태코드와 메세지를 보내주는게 좋다
        List<Board> boardList = boardRepository.selectAll();
        //response.setStatus(400);
        return new ApiUtil<>(boardList); // MessagetConverter
    }

}
