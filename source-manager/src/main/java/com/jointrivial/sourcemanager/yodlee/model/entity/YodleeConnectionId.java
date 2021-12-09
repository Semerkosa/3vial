package com.jointrivial.sourcemanager.yodlee.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "yodlee_connection_ids")
public class YodleeConnectionId {

    // loginName will be a unique string which is constructed by our app.
    // Yodlee identifies the different users by their login names.
    private String loginName;

    // The id of the application customer which was created during registration
    private String userId;

    public YodleeConnectionId() {
    }

    @Id
    @Column(name = "login_name", unique = true, nullable = false)
    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Column(name = "user_id", unique = true, nullable = false)
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
