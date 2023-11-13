CREATE TABLE study_groups
(
    id bigserial PRIMARY KEY NOT NULL,
    name character varying(128) NOT NULL
);
CREATE TABLE study_plans
(
    id bigserial PRIMARY KEY NOT NULL,
    name character varying(128) NOT NULL
);

CREATE TABLE students
(
    id bigserial PRIMARY KEY NOT NULL,
    first_name character varying(45) NOT NULL,
    last_name character varying(45) NOT NULL,
    age integer,
    study_group_id bigserial REFERENCES study_groups(id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE academic_records
(
    id bigserial PRIMARY KEY NOT NULL,
    grade integer,
    student_id bigserial REFERENCES students(id) NOT NULL,
    study_plan_id bigserial REFERENCES study_plans(id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION
);

