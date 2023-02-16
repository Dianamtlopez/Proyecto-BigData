--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-02-12 19:23:24

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 52730)
-- Name: Data_Womans_Company; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA "Data_Womans_Company";


ALTER SCHEMA "Data_Womans_Company" OWNER TO postgres;

--
-- TOC entry 3323 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA "Data_Womans_Company"; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA "Data_Womans_Company" IS 'Esquema que contiene el nombre del grupo de desarrollo';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 52731)
-- Name: data; Type: TABLE; Schema: Data_Womans_Company; Owner: postgres
--

CREATE TABLE "Data_Womans_Company".data (
    "ID" integer NOT NULL,
    "Host ID" integer,
    "Host Response Rate" double precision,
    "Host Listings Count" double precision,
    "Host Total Listings Count" double precision,
    "Neighbourhood Cleansed" character varying,
    "Neighbourhood Group Cleansed" character varying,
    "Zipcode" character varying,
    "Market" character varying,
    "Latitude" double precision,
    "Longitude" double precision,
    "Property Type" character varying,
    "Room Type" character varying,
    "Accommodates" integer,
    "Bathrooms" double precision,
    "Bedrooms" double precision,
    beds double precision,
    "Price" double precision,
    "Weekly Price" double precision,
    "Monthly Price" double precision,
    "Guests Included" integer,
    "Extra People" integer,
    "Minimum Nights" integer,
    "Maximum Nights" integer,
    "Number of Reviews" integer,
    "Review Scores Rating" double precision,
    "Review Scores Accuracy" double precision,
    "Review Scores Cleanliness" double precision,
    "Review Scores Checkin" double precision,
    "Review Scores Communication" double precision,
    "Review Scores Location" double precision,
    "Review Scores Value" double precision,
    "Cancellation Policy" character varying,
    "Reviews per Month" double precision,
    "Geolocation" character varying,
    "Features" character varying
);


ALTER TABLE "Data_Womans_Company".data OWNER TO postgres;

--
-- TOC entry 3324 (class 0 OID 0)
-- Dependencies: 215
-- Name: TABLE data; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON TABLE "Data_Womans_Company".data IS 'Tabla asignada por el departamento de Data, la cual contiene todos los datos necesarios para desarrollar el ejercicio del ciclo de vida del Dato, y manejo de ETL';


--
-- TOC entry 3325 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."ID"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."ID" IS 'Columna que contiene la identificacion del anfitrion';


--
-- TOC entry 3326 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Host ID"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Host ID" IS 'Columna que contiene el identificador de Host (anfitrión).';


--
-- TOC entry 3327 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Host Response Rate"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Host Response Rate" IS 'Columna que contiene índice de respuestas del anfitrión, o cómo de rápida es la respuesta de los anfitriones.';


--
-- TOC entry 3328 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Host Listings Count"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Host Listings Count" IS 'Columna que contiene el número de alojamientos por anfitrión.';


--
-- TOC entry 3329 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Host Total Listings Count"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Host Total Listings Count" IS 'Columna que contiene el número total de alojamientos por anfitrión.';


--
-- TOC entry 3330 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Neighbourhood Cleansed"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Neighbourhood Cleansed" IS 'Columna que contiene el barrio donde está localizado el alojamiento.';


--
-- TOC entry 3331 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Neighbourhood Group Cleansed"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Neighbourhood Group Cleansed" IS 'Columna que contiene el distrito donde se encuentra el alojamiento.';


--
-- TOC entry 3332 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Zipcode"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Zipcode" IS 'Columna que contiene el código postal del alojamiento.Identifica por códogos los barrios o distritos.';


--
-- TOC entry 3333 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Market"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Market" IS 'Columna que contiene laciudad donde se encuentra el alojamiento.';


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Latitude"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Latitude" IS 'Columna que contiene la latitud, proporciona la localizacion de un lugar.';


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Longitude"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Longitude" IS 'Columna que contiene la longitud geográfica. Proporciona la localización de un. Se mide en grados minutos y segundos.';


--
-- TOC entry 3336 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Property Type"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Property Type" IS 'Columna que contiene el tipo de propiedad (apartamento, casa, etc.)';


--
-- TOC entry 3337 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Room Type"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Room Type" IS 'Columna que contiene el tipo de habitación (Habitación privada, habitación compartida, apatramento/casa entera, etc.)';


--
-- TOC entry 3338 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Accommodates"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Accommodates" IS 'Columna que contiene el número de personas que la propiedad puede acomodar (aforo).';


--
-- TOC entry 3339 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Bathrooms"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Bathrooms" IS 'Columna que contiene el número de baños del alojamiento.';


--
-- TOC entry 3340 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Bedrooms"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Bedrooms" IS 'Columna que contiene el número de dormitorios del alojamientos.';


--
-- TOC entry 3341 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data.beds; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data.beds IS 'Columna que contiene el número de camas en el alojamientos. Puede ser cualquier tipo de cama.';


--
-- TOC entry 3342 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Price"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Price" IS 'Columna que contiene el precio por noche.';


