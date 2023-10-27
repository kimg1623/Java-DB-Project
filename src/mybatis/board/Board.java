package mybatis.board;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.management.ConstructorParameters;
import java.util.Date;

@Data
@Getter
@Setter
public class Board {
    private int bno;
    private String btitle;
    private String bcontent;
    private String bwriter;
    private Date bdate;

    public Board(int bno){
        super();
        this.bno = bno;
    }

    public Board(String btitle, String bcontent, String bwriter){
        super();
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
    public Board(int bno, String btitle, String bcontent, String bwriter){
        super();
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
    }
    public Board(int bno, String btitle, String bcontent, String bwriter, Date bdate){
        super();
        this.bno = bno;
        this.btitle = btitle;
        this.bcontent = bcontent;
        this.bwriter = bwriter;
        this.bdate = bdate;
    }
}