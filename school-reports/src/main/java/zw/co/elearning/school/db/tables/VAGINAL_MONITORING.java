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
public class VAGINAL_MONITORING extends TableImpl<Record> {

    private static final long serialVersionUID = 1395147439;

    /**
     * The reference instance of <code>school.vaginal_monitoring</code>
     */
    public static final VAGINAL_MONITORING VAGINAL_MONITORING = new VAGINAL_MONITORING();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.vaginal_monitoring.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.vaginal_monitoring.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.vaginal_monitoring.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.vaginal_monitoring.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.vaginal_monitoring.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.vaginal_monitoring.date</code>.
     */
    public final TableField<Record, Timestamp> DATE = createField("date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.vaginal_monitoring.amniotic_fluid_id</code>.
     */
    public final TableField<Record, Long> AMNIOTIC_FLUID_ID = createField("amniotic_fluid_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.vaginal_monitoring.caput_id</code>.
     */
    public final TableField<Record, Long> CAPUT_ID = createField("caput_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.vaginal_monitoring.delivery_id</code>.
     */
    public final TableField<Record, Long> DELIVERY_ID = createField("delivery_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.vaginal_monitoring.moulding_id</code>.
     */
    public final TableField<Record, Long> MOULDING_ID = createField("moulding_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>school.vaginal_monitoring</code> table reference
     */
    public VAGINAL_MONITORING() {
        this("vaginal_monitoring", null);
    }

    /**
     * Create an aliased <code>school.vaginal_monitoring</code> table reference
     */
    public VAGINAL_MONITORING(String alias) {
        this(alias, VAGINAL_MONITORING);
    }

    private VAGINAL_MONITORING(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private VAGINAL_MONITORING(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_VAGINAL_MONITORING;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_VAGINAL_MONITORING_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_VAGINAL_MONITORING_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK33EGAURSGBI576H4M2YX660JH, Keys.FKBYT3RWGHXY2OM67QCONRSUAS7, Keys.FK3NRKUM6XVLN04OBC6AXE2PTNK, Keys.FKRFSMFYG53KB14YABMNA9J558L);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VAGINAL_MONITORING as(String alias) {
        return new VAGINAL_MONITORING(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public VAGINAL_MONITORING rename(String name) {
        return new VAGINAL_MONITORING(name, null);
    }
}
