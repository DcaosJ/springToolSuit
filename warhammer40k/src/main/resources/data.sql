INSERT INTO categoria (destacada, imagen, nombre) VALUES (true, 'https://imagen1.com', 'Miniatura');
INSERT INTO categoria (destacada, imagen, nombre) VALUES (false, 'https://imagen2.com', 'Caja Ejercitos');
INSERT INTO categoria (destacada, imagen, nombre) VALUES (true, 'https://imagen3.com', 'Libros');
INSERT INTO categoria (destacada, imagen, nombre) VALUES (false, 'https://imagen4.com', 'Pinturas y modelismo');
INSERT INTO categoria (destacada, imagen, nombre) VALUES (true, 'https://imagen5.com', 'Accesorios');

INSERT INTO producto (nombre, descripcion, precio, stock, imagen, categoria_id) VALUES ('Vashtorr el Arquífice', 'Este kit consta de 47 piezas de plástico e incluye una peana Citadel redonda de 80 mm. Esta miniatura se suministra sin pintar y requiere montaje. Recomendamos usar pegamento para plástico Citadel y pinturas Citadel.', 29.99, 50, 'https://www.games-workshop.com/resources/catalog/product/920x950/99120102180_CSMVashtorrTheArkifane01.jpg', 1);
INSERT INTO producto (nombre, descripcion, precio, stock, imagen, categoria_id) VALUES ('Warhammer 40k: Conquest', 'Juego de mesa de estrategia basado en la batalla de la Herejía de Horus', 49.99, 20, NULL, 2);
INSERT INTO producto (nombre, descripcion, precio, stock, imagen, categoria_id) VALUES ('Horus Heresy: Betrayal at Calth', 'Juego de mesa táctico de dos jugadores ambientado en la Herejía de Horus', 79.99, 10, NULL, 2);
INSERT INTO producto (nombre, descripcion, precio, stock, imagen, categoria_id) VALUES ('Horus Heresy: Legión Astartes', 'Libro de tapa dura con información detallada sobre las legiones de la Herejía de Horus', 59.99, 15, NULL, 3);
INSERT INTO producto (nombre, descripcion, precio, stock, imagen, categoria_id) VALUES ('Pintura Vallejo Model Color', 'Set de 16 pinturas acrílicas de alta calidad para modelos de Warhammer 40k', 34.99, 30, NULL, 4);

INSERT INTO popularidad (puntuacion, producto_id) VALUES (4, 1);
INSERT INTO popularidad (puntuacion, producto_id) VALUES (5, 2);
INSERT INTO popularidad (puntuacion, producto_id) VALUES (3, 3);
INSERT INTO popularidad (puntuacion, producto_id) VALUES (2, 4);
INSERT INTO popularidad (puntuacion, producto_id) VALUES (5, 5);