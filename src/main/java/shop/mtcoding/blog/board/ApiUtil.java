package shop.mtcoding.blog.board;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiUtil<T> {
    private Integer status; // 200 400 404 405
    private String msg; // 성공, 실패시 -> 정확한 메세지
    private T body;

    public ApiUtil(T body) {
        this.status = 200;
        this.msg ="성공";
        this.body = body;
    }

    public ApiUtil(Integer status, String msg) {
        this.status = status;
        this.msg ="실패";
        this.body = null;
    }

}
