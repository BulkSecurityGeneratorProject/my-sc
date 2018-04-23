/*
 * This file is generated by jOOQ.
*/
package zw.co.elearning.school.db.tables;


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
public class FREQUENCY extends TableImpl<Record> {

    private static final long serialVersionUID = -1799131769;

    /**
     * The reference instance of <code>school.frequency</code>
     */
    public static final FREQUENCY FREQUENCY = new FREQUENCY();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.frequency.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.frequency.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.frequency.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.frequency.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.frequency.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.frequency.code</code>.
     */
    public final TableField<Record, String> CODE = createField("code", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.frequency.description</code>.
     */
    public final TableField<Record, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>school.frequency.name</code>.
     */
    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.frequency.number_per_day</code>.
     */
    public final TableField<Record, Integer> NUMBER_PER_DAY = createField("number_per_day", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>school.frequency.standard_id</code>.
     */
    public final TableField<Record, Long> STANDARD_ID = createField("standard_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.frequency</code> table reference
     */
    public FREQUENCY() {
        this("frequency", null);
    }

    /**
     * Create an aliased <code>school.frequency</code> table reference
     */
    public FREQUENCY(String alias) {
        this(alias, FREQUENCY);
    }

    private FREQUENCY(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private FREQUENCY(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_FREQUENCY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_FREQUENCY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_FREQUENCY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK2EI6LSUY5DY2M4EFBBI0DSLBJ);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FREQUENCY as(String alias) {
        return new FREQUENCY(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public FREQUENCY rename(String name) {
        return new FREQUENCY(name, null);
    }
}
