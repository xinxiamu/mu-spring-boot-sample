/*
 * This file is generated by jOOQ.
*/
package com.example.demo.jooq.tables;


import com.example.demo.jooq.Keys;
import com.example.demo.jooq.Testdb;
import com.example.demo.jooq.tables.records.StudentRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
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
public class Student extends TableImpl<StudentRecord> {

    private static final long serialVersionUID = 1960863890;

    /**
     * The reference instance of <code>testdb.student</code>
     */
    public static final Student STUDENT = new Student();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<StudentRecord> getRecordType() {
        return StudentRecord.class;
    }

    /**
     * The column <code>testdb.student.id</code>.
     */
    public final TableField<StudentRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>testdb.student.pepole_basic_id</code>.
     */
    public final TableField<StudentRecord, Long> PEPOLE_BASIC_ID = createField("pepole_basic_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>testdb.student.classz_id</code>.
     */
    public final TableField<StudentRecord, Long> CLASSZ_ID = createField("classz_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>testdb.student</code> table reference
     */
    public Student() {
        this("student", null);
    }

    /**
     * Create an aliased <code>testdb.student</code> table reference
     */
    public Student(String alias) {
        this(alias, STUDENT);
    }

    private Student(String alias, Table<StudentRecord> aliased) {
        this(alias, aliased, null);
    }

    private Student(String alias, Table<StudentRecord> aliased, Field<?>[] parameters) {
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
    public Identity<StudentRecord, Long> getIdentity() {
        return Keys.IDENTITY_STUDENT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<StudentRecord> getPrimaryKey() {
        return Keys.KEY_STUDENT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<StudentRecord>> getKeys() {
        return Arrays.<UniqueKey<StudentRecord>>asList(Keys.KEY_STUDENT_PRIMARY, Keys.KEY_STUDENT_UK_KVSEQB7LNHJ12N0GE2CJII29C);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<StudentRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<StudentRecord, ?>>asList(Keys.FK7C7AJ3I9VKWMAP93F2OPE7SNW, Keys.FKOIXNMXEWP3TGVYCCTIG771GNV);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Student as(String alias) {
        return new Student(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Student rename(String name) {
        return new Student(name, null);
    }
}