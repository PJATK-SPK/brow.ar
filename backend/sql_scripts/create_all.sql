CREATE TABLE core.manufacturers (
	id SERIAL PRIMARY KEY,
	name varchar(50) not null
);

CREATE TABLE core.beers (
	id SERIAL PRIMARY KEY,
	name varchar(50) not null,
	description varchar(3000) not null,
	image_url varchar(300) not null,
	manufacturer_id int null,
    is_mock BOOLEAN DEFAULT TRUE NOT NULL,
	FOREIGN KEY (manufacturer_id) REFERENCES manufacturers(id)
);

CREATE TABLE core.rates (
    id SERIAL PRIMARY KEY,
    beer_id INT NOT NULL,
    taste_rating INT CHECK (taste_rating >= 1 AND taste_rating <= 5),
    color_rating INT CHECK (color_rating >= 1 AND color_rating <= 5),
    aroma_rating INT CHECK (aroma_rating >= 1 AND aroma_rating <= 5),
    is_mock BOOLEAN DEFAULT TRUE NOT NULL,
    FOREIGN KEY (beer_id) REFERENCES beers(id)
);

CREATE TABLE core.comments (
    id SERIAL PRIMARY KEY,
    beer_id INT NOT NULL,
    content varchar(3000) not null,
    is_mock BOOLEAN DEFAULT TRUE NOT NULL,
    FOREIGN KEY (beer_id) REFERENCES beers(id)
);