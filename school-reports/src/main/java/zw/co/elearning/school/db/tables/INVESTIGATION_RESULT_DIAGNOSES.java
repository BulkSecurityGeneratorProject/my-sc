/*
 * This file is generated by jOOQ.
*/
package zw.co.elearning.school.db.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
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
public class INVESTIGATION_RESULT_DIAGNOSES extends TableImpl<Record> {

    private static final long serialVersionUID = -105624293;

    /**
     * The reference instance of <code>school.investigation_result_diagnoses</code>
     */
    public static final INVESTIGATION_RESULT_DIAGNOSES INVESTIGATION_RESULT_DIAGNOSES = new INVESTIGATION_RESULT_DIAGNOSES();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.investigation_result_diagnoses.investigation_results_id</code>.
     */
    public final TableField<Record, Long> INVESTIGATION_RESULTS_ID = createField("investigation_results_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.investigation_result_diagnoses.diagnoses_id</code>.
     */
    public final TableField<Record, Long> DIAGNOSES_ID = createField("diagnoses_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.investigation_result_diagnoses</code> table reference
     */
    public INVESTIGATION_RESULT_DIAGNOSES() {
        this("investigation_result_diagnoses", null);
    }

    /**
     * Create an aliased <code>school.investigation_result_diagnoses</code> table reference
     */
    public INVESTIGATION_RESULT_DIAGNOSES(String alias) {
        this(alias, INVESTIGATION_RESULT_DIAGNOSES);
    }

    private INVESTIGATION_RESULT_DIAGNOSES(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private INVESTIGATION_RESULT_DIAGNOSES(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_INVESTIGATION_RESULT_DIAGNOSES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_INVESTIGATION_RESULT_DIAGNOSES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK69XTMU7J0VJQ07PG1MFQVUKCR, Keys.FKD4N0TTA7WCPUL6B5AR47URT2J);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public INVESTIGATION_RESULT_DIAGNOSES as(String alias) {
        return new INVESTIGATION_RESULT_DIAGNOSES(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public INVESTIGATION_RESULT_DIAGNOSES rename(String name) {
        return new INVESTIGATION_RESULT_DIAGNOSES(name, null);
    }
}
