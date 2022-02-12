package com.enterprise.netmovies.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;

@Data
@Document(collection = "AUTH_AUTHORITY")
public class Authority implements GrantedAuthority {
    @Id
    private String id;

    @Field(name = "ROLE_CODE")
    private String roleCode;

    @Field(name = "ROLE_DESCRIPTION")
    private String roleDescription;

    public Authority(){}
    public Authority(String roleCode,String roleDescription){
        this.roleCode = roleCode;
        this.roleDescription = roleDescription;
    }
    @Override
    public String getAuthority() {
        return roleCode;
    }


    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
}
