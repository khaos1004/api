package com.isys.api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "user_info")
public class UserInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @ManyToOne
    @JoinColumn(name = "USERGROUP_FK", columnDefinition = "DECIMAL")
    private UserGroupEntity userGroupEntity;

    @Column(name = "OFFICENUM", columnDefinition = "DECIMAL")
    private int officeNum;

    @Column(name = "PASSWORD")
    private String passWord;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CENTEROFFICE_MRFK", columnDefinition = "DECIMAL")
    private int genterOfficeMrFx;

    @Column(name = "WORKCLASSTYPE_FK", columnDefinition = "DECIMAL")
    private int workClassTypeFk;
}
