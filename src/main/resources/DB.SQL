create database ecommerce;
use ecommerce;
INSERT INTO Role (name)
VALUES ('ROLE_ADMIN'),
       ('ROLE_SHOP'),
       ('ROLE_CUSTOMER');
-- Chèn dữ liệu cho bảng Account
INSERT INTO Account (username, password, firstname, lastname, phone, email, image, address, province, district, ward,
                     role_id)
VALUES ('admin', 'password1', 'Thục', 'Trịnh', '1234567891', 'user1@example.com', 'image1.jpg', '123 Main St', 'State1',
        'District1', 'Ward1', 1),
       ('user1', 'password1', 'John', 'Doe', '1234567891', 'user1@example.com', 'image1.jpg', '123 Main St', 'State1',
        'District1', 'Ward1', 1),
       ('user2', 'password2', 'Jane', 'Smith', '1234567892', 'user2@example.com', 'image2.jpg', '456 Elm St', 'State2',
        'District2', 'Ward2', 2),
       ('user3', 'password3', 'Alice', 'Johnson', '1234567893', 'user3@example.com', 'image3.jpg', '789 Oak St',
        'State3', 'District3', 'Ward3', 3),
       ('user4', 'password4', 'Bob', 'Williams', '1234567894', 'user4@example.com', 'image4.jpg', '101 Pine St',
        'State4', 'District4', 'Ward4', 1),
       ('user5', 'password5', 'Emily', 'Brown', '1234567895', 'user5@example.com', 'image5.jpg', '202 Cedar St',
        'State5', 'District5', 'Ward5', 2),
       ('user6', 'password6', 'David', 'Taylor', '1234567896', 'user6@example.com', 'image6.jpg', '303 Maple St',
        'State6', 'District6', 'Ward6', 3),
       ('user7', 'password7', 'Grace', 'Anderson', '1234567897', 'user7@example.com', 'image7.jpg', '404 Birch St',
        'State7', 'District7', 'Ward7', 1),
       ('user8', 'password8', 'Tom', 'Martinez', '1234567898', 'user8@example.com', 'image8.jpg', '505 Walnut St',
        'State8', 'District8', 'Ward8', 2),
       ('user9', 'password9', 'Linda', 'Hernandez', '1234567899', 'user9@example.com', 'image9.jpg', '606 Fir St',
        'State9', 'District9', 'Ward9', 3),
       ('user10', 'password10', 'Michael', 'Gonzalez', '1234567890', 'user10@example.com', 'image10.jpg', '707 Oak St',
        'State10', 'District10', 'Ward10', 1);
