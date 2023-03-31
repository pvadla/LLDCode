package com.scaler.bmsfair.models;


import com.scaler.bmsfair.models.enums.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User extends BaseModel{
    private String name;
    private String password;
    private List<Role> roles;

}
