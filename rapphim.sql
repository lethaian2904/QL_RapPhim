-- Tạo bảng cho rạp chiếu
CREATE TABLE cinemas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL
);

-- Tạo bảng chi tiết rạp phim
CREATE TABLE cinema_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cinema_id BIGINT,
    description TEXT,
    image_path VARCHAR(255),
    support_info TEXT,
    user_rating DOUBLE,
    FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
);

-- Tạo bảng cho phim
CREATE TABLE movies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    duration INT NOT NULL
);

-- Tạo bảng chi tiết phim
CREATE TABLE movie_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT,
    description TEXT,
    trailer VARCHAR(255),
    director VARCHAR(255),
    image_path VARCHAR(255),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

-- Tạo bảng cho loại vé
CREATE TABLE ticket_types (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    cinema_id BIGINT,
    FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
);

-- Tạo bảng khuyến mãi
CREATE TABLE promotions (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    discount DOUBLE,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    min_amount DOUBLE,
    cinema_id BIGINT,
    FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
);

-- Tạo bảng cho người dùng
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL
);

-- Tạo bảng cho thông tin người dùng
CREATE TABLE user_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    phone_number VARCHAR(20),
    email VARCHAR(255),
    address VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Tạo bảng cho đánh giá phim từ người dùng
CREATE TABLE movie_reviews (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    movie_id BIGINT,
    rating INT NOT NULL,
    review TEXT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (movie_id) REFERENCES movies(id)
);

-- Tạo bảng cho ghế
CREATE TABLE seats (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    cinema_id BIGINT,
    row_number INT NOT NULL,
    seat_number INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
);

-- Tạo bảng cho lịch chiếu
CREATE TABLE showtimes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    movie_id BIGINT,
    cinema_id BIGINT,
    start_time DATETIME NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies(id),
    FOREIGN KEY (cinema_id) REFERENCES cinemas(id)
);

-- Tạo bảng liên kết giữa ghế và lịch chiếu (mối quan hệ ManyToMany)
CREATE TABLE showtime_seats (
    showtime_id BIGINT,
    seat_id BIGINT,
    PRIMARY KEY (showtime_id, seat_id),
    FOREIGN KEY (showtime_id) REFERENCES showtimes(id),
    FOREIGN KEY (seat_id) REFERENCES seats(id)
);

-- Tạo bảng cho đơn hàng
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    total_amount DOUBLE NOT NULL,
    order_date DATE NOT NULL,
    cinema_id BIGINT,
    promotion_id BIGINT,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (cinema_id) REFERENCES cinemas(id),
    FOREIGN KEY (promotion_id) REFERENCES promotions(id)
);

-- Tạo bảng cho chi tiết đơn hàng
CREATE TABLE order_details (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id BIGINT,
    ticket_type_id BIGINT,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (ticket_type_id) REFERENCES ticket_types(id)
);
