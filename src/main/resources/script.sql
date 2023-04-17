--create SEQUENCE people_id_seq;


CREATE TABLE IF NOT EXISTS public.people
(
    id bigint NOT NULL DEFAULT nextval('people_id_seq'::regclass),
    name text COLLATE pg_catalog."default" NOT NULL,
    birthdate date,
    "home_address" text COLLATE pg_catalog."default" NOT NULL,
    "science_grade" text COLLATE pg_catalog."default" NOT NULL,
    "conference_name" text,
    --foreign key ("conference_name") references public.conference_сommittee("conference_name"),
    CONSTRAINT people_pkey PRIMARY KEY (id)
);


CREATE SEQUENCE IF NOT EXISTS public.people_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1
    OWNED BY people.id;


CREATE TABLE IF NOT EXISTS public.conference_сommittee
(
     "conference_name"  text NOT NULL primary key ,
    "room_description" text,
    id bigint,
    "payment_value" bigint NOT NULL,
    foreign key (id) references public.people(id)
);