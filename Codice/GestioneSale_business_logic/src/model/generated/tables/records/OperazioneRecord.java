/*
 * This file is generated by jOOQ.
 */
package model.generated.tables.records;


import model.generated.tables.Operazione;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class OperazioneRecord extends UpdatableRecordImpl<OperazioneRecord> implements Record7<String, String, String, Boolean, String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>OPERAZIONE.CODICE</code>.
     */
    public void setCodice(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>OPERAZIONE.CODICE</code>.
     */
    public String getCodice() {
        return (String) get(0);
    }

    /**
     * Setter for <code>OPERAZIONE.BLOCCO</code>.
     */
    public void setBlocco(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>OPERAZIONE.BLOCCO</code>.
     */
    public String getBlocco() {
        return (String) get(1);
    }

    /**
     * Setter for <code>OPERAZIONE.SALA</code>.
     */
    public void setSala(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>OPERAZIONE.SALA</code>.
     */
    public String getSala() {
        return (String) get(2);
    }

    /**
     * Setter for <code>OPERAZIONE.ANESTESIA</code>.
     */
    public void setAnestesia(Boolean value) {
        set(3, value);
    }

    /**
     * Getter for <code>OPERAZIONE.ANESTESIA</code>.
     */
    public Boolean getAnestesia() {
        return (Boolean) get(3);
    }

    /**
     * Setter for <code>OPERAZIONE.PRIMO_OPERATORE</code>.
     */
    public void setPrimoOperatore(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>OPERAZIONE.PRIMO_OPERATORE</code>.
     */
    public String getPrimoOperatore() {
        return (String) get(4);
    }

    /**
     * Setter for <code>OPERAZIONE.CODICE_ANAGRAFICA</code>.
     */
    public void setCodiceAnagrafica(String value) {
        set(5, value);
    }

    /**
     * Getter for <code>OPERAZIONE.CODICE_ANAGRAFICA</code>.
     */
    public String getCodiceAnagrafica() {
        return (String) get(5);
    }

    /**
     * Setter for <code>OPERAZIONE.MEDICO_SCHEDULAZIONE</code>.
     */
    public void setMedicoSchedulazione(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>OPERAZIONE.MEDICO_SCHEDULAZIONE</code>.
     */
    public String getMedicoSchedulazione() {
        return (String) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row7<String, String, String, Boolean, String, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    @Override
    public Row7<String, String, String, Boolean, String, String, String> valuesRow() {
        return (Row7) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Operazione.OPERAZIONE.CODICE;
    }

    @Override
    public Field<String> field2() {
        return Operazione.OPERAZIONE.BLOCCO;
    }

    @Override
    public Field<String> field3() {
        return Operazione.OPERAZIONE.SALA;
    }

    @Override
    public Field<Boolean> field4() {
        return Operazione.OPERAZIONE.ANESTESIA;
    }

    @Override
    public Field<String> field5() {
        return Operazione.OPERAZIONE.PRIMO_OPERATORE;
    }

    @Override
    public Field<String> field6() {
        return Operazione.OPERAZIONE.CODICE_ANAGRAFICA;
    }

    @Override
    public Field<String> field7() {
        return Operazione.OPERAZIONE.MEDICO_SCHEDULAZIONE;
    }

    @Override
    public String component1() {
        return getCodice();
    }

    @Override
    public String component2() {
        return getBlocco();
    }

    @Override
    public String component3() {
        return getSala();
    }

    @Override
    public Boolean component4() {
        return getAnestesia();
    }

    @Override
    public String component5() {
        return getPrimoOperatore();
    }

    @Override
    public String component6() {
        return getCodiceAnagrafica();
    }

    @Override
    public String component7() {
        return getMedicoSchedulazione();
    }

    @Override
    public String value1() {
        return getCodice();
    }

    @Override
    public String value2() {
        return getBlocco();
    }

    @Override
    public String value3() {
        return getSala();
    }

    @Override
    public Boolean value4() {
        return getAnestesia();
    }

    @Override
    public String value5() {
        return getPrimoOperatore();
    }

    @Override
    public String value6() {
        return getCodiceAnagrafica();
    }

    @Override
    public String value7() {
        return getMedicoSchedulazione();
    }

    @Override
    public OperazioneRecord value1(String value) {
        setCodice(value);
        return this;
    }

    @Override
    public OperazioneRecord value2(String value) {
        setBlocco(value);
        return this;
    }

    @Override
    public OperazioneRecord value3(String value) {
        setSala(value);
        return this;
    }

    @Override
    public OperazioneRecord value4(Boolean value) {
        setAnestesia(value);
        return this;
    }

    @Override
    public OperazioneRecord value5(String value) {
        setPrimoOperatore(value);
        return this;
    }

    @Override
    public OperazioneRecord value6(String value) {
        setCodiceAnagrafica(value);
        return this;
    }

    @Override
    public OperazioneRecord value7(String value) {
        setMedicoSchedulazione(value);
        return this;
    }

    @Override
    public OperazioneRecord values(String value1, String value2, String value3, Boolean value4, String value5, String value6, String value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached OperazioneRecord
     */
    public OperazioneRecord() {
        super(Operazione.OPERAZIONE);
    }

    /**
     * Create a detached, initialised OperazioneRecord
     */
    public OperazioneRecord(String codice, String blocco, String sala, Boolean anestesia, String primoOperatore, String codiceAnagrafica, String medicoSchedulazione) {
        super(Operazione.OPERAZIONE);

        setCodice(codice);
        setBlocco(blocco);
        setSala(sala);
        setAnestesia(anestesia);
        setPrimoOperatore(primoOperatore);
        setCodiceAnagrafica(codiceAnagrafica);
        setMedicoSchedulazione(medicoSchedulazione);
        resetChangedOnNotNull();
    }
}
