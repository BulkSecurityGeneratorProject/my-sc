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
public class PERSON_ART_STATUS extends TableImpl<Record> {

    private static final long serialVersionUID = -507194997;

    /**
     * The reference instance of <code>school.person_art_status</code>
     */
    public static final PERSON_ART_STATUS PERSON_ART_STATUS = new PERSON_ART_STATUS();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.person_art_status.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.person_art_status.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.person_art_status.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.person_art_status.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.person_art_status.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.person_art_status.date</code>.
     */
    public final TableField<Record, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>school.person_art_status.art_id</code>.
     */
    public final TableField<Record, Long> ART_ID = createField("art_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.person_art_status.art_reason_id</code>.
     */
    public final TableField<Record, Long> ART_REASON_ID = createField("art_reason_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.person_art_status.art_status_id</code>.
     */
    public final TableField<Record, Long> ART_STATUS_ID = createField("art_status_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.person_art_status.arv_combination_regimen_id</code>.
     */
    public final TableField<Record, Long> ARV_COMBINATION_REGIMEN_ID = createField("arv_combination_regimen_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>school.person_art_status</code> table reference
     */
    public PERSON_ART_STATUS() {
        this("person_art_status", null);
    }

    /**
     * Create an aliased <code>school.person_art_status</code> table reference
     */
    public PERSON_ART_STATUS(String alias) {
        this(alias, PERSON_ART_STATUS);
    }

    private PERSON_ART_STATUS(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private PERSON_ART_STATUS(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_PERSON_ART_STATUS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_PERSON_ART_STATUS_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_PERSON_ART_STATUS_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK73J8PY5VI0E99LAYEJK2RPRFE, Keys.FKMTYL2GCGBO1QSD8QUJV7G3C75, Keys.FKPK7YI4KPG5GIXKBGWLENLDNR5, Keys.FKFTG9AO08FWXL8BGFO8MOFELA4);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PERSON_ART_STATUS as(String alias) {
        return new PERSON_ART_STATUS(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PERSON_ART_STATUS rename(String name) {
        return new PERSON_ART_STATUS(name, null);
    }
}
