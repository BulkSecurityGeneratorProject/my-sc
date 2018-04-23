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
public class IMNCI_QUESTIONNAIRE extends TableImpl<Record> {

    private static final long serialVersionUID = 1755237622;

    /**
     * The reference instance of <code>school.imnci_questionnaire</code>
     */
    public static final IMNCI_QUESTIONNAIRE IMNCI_QUESTIONNAIRE = new IMNCI_QUESTIONNAIRE();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.imnci_questionnaire.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.imnci_questionnaire.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.imnci_questionnaire.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.imnci_questionnaire.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.imnci_questionnaire.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.imnci_questionnaire.discontinued</code>.
     */
    public final TableField<Record, Boolean> DISCONTINUED = createField("discontinued", org.jooq.impl.SQLDataType.BIT, this, "");

    /**
     * The column <code>school.imnci_questionnaire.input_type</code>.
     */
    public final TableField<Record, String> INPUT_TYPE = createField("input_type", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

    /**
     * The column <code>school.imnci_questionnaire.name</code>.
     */
    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.imnci_questionnaire.category_id</code>.
     */
    public final TableField<Record, Long> CATEGORY_ID = createField("category_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.imnci_questionnaire</code> table reference
     */
    public IMNCI_QUESTIONNAIRE() {
        this("imnci_questionnaire", null);
    }

    /**
     * Create an aliased <code>school.imnci_questionnaire</code> table reference
     */
    public IMNCI_QUESTIONNAIRE(String alias) {
        this(alias, IMNCI_QUESTIONNAIRE);
    }

    private IMNCI_QUESTIONNAIRE(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private IMNCI_QUESTIONNAIRE(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_IMNCI_QUESTIONNAIRE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_IMNCI_QUESTIONNAIRE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_IMNCI_QUESTIONNAIRE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FKDTF69EM39D2N2JWPOCIH47T43);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IMNCI_QUESTIONNAIRE as(String alias) {
        return new IMNCI_QUESTIONNAIRE(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IMNCI_QUESTIONNAIRE rename(String name) {
        return new IMNCI_QUESTIONNAIRE(name, null);
    }
}
