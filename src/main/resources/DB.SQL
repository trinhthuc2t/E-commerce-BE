# create database ecommerce;
use ecommerce;
INSERT INTO Role (id, name)
VALUES (1, 'ROLE_ADMIN'),
       (2, 'ROLE_SHOP'),
       (3, 'ROLE_CUSTOMER');
-- Chèn dữ liệu cho bảng Account
INSERT INTO Account (id, username, password, firstname, lastname, phone, email, avatar, address, province, district,
                     ward, wallet, role_id, status)
VALUES (1, 'admin', '1', 'Thục', 'Trịnh', '1234567891', 'user1@example.com', 'image1.jpg', '123 Main St',
        'State1',
        'District1', 'Ward1', 0, 1, 'Đang hoạt động'),
       (2, 'shop1', '1', 'John', 'Doe', '1234567891', 'shop1@example.com', 'image1.jpg', '123 Main St',
        'State1',
        'District1', 'Ward1', 0, 1, 'Đang hoạt động'),
       (3, 'shop2', '1', 'Jane', 'Smith', '1234567892', 'shop2@example.com', 'image2.jpg', '456 Elm St',
        'State2',
        'District2', 'Ward2', 0, 2, 'Đang hoạt động'),
       (4, 'user1', '1', 'Alice', 'Johnson', '1234567893', 'user3@example.com', 'image3.jpg', '789 Oak St',
        'State3', 'District3', 'Ward3', 0, 2, 'Đang hoạt động'),
       (5, 'user2', '1', 'Bob', 'Williams', '1234567894', 'user4@example.com', 'image4.jpg', '101 Pine St',
        'State4', 'District4', 'Ward4', 0, 3, 'Đang hoạt động'),
       (6, 'user3', '1', 'Emily', 'Brown', '1234567895', 'user5@example.com', 'image5.jpg', '202 Cedar St',
        'State5', 'District5', 'Ward5', 0, 3, 'Đang hoạt động'),
       (7, 'user4', '1', 'David', 'Taylor', '1234567896', 'user6@example.com', 'image6.jpg', '303 Maple St',
        'State6', 'District6', 'Ward6', 0, 3, 'Đang hoạt động'),
       (8, 'user5', '1', 'Grace', 'Anderson', '1234567897', 'user7@example.com', 'image7.jpg', '404 Birch St',
        'State7', 'District7', 'Ward7', 0, 3, 'Đang hoạt động'),
       (9, 'user6', '1', 'Tom', 'Martinez', '1234567898', 'user8@example.com', 'image8.jpg', '505 Walnut St',
        'State8', 'District8', 'Ward8', 0, 3, 'Đang hoạt động'),
       (10, 'user7', '1', 'Linda', 'Hernandez', '1234567899', 'user9@example.com', 'image9.jpg', '606 Fir St',
        'State9', 'District9', 'Ward9', 0, 3, 'Đang hoạt động'),
       (11, 'user8', '1', 'Michael', 'Gonzalez', '1234567890', 'user10@example.com', 'image10.jpg',
        '707 Oak St',
        'State10', 'District10', 'Ward10', 0, 3, 'Đang hoạt động');
