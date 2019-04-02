  CREATE sequence hibernate_sequence start with 1 increment BY 1;
  CREATE TABLE diplome
    (
      id                     NUMBER(19,0) NOT NULL,
      code                   VARCHAR2(6 CHAR) NOT NULL,
      descriptif             VARCHAR2(4000 CHAR),
      enseignant_responsable VARCHAR2(255 CHAR),
      libelle                VARCHAR2(100 CHAR) NOT NULL,
      type_id                NUMBER(10,0) NOT NULL,
      PRIMARY KEY (id)
    );
  CREATE TABLE diplome_unites
    (
      diplome_id NUMBER(19,0) NOT NULL,
      unites_id  NUMBER(19,0) NOT NULL
    );
  CREATE TABLE inscription
    (
      id                NUMBER(19,0) NOT NULL,
      code_postal       VARCHAR2(6 CHAR) NOT NULL,
      commune           VARCHAR2(50 CHAR) NOT NULL,
      numero_et_voie    VARCHAR2(100 CHAR) NOT NULL,
      pays              VARCHAR2(50 CHAR) NOT NULL,
      civilite          VARCHAR2(3 CHAR) NOT NULL,
      date_de_naissance DATE NOT NULL,
      nom               VARCHAR2(100 CHAR) NOT NULL,
      prenom            VARCHAR2(100 CHAR) NOT NULL,
      reference_dossier VARCHAR2(6 CHAR) NOT NULL,
      diplome_id        NUMBER(19,0) NOT NULL,
      PRIMARY KEY (id)
    );
  CREATE TABLE inscription_unites_optionnelles
    (
      inscription_id         NUMBER(19,0) NOT NULL,
      unites_optionnelles_id NUMBER(19,0) NOT NULL
    );
  CREATE TABLE type_diplome
    (
      id      NUMBER(10,0) NOT NULL,
      libelle VARCHAR2(20 CHAR) NOT NULL,
      PRIMARY KEY (id)
    );
  CREATE TABLE unite_enseignement
    (
      id          NUMBER(19,0) NOT NULL,
      code        VARCHAR2(6 CHAR) NOT NULL,
      libelle     VARCHAR2(100 CHAR) NOT NULL,
      obligatoire NUMBER(1,0) NOT NULL,
      PRIMARY KEY (id)
    );
  ALTER TABLE diplome_unites ADD CONSTRAINT UK_a272bciijdl83lp9hx3237udy UNIQUE (unites_id);
  ALTER TABLE diplome ADD CONSTRAINT FKf70vl715qfrwbxycx7v78x07q FOREIGN KEY (type_id) REFERENCES type_diplome;
  ALTER TABLE diplome_unites ADD CONSTRAINT FKdm6b6rsali91kroryswm5ylr8 FOREIGN KEY (unites_id) REFERENCES unite_enseignement;
  ALTER TABLE diplome_unites ADD CONSTRAINT FKm17vjrobwhc0p7p6o55fqiius FOREIGN KEY (diplome_id) REFERENCES diplome;
  ALTER TABLE inscription ADD CONSTRAINT FK1cs09uemq3yr3rleq7f9lv8g3 FOREIGN KEY (diplome_id) REFERENCES diplome;
  ALTER TABLE inscription_unites_optionnelles ADD CONSTRAINT FKjp8cj42ruvp2prv005mobw3k6 FOREIGN KEY (unites_optionnelles_id) REFERENCES unite_enseignement;
  ALTER TABLE inscription_unites_optionnelles ADD CONSTRAINT FK8dh4u5yovx5a52nwqr05x9020 FOREIGN KEY (inscription_id) REFERENCES inscription;
