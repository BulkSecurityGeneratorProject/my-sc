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
public class PNC_QUESTIONARE_CATEGORY extends TableImpl<Record> {

    private static final long serialVersionUID = 978294743;

    /**
     * The reference instance of <code>school.pnc_questionare_category</code>
     */
    public static final PNC_QUESTIONARE_CATEGORY PNC_QUESTIONARE_CATEGORY = new PNC_QUESTIONARE_CATEGORY();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    /**
     * The column <code>school.pnc_questionare_category.id</code>.
     */
    public final TableField<Record, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>school.pnc_questionare_category.created_by</code>.
     */
    public final TableField<Record, String> CREATED_BY = createField("created_by", org.jooq.impl.SQLDataType.VARCHAR.length(50).nullable(false), this, "");

    /**
     * The column <code>school.pnc_questionare_category.created_date</code>.
     */
    public final TableField<Record, Timestamp> CREATED_DATE = createField("created_date", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>school.pnc_questionare_category.last_modified_by</code>.
     */
    public final TableField<Record, String> LAST_MODIFIED_BY = createField("last_modified_by", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>school.pnc_questionare_category.last_modified_date</code>.
     */
    public final TableField<Record, Timestamp> LAST_MODIFIED_DATE = createField("last_modified_date", org.jooq.impl.SQLDataType.TIMESTAMP, this, "");

    /**
     * The column <code>school.pnc_questionare_category.name</code>.
     */
    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * The column <code>school.pnc_questionare_category.position</code>.
     */
    public final TableField<Record, Integer> POSITION = createField("position", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>school.pnc_questionare_category</code> table reference
     */
    public PNC_QUESTIONARE_CATEGORY() {
        this("pnc_questionare_category", null);
    }

    /**
     * Create an aliased <code>school.pnc_questionare_category</code> table reference
     */
    public PNC_QUESTIONARE_CATEGORY(String alias) {
        this(alias, PNC_QUESTIONARE_CATEGORY);
    }

    private PNC_QUESTIONARE_CATEGORY(String alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private PNC_QUESTIONARE_CATEGORY(String alias, Table<Record> aliased, Field<?>[] parameters) {
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
        return Keys.IDENTITY_PNC_QUESTIONARE_CATEGORY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Keys.KEY_PNC_QUESTIONARE_CATEGORY_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(Keys.KEY_PNC_QUESTIONARE_CATEGORY_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PNC_QUESTIONARE_CATEGORY as(String alias) {
        return new PNC_QUESTIONARE_CATEGORY(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PNC_QUESTIONARE_CATEGORY rename(String name) {
        return new PNC_QUESTIONARE_CATEGORY(name, null);
    }
}