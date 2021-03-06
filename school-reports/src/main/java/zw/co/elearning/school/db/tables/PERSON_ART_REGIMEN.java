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
public class PERSON_ART_REGIMEN extends TableImpl<Record> {

    private static final long serialVersionUID = -1278633243;

    /**
     * The reference instance of <code>school.person_art_regimen</code>
     */
    public static final PERSON_ART_REGIMEN PERSON_ART_REGIMEN = new PERSON_ART_REGIMEN();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.person_art_regimen.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.person_art_regimen.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.person_art_regimen.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.person_art_regimen.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.person_art_regimen.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.person_art_regimen.date</code>.
     */
    public final TableField<Record, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>school.person_art_regimen.art_id</code>.
     */
    public final TableField<Record, Long> ART_ID = createField("art_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.person_art_regimen.arv_combination_regimen_id</code>.
     */
    public final TableField<Record, Long> ARV_COMBINATION_REGIMEN_ID = createField("arv_combination_regimen_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.person_art_regimen</code> table reference
     */
    public PERSON_ART_REGIMEN() {
        this("person_art_regimen", null);
    }

    /**
     * Create an aliased <code>school.person_art_regimen</code> table reference
     */
    public PERSON_ART_REGIMEN(String alias) {
        this(alias, PERSON_ART_REGIMEN);
    }

    private PERSON_ART_REGIMEN(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private PERSON_ART_REGIMEN(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_PERSON_ART_REGIMEN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_PERSON_ART_REGIMEN_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_PERSON_ART_REGIMEN_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FKPN8N4WFBWL3DKJ39E6YFXJK7O, Keys.FKM6X1I94RXLO1YPHRJPJEJ0DPR);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PERSON_ART_REGIMEN as(String alias) {
        return new PERSON_ART_REGIMEN(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PERSON_ART_REGIMEN rename(String name) {
        return new PERSON_ART_REGIMEN(name, null);
    }
}
