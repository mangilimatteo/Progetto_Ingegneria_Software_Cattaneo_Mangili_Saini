/*
 * This file is generated by jOOQ.
 */
package model.generated;


import model.generated.tables.Anagrafica;
import model.generated.tables.Codice;
import model.generated.tables.Dipendente;
import model.generated.tables.Operazione;
import model.generated.tables.Verbale;
import model.generated.tables.records.AnagraficaRecord;
import model.generated.tables.records.CodiceRecord;
import model.generated.tables.records.DipendenteRecord;
import model.generated.tables.records.OperazioneRecord;
import model.generated.tables.records.VerbaleRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AnagraficaRecord> ANAGRAFICA__PK_ANAGRAFICA = Internal.createUniqueKey(Anagrafica.ANAGRAFICA, DSL.name("pk_ANAGRAFICA"), new TableField[] { Anagrafica.ANAGRAFICA.CODICE }, true);
    public static final UniqueKey<CodiceRecord> CODICE__PK_CODICE = Internal.createUniqueKey(Codice.CODICE, DSL.name("pk_CODICE"), new TableField[] { Codice.CODICE.TIPO }, true);
    public static final UniqueKey<DipendenteRecord> DIPENDENTE__PK_DIPENDENTE = Internal.createUniqueKey(Dipendente.DIPENDENTE, DSL.name("pk_DIPENDENTE"), new TableField[] { Dipendente.DIPENDENTE.MATRICOLA }, true);
    public static final UniqueKey<OperazioneRecord> OPERAZIONE__PK_OPERAZIONE = Internal.createUniqueKey(Operazione.OPERAZIONE, DSL.name("pk_OPERAZIONE"), new TableField[] { Operazione.OPERAZIONE.CODICE }, true);
    public static final UniqueKey<VerbaleRecord> VERBALE__PK_VERBALE = Internal.createUniqueKey(Verbale.VERBALE, DSL.name("pk_VERBALE"), new TableField[] { Verbale.VERBALE.CODICE }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<AnagraficaRecord, DipendenteRecord> ANAGRAFICA__FK_ANAGRAFICA_PK_DIPENDENTE = Internal.createForeignKey(Anagrafica.ANAGRAFICA, DSL.name("fk_ANAGRAFICA_pk_DIPENDENTE"), new TableField[] { Anagrafica.ANAGRAFICA.MATR_MEDICO }, Keys.DIPENDENTE__PK_DIPENDENTE, new TableField[] { Dipendente.DIPENDENTE.MATRICOLA }, true);
    public static final ForeignKey<OperazioneRecord, AnagraficaRecord> OPERAZIONE__FK_OPERAZIONE_PK_ANAGRAFICA = Internal.createForeignKey(Operazione.OPERAZIONE, DSL.name("fk_OPERAZIONE_pk_ANAGRAFICA"), new TableField[] { Operazione.OPERAZIONE.CODICE_ANAGRAFICA }, Keys.ANAGRAFICA__PK_ANAGRAFICA, new TableField[] { Anagrafica.ANAGRAFICA.CODICE }, true);
    public static final ForeignKey<OperazioneRecord, DipendenteRecord> OPERAZIONE__FK_OPERAZIONE_PK_DIPENDENTE = Internal.createForeignKey(Operazione.OPERAZIONE, DSL.name("fk_OPERAZIONE_pk_DIPENDENTE"), new TableField[] { Operazione.OPERAZIONE.MEDICO_SCHEDULAZIONE, Operazione.OPERAZIONE.PRIMO_OPERATORE }, Keys.DIPENDENTE__PK_DIPENDENTE, new TableField[] { Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA }, true);
    public static final ForeignKey<VerbaleRecord, DipendenteRecord> VERBALE__FK_VERBALE_PK_DIPENDENTE = Internal.createForeignKey(Verbale.VERBALE, DSL.name("fk_VERBALE_pk_DIPENDENTE"), new TableField[] { Verbale.VERBALE.TECNICO_RADIOLOGIA, Verbale.VERBALE.AIUTO_ANESTESISTA, Verbale.VERBALE.INFERMIERE, Verbale.VERBALE.STRUMENTISTA, Verbale.VERBALE.ANESTESISTA, Verbale.VERBALE.TERZO_OPERATORE, Verbale.VERBALE.SECONDO_OPERATORE, Verbale.VERBALE.PRIMO_OPERATORE }, Keys.DIPENDENTE__PK_DIPENDENTE, new TableField[] { Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA, Dipendente.DIPENDENTE.MATRICOLA }, true);
    public static final ForeignKey<VerbaleRecord, OperazioneRecord> VERBALE__FK_VERBALE_PK_OPERAZIONE = Internal.createForeignKey(Verbale.VERBALE, DSL.name("fk_VERBALE_pk_OPERAZIONE"), new TableField[] { Verbale.VERBALE.CODICE_OPERAZIONE }, Keys.OPERAZIONE__PK_OPERAZIONE, new TableField[] { Operazione.OPERAZIONE.CODICE }, true);
}
