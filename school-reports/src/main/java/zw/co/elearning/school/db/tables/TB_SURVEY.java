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
public class TB_SURVEY extends TableImpl<Record> {

    private static final long serialVersionUID = -1965074531;

    /**
     * The reference instance of <code>school.tb_survey</code>
     */
    public static final TB_SURVEY TB_SURVEY = new TB_SURVEY();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.tb_survey.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.tb_survey.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.tb_survey.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.tb_survey.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.tb_survey.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.tb_survey.value</code>.
     */
    public final TableField<Record, String> VALUE = createField("value", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.tb_survey.tb_id</code>.
     */
    public final TableField<Record, Long> TB_ID = createField("tb_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.tb_survey.tb_questionare_id</code>.
     */
    public final TableField<Record, Long> TB_QUESTIONARE_ID = createField("tb_questionare_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.tb_survey</code> table reference
     */
    public TB_SURVEY() {
        this("tb_survey", null);
    }

    /**
     * Create an aliased <code>school.tb_survey</code> table reference
     */
    public TB_SURVEY(String alias) {
        this(alias, TB_SURVEY);
    }

    private TB_SURVEY(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private TB_SURVEY(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_TB_SURVEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_TB_SURVEY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_TB_SURVEY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FKEJNVKCINEVU7BMNU4BKFT9EL4, Keys.FKA8QWLC6F1TQREEV5ESEGCAFTY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TB_SURVEY as(String alias) {
        return new TB_SURVEY(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public TB_SURVEY rename(String name) {
        return new TB_SURVEY(name, null);
    }
}