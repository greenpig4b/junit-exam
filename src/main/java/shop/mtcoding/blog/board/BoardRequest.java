package shop.mtcoding.blog.board;

import lombok.Data;

public class BoardRequest {
    @Data
    public static class WriteDTO{
        private String title;
        private String content;
        private String author;

    }

    //DTO 나눈이유 : 수정하는일이 생기게되면 다시 다바꿔야한다.(나중을 위해서)
    @Data
    public static class UpdateDTO{
        private String title;
        private String content;
        private String author;

    }
}