-- Chèn dữ liệu cho bảng Category
INSERT INTO Category (name, image)
VALUES ('Thời Trang Nam', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYAkRAhen7bleX7OwA2RsXHZr20OcH6yQMdA&usqp=CAU'),
       ('Điện Thoại & Phụ Kiện', 'https://cdn.tgdd.vn/Files/2020/11/27/1309600/dathang2_799x449.jpg'),
       ('Máy Tính & Lap Top',
        'https://cdn.tgdd.vn/Files/2021/09/04/1380197/logo-24h-cong-nghe8_1280x720-800-resize.png'),
       ('Thời Trang Nữ',
        'https://bizweb.dktcdn.net/100/369/522/files/chan-vay-ngan-chu-a-mau-den-loli-black-skirt-2-jpeg.jpg?v=1628045003529'),
       ('Đồng Hồ', 'https://cdn11.dienmaycholon.vn/filewebdmclnew/DMCL21/Picture/News/News_expe_6551/6551.png'),
       ('Thể Thao & Du Lịch',
        'https://thethaotuoitre.com/wp-content/uploads/2018/12/tim-hieu-ve-trong-luong-qua-bong-da.jpg'),
       ('Giày Dép', 'https://www.elleman.vn/app/uploads/2022/03/29/212830/sneakers-giay-nam-2022.jpg'),
       ('Thiết Bị Gia Dụng',
        'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfE95p-AeghFo1Cmq9yBakBAF6_HCJ9_wwzOURUl5LRd_NPG7LVRxUyzk5fJ91dkmIzac&usqp=CAU');


-- Thêm dữ liệu giả cho bảng Product với các category tương ứng

-- Thời Trang Nam
INSERT INTO Product (name, description, price, quantity, thumbnail, creat_at, update_at, category_id)
VALUES ('Áo Sơ Mi Nam Trắng', 'Áo sơ mi nam thời trang', 35, 100, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRLOzvp7FltIvcMliuNMEa71wSL8uaX3dFrQ&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 1),
       ('Quần Jeans Nam', 'Quần jeans nam hàng hiệu', 50, 80, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQLQ5KfndpZC_sJ5HTzxWNGdunJtWRSWvUdpw&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 1),
       ('Đầm Dạo Phố', 'Đầm dạo phố thời trang nữ', 45, 60, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfsJqj95twQLbrJATj6Qsulp4y8z3CpiahwtD_rxXPtSlzekcPoK71UzhbKmv9yU-iHuI&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 4),
       ('Áo Khoác Nỉ', 'Áo khoác nỉ dành cho nữ', 55, 40, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQZBi5Wg4ieoJLttq72uNw73XYHjKGwadpYWg&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 4),
       ('Túi Xách Thời Trang', 'Túi xách dành cho phái đẹp', 30, 80, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_Yv4gEFUhECgIvynvOzEIO2UpdVkcdE0H2w&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 4),
       ('iPhone 13', 'Điện thoại iPhone 13', 999, 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXyrXouuUDhtCuTbH_lrn4mtZ5hXw3HBbtVk7h_G2J0E32SY3FwVDG9lS-GCjTAF4-GYQ&usqp=CAU', '2023-11-15 00:00:00.000000',
        '2023-11-15 00:00:00.000000', 2),
       ('Tai nghe Bluetooth', 'Tai nghe Bluetooth không dây', 40, 120, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT1P51bP8BFaOKKM8MSd98dLXQFy_wK0WGMw&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 2),
       ('Laptop Dell XPS 13', 'Laptop siêu mỏng và nhẹ', 1500, 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRPTcYYHYtbSN3raNkriNx4LXqiqcwgtNGku4VRSwzkzfshPooeiUFMEkl20CYMs_sqZF8&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 3),
       ('Bàn Phím Gaming', 'Bàn phím cơ cho game thủ', 100, 80, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSF8zoJoOVNILLn_qNfYOoXJ9y-2VF5JHx7UQ&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 3),

       ('Đồng Hồ Nam Casio', 'Đồng hồ nam thời trang', 80, 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRV4Wl-4IRFSZxK4dB7gCIhYv3yGVQpS5svgA&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 5),
       ('Đồng Hồ Nữ Citizen', 'Đồng hồ nữ đẹp', 120, 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMgVImpXWNX_fvDMY_pOFXzeh1aqg21GSj_Q&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 5),
       ('Bóng Đá Adidas', 'Bóng đá chất lượng cao', 20, 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoT0ZIburdu-2RyWzTrcz-G209XtI_oKnaVg&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 6),
       ('Ba Lô Du Lịch', 'Ba lô du lịch thoải mái', 35, 70, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoT0ZIburdu-2RyWzTrcz-G209XtI_oKnaVg&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 6),
       ('Áo Polo Nam', 'Áo polo nam phong cách', 25, 80, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ_hL20QWChhmL-58OyhlUx4fLUPqHuaTUJvQ&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 1),
       ('Quần Tây Nam', 'Quần tây nam dành cho công sở', 40, 60, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQlyfxmQ5TCaR2jNzL5eY8XGB3ZfR69YPe1vQ&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 1),
       ('Tai Nghe Airpods', 'Tai nghe không dây chất lượng cao', 120, 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTSnqCXmRbzlHYheGjg-TZEbsi4l_YVNYHP1M5k0O4O5uG7ToG94yrmB4x4FklaqtudEQ&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 2),
       ('Sạc Dự Phòng', 'Sạc dự phòng dung lượng lớn', 35, 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUnUVjJlnNXcwj7-bAlE_A_9mJvWWmHV42RQ&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 2),
       ('Máy Tính Để Bàn', 'Máy tính để bàn gaming', 800, 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSifVk-kdf3laEPoDm4oSpyYJnRf4k1KJWefw&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 3),
       ('Laptop HP Spectre', 'Laptop siêu mỏng và nhẹ', 1300, 40, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqPiKrqyalOtGFm6BWr1ZtrAQr5DflqaH03w&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 3),
       ('Đầm Hoa Văn Nữ', 'Đầm hoa văn nữ thời trang', 45, 60, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVYttuWRwTm2azeh0qXOtkoP-Rt1DdFzQkYw&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 4),
       ('Áo Thun Crop Top', 'Áo thun crop top nữ', 35, 80, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQKfIm3WtD_URf9AVL1rbmUenQlcVovD3iMNg&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 4),
       ('Đồng Hồ Nam Seiko', 'Đồng hồ nam đẹp', 150, 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhOSARk7nfyJe7744fkyJgKYDfEuiQfRJQQw&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 5),
       ('Đồng Hồ Nữ Michael Kors', 'Đồng hồ nữ cao cấp', 200, 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQdEEyuRN_eunud1Ygnmt8G0mN_vr1-W4Rapg&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 5),
       ('Bóng Rổ Adidas', 'Bóng rổ chất lượng cao', 30, 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJHxGIZklh0dub_i1O1G-RIEfnaiJ3nO8WiA&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 6),
       ('Vali Du Lịch', 'Vali du lịch chất lượng', 60, 70, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRkp28dvYUOWHip4dSLDLE7k2wq-pdHnV1jCw&usqp=CAU',
        '2023-11-15 00:00:00.000000', '2023-11-15 00:00:00.000000', 6);



