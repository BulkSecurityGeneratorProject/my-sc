/*
 * This file is generated by jOOQ.
*/
package zw.co.elearning.school.db.tables;


import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;

import zw.co.elearning.school.db.Keys;
import zw.co.elearning.school.db.School;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class OBSTETRIC_EXAMINATION extends TableImpl<Record> {

    private static final long serialVersionUID = -784726512;

    /**
     * The reference instance of <code>school.obstetric_examination</code>
     */
    public static final OBSTETRIC_EXAMINATION OBSTETRIC_EXAMINATION = new OBSTETRIC_EXAMINATION();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.obstetric_examination.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.obstetric_examination.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.obstetric_examination.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.obstetric_examination.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.obstetric_examination.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.obstetric_examination.engaged</code>.
     */
    public final TableField<Record, Boolean> ENGAGED = createField("engaged", org.jooq.impl.SQLDataType.BIT.nullable(false), this, "");

    /**
     * The column <code>school.obstetric_examination.fetal_movement</code>.
     */
    public final TableField<Record, Boolean> FETAL_MOVEMENT = createField("fetal_movement", org.jooq.impl.SQLDataType.BIT.nullable(false), this, "");

    /**
     * The column <code>school.obstetric_examination.lie</code>.
     */
    public final TableField<Record, String> LIE = createField("lie", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.obstetric_examination.presentation</code>.
     */
    public final TableField<Record, String> PRESENTATION = createField("presentation", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * Create a <code>school.obstetric_examination</code> table reference
     */
    public OBSTETRIC_EXAMINATION() {
        this("obstetric_examination", null);
    }

    /**
     * Create an aliased <code>school.obstetric_examination</code> table reference
     */
    public OBSTETRIC_EXAMINATION(String alias) {
        this(alias, OBSTETRIC_EXAMINATION);
    }

    private OBSTETRIC_EXAMINATION(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private OBSTETRIC_EXAMINATION(String alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return School.SCHOOL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<Record, Long> getIdentity() {
        return Keys.IDENTITY_OBSTETRIC_EXAMINATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_OBSTETRIC_EXAMINATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_OBSTETRIC_EXAMINATION_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OBSTETRIC_EXAMINATION as(String alias) {
        return new OBSTETRIC_EXAMINATION(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public OBSTETRIC_EXAMINATION rename(String name) {
        return new OBSTETRIC_EXAMINATION(name, null);
    }
}
