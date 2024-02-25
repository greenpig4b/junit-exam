package shop.mtcoding.blog.board;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//데이터 보내는 컨트롤러
@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardRepository boardRepository;

    //삭제
    @DeleteMapping("/api/boards/{id}")
    public ApiUtil<List<?>> deleteId(@PathVariable Integer id ,HttpServletResponse response){
        //제약조건
        Board board = boardRepository.selectOne(id);
        if (board == null){
            response.setStatus(404);
            return new ApiUtil<>(404,"내용없습니다.");
        }

        boardRepository.deleteById(id);
        return new ApiUtil<>(null);
    }

    //메인보드에 보드리스트 뿌리기
    @GetMapping("/api/boards")
    public ApiUtil<List<?>> findAll(){
        //상태코드와 메세지를 보내주는게 좋다
        List<Board> boardList = boardRepository.selectAll();
        //response.setStatus(400);
        return new ApiUtil<>(boardList); // MessagetConverter
    }

    //글쓰기
    @PostMapping("/api/boards")
    public ApiUtil<List<?>> write(@RequestBody BoardRequest.WriteDTO requestDTO){

        //유효성로직

        //필수로직
        boardRepository.insert(requestDTO);

        return new ApiUtil<>(null);
    }

    //업데이트
    @PutMapping("/api/boards/[id}")
    public  ApiUtil<List<?>> update(@PathVariable Integer id, @RequestBody BoardRequest.UpdateDTO requestDTO){
        boardRepository.upDateById(requestDTO, id);
        return  new ApiUtil<>(null);
    }
}
