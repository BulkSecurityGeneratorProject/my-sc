/*
 * This file is generated by jOOQ.
*/
package zw.co.elearning.school.db.tables;


import java.sql.Date;
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
public class IMNCI_VISIT extends TableImpl<Record> {

    private static final long serialVersionUID = -1946642251;

    /**
     * The reference instance of <code>school.imnci_visit</code>
     */
    public static final IMNCI_VISIT IMNCI_VISIT = new IMNCI_VISIT();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.imnci_visit.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.imnci_visit.date</code>.
     */
    public final TableField<Record, Date> DATE = createField("date", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

    /**
     * The column <code>school.imnci_visit.encounter_id</code>.
     */
    public final TableField<Record, Long> ENCOUNTER_ID = createField("encounter_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * Create a <code>school.imnci_visit</code> table reference
     */
    public IMNCI_VISIT() {
        this("imnci_visit", null);
    }

    /**
     * Create an aliased <code>school.imnci_visit</code> table reference
     */
    public IMNCI_VISIT(String alias) {
        this(alias, IMNCI_VISIT);
    }

    private IMNCI_VISIT(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private IMNCI_VISIT(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_IMNCI_VISIT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_IMNCI_VISIT_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_IMNCI_VISIT_PRIMARY, Keys.KEY_IMNCI_VISIT_UK_KCHYIF1DNMXJ2OOHIBOLXAXNS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<Record, ?>> getReferences() {
        return Arrays.<ForeignKey<Record, ?>>asList(Keys.FK5WDDQBR4LTIMGSASRLARGDXB8);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IMNCI_VISIT as(String alias) {
        return new IMNCI_VISIT(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public IMNCI_VISIT rename(String name) {
        return new IMNCI_VISIT(name, null);
    }
}
