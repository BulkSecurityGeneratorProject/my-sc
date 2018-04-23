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
public class TB_RISK_GROUP extends TableImpl<Record> {

    private static final long serialVersionUID = -838947963;

    /**
     * The reference instance of <code>school.tb_risk_group</code>
     */
    public static final TB_RISK_GROUP TB_RISK_GROUP = new TB_RISK_GROUP();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.tb_risk_group.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.tb_risk_group.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.tb_risk_group.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.tb_risk_group.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.tb_risk_group.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.tb_risk_group.name</code>.
     */
    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.tb_risk_group.state</code>.
     */
    public final TableField<Record, Boolean> STATE = createField("state", org.jooq.impl.SQLDataType.BIT, this, "");

    /**
     * Create a <code>school.tb_risk_group</code> table reference
     */
    public TB_RISK_GROUP() {
        this("tb_risk_group", null);
    }

    /**
     * Create an aliased <code>school.tb_risk_group</code> table reference
     */
    public TB_RISK_GROUP(String alias) {
        this(alias, TB_RISK_GROUP);
    }

    private TB_RISK_GROUP(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private TB_RISK_GROUP(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_TB_RISK_GROUP;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_TB_RISK_GROUP_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_TB_RISK_GROUP_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TB_RISK_GROUP as(String alias) {
        return new TB_RISK_GROUP(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TB_RISK_GROUP rename(String name) {
        return new TB_RISK_GROUP(name, null);
    }
}