--
-- TOC entry 3343 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Weekly Price"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Weekly Price" IS 'Columna que contiene el precio por semana.';


--
-- TOC entry 3344 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Monthly Price"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Monthly Price" IS 'Columna que contiene el precio por mes. Precio por semana.';


--
-- TOC entry 3345 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Guests Included"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Guests Included" IS 'Columna que contiene el número de huéspedes que pueden quedarse en el alojamiento incluidos en el precio.';


--
-- TOC entry 3346 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Extra People"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Extra People" IS 'Columna que contiene el precio que los huéspedes tendrán que pagar si quieren invitar personas extra.';


--
-- TOC entry 3347 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Minimum Nights"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Minimum Nights" IS 'Columna que contiene el mínimo de noches que hay que reservar para poder alquilar el alojamiento.';


--
-- TOC entry 3348 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Maximum Nights"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Maximum Nights" IS 'Columna que contiene el número máximo de noches que pueden pernoctar los huéspedes.';


--
-- TOC entry 3349 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Number of Reviews"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Number of Reviews" IS 'Columna que contiene el número de reseñas que tiene el alojamiento.';


--
-- TOC entry 3350 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Rating"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Rating" IS 'Columna que contiene la puntuación de las reseñas dejadas por los huéspedes.';


--
-- TOC entry 3351 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Accuracy"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Accuracy" IS 'Columna que contiene la precisión (exactitud) de la descripción del inmueble escrita por los anfitriones.';


--
-- TOC entry 3352 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Cleanliness"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Cleanliness" IS 'Columna que contieene la puntuación de la limpieza de los alojamientos.';


--
-- TOC entry 3353 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Checkin"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Checkin" IS 'Columna que contiene la puntuación del check-in del alojamiento. Puntuación de 1 a 10.';


--
-- TOC entry 3354 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Communication"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Communication" IS 'Columna que contiene la puntuación que han dejado los huéspedes sobre la comunicación con el anfitrión o anfitriones.';


--
-- TOC entry 3355 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Location"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Location" IS 'Columna que contiene la puntuación que han dejado los huéspedes sobre la ubicación del inmueble.';


--
-- TOC entry 3356 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Review Scores Value"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Review Scores Value" IS 'Columna que contiene la puntuación del valor por el precio pagado por e huésped. Los huéspedes valoran si merece la pena quedarse en el inmueble o no.';


--
-- TOC entry 3357 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Cancellation Policy"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Cancellation Policy" IS 'Columna que contiene la política de cancelación impuesta por el anfitrion (estricta, moderada, etc.).';


--
-- TOC entry 3358 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Reviews per Month"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Reviews per Month" IS 'Columna que contiene el número de reseñas de un alojamiento por mes.';


--
-- TOC entry 3359 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Geolocation"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Geolocation" IS 'Columna que contiene la geolocalización, las coordenadas de la ubicación del inmueble.';


--
-- TOC entry 3360 (class 0 OID 0)
-- Dependencies: 215
-- Name: COLUMN data."Features"; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON COLUMN "Data_Womans_Company".data."Features" IS 'Columna que contiene información sobre el anfitrión, si el anfitrion es superhost o host normal.';


--
-- TOC entry 3317 (class 0 OID 52731)
-- Dependencies: 215
-- Data for Name: data; Type: TABLE DATA; Schema: Data_Womans_Company; Owner: postgres
--

COPY "Data_Womans_Company".data ("ID", "Host ID", "Host Response Rate", "Host Listings Count", "Host Total Listings Count", "Neighbourhood Cleansed", "Neighbourhood Group Cleansed", "Zipcode", "Market", "Latitude", "Longitude", "Property Type", "Room Type", "Accommodates", "Bathrooms", "Bedrooms", beds, "Price", "Weekly Price", "Monthly Price", "Guests Included", "Extra People", "Minimum Nights", "Maximum Nights", "Number of Reviews", "Review Scores Rating", "Review Scores Accuracy", "Review Scores Cleanliness", "Review Scores Checkin", "Review Scores Communication", "Review Scores Location", "Review Scores Value", "Cancellation Policy", "Reviews per Month", "Geolocation", "Features") FROM stdin;
\.


--
-- TOC entry 3174 (class 2606 OID 52737)
-- Name: data data_pk; Type: CONSTRAINT; Schema: Data_Womans_Company; Owner: postgres
--

ALTER TABLE ONLY "Data_Womans_Company".data
    ADD CONSTRAINT data_pk PRIMARY KEY ("ID");


--
-- TOC entry 3361 (class 0 OID 0)
-- Dependencies: 3174
-- Name: CONSTRAINT data_pk ON data; Type: COMMENT; Schema: Data_Womans_Company; Owner: postgres
--

COMMENT ON CONSTRAINT data_pk ON "Data_Womans_Company".data IS 'Llave primaria de la tabla data';


-- Completed on 2023-02-12 19:23:24

--
-- PostgreSQL database dump complete
--

