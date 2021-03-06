/*
 * This file is generated by jOOQ.
*/
package zw.co.elearning.school.db.tables;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.impl.TableImpl;

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
public class HIBERNATE_SEQUENCE extends TableImpl<Record> {

    private static final long serialVersionUID = -629103990;

    /**
     * The reference instance of <code>school.hibernate_sequence</code>
     */
    public static final HIBERNATE_SEQUENCE HIBERNATE_SEQUENCE = new HIBERNATE_SEQUENCE();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.hibernate_sequence.next_val</code>.
     */
    public final TableField<Record, Long> NEXT_VAL = createField("next_val", org.jooq.impl.SQLDataType.BIGINT, this, "");

    /**
     * Create a <code>school.hibernate_sequence</code> table reference
     */
    public HIBERNATE_SEQUENCE() {
        this("hibernate_sequence", null);
    }

    /**
     * Create an aliased <code>school.hibernate_sequence</code> table reference
     */
    public HIBERNATE_SEQUENCE(String alias) {
        this(alias, HIBERNATE_SEQUENCE);
    }

    private HIBERNATE_SEQUENCE(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private HIBERNATE_SEQUENCE(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
    public HIBERNATE_SEQUENCE as(String alias) {
        return new HIBERNATE_SEQUENCE(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public HIBERNATE_SEQUENCE rename(String name) {
        return new HIBERNATE_SEQUENCE(name, null);
    }
}
