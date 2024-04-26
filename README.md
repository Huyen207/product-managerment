Cấu hình dự án
- Open JDK  21.0.2
- Apache Maven 3.9.6

Các bước chạy dự án:

B1: Clone 2 project từ GitHub :
 https://github.com/Huyen207/product-io-spring.git
 https://github.com/Huyen207/product-managerment.git
 
B2: Sau đó chạy các lệnh sau 
cd product-io-spring/
run mvn install
Sau khi run ta được một tập tin JAR

B3: Sau đó chạy lệnh sau:
cd product-managerment/
mvn package
java -jar tên_file_tại_B2
