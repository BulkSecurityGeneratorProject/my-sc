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
public class PNC_VISIT extends TableImpl<Record> {

    private static final long serialVersionUID = 370546673;

    /**
     * The reference instance of <code>school.pnc_visit</code>
     */
    public static final PNC_VISIT PNC_VISIT = new PNC_VISIT();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.pnc_visit.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.pnc_visit.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.pnc_visit.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.pnc_visit.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.pnc_visit.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.pnc_visit.date</code>.
     */
    public final TableField<Record, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>school.pnc_visit.encounter_id</code>.
     */
    public final TableField<Record, Long> ENCOUNTER_ID = createField("encounter_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.pnc_visit.pnc_id</code>.
     */
    public final TableField<Record, Long> PNC_ID = createField("pnc_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.pnc_visit.pnc_visit_type_id</code>.
     */
    public final TableField<Record, Long> PNC_VISIT_TYPE_ID = createField("pnc_visit_type_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>school.pnc_visit</code> table reference
     */
    public PNC_VISIT() {
        this("pnc_visit", null);
    }

    /**
     * Create an aliased <code>school.pnc_visit</code> table reference
     */
    public PNC_VISIT(String alias) {
        this(alias, PNC_VISIT);
    }

    private PNC_VISIT(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private PNC_VISIT(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_PNC_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_PNC_VISIT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_PNC_VISIT_PRIMARY, Keys.KEY_PNC_VISIT_UK_DVFIF98LEFJW97Q2C3F3C6T1N);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FKTRP4YR9Q32KCUJ18XUKIDJJBB, Keys.FK2IPE77IUTD2H9RRFVSFHW8WUY, Keys.FK7QK8S4KLAIX15FTSC0GPHG0BM);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PNC_VISIT as(String alias) {
        return new PNC_VISIT(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PNC_VISIT rename(String name) {
        return new PNC_VISIT(name, null);
    }
}
