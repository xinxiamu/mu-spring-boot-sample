/*
 * This file is generated by jOOQ.
*/
package com.example.demo.jooq.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.2"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TeacherClasszs implements Serializable {

    private static final long serialVersionUID = 843462256;

    private Long teachersId;
    private Long classzsId;

    public TeacherClasszs() {}

    public TeacherClasszs(TeacherClasszs value) {
        this.teachersId = value.teachersId;
        this.classzsId = value.classzsId;
    }

    public TeacherClasszs(
        Long teachersId,
        Long classzsId
    ) {
        this.teachersId = teachersId;
        this.classzsId = classzsId;
    }

    public Long getTeachersId() {
        return this.teachersId;
    }

    public void setTeachersId(Long teachersId) {
        this.teachersId = teachersId;
    }

    public Long getClasszsId() {
        return this.classzsId;
    }

    public void setClasszsId(Long classzsId) {
        this.classzsId = classzsId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("TeacherClasszs (");

        sb.append(teachersId);
        sb.append(", ").append(classzsId);

        sb.append(")");
        return sb.toString();
    }
}