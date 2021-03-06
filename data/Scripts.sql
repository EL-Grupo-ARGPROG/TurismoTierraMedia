DROP TABLE IF EXISTS "Itinerario";
CREATE TABLE "Itinerario" (
	"id"	INTEGER,
	"id_usuario"	INTEGER NOT NULL,
	"atraccion"	TEXT,
	"promocion"	TEXT,
	"precio"	INTEGER,
	FOREIGN KEY("id_usuario") REFERENCES "Usuarios"("id"),
	FOREIGN KEY("promocion") REFERENCES "Promociones"("nombre"),
	FOREIGN KEY("atraccion") REFERENCES "Atracciones"("nombre"),
	PRIMARY KEY("id")
);

DROP TABLE IF EXISTS "Pack_Atracciones";
CREATE TABLE "Pack_Atracciones" (
	"id"	INTEGER NOT NULL,
	"nombre_atraccion"	TEXT,
	FOREIGN KEY("nombre_atraccion") REFERENCES "Atracciones"("nombre"),
	FOREIGN KEY ("id") REFERENCES "Promociones" ("id_pack")
	PRIMARY KEY("id","nombre_atraccion")
);

DROP TABLE IF EXISTS "Promociones";
CREATE TABLE "Promociones" (
	"nombre"	TEXT NOT NULL,
	"id_pack"	INTEGER NOT NULL,
	"tipo_tematica"	TEXT,
	"tipo_promo"	TEXT,
	"beneficio_Abs"	NUMERIC,
	"beneficio_Porcen"	NUMERIC,
	"beneficio_AxB"	TEXT,
	"valido"	INTEGER DEFAULT 1,
	PRIMARY KEY("id_pack" AUTOINCREMENT),
	FOREIGN KEY("tipo_tematica") REFERENCES "Tipos_Tematicas"("Nombre"),
	FOREIGN KEY("tipo_promo") REFERENCES "Tipos_Promos"("nombre")
);

DROP TABLE IF EXISTS "Tipos_Promos";
CREATE TABLE "Tipos_Promos" (
	"nombre"	TEXT NOT NULL,
	PRIMARY KEY("nombre")
);
DROP TABLE IF EXISTS "Usuarios";
CREATE TABLE "Usuarios" (
	"id"	INTEGER NOT NULL,
	"nombre"	TEXT,
	"password"	TEXT,
	"presupuesto"	NUMERIC,
	"tiempo_disponible"	NUMERIC,
	"tipo_preferencia"	TEXT,
	"admin"	TEXT,
	"valido"	INTEGER DEFAULT 1,
	FOREIGN KEY("tipo_preferencia") REFERENCES "Tipos_Tematicas"("Nombre"),
	PRIMARY KEY("id" AUTOINCREMENT)
);

DROP TABLE IF EXISTS "Atracciones";
CREATE TABLE "Atracciones" (
	"nombre"	TEXT NOT NULL,
	"costo"	NUMERIC,
	"tiempo_necesario"	INTEGER,
	"cupo"	INTEGER,
	"tipo_tematica"	TEXT,
	"valido"	INTEGER DEFAULT 1,
	PRIMARY KEY("nombre"),
	FOREIGN KEY("tipo_tematica") REFERENCES "Tipos_Tematicas"("Nombre")
);


DROP TABLE IF EXISTS "Tipos_Tematicas";
CREATE TABLE "Tipos_Tematicas" (
	"Nombre"	TEXT NOT NULL,
	PRIMARY KEY("Nombre")
);





INSERT INTO "Tipos_Tematicas"
VALUES ("AVENTURA"),
("PAISAJE"),
("DEGUSTACION");

INSERT INTO "Atracciones"
VALUES ("Moria",100,2,6,"AVENTURA",1),
("Minas Tirith",75,2.5,25,"PAISAJE",1),
("La Comarca",120,6.5,150,"DEGUSTACION",1),
("Mordor",175,3,4,"AVENTURA",1),
("Abismo de Helm",105,2,15,"PAISAJE",1),
("Lothlorein",135,1,30,"DEGUSTACION",1),
("Erebor",160,3,32,"PAISAJE",1),
("Bosque Negro",95,4,12,"AVENTURA",1),
("Los Arboles Del Infinito",115,1.5,5,"DEGUSTACION",1);

INSERT INTO "Usuarios"
VALUES (1, "Eowyn", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay", 400,8,"AVENTURA", "False",1),
(2, "Gandalf", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay",600,6,"PAISAJE", "False",1),
(3, "Sam", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay",800,9,"DEGUSTACION", "True",1),
(4, "Galadriel", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay",900,5,"AVENTURA", "False",1),
(5, "Frodo", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay",500,12,"DEGUSTACION", "True",1),
(6, "Golum", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay",100,3,"PAISAJE", "False",1),
(7, "Aragon", "$2a$13$sOCJTM86cugRbHbhkZE.AePVqVymjkX2UNp6kFhm94etpfEDBpMay",1000,2.5,"AVENTURA", "True",1);


INSERT INTO "Tipos_Promos"
VALUES ("PORCENTUAL"),
("ABSOLUTA"),
("AxB");


INSERT INTO "Promociones" ("tipo_promo", "nombre", "beneficio_Abs", "beneficio_porcen",
                            "beneficio_AxB", "tipo_tematica","id_pack")
VALUES ("PORCENTUAL","Pack Aventura",NULL,20, NULL,"AVENTURA",1);
INSERT INTO "Promociones" ("tipo_promo", "nombre", "beneficio_Abs", "beneficio_porcen",
                            "beneficio_AxB", "tipo_tematica", "id_pack")
VALUES("ABSOLUTA","Pack Degustacion",200, NULL, NULL,"DEGUSTACION",2);
INSERT INTO "Promociones" ("tipo_promo", "nombre", "beneficio_Abs", "beneficio_porcen",
                            "beneficio_AxB", "tipo_tematica", "id_pack")
VALUES("AxB","Pack Paisajes",NULL, NULL, "Erebor","PAISAJE",3);
INSERT INTO "Promociones" ("tipo_promo", "nombre", "beneficio_Abs", "beneficio_porcen",
                            "beneficio_AxB", "tipo_tematica", "id_pack")
VALUES("PORCENTUAL","Pack Paisaje 2",NULL, 15,NULL,"PAISAJE",4);
INSERT INTO "Promociones" ("tipo_promo", "nombre", "beneficio_Abs", "beneficio_porcen",
                            "beneficio_AxB", "tipo_tematica", "id_pack")
VALUES("ABSOLUTA","Pack Aventura 2",300, NULL, NULL,"AVENTURA",5);
INSERT INTO "Promociones" ("tipo_promo", "nombre", "beneficio_Abs", "beneficio_porcen",
                            "beneficio_AxB", "tipo_tematica", "id_pack")
VALUES("AxB","Pack Degustacion 2",NULL, NULL, "La Comarca","DEGUSTACION",6);


INSERT INTO "Pack_Atracciones"
VALUES (1, "Bosque Negro"),
(1, "Mordor"),
(2, "Lothlorein"),
(2, "La Comarca"),
(3, "Minas Tirith"),
(3, "Abismo de Helm"),
(3, "Erebor"),
(4, "Erebor"),
(4, "Minas Tirith"),
(5, "Moria"),
(5, "Mordor"),
(5, "Bosque Negro"),
(6, "Lothlorein"),
(6, "La Comarca"),
(6, "Los Arboles Del Infinito");