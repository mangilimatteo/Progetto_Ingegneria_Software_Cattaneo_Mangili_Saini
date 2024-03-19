/*
 * This file is generated by jOOQ.
 */
package model.generated.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import model.generated.DefaultSchema;
import model.generated.Keys;
import model.generated.tables.records.OperazioneRecord;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function6;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row6;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Operazione extends TableImpl<OperazioneRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>OPERAZIONE</code>
     */
    public static final Operazione OPERAZIONE = new Operazione();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<OperazioneRecord> getRecordType() {
        return OperazioneRecord.class;
    }

    /**
     * The column <code>OPERAZIONE.CODICE</code>.
     */
    public final TableField<OperazioneRecord, String> CODICE = createField(DSL.name("CODICE"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>OPERAZIONE.BLOCCO</code>.
     */
    public final TableField<OperazioneRecord, String> BLOCCO = createField(DSL.name("BLOCCO"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>OPERAZIONE.SALA</code>.
     */
    public final TableField<OperazioneRecord, String> SALA = createField(DSL.name("SALA"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>OPERAZIONE.ANESTESIA</code>.
     */
    public final TableField<OperazioneRecord, Boolean> ANESTESIA = createField(DSL.name("ANESTESIA"), SQLDataType.BOOLEAN.nullable(false), this, "");

    /**
     * The column <code>OPERAZIONE.PRIMO_OPERATORE</code>.
     */
    public final TableField<OperazioneRecord, String> PRIMO_OPERATORE = createField(DSL.name("PRIMO_OPERATORE"), SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>OPERAZIONE.CODICE_ANAGRAFICA</code>.
     */
    public final TableField<OperazioneRecord, String> CODICE_ANAGRAFICA = createField(DSL.name("CODICE_ANAGRAFICA"), SQLDataType.CLOB.nullable(false), this, "");

    private Operazione(Name alias, Table<OperazioneRecord> aliased) {
        this(alias, aliased, null);
    }

    private Operazione(Name alias, Table<OperazioneRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>OPERAZIONE</code> table reference
     */
    public Operazione(String alias) {
        this(DSL.name(alias), OPERAZIONE);
    }

    /**
     * Create an aliased <code>OPERAZIONE</code> table reference
     */
    public Operazione(Name alias) {
        this(alias, OPERAZIONE);
    }

    /**
     * Create a <code>OPERAZIONE</code> table reference
     */
    public Operazione() {
        this(DSL.name("OPERAZIONE"), null);
    }

    public <O extends Record> Operazione(Table<O> child, ForeignKey<O, OperazioneRecord> key) {
        super(child, key, OPERAZIONE);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<OperazioneRecord> getPrimaryKey() {
        return Keys.OPERAZIONE__PK_OPERAZIONE;
    }

    @Override
    public List<ForeignKey<OperazioneRecord, ?>> getReferences() {
        return Arrays.asList(Keys.OPERAZIONE__FK_OPERAZIONE_PK_ANAGRAFICA);
    }

    private transient Anagrafica _anagrafica;

    /**
     * Get the implicit join path to the <code>ANAGRAFICA</code> table.
     */
    public Anagrafica anagrafica() {
        if (_anagrafica == null)
            _anagrafica = new Anagrafica(this, Keys.OPERAZIONE__FK_OPERAZIONE_PK_ANAGRAFICA);

        return _anagrafica;
    }

    @Override
    public Operazione as(String alias) {
        return new Operazione(DSL.name(alias), this);
    }

    @Override
    public Operazione as(Name alias) {
        return new Operazione(alias, this);
    }

    @Override
    public Operazione as(Table<?> alias) {
        return new Operazione(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Operazione rename(String name) {
        return new Operazione(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Operazione rename(Name name) {
        return new Operazione(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Operazione rename(Table<?> name) {
        return new Operazione(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<String, String, String, Boolean, String, String> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function6<? super String, ? super String, ? super String, ? super Boolean, ? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function6<? super String, ? super String, ? super String, ? super Boolean, ? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
