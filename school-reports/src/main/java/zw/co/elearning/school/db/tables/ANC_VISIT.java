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
public class ANC_VISIT extends TableImpl<Record> {

    private static final long serialVersionUID = -448158265;

    /**
     * The reference instance of <code>school.anc_visit</code>
     */
    public static final ANC_VISIT ANC_VISIT = new ANC_VISIT();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.anc_visit.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.anc_visit.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.anc_visit.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.anc_visit.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.anc_visit.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.anc_visit.visit_number</code>.
     */
    public final TableField<Record, Long> VISIT_NUMBER = createField("visit_number", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * The column <code>school.anc_visit.anc_id</code>.
     */
    public final TableField<Record, Long> ANC_ID = createField("anc_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.anc_visit.encounter_id</code>.
     */
    public final TableField<Record, Long> ENCOUNTER_ID = createField("encounter_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.anc_visit.general_assessment_id</code>.
     */
    public final TableField<Record, Long> GENERAL_ASSESSMENT_ID = createField("general_assessment_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.anc_visit.obstetric_examination_id</code>.
     */
    public final TableField<Record, Long> OBSTETRIC_EXAMINATION_ID = createField("obstetric_examination_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.anc_visit</code> table reference
     */
    public ANC_VISIT() {
        this("anc_visit", null);
    }

    /**
     * Create an aliased <code>school.anc_visit</code> table reference
     */
    public ANC_VISIT(String alias) {
        this(alias, ANC_VISIT);
    }

    private ANC_VISIT(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private ANC_VISIT(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_ANC_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_ANC_VISIT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_ANC_VISIT_PRIMARY, Keys.KEY_ANC_VISIT_UK_BJ2Y412AX1SLRF6207O9FS5RH, Keys.KEY_ANC_VISIT_UK_E7DCAU2WF5LOAT1EFXM0HMKJ2, Keys.KEY_ANC_VISIT_UK_4K0GSMD0LNV50N9MCN6MDCK6Y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK88NTYF2TJ67S2HFVO2DASUJFK, Keys.FKPMAX62UAG3UFXFILSXCDYK7X6, Keys.FK6QGG797FRLRYKMIFR8PR8S0J3, Keys.FKR56PC2VUPCCVNOO3A6D47UV6I);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ANC_VISIT as(String alias) {
        return new ANC_VISIT(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ANC_VISIT rename(String name) {
        return new ANC_VISIT(name, null);
    }
}
