/*
 * This file is generated by jOOQ.
*/
package com.example.demo.jooq.tables;


import com.example.demo.jooq.Keys;
import com.example.demo.jooq.Testdb;
import com.example.demo.jooq.tables.records.ClasszRecord;

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
public class Classz extends TableImpl<ClasszRecord> {

    private static final long serialVersionUID = 935146132;

    /**
     * The reference instance of <code>testdb.classz</code>
     */
    public static final Classz CLASSZ = new Classz();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ClasszRecord> getRecordType() {
        return ClasszRecord.class;
    }

    /**
     * The column <code>testdb.classz.id</code>.
     */
    public final TableField<ClasszRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>testdb.classz.cnum</code>.
     */
    public final TableField<ClasszRecord, Integer> CNUM = createField("cnum", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>testdb.classz.grade_id</code>.
     */
    public final TableField<ClasszRecord, Long> GRADE_ID = createField("grade_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>testdb.classz</code> table reference
     */
    public Classz() {
        this("classz", null);
    }

    /**
     * Create an aliased <code>testdb.classz</code> table reference
     */
    public Classz(String alias) {
        this(alias, CLASSZ);
    }

    private Classz(String alias, Table<ClasszRecord> aliased) {
        this(alias, aliased, null);
    }

    private Classz(String alias, Table<ClasszRecord> aliased, Field<?>[] parameters) {
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
    public Identity<ClasszRecord, Long> getIdentity() {
        return Keys.IDENTITY_CLASSZ;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ClasszRecord> getPrimaryKey() {
        return Keys.KEY_CLASSZ_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ClasszRecord>> getKeys() {
        return Arrays.<UniqueKey<ClasszRecord>>asList(Keys.KEY_CLASSZ_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<ClasszRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<ClasszRecord, ?>>asList(Keys.FKDGIFY2GAYJDKJYCB28EUA14U3);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Classz as(String alias) {
        return new Classz(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Classz rename(String name) {
        return new Classz(name, null);
    }
}