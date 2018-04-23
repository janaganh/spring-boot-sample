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
    profession_id bigint NOT NULL REFERENCES profession,
    CONSTRAINT personal_pkey PRIMARY KEY (id)
);

CREATE TABLE commission
(
    id bigint NOT NULL,
    profession_id bigint UNIQUE NOT NULL REFERENCES profession,
    group_nos integer NOT NULL,
    unit_payment_amount double precision NOT NULL,
    commission_rate double precision NOT NULL,
    CONSTRAINT commission_pkey PRIMARY KEY (id)
);

CREATE TABLE recruitment_transaction
(
    id bigint NOT NULL,
    recruiter_id bigint NOT NULL REFERENCES recruiter,
    transaction_date date NOT NULL,
    CONSTRAINT recruitment_transaction_pkey PRIMARY KEY (id)
);

CREATE TABLE recruitment_transaction_personal
(
    recruitment_transaction_id bigint NOT NULL REFERENCES recruitment_transaction,
    personal_id bigint NOT NULL REFERENCES personal,
    CONSTRAINT recruitment_transaction_personal_pkey PRIMARY KEY (recruitment_transaction_id, personal_id)
);

INSERT INTO recruiter(
	id, name)
	VALUES (1, 'ABC recruitment'),
    	   (2, 'Acme recruitment');


INSERT INTO profession(
	id, name)
	VALUES (1, 'Mason'),
    	   (2, 'Carpenter');

INSERT INTO personal(
	id, name, profession_id)
	VALUES (1, 'John Adam', 1),
    	   (2, 'Mary Brown', 1),
    	   (3, 'Author Doyle1', 1),
    	   (4, 'Author Doyle2', 1),
    	   (5, 'Author Doyle3',1),
    	   (6, 'Author Doyle4',1),
    	   (7, 'Author Doyle5',2),
    	   (8, 'Author Doyle6',2),
    	   (9, 'Author Doyle7',2),
    	   (10, 'Author Doyle8',2);

INSERT INTO commission(
	id, profession_id, group_nos, unit_payment_amount, commission_rate)
	VALUES (1, 1, 5, 200, 0.1),
    	   (2, 2, 5, 250, 0.1);

INSERT INTO recruitment_transaction(
	id, recruiter_id, transaction_date)
	VALUES (1, 1, '2018-04-08'),
    	   (2, 1, '2018-04-08'),
    	   (3, 1, '2018-03-08'),
    	   (4, 2, '2018-03-08'),
    	   (5, 2, '2018-04-08');

INSERT INTO recruitment_transaction_personal(
	recruitment_transaction_id, personal_id)
	VALUES (1, 1),(1, 2),(1, 3),(1, 4),(1, 5),
	       (2, 6),
	       (3, 7),
	       (4, 9),
	       (5, 10);
