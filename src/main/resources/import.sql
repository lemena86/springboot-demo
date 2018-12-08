INSERT INTO _category  VALUES (1, 'notebooks');
INSERT INTO _category  VALUES (2, 'tablets');
INSERT INTO _category  VALUES (3, 'phones');

INSERT INTO _seller  VALUES (1, 'dell', 'Apoquindo 1200', '12345');
INSERT INTO _seller  VALUES (2, 'apple', 'San Pascual', '678');
INSERT INTO _seller  VALUES (3, 'samsung', 'San Diego 1200', '980');

INSERT INTO _review  VALUES (1, 4, 10);
INSERT INTO _review  VALUES (2, 3.5, 20);
INSERT INTO _review  VALUES (3, 4, 31);
INSERT INTO _review  VALUES (4, 2.9, 21);
INSERT INTO _review  VALUES (5, 4.2, 41);
INSERT INTO _review  VALUES (6, 3.8, 20);
INSERT INTO _review  VALUES (7, 4.2, 26);

INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (1, 'Acer - Laptop S1003-1622 de 10.1', 'Intel Atom - Memoria de 2 GB - Unidad de estado sólido de 32 GB - Gris', 450000, 'https://pisces.bbystatic.com/image2/BestBuy_MX/images/products/1000/1000209663_sa.jpg;maxHeight=200;maxWidth=200', 0, 1, 1, 1, 1);
INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (2, 'HP - Laptop 14-ck0014la de 14', 'Celeron - UHD 600 - Memoria de 4GB - Disco duro de 500GB - Blanco', 355000, 'https://pisces.bbystatic.com/image2/BestBuy_MX/images/products/1000/1000213020_ra.jpg', 1, 1, 1, 1, 2);
INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (3, 'Asus - Laptop X507MA-BR009T de 14', 'Asus - Laptop X507MA-BR009T de 14', 550000, 'https://pisces.bbystatic.com/image2/BestBuy_MX/images/products/1000/1000215627_sa.jpg', 0, 1, 2, 1, 3);
INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (4, 'Nuevo iPad 2018 9,7', 'Nuevo iPad 2018 9,7', 250000, 'https://imagenes.paris.cl/is/image/Cencosud/9078620-001?wid=441&fmt=jpg', 1, 1, 2, 2, 4);
INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (5, 'Samsung Galaxy S9 64gb ', 'Pantalla: 5.8 QHD+ (1440 x 2960) con 570dpi - Relación de aspecto 18,5:9Procesador: Qualcomm Snapdragon 845 Octa-core (4x2.7 GHz Kryo 385 Gold & 4x1.7 GHz Kryo 385 Silver) / Exynos 8890 (Confirmar en sección preguntas)RAM: 4GB LPDDR4', 150000, 'https://http2.mlstatic.com/samsung-galaxy-s9-64gb-promovil-D_NQ_NP_600706-MLC28298317830_102018-F.webp', 1, 0, 3, 3, 5);
INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (6, 'Samsung Galaxy J6', 'Despacho GRATIS en Región Metropolitana Urbana en solo 2 días hábiles y resto de Chile hasta máximo 6 días hábiles', 190020, 'https://d1sedrn2lw9dir.cloudfront.net/media/catalog/product/cache/1/image/650x/040ec09b1e35df139433887a97daa66f/5/0/502x600_samsung_galaxy-j6_back_black_1.png', 0, 9, 3, 3, 6);
INSERT INTO _product (id, title, description, price, thumbnail, shiping, condition, seller_id, category_id, review_id) VALUES (7, 'Iphone Xs Max Clon 512 Gb', 'iPhone XS MAX clon chino recien lanzado. La mejor fabrica, idéntico, 512 GB, android emulado a iOS, probado con red 4g wom, desbloqueado. Con sus accesorios y caja. ', 350000, 'https://http2.mlstatic.com/iphone-xs-max-clon-512-gb-D_NQ_NP_648268-MLC28509929469_102018-F.webp', 1, 1, 3, 3, 7);