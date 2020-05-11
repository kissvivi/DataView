package top.kissvs.dataview.entities;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInfo  implements Serializable {

    private long id;
    private String userName ;
    private String passWord ;
    private String userPhone ;
    private String userAddr ;
    private String userEmail ;
    private int isDelete;
    private String createDate;

    private int userSe;//用户权限


}
