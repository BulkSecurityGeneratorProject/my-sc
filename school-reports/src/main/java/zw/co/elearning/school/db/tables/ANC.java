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
public class ANC extends TableImpl<Record> {

    private static final long serialVersionUID = -997113022;

    /**
     * The reference instance of <code>school.anc</code>
     */
    public static final ANC ANC = new ANC();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.anc.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.anc.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.anc.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.anc.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.anc.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.anc.blood_flow</code>.
     */
    public final TableField<Record, String> BLOOD_FLOW = createField("blood_flow", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.anc.date</code>.
     */
    public final TableField<Record, Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.anc.first_booking</code>.
     */
    public final TableField<Record, Boolean> FIRST_BOOKING = createField("first_booking", org.jooq.impl.SQLDataType.BIT.nullable(false), this, "");

    /**
     * The column <code>school.anc.frequency</code>.
     */
    public final TableField<Record, Integer> FREQUENCY = createField("frequency", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>school.anc.lnmp</code>.
     */
    public final TableField<Record, Date> LNMP = createField("lnmp", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>school.anc.menstrual_cycle</code>.
     */
    public final TableField<Record, String> MENSTRUAL_CYCLE = createField("menstrual_cycle", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.anc.number</code>.
     */
    public final TableField<Record, String> NUMBER = createField("number", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>school.anc.outcome</code>.
     */
    public final TableField<Record, String> OUTCOME = createField("outcome", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.anc.delivery_id</code>.
     */
    public final TableField<Record, Long> DELIVERY_ID = createField("delivery_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.anc.diagnosis_id</code>.
     */
    public final TableField<Record, Long> DIAGNOSIS_ID = createField("diagnosis_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.anc.feeding_option_id</code>.
     */
    public final TableField<Record, Long> FEEDING_OPTION_ID = createField("feeding_option_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.anc.person_id</code>.
     */
    public final TableField<Record, Long> PERSON_ID = createField("person_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.anc</code> table reference
     */
    public ANC() {
        this("anc", null);
    }

    /**
     * Create an aliased <code>school.anc</code> table reference
     */
    public ANC(String alias) {
        this(alias, ANC);
    }

    private ANC(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private ANC(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_ANC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_ANC_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_ANC_PRIMARY, Keys.KEY_ANC_UK_8DITXKRWARUIMQI37DANBSVGV);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK3XYKYLE5WCO979RXDNNA3WFQR, Keys.FKCDQ7YA83TCHPKS32HVYGTG8NM, Keys.FKMCYHA6X8U7D4NRRONLKGY5IRF, Keys.FKOHS0O075TL74T7JOGFY5RR7XI);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ANC as(String alias) {
        return new ANC(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ANC rename(String name) {
        return new ANC(name, null);
    }
}