-- Chèn dữ liệu cho bảng Category
INSERT INTO Category (id, name, image)
VALUES (1, 'Thời Trang Nam',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYAkRAhen7bleX7OwA2RsXHZr20OcH6yQMdA&usqp=CAU'),
       (2, 'Điện Thoại & Phụ Kiện', 'https://cdn.tgdd.vn/Files/2020/11/27/1309600/dathang2_799x449.jpg'),
       (3, 'Máy Tính & Lap Top',
        'https://cdn.tgdd.vn/Files/2021/09/04/1380197/logo-24h-cong-nghe8_1280x720-800-resize.png'),
       (4, 'Thời Trang Nữ',
        'https://bizweb.dktcdn.net/100/369/522/files/chan-vay-ngan-chu-a-mau-den-loli-black-skirt-2-jpeg.jpg?v=1628045003529'),
       (5, 'Đồng Hồ', 'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture/News/News_expe_6551/6551.png'),
       (6, 'Thể Thao & Du Lịch',
        'https://thethaotuoitre.com/wp-content/uploads/2018/12/tim-hieu-ve-trong-luong-qua-bong-da.jpg'),
       (7, 'Giày Dép', 'https://www.elleman.vn/app/uploads/2022/03/29/212830/sneakers-giay-nam-2022.jpg'),
       (8, 'Thiết Bị Gia Dụng',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfE95p-AeghFo1Cmq9yBakBAF6_HCJ9_wwzOURUl5LRd_NPG7LVRxUyzk5fJ91dkmIzac&usqp=CAU');


insert into color_product(id, name)
VALUES (1, 'Black'),
       (2, 'White'),
       (3, 'Red'),
       (4, 'Green');
insert into size_product(id, name)
VALUES (1, 'XXL'),
       (2, 'XL'),
       (3, 'L'),
       (5, 'XS');
-- Thêm dữ liệu giả cho bảng Product với các category tương ứng

-- Thời Trang Nam
INSERT INTO Product (id, name, description, price, thumbnail, category_id, account_id)
VALUES (1, 'Áo Sơ Mi Nam Trắng', 'Áo sơ mi nam thời trang', 350000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRLOzvp7FltIvcMliuNMEa71wSL8uaX3dFrQ&usqp=CAU', 1, 2),
       (2, 'Quần Jeans Nam', 'Quần jeans nam hàng hiệu', 500000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLQ5KfndpZC_sJ5HTzxWNGdunJtWRSWvUdpw&usqp=CAU', 1, 2),
       (3, 'Đầm Dạo Phố', 'Đầm dạo phố thời trang nữ', 450000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfsJqj95twQLbrJATj6Qsulp4y8z3CpiahwtD_rxXPtSlzekcPoK71UzhbKmv9yU-iHuI&usqp=CAU',
        4, 2),
       (4, 'Áo Khoác Nỉ', 'Áo khoác nỉ dành cho nữ', 550000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZBi5Wg4ieoJLttq72uNw73XYHjKGwadpYWg&usqp=CAU', 4, 2),
       (5, 'Túi Xách Thời Trang', 'Túi xách dành cho phái đẹp', 300000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_Yv4gEFUhECgIvynvOzEIO2UpdVkcdE0H2w&usqp=CAU', 4, 2),
       (6, 'iPhone 13', 'Điện thoại iPhone 13', 19990000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXyrXouuUDhtCuTbH_lrn4mtZ5hXw3HBbtVk7h_G2J0E32SY3FwVDG9lS-GCjTAF4-GYQ&usqp=CAU',
        2, 2),
       (7, 'Tai nghe Bluetooth', 'Tai nghe Bluetooth không dây', 400000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT1P51bP8BFaOKKM8MSd98dLXQFy_wK0WGMw&usqp=CAU', 2, 2),
       (8, 'Laptop Dell XPS 13', 'Laptop siêu mỏng và nhẹ', 15000000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPTcYYHYtbSN3raNkriNx4LXqiqcwgtNGku4VRSwzkzfshPooeiUFMEkl20CYMs_sqZF8&usqp=CAU',
        3, 2),
       (9, 'Bàn Phím Gaming', 'Bàn phím cơ cho game thủ', 1000000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSF8zoJoOVNILLn_qNfYOoXJ9y-2VF5JHx7UQ&usqp=CAU', 3, 2),

       (10, 'Đồng Hồ Nam Casio', 'Đồng hồ nam thời trang', 800000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRV4Wl-4IRFSZxK4dB7gCIhYv3yGVQpS5svgA&usqp=CAU', 5, 2),
       (11, 'Đồng Hồ Nữ Citizen', 'Đồng hồ nữ đẹp', 1200000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMgVImpXWNX_fvDMY_pOFXzeh1aqg21GSj_Q&usqp=CAU', 5, 2),
       (12, 'Bóng Đá Adidas', 'Bóng đá chất lượng cao', 200000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoT0ZIburdu-2RyWzTrcz-G209XtI_oKnaVg&usqp=CAU', 6, 2),
       (13, 'Ba Lô Du Lịch', 'Ba lô du lịch thoải mái', 350000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoT0ZIburdu-2RyWzTrcz-G209XtI_oKnaVg&usqp=CAU', 6, 2),
       (14, 'Áo Polo Nam', 'Áo polo nam phong cách', 250000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_hL20QWChhmL-58OyhlUx4fLUPqHuaTUJvQ&usqp=CAU', 1, 2),
       (15, 'Quần Tây Nam', 'Quần tây nam dành cho công sở', 400000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlyfxmQ5TCaR2jNzL5eY8XGB3ZfR69YPe1vQ&usqp=CAU', 1, 2),
       (16, 'Tai Nghe Airpods', 'Tai nghe không dây chất lượng cao', 120000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTSnqCXmRbzlHYheGjg-TZEbsi4l_YVNYHP1M5k0O4O5uG7ToG94yrmB4x4FklaqtudEQ&usqp=CAU',
        2, 2),
       (17, 'Sạc Dự Phòng', 'Sạc dự phòng dung lượng lớn', 350000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUnUVjJlnNXcwj7-bAlE_A_9mJvWWmHV42RQ&usqp=CAU', 2, 2),
       (18, 'Máy Tính Để Bàn', 'Máy tính để bàn gaming', 8000000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSifVk-kdf3laEPoDm4oSpyYJnRf4k1KJWefw&usqp=CAU', 3, 2),
       (19, 'Laptop HP Spectre', 'Laptop siêu mỏng và nhẹ', 13000000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqPiKrqyalOtGFm6BWr1ZtrAQr5DflqaH03w&usqp=CAU', 3, 2),
       (20, 'Đầm Hoa Văn Nữ', 'Đầm hoa văn nữ thời trang', 450000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVYttuWRwTm2azeh0qXOtkoP-Rt1DdFzQkYw&usqp=CAU', 4, 2),
       (21, 'Áo Thun Crop Top', 'Áo thun crop top nữ', 350000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKfIm3WtD_URf9AVL1rbmUenQlcVovD3iMNg&usqp=CAU', 4, 2),
       (22, 'Đồng Hồ Nam Seiko', 'Đồng hồ nam đẹp', 1500000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhOSARk7nfyJe7744fkyJgKYDfEuiQfRJQQw&usqp=CAU', 5, 2),
       (23, 'Đồng Hồ Nữ Michael Kors', 'Đồng hồ nữ cao cấp', 20000000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdEEyuRN_eunud1Ygnmt8G0mN_vr1-W4Rapg&usqp=CAU', 5, 2),
       (24, 'Bóng Rổ Adidas', 'Bóng rổ chất lượng cao', 300000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJHxGIZklh0dub_i1O1G-RIEfnaiJ3nO8WiA&usqp=CAU', 6, 2),
       (25, 'Vali Du Lịch', 'Vali du lịch chất lượng', 600000,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkp28dvYUOWHip4dSLDLE7k2wq-pdHnV1jCw&usqp=CAU', 6, 2);



INSERT INTO product_detail (id, color_product_id, size_product_id, creat_at, quantity, update_at, product_id)
values (1, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 1),
       (2, 1, 2, '2023-11-15 00:00:00.000000', 80, '2023-11-15 00:00:00.000000', 2),
       (3, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 3),
       (4, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 4),
       (5, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 5),
       (6, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 6),
       (7, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 7),
       (8, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 8),
       (9, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 9),
       (10, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 10),
       (11, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 11),
       (12, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 12),
       (13, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 13),
       (14, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 14),
       (15, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 15),
       (16, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 16),
       (17, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 17),
       (18, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 18),
       (19, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 19),
       (20, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 20),
       (21, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 21),
       (22, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 22),
       (23, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 23),
       (24, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 24),
       (25, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 25),
       (26, 2, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 1),
       (27, 1, 2, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 1),
       (28, 2, 2, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 1),
       (29, 1, 3, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 1),
       (30, 2, 3, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 1),
       (31, 4, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 2),
       (32, 1, 1, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 2),
       (33, 4, 2, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 2),
       (34, 1, 2, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 2),
       (35, 4, 3, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 2),
       (36, 1, 3, '2023-11-15 00:00:00.000000', 100, '2023-11-15 00:00:00.000000', 2);


-- Tạo dữ liệu giả cho bảng Image
INSERT INTO Image (id, image_url, product_id)
VALUES (1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSwoioNnT-S9MSW2Y--QlK553xz2LK9BPI3OA&usqp=CAU', 1),
       (2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFM97rFHBjO5r-XYWzLA11Pz3sCakBZ5SJ4Q&usqp=CAU', 1),
       (3, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-eSdV1UtOXHGtAQxQIo4iChcaeOrq0STj5w&usqp=CAU', 1),
       (4,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTI1IvOOGNsczF9bEBOdB9jBsxAPDqFwNG1jgvbSvx8Sh8c_ls8AM_gIRbWrG4qlGf8RZo&usqp=CAU',
        1),
       (5,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0hvCVyTSu3nu0utwQ6Gj-YnWo6NQdxSp9OaL-IfAR0hhwhle5339Z5M8NUlcuPYt4eqI&usqp=CAU',
        2),
       (6,
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRlcfWMdc1X0LYFJA7_TqzVIdS5eWFHkoAroTMZ3GURF4PumD0nDIEbM9DGjlBSP1N6h1M&usqp=CAU',
        2),
       (7, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-IbZZwbdZ_RULc7w1JsC-7x01lHaHHc6a7Q&usqp=CAU', 2),
       (8, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQY6Gkyo2xmGVG4OagcUk_DjRhel0t7JAoSnA&usqp=CAU', 2);


INSERT INTO review (id, comment, created_at, rating, updated_at, account_id, product_id)
VALUES
    (1, 'Shop giao nhanh đúng mẫu vải mặc rất là mát form chuẩn rất hài lòng với sản phẩm sẽ ủng hộ shop dài dài
', '2023-11-15 12:34:56.789', 5, '2023-11-15 12:34:56.789', 3, 1),
    (2, 'chất lượng sản phẩm vượt mong đợi so với giá thì sản phẩm quá tốt. shop thì đóng gói cẩn thận tư vấn nhiệt tình. tuyệt vời
', '2023-11-15 12:45:00.000', 4, '2023-11-15 12:45:00.000', 4, 2),
    (3, 'Mình nhận được áo rồi ạ giao hàng nhanh đóng gói cẩn thận áo giá rẻ mà chất lương rất ổn trong tầm giá chất vải mặc mềm mại thoáng mát không có chỉ thừa màu cũng đẹp nữa
', '2023-11-15 13:00:00.000', 3, '2023-11-15 13:00:00.000', 5, 1),
    (4, 'Shop giao hàng nhanh, đóng gói cẩn thận, đúng với mô tả. Hàng đẹp và giá rất ok. Mua 2 cái mà cái nào cũng OK. Sẽ tiếp tục ủng hộ Shop 👍👍👍', '2023-11-15 13:15:00.000', 5, '2023-11-15 13:15:00.000', 6, 1),
    (5, 'áo rẻ mà đẹp đường may tôt không chỉ thừa vải dày dặn mặc khá  thoáng  và mát shop tư vân  nhiệ tinh cho shop 5 sao
', '2023-11-15 13:30:00.000', 5, '2023-11-15 13:30:00.000', 7, 2);


insert into review (id, comment, created_at, updated_at, rating, account_id, product_id) VALUES
(1,'Shop giao nhanh đúng mẫu vải mặc rất là mát form chuẩn rất hài lòng với sản phẩm sẽ ủng hộ shop dài dài',
 '2023-11-15 12:34:56.789000',5,'2023-11-15 12:34:56.789000',3,1),
(2,'chất lượng sản phẩm vượt mong đợi so với giá thì sản phẩm quá tốt. shop thì đóng gói cẩn thận tư vấn nhiệt tình. tuyệt vời','2023-11-15 12:45:00.000000',4,'2023-11-15 12:45:00.000000',4,2),
(3,'Mình nhận được áo rồi ạ giao hàng nhanh đóng gói cẩn thận áo giá rẻ mà chất lương rất ổn trong tầm giá chất vải mặc mềm mại thoáng mát không có chỉ thừa màu cũng đẹp nữa
','2023-11-15 13:00:00.000000',3,'2023-11-15 13:00:00.000000',5,1),
(4,'Shop giao hàng nhanh, đóng gói cẩn thận, đúng với mô tả. Hàng đẹp và giá rất ok. Mua 2 cái mà cái nào cũng OK. Sẽ tiếp tục ủng hộ Shop ???','2023-11-15 13:15:00.000000',5,'2023-11-15 13:15:00.000000',6,1),
(5,'áo rẻ mà đẹp đường may tôt không chỉ thừa vải dày dặn mặc khá  thoáng  và mát shop tư vân  nhiệ tinh cho shop 5 sao
','2023-11-15 13:30:00.000000',5,'2023-11-15 13:30:00.000000',7,2)
