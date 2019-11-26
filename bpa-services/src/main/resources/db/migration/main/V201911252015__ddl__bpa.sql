
CREATE TABLE eg_bpa_BuildingPlan(

  id character varying(64),
  applicationNo character varying(64),
  edcrNumber character varying(64),
  tenantId character varying(256) NOT NULL,
  serviceType character varying(256),
  status character varying(64),
  ownershipCategory character varying(64),
  additionalDetail JSONB,
  propertyId character varying(256),
  createdBy character varying(64),
  lastModifiedBy character varying(64),
  createdTime bigint,
  lastModifiedTime bigint,

  CONSTRAINT uk_eg_bpa_BuildingPlan  PRIMARY KEY (id)
);


CREATE TABLE eg_bpa_Unit(
    id character varying(64) NOT NULL,
    tenantId character varying(256),
    usageCategory character varying(64),
    additionalDetails JSONB,
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime bigint,
    lastModifiedTime bigint,

    CONSTRAINT pk_eg_bpa_Unit PRIMARY KEY (id),
    CONSTRAINT fk_eg_bpa_Unit FOREIGN KEY (buildingPlanId) REFERENCES eg_bpa_BuildingPlan (id)
);


CREATE TABLE eg_bpa_Document(
    id character varying(64),
    documentType character varying(64),
    fileStore character varying(64),
    documentUid character varying(64),
    buildingPlanId character varying(64),
    additionalDetails JSONB,
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime bigint,
    lastModifiedTime bigint,

    CONSTRAINT uk_eg_bpa_Document PRIMARY KEY (id),
    CONSTRAINT fk_eg_bpa_Document FOREIGN KEY (buildingPlanId) REFERENCES eg_bpa_BuildingPlan (id)
);


CREATE TABLE eg_bpa_Address(
    id character varying(64),
    tenantId character varying(64) NOT NULL,
    doorNo character varying(64),
    plotNo character varying(64),
    landmark character varying(64),
    city character varying(64),
    district character varying(64),
    region character varying(64),
    state character varying(64),
    country character varying(64),
    pincode character varying(64),
    additionDetails character varying(64),
    buildingName character varying(64),
    street character varying(64),
    buildingPlanId character varying(64),
    createdBy character varying(64),
    lastModifiedBy character varying(64),
    createdTime bigint,
    lastModifiedTime bigint,

    CONSTRAINT uk_eg_bpa_Address PRIMARY KEY (id),
    CONSTRAINT fk_eg_bpa_Address FOREIGN KEY (buildingPlanId) REFERENCES eg_bpa_BuildingPlan (id)
      ON UPDATE CASCADE
      ON DELETE CASCADE
);


CREATE TABLE eg_bpa_owner(
  id character varying(64),
  name character varying(256) NOT NULL,
  mobileNumber character varying(256) NOT NULL,
  gender character varying(256) NOT NULL,
  fatherOrHusbandName character varying(256) NOT NULL,
  correspondenceAddress character varying(256),
  isprimaryowner boolean,
  ownershippercentage double,
  ownertype character varying(64),
  institutionId character varying(64),
  relationship character varying(64) NOT NULL,
  additionalDetails JSONB,
  createdby character varying(64),
  createdtime bigint,
  lastmodifiedby character varying(64),
  buildingPlanId character varying(64),
  lastmodifiedtime bigint,
  CONSTRAINT pk_eg_bpa_owner PRIMARY KEY (id,tradeLicenseDetailId),
  CONSTRAINT uk_eg_bpa_owner  UNIQUE (id),
  CONSTRAINT fk_eg_bpa_owner FOREIGN KEY (buildingPlanId) REFERENCES eg_bpa_BuildingPlan (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE
);


CREATE TABLE eg_tl_institution (
  tenantId character varying(256),
  id character varying(64),
  tradeLicenseDetailId character varying(64),
  name character varying(64),
  type character varying(64),
  designation character varying(64),
  createdby character varying(64),
  createdtime bigint,
  lastmodifiedby character varying(64),
  lastmodifiedtime bigint,

  CONSTRAINT pk_eg_tl_institution PRIMARY KEY (id),
  CONSTRAINT fk_eg_tl_institution FOREIGN KEY (tradeLicenseDetailId) REFERENCES eg_tl_TradeLicenseDetail (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE
);