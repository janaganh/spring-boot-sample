CREATE TABLE recruiter
(
    id bigint NOT NULL,
    name character varying NOT NULL,
    CONSTRAINT recruiter_pkey PRIMARY KEY (id)
);

CREATE TABLE profession
(
    id bigint NOT NULL,
    name character varying  NOT NULL,
    CONSTRAINT profession_pkey PRIMARY KEY (id)
);

CREATE TABLE personal
(
    id bigint NOT NULL,
    name character varying NOT NULL,
    CONSTRAINT employees_pkey PRIMARY KEY (id)
);

CREATE TABLE commission
(
    id bigint NOT NULL,
    profession_id bigint NOT NULL REFERENCES profession,
    group_nos integer NOT NULL,
    unit_payment_amount double precision NOT NULL,
    commision_rate double precision NOT NULL,
    CONSTRAINT commision_pkey PRIMARY KEY (id, profession_id)
);

CREATE TABLE recruitment
(
    id bigint NOT NULL,
    recruiter_id bigint NOT NULL REFERENCES recruiter,
    recruitment_date date NOT NULL,
    CONSTRAINT recruitment_pkey PRIMARY KEY (id)
)

CREATE TABLE recruited_personal
(
    recruitment_id bigint NOT NULL REFERENCES recruitment,
    personal_id bigint NOT NULL REFERENCES personal,
    CONSTRAINT recruited_employees_pkey PRIMARY KEY (personal_id, recruitment_id)
)

INSERT INTO recruiter(
	id, name)
	VALUES (1, 'ABC recruitment'),
    	   (2, 'Acme recruitment');


INSERT INTO profession(
	id, name)
	VALUES (1, 'Mason'),
    	   (2, 'Carpenter');

INSERT INTO personal(
	id, name)
	VALUES (1, 'John Adam'),
    	   (2, 'Mary Brown'),
    	   (3, 'Author Doyle'),

INSERT INTO commission(
	id, profession_id, group_nos, unit_payment_amount, commision_rate)
	VALUES (1, 1, 5, 200, 0.1),
    	   (2, 2, 5, 250, 0.1);

INSERT INTO recruitment(
	id, recruiter_id, recruitment_date)
	VALUES (1, 1, '2018-01-08'),
    	   (1, 1, '2018-01-08'),
    	   (1, 1, '2018-01-08'),
    	   (1, 1, '2018-01-08'),

INSERT INTO commission(
	id, profession_id, group_nos, unit_payment_amount, commision_rate)
	VALUES (1, 1, 5, 200, 0.1),
    	   (2, 2, 5, 250, 0.1);
