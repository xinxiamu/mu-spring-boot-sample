/*
 * This file is generated by jOOQ.
*/
package com.example.demo.jooq.tables;


import com.example.demo.jooq.Keys;
import com.example.demo.jooq.Testdb;
import com.example.demo.jooq.tables.records.TeacherStudentsRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;


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
public class TeacherStudents extends TableImpl<TeacherStudentsRecord> {

    private static final long serialVersionUID = 207098618;

    /**
     * The reference instance of <code>testdb.teacher_students</code>
     */
    public static final TeacherStudents TEACHER_STUDENTS = new TeacherStudents();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<TeacherStudentsRecord> getRecordType() {
        return TeacherStudentsRecord.class;
    }

    /**
     * The column <code>testdb.teacher_students.teachers_id</code>.
     */
    public final TableField<TeacherStudentsRecord, Long> TEACHERS_ID = createField("teachers_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>testdb.teacher_students.students_id</code>.
     */
    public final TableField<TeacherStudentsRecord, Long> STUDENTS_ID = createField("students_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>testdb.teacher_students</code> table reference
     */
    public TeacherStudents() {
        this("teacher_students", null);
    }

    /**
     * Create an aliased <code>testdb.teacher_students</code> table reference
     */
    public TeacherStudents(String alias) {
        this(alias, TEACHER_STUDENTS);
    }

    private TeacherStudents(String alias, Table<TeacherStudentsRecord> aliased) {
        this(alias, aliased, null);
    }

    private TeacherStudents(String alias, Table<TeacherStudentsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Testdb.TESTDB;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<TeacherStudentsRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<TeacherStudentsRecord, ?>>asList(Keys.FKKR9RJNME1KLPD0O8SNOCE0124, Keys.FKHSTOJ4YEP9M2VR6WH8CVQ1UPF);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TeacherStudents as(String alias) {
        return new TeacherStudents(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TeacherStudents rename(String name) {
        return new TeacherStudents(name, null);
    }
}