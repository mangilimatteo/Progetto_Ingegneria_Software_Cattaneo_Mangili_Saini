/*
 * This file is generated by jOOQ.
 */
package model.generated.tables.records;


import model.generated.tables.Codice;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CodiceRecord extends UpdatableRecordImpl<CodiceRecord> implements Record2<String, Integer> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>CODICE.TIPO</code>.
     */
    public void setTipo(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>CODICE.TIPO</code>.
     */
    public String getTipo() {
        return (String) get(0);
    }

    /**
     * Setter for <code>CODICE.CONTATORE</code>.
     */
    public void setContatore(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>CODICE.CONTATORE</code>.
     */
    public Integer getContatore() {
        return (Integer) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, Integer> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<String, Integer> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Codice.CODICE.TIPO;
    }

    @Override
    public Field<Integer> field2() {
        return Codice.CODICE.CONTATORE;
    }

    @Override
    public String component1() {
        return getTipo();
    }

    @Override
    public Integer component2() {
        return getContatore();
    }

    @Override
    public String value1() {
        return getTipo();
    }

    @Override
    public Integer value2() {
        return getContatore();
    }

    @Override
    public CodiceRecord value1(String value) {
        setTipo(value);
        return this;
    }

    @Override
    public CodiceRecord value2(Integer value) {
        setContatore(value);
        return this;
    }

    @Override
    public CodiceRecord values(String value1, Integer value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CodiceRecord
     */
    public CodiceRecord() {
        super(Codice.CODICE);
    }

    /**
     * Create a detached, initialised CodiceRecord
     */
    public CodiceRecord(String tipo, Integer contatore) {
        super(Codice.CODICE);

        setTipo(tipo);
        setContatore(contatore);
        resetChangedOnNotNull();
    }
}
