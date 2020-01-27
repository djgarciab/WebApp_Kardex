-- DIEGO JAVIER GARCÍA
-- BASE DE DATOS BDkARDEX PARA MYSQL

CREATE TABLE entradasproducto (
    entid            INTEGER NOT NULL,
    prodreferencia   VARCHAR(50) NOT NULL,
    entdocumento     VARCHAR(50),
    entfecha         DATE,
    entdetalle       VARCHAR(200),
    entcantidad      INTEGER,
    entcosto         FLOAT(12),
    enttotal         FLOAT(12)
);

ALTER TABLE entradasproducto ADD CONSTRAINT entradaproducto_pk PRIMARY KEY ( entid );

CREATE TABLE productos (
    prodreferencia    VARCHAR(50) NOT NULL,
    tiporeferencia    VARCHAR(50) NOT NULL,
    prodnombre        VARCHAR(50) NOT NULL,
    proddescripcion   VARCHAR(200)
);

ALTER TABLE productos ADD CONSTRAINT producto_pk PRIMARY KEY ( prodreferencia );

CREATE TABLE registroskardex (
    regid            INTEGER NOT NULL,
    prodreferencia   VARCHAR(50) NOT NULL,
    entid            INTEGER NOT NULL,
    salid            INTEGER NOT NULL,
    regcantidad      INTEGER,
    regcosto         FLOAT(12),
    regtotal         FLOAT(12)
);

ALTER TABLE registroskardex ADD CONSTRAINT registroskardex_pk PRIMARY KEY ( regid );

CREATE TABLE salidasproducto (
    salid            INTEGER NOT NULL,
    prodreferencia   VARCHAR(50) NOT NULL,
    saldocumento     VARCHAR(50),
    saldetalle       VARCHAR(200),
    salfecha         DATE,
    salcantidad      INTEGER,
    salcosto         FLOAT(12),
    saltotal         FLOAT(12)
);

ALTER TABLE salidasproducto ADD CONSTRAINT salidaproducto_pk PRIMARY KEY ( salid );

CREATE TABLE tipos (
    tiporeferencia   VARCHAR(50) NOT NULL,
    tiponombre       VARCHAR(50) NOT NULL
);

ALTER TABLE tipos ADD CONSTRAINT tipo_pk PRIMARY KEY ( tiporeferencia );

ALTER TABLE entradasproducto
    ADD CONSTRAINT entradaproducto_productos_fk FOREIGN KEY ( prodreferencia )
        REFERENCES productos ( prodreferencia );

ALTER TABLE productos
    ADD CONSTRAINT producto_tipo_fk FOREIGN KEY ( tiporeferencia )
        REFERENCES tipos ( tiporeferencia );

ALTER TABLE registroskardex
    ADD CONSTRAINT registroskardex_entproducto_fk FOREIGN KEY ( entid )
        REFERENCES entradasproducto ( entid );

ALTER TABLE registroskardex
    ADD CONSTRAINT registroskardex_productos_fk FOREIGN KEY ( prodreferencia )
        REFERENCES productos ( prodreferencia );

ALTER TABLE registroskardex
    ADD CONSTRAINT registroskardex_salproducto_fk FOREIGN KEY ( salid )
        REFERENCES salidasproducto ( salid );

ALTER TABLE salidasproducto
    ADD CONSTRAINT salproducto_productos_fk FOREIGN KEY ( prodreferencia )
        REFERENCES productos ( prodreferencia );

