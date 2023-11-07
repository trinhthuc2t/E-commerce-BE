use ecommerce;
INSERT INTO Role (name) VALUES
                            ('ROLE_ADMIN'),
                            ('ROLE_SHOP'),
                            ('ROLE_CUSTOMER');
-- Chèn dữ liệu cho bảng Account
INSERT INTO Account (username, password, firstname, lastname, phone, email, image, address, province, district, ward, role_id) VALUES
                                                                                                                                   ('admin', 'password1', 'Thục', 'Trịnh', '1234567891', 'user1@example.com', 'image1.jpg', '123 Main St', 'State1', 'District1', 'Ward1', 1),
                                                                                                                                   ('user1', 'password1', 'John', 'Doe', '1234567891', 'user1@example.com', 'image1.jpg', '123 Main St', 'State1', 'District1', 'Ward1', 1),
                                                                                                                                   ('user2', 'password2', 'Jane', 'Smith', '1234567892', 'user2@example.com', 'image2.jpg', '456 Elm St', 'State2', 'District2', 'Ward2', 2),
                                                                                                                                   ('user3', 'password3', 'Alice', 'Johnson', '1234567893', 'user3@example.com', 'image3.jpg', '789 Oak St', 'State3', 'District3', 'Ward3', 3),
                                                                                                                                   ('user4', 'password4', 'Bob', 'Williams', '1234567894', 'user4@example.com', 'image4.jpg', '101 Pine St', 'State4', 'District4', 'Ward4', 1),
                                                                                                                                   ('user5', 'password5', 'Emily', 'Brown', '1234567895', 'user5@example.com', 'image5.jpg', '202 Cedar St', 'State5', 'District5', 'Ward5', 2),
                                                                                                                                   ('user6', 'password6', 'David', 'Taylor', '1234567896', 'user6@example.com', 'image6.jpg', '303 Maple St', 'State6', 'District6', 'Ward6', 3),
                                                                                                                                   ('user7', 'password7', 'Grace', 'Anderson', '1234567897', 'user7@example.com', 'image7.jpg', '404 Birch St', 'State7', 'District7', 'Ward7', 1),
                                                                                                                                   ('user8', 'password8', 'Tom', 'Martinez', '1234567898', 'user8@example.com', 'image8.jpg', '505 Walnut St', 'State8', 'District8', 'Ward8', 2),
                                                                                                                                   ('user9', 'password9', 'Linda', 'Hernandez', '1234567899', 'user9@example.com', 'image9.jpg', '606 Fir St', 'State9', 'District9', 'Ward9', 3),
                                                                                                                                   ('user10', 'password10', 'Michael', 'Gonzalez', '1234567890', 'user10@example.com', 'image10.jpg', '707 Oak St', 'State10', 'District10', 'Ward10', 1);
