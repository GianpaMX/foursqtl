CREATE TABLE "authentification" (
    "id_user" INTEGER PRIMARY KEY NOT NULL,
    "code" TEXT
);
CREATE TABLE "user" (
    "id_user" INTEGER PRIMARY KEY NOT NULL,
    "first_name" TEXT,
    "last_name" TEXT,
    "photo" TEXT,
    "gender" TEXT,
    "home_city" TEXT,
    "relationship" TEXT
);
CREATE TABLE "user_contact" (
    "id_user" TEXT NOT NULL,
    "phone" TEXT,
    "email" TEXT,
    "twitter" TEXT,
    "facebook" TEXT
);
CREATE TABLE "checkin" (
    "id_checkin" INTEGER PRIMARY KEY NOT NULL,
    "id_user" INTEGER,
    "id_venue" INTEGER,
    "created_at" INTEGER,
    "shout" TEXT,
    "is_mayor" INTEGER,
    "time_zone" TEXT
);
CREATE TABLE "venue" (
    "id_venue" INTEGER PRIMARY KEY,
    "id_location" INTEGER,
    "name" TEXT,
    "url" TEXT
);
CREATE TABLE "location" (
    "id_location" INTEGER PRIMARY KEY NOT NULL,
    "address" TEXT,
    "cross_street" TEXT,
    "lat" REAL,
    "lng" REAL,
    "postal_code" TEXT,
    "city" TEXT,
    "state" TEXT,
    "country" TEXT
);
CREATE TABLE "category" (
    "id_category" INTEGER PRIMARY KEY NOT NULL,
    "id_icon" INTEGER,
    "name" TEXT,
    "plural_name" TEXT,
    "short_name" TEXT
);
CREATE TABLE "icon" (
    "id_icon" INTEGER PRIMARY KEY NOT NULL,
    "prefix" TEXT,
    "name" TEXT
);
CREATE TABLE "icon_size" (
    "id_icon_size" INTEGER PRIMARY KEY NOT NULL,
    "id_icon" INTEGER NOT NULL,
    "size" TEXT
);
CREATE TABLE "venue_category" (
    "id_venue" INTEGER NOT NULL,
    "id_category" INTEGER NOT NULL,
    "primary" INTEGER NOT NULL
);
