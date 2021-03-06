/*
 * This file is generated by jOOQ.
*/
package zw.co.elearning.school.db.tables;


import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class ENCOUNTER_NOTE extends TableImpl<Record> {

    private static final long serialVersionUID = -713850479;

    /**
     * The reference instance of <code>school.encounter_note</code>
     */
    public static final ENCOUNTER_NOTE ENCOUNTER_NOTE = new ENCOUNTER_NOTE();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.encounter_note.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.encounter_note.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.encounter_note.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.encounter_note.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.encounter_note.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.encounter_note.date</code>.
     */
    public final TableField<Record, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>school.encounter_note.note</code>.
     */
    public final TableField<Record, String> NOTE = createField("note", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.encounter_note.encounter_id</code>.
     */
    public final TableField<Record, Long> ENCOUNTER_ID = createField("encounter_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.encounter_note</code> table reference
     */
    public ENCOUNTER_NOTE() {
        this("encounter_note", null);
    }

    /**
     * Create an aliased <code>school.encounter_note</code> table reference
     */
    public ENCOUNTER_NOTE(String alias) {
        this(alias, ENCOUNTER_NOTE);
    }

    private ENCOUNTER_NOTE(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private ENCOUNTER_NOTE(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_ENCOUNTER_NOTE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_ENCOUNTER_NOTE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_ENCOUNTER_NOTE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FKLSJ1RB2UU9021GWRMJDA8IBQ9);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ENCOUNTER_NOTE as(String alias) {
        return new ENCOUNTER_NOTE(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ENCOUNTER_NOTE rename(String name) {
        return new ENCOUNTER_NOTE(name, null);
    }
}
