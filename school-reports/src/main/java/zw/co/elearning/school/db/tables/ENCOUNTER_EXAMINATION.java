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
public class ENCOUNTER_EXAMINATION extends TableImpl<Record> {

    private static final long serialVersionUID = 1964006630;

    /**
     * The reference instance of <code>school.encounter_examination</code>
     */
    public static final ENCOUNTER_EXAMINATION ENCOUNTER_EXAMINATION = new ENCOUNTER_EXAMINATION();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.encounter_examination.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.encounter_examination.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.encounter_examination.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.encounter_examination.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.encounter_examination.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.encounter_examination.encounter_id</code>.
     */
    public final TableField<Record, Long> ENCOUNTER_ID = createField("encounter_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.encounter_examination.person_examination_id</code>.
     */
    public final TableField<Record, Long> PERSON_EXAMINATION_ID = createField("person_examination_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.encounter_examination</code> table reference
     */
    public ENCOUNTER_EXAMINATION() {
        this("encounter_examination", null);
    }

    /**
     * Create an aliased <code>school.encounter_examination</code> table reference
     */
    public ENCOUNTER_EXAMINATION(String alias) {
        this(alias, ENCOUNTER_EXAMINATION);
    }

    private ENCOUNTER_EXAMINATION(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private ENCOUNTER_EXAMINATION(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_ENCOUNTER_EXAMINATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_ENCOUNTER_EXAMINATION_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_ENCOUNTER_EXAMINATION_PRIMARY, Keys.KEY_ENCOUNTER_EXAMINATION_UK_O1JYKJMK7SAMVYFNYRKBPA9P);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK3LTVG23BYAAPHDRD7Q5WTRXPK, Keys.FKBIFKW4QYELQ7H5CHQRQD3447Y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ENCOUNTER_EXAMINATION as(String alias) {
        return new ENCOUNTER_EXAMINATION(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ENCOUNTER_EXAMINATION rename(String name) {
        return new ENCOUNTER_EXAMINATION(name, null);
    }
}
