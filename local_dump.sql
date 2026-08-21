--
-- PostgreSQL database dump
--

\restrict WNMRvBEp3Y9OPhI3d71iyzyY9ISldgPganNGSXWsAge49BZ2C2iVSB8RYaaZr16

-- Dumped from database version 18.4
-- Dumped by pg_dump version 18.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: friends; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.friends (
    id uuid NOT NULL,
    favorite_thing character varying(255),
    memory character varying(2000),
    message character varying(1000),
    name character varying(255) NOT NULL,
    nickname character varying(255),
    song_dedication character varying(255),
    slam_book_id uuid NOT NULL
);


--
-- Name: memories; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.memories (
    id uuid NOT NULL,
    capsule_date character varying(255),
    photo_url text,
    slam_book_id uuid NOT NULL,
    text text
);


--
-- Name: slam_books; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.slam_books (
    id uuid NOT NULL,
    about_me character varying(1000),
    best_friend boolean,
    capsule_photo_url character varying(255),
    capsule_text character varying(2000),
    date_of_birth date,
    favorite_color character varying(255),
    friendship_rating integer,
    friendship_since date,
    full_name character varying(255) NOT NULL,
    gender character varying(255),
    nickname character varying(255),
    profile_photo_url character varying(255)
);


--
-- Data for Name: friends; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.friends (id, favorite_thing, memory, message, name, nickname, song_dedication, slam_book_id) FROM stdin;
f11aaec9-dbfd-4e28-a6b1-f62590a265dd	White wine with chicken tandoori	No money still lived without money...	You are good person...	Priya	Priya	https://youtu.be/g23pmazHwgE?si=02IP11TrpivvGuah	f4e6f06d-950a-477d-a129-54204ff9dc0a
8e8cbe32-9f4c-4726-91fa-51254a992aa8	White wine with chicken tandoori	sdfghj	asdfghj	Priya	Priya	https://youtu.be/g23pmazHwgE?si=02IP11TrpivvGuah	e16e0522-191c-48fe-bbd6-c9c614ffe068
\.


--
-- Data for Name: memories; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.memories (id, capsule_date, photo_url, slam_book_id, text) FROM stdin;
\.


--
-- Data for Name: slam_books; Type: TABLE DATA; Schema: public; Owner: -
--

COPY public.slam_books (id, about_me, best_friend, capsule_photo_url, capsule_text, date_of_birth, favorite_color, friendship_rating, friendship_since, full_name, gender, nickname, profile_photo_url) FROM stdin;
f4e6f06d-950a-477d-a129-54204ff9dc0a	Im good boy..	t	\N	Dosti jinda rahe hamari	1996-07-20	#ff7c5c	8	2026-08-20	Anirudh Singh	Male	Pintu	\N
e16e0522-191c-48fe-bbd6-c9c614ffe068	dfghjk	t	http://localhost:8080/uploads/1e2b8d2b-68dd-4db6-a942-aae792fdcbf2.png	sdfghj	2026-08-14	#41337a	8	2026-08-18	harsh	Male	muruskar	http://localhost:8080/uploads/4eb64bb3-61f8-489e-b1eb-c347448b2cc4.png
e3f93966-0abf-4b65-9f57-f32eaa26440e	bgjhgh	t	http://localhost:8080/uploads/deeae992-eefa-4f78-8288-d3973093749e.png	hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh	2026-08-12	#7c5cff	8	2026-08-21	vghfghj	Female	vfjh	http://localhost:8080/uploads/ca0a631a-feed-40cf-9a17-749bf8665ec3.png
0f175849-a688-486b-ab6c-7adf86a04ec8	fghgfhfgh	t	https://ornfiystiyfrgtndzgdg.supabase.co/storage/v1/object/public/images/20cea139-ea54-4b38-9b7a-32bc7eaff968.png	dfhdh	2026-08-20	#7c5cff	8	2026-08-13	hhhh	Male	ghfh	https://ornfiystiyfrgtndzgdg.supabase.co/storage/v1/object/public/images/c1de5d7b-2cb4-44a8-8f2f-be674e99a571.png
\.


--
-- Name: friends friends_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.friends
    ADD CONSTRAINT friends_pkey PRIMARY KEY (id);


--
-- Name: memories memories_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.memories
    ADD CONSTRAINT memories_pkey PRIMARY KEY (id);


--
-- Name: slam_books slam_books_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.slam_books
    ADD CONSTRAINT slam_books_pkey PRIMARY KEY (id);


--
-- Name: friends fk5oy2ka9ypycllamaqksbikux7; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.friends
    ADD CONSTRAINT fk5oy2ka9ypycllamaqksbikux7 FOREIGN KEY (slam_book_id) REFERENCES public.slam_books(id);


--
-- PostgreSQL database dump complete
--

\unrestrict WNMRvBEp3Y9OPhI3d71iyzyY9ISldgPganNGSXWsAge49BZ2C2iVSB8RYaaZr16

